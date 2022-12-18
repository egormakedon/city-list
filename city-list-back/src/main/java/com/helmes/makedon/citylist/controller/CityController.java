package com.helmes.makedon.citylist.controller;

import com.helmes.makedon.citylist.domain.City;
import com.helmes.makedon.citylist.dto.impl.CityDto;
import com.helmes.makedon.citylist.dto.impl.CityDtoMapper;
import com.helmes.makedon.citylist.service.impl.CityService;
import com.helmes.makedon.citylist.util.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Yahor Makedon
 */
@RestController
@RequestMapping("/api/v1/cities")
public class CityController {
	@Autowired
	private CityService cityService;
	@Autowired
	private CityDtoMapper cityDtoMapper;

	@GetMapping
	public Page<City> getAllCities(@PageableDefault(sort = {"name"}, direction = Sort.Direction.ASC) Pageable pageable) {
		return cityService.getAll(pageable);
	}

	@GetMapping("/{id}")
	public CityDto getCity(@PathVariable Long id) {
		return cityDtoMapper.convertToDto(cityService.getById(id).orElseThrow(ResourceNotFoundException::new));
	}

	@GetMapping("/search")
	public Page<City> searchCities(@RequestParam String name, @PageableDefault(sort = {"name"}, direction = Sort.Direction.ASC) Pageable pageable) {
		return cityService.searchByName(name, pageable);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public CityDto updateCity(@PathVariable Long id, @Valid @RequestBody CityDto cityDto) {
		cityDto.setId(id);
		return cityDtoMapper.convertToDto(cityService.save(cityDtoMapper.convertToEntity(cityDto)));
	}
}
