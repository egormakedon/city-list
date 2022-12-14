package com.helmes.makedon.citylist.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Yahor Makedon
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class City implements BaseBean {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String photoUrl;
}
