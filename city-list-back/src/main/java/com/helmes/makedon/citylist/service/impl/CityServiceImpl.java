package com.helmes.makedon.citylist.service.impl;

import com.helmes.makedon.citylist.domain.City;
import com.helmes.makedon.citylist.repository.CityRepository;
import com.helmes.makedon.citylist.service.AbstractService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
	public List<City> searchByName(String name) {
		log.debug("searchByName: {}", name);
		return cityRepository.findByNameContains(name);
	}
}
