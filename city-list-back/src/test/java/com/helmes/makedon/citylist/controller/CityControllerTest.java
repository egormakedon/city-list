package com.helmes.makedon.citylist.controller;

import com.helmes.makedon.citylist.domain.City;
import com.helmes.makedon.citylist.dto.impl.CityDto;
import com.helmes.makedon.citylist.dto.impl.CityDtoMapper;
import com.helmes.makedon.citylist.service.impl.CityService;
import com.helmes.makedon.citylist.util.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Yahor Makedon
 */
@WebMvcTest(CityController.class)
@ExtendWith(SpringExtension.class)
public class CityControllerTest {
	@Autowired
	private MockMvc mvc;
	@MockBean
	private CityService service;
	@MockBean
	private CityDtoMapper mapper;

	private static final String url = "/api/v1/cities";

	@Test
	public void getAllCities() throws Exception {
		List<City> cityList = List.of(
			City.builder().id(1L).name("Warsaw").photoUrl("url").build(),
			City.builder().id(2L).name("London").photoUrl("url").build()
		);

		when(service.getAll(any(Pageable.class))).thenReturn(new PageImpl<>(cityList));

		mvc.perform(get(url).contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.content", hasSize(2)))
			.andExpect(jsonPath("$.content[0].id", equalTo(cityList.get(0).getId().intValue())))
			.andExpect(jsonPath("$.content[0].name", is(cityList.get(0).getName())))
			.andExpect(jsonPath("$.content[1].id", equalTo(cityList.get(1).getId().intValue())))
			.andExpect(jsonPath("$.content[1].name", is(cityList.get(1).getName())));

		verify(service, times(1)).getAll(any(Pageable.class));
	}

	@Test
	public void getCity_ok() throws Exception {
		City entity = City.builder().id(1L).name("Warsaw").photoUrl("url").build();
		CityDto dto = CityDto.builder().id(1L).name("Warsaw").photoUrl("url").build();

		when(service.getById(1L)).thenReturn(Optional.of(entity));
		when(mapper.convertToDto(entity)).thenReturn(dto);

		mvc.perform(get(String.format("%s/%d", url, 1L)).contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.id", equalTo(dto.getId().intValue())))
			.andExpect(jsonPath("$.name", is(dto.getName())))
			.andExpect(jsonPath("$.photoUrl", is(dto.getPhotoUrl())));

		verify(service, times(1)).getById(1L);
		verify(mapper, times(1)).convertToDto(entity);
	}

	@Test
	public void getCity_404() throws Exception {
		when(service.getById(1L)).thenReturn(Optional.empty());
		when(mapper.convertToDto(any(City.class))).thenReturn(any(CityDto.class));

		mvc.perform(get(String.format("%s/%d", url, 1L)).contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isNotFound())
			.andExpect(response -> assertTrue(response.getResolvedException() instanceof ResourceNotFoundException));

		verify(service, times(1)).getById(1L);
		verify(mapper, times(0)).convertToDto(any(City.class));
	}
}
