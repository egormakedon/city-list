package com.helmes.makedon.citylist.service.impl;

import com.helmes.makedon.citylist.domain.City;
import com.helmes.makedon.citylist.repository.CityRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * @author Yahor Makedon
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class CityServiceTest {
	@Autowired
	private CityService service;
	@MockBean
	private CityRepository repository;

	@Test
	public void searchByName() {
		when(repository.findByNameContainsIgnoreCase(any(String.class), any(Pageable.class))).thenReturn(Page.empty());

		Page<City> r = service.searchByName("test", Pageable.ofSize(1));

		verify(repository, times(1)).findByNameContainsIgnoreCase(any(String.class), any(Pageable.class));
		assertEquals(Page.empty(), r);
	}
}
