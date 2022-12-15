package com.helmes.makedon.citylist.dto.impl;

import com.helmes.makedon.citylist.dto.Dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Yahor Makedon
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CityDto implements Dto {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String photoUrl;
}
