package com.helmes.makedon.citylist.service.impl;

import com.helmes.makedon.citylist.domain.City;
import com.helmes.makedon.citylist.repository.CityRepository;
import com.helmes.makedon.citylist.service.AbstractService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author Yahor Makedon
 */
@Service
@Slf4j
public class CityServiceImpl extends AbstractService<City> implements CityService {
	private final CityRepository cityRepository;

	@Autowired
	public CityServiceImpl(CityRepository cityRepository) {
		super(cityRepository);
		this.cityRepository = cityRepository;
	}

	@Override
	public Page<City> searchByName(String name, Pageable pageable) {
		log.debug("searchByName: {}; {}", name, pageable);
		return cityRepository.findByNameContainsIgnoreCase(name, pageable);
	}
}
