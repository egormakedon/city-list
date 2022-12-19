package com.helmes.makedon.citylist.dto.impl;

import com.helmes.makedon.citylist.domain.City;
import com.helmes.makedon.citylist.dto.AbstractDtoMapper;
import com.helmes.makedon.citylist.service.impl.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Yahor Makedon
 */
@Component
public class CityDtoMapperImpl extends AbstractDtoMapper<City, CityDto> implements CityDtoMapper {
	private final CityService cityService;

	@Autowired
	public CityDtoMapperImpl(CityService cityService) {
		super(cityService);
		this.cityService = cityService;
	}

	@Override
	public City convertToEntity(CityDto cityDto) {
		Long id = cityDto.getId();
		City city = id == null ? new City() : getById(id);

		return city.toBuilder()
			.name(cityDto.getName())
			.photoUrl(cityDto.getPhotoUrl())
			.build();
	}

	@Override
	public CityDto convertToDto(City city) {
		return CityDto.builder()
			.id(city.getId())
			.name(city.getName())
			.photoUrl(city.getPhotoUrl())
			.build();
	}
}
