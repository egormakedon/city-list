package com.helmes.makedon.citylist.service;

import com.helmes.makedon.citylist.domain.BaseBean;

import java.util.List;
import java.util.Optional;

/**
 * @author Yahor Makedon
 */
public interface CrudService<ENTITY extends BaseBean> {
	ENTITY save(ENTITY entity);
	List<ENTITY> saveAll(List<ENTITY> entityList);
	Optional<ENTITY> getById(Long id);
	List<ENTITY> getAllById(List<Long> idList);
	List<ENTITY> getAll();
	void deleteById(Long id);
	void deleteAllById(List<Long> idList);
	void deleteAll();
}
