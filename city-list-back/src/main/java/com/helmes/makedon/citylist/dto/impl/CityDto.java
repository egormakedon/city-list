package com.helmes.makedon.citylist.dto.impl;

import com.helmes.makedon.citylist.dto.Dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
	@NotBlank(message = "Name cannot be blank")
	@Size(max = 100, message = "Name length should not be greater than 100")
	private String name;
	@NotBlank(message = "Photo Url cannot be blank")
	private String photoUrl;
}
