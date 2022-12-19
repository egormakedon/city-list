package com.helmes.makedon.citylist.service.impl;

import com.helmes.makedon.citylist.domain.City;
import com.helmes.makedon.citylist.service.CrudService;
import com.helmes.makedon.citylist.service.PagingService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Yahor Makedon
 */
public interface CityService extends CrudService<City>, PagingService<City> {
	Page<City> searchByName(String name, Pageable pageable);
}
