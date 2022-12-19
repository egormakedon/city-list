package com.helmes.makedon.citylist.repository;

import com.helmes.makedon.citylist.domain.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Yahor Makedon
 */
public interface CityRepository extends JpaRepository<City, Long> {
	Page<City> findByNameContainsIgnoreCase(String name, Pageable pageable);
}
