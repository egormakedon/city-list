package com.helmes.makedon.citylist.dto;

import com.helmes.makedon.citylist.domain.BaseBean;
import com.helmes.makedon.citylist.service.CrudService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Yahor Makedon
 */
@RequiredArgsConstructor
public abstract class AbstractDtoMapper<ENTITY extends BaseBean, DTO extends Dto> implements DtoMapper<ENTITY, DTO> {
	private final CrudService<ENTITY> service;

	@Override
	public List<ENTITY> convertToEntity(List<DTO> dtoList) {
		return dtoList.stream().map(this::convertToEntity).collect(Collectors.toList());
	}

	@Override
	public List<DTO> convertToDto(List<ENTITY> entityList) {
		return entityList.stream().map(this::convertToDto).collect(Collectors.toList());
	}

	protected ENTITY getById(Long id) {
		Optional<ENTITY> optional = service.getById(id);

		if (optional.isEmpty()) {
			throw new IllegalArgumentException(String.format("Entity with '%d' id doesn't exist", id));
		}

		return optional.get();
	}
}
