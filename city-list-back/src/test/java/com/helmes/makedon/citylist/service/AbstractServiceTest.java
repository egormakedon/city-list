package com.helmes.makedon.citylist.service;

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

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * @author Yahor Makedon
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class AbstractServiceTest {
	@Autowired
	private AbstractService<City> service;
	@MockBean
	private CityRepository repository;

	@Test
	public void save() {
		City in = createCity(null, "1", "1");
		City out = createCity(1L, "1", "1");
		when(repository.save(in)).thenReturn(out);

		City r = service.save(in);

		verify(repository, times(1)).save(in);
		assertEquals(out, r);
	}

	@Test
	public void saveAll() {
		List<City> in = List.of(createCity(null, "1", "1"));
		List<City> out = List.of(createCity(1L, "1", "1"));
		when(repository.saveAll(in)).thenReturn(out);

		List<City> r = service.saveAll(in);

		verify(repository, times(1)).saveAll(in);
		assertEquals(out, r);
	}

	@Test
	public void getById() {
		Long in = 1L;
		Optional<City> out = Optional.of(createCity(1L, "1", "1"));
		when(repository.findById(in)).thenReturn(out);

		Optional<City> r = service.getById(in);

		verify(repository, times(1)).findById(in);
		assertEquals(out.get(), r.get());
	}

	@Test
	public void getAllById() {
		List<Long> in = List.of(1L);
		List<City> out = List.of(createCity(1L, "1", "1"));
		when(repository.findAllById(in)).thenReturn(out);

		List<City> r = service.getAllById(in);

		verify(repository, times(1)).findAllById(in);
		assertEquals(out, r);
	}

	@Test
	public void getAll() {
		List<City> out = List.of(createCity(1L, "1", "1"));
		when(repository.findAll()).thenReturn(out);

		List<City> r = service.getAll();

		verify(repository, times(1)).findAll();
		assertEquals(out, r);
	}

	@Test
	public void deleteById() {
		Long in = 1L;
		doNothing().when(repository).deleteById(in);

		service.deleteById(in);

		verify(repository, times(1)).deleteById(in);
	}

	@Test
	public void deleteAllById() {
		List<Long> in = List.of(1L);
		doNothing().when(repository).deleteAllByIdInBatch(in);

		service.deleteAllById(in);

		verify(repository, times(1)).deleteAllByIdInBatch(in);
	}

	@Test
	public void deleteAll() {
		doNothing().when(repository).deleteAllInBatch();

		service.deleteAll();

		verify(repository, times(1)).deleteAllInBatch();
	}

	@Test
	public void getAll_withPagination() {
		when(repository.findAll(any(Pageable.class))).thenReturn(Page.empty());

		Page<City> r = service.getAll(Pageable.ofSize(1));

		verify(repository, times(1)).findAll(any(Pageable.class));
		assertEquals(Page.empty(), r);
	}

	private City createCity(Long id, String name, String photoUrl) {
		return City.builder().id(id).name(name).photoUrl(photoUrl).build();
	}
}
