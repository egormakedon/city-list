package com.helmes.makedon.citylist.dto;

import com.helmes.makedon.citylist.domain.BaseBean;

import java.util.List;

/**
 * @author Yahor Makedon
 */
public interface DtoMapper<ENTITY extends BaseBean, DTO extends Dto> {
	ENTITY convertToEntity(DTO dto);
	List<ENTITY> convertToEntity(List<DTO> dtoList);
	DTO convertToDto(ENTITY entity);
	List<DTO> convertToDto(List<ENTITY> entityList);
}
