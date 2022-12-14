package com.helmes.makedon.citylist.repository;

import com.helmes.makedon.citylist.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Yahor Makedon
 */
public interface CityRepository extends JpaRepository<City, Long> {
	List<City> findByNameContains(String name);
}
