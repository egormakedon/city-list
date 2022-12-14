package com.helmes.makedon.citylist.service.impl;

import com.helmes.makedon.citylist.domain.City;
import com.helmes.makedon.citylist.service.CrudService;

import java.util.List;

/**
 * @author Yahor Makedon
 */
public interface CityService extends CrudService<City> {
	List<City> searchByName(String name);
}
