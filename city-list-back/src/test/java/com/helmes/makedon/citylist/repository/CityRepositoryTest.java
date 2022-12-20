package com.helmes.makedon.citylist.repository;

import com.helmes.makedon.citylist.domain.City;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Yahor Makedon
 */
@DataJpaTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class CityRepositoryTest {
	@Autowired
	private CityRepository repository;
	@Autowired
	private TestEntityManager entityManager;

	@BeforeEach
	public void init() {
		List<City> cityList = List.of(
			City.builder().id(null).name("Minsk").photoUrl("url").build(),
			City.builder().id(null).name("Moscow").photoUrl("url").build(),
			City.builder().id(null).name("London").photoUrl("url").build(),
			City.builder().id(null).name("Warsaw").photoUrl("url").build(),
			City.builder().id(null).name("Birmingham").photoUrl("url").build()
		);
		cityList.forEach(entityManager::persistAndFlush);
	}

	@Test
	public void findByNameContainsIgnoreCase_sensitiveCase() {
		City exp1 = City.builder().id(3L).name("London").photoUrl("url").build();
		City exp2 = City.builder().id(4L).name("Warsaw").photoUrl("url").build();

		Page<City> r1 = repository.findByNameContainsIgnoreCase("London", createPageable(0, 10));
		Page<City> r2 = repository.findByNameContainsIgnoreCase("Warsaw", createPageable(0, 10));

		assertEquals(exp1, r1.getContent().get(0));
		assertEquals(exp2, r2.getContent().get(0));
	}

	@Test
	public void findByNameContainsIgnoreCase_nonSensitiveCase() {
		City exp1 = City.builder().id(3L).name("London").photoUrl("url").build();
		City exp2 = City.builder().id(5L).name("Birmingham").photoUrl("url").build();

		Page<City> r1 = repository.findByNameContainsIgnoreCase("London".toLowerCase(), createPageable(0, 10));
		Page<City> r2 = repository.findByNameContainsIgnoreCase("Birmingham".toUpperCase(), createPageable(0, 10));

		assertEquals(exp1, r1.getContent().get(0));
		assertEquals(exp2, r2.getContent().get(0));
	}

	@Test
	public void findByNameContainsIgnoreCase_contains() {
		List<City> exp = List.of(
			City.builder().id(1L).name("Minsk").photoUrl("url").build(),
			City.builder().id(5L).name("Birmingham").photoUrl("url").build()
		);

		Page<City> r = repository.findByNameContainsIgnoreCase("mi", createPageable(0, 10));

		assertEquals(exp, r.getContent());
	}

	private Pageable createPageable(int page, int size) {
		return PageRequest.of(page, size);
	}
}
