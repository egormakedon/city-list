package com.helmes.makedon.citylist.service;

import com.helmes.makedon.citylist.domain.BaseBean;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author Yahor Makedon
 */
@RequiredArgsConstructor
@Slf4j
public abstract class AbstractService<ENTITY extends BaseBean> implements CrudService<ENTITY> {
	private final JpaRepository<ENTITY, Long> repository;

	@Transactional
	@Override
	public ENTITY save(ENTITY entity) {
		log.debug("save: {}", entity);
		return repository.save(entity);
	}

	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRES_NEW)
	@Override
	public List<ENTITY> saveAll(List<ENTITY> entityList) {
		log.debug("saveAll: {}", entityList);
		return repository.saveAll(entityList);
	}

	@Override
	public Optional<ENTITY> getById(Long id) {
		log.debug("getById: {}", id);
		return repository.findById(id);
	}

	@Override
	public List<ENTITY> getAllById(List<Long> idList) {
		log.debug("getAllById: {}", idList);
		return repository.findAllById(idList);
	}

	@Override
	public List<ENTITY> getAll() {
		log.debug("getAll");
		return repository.findAll();
	}

	@Transactional
	@Override
	public void deleteById(Long id) {
		log.debug("deleteById: {}", id);
		repository.deleteById(id);
	}

	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRES_NEW)
	@Override
	public void deleteAllById(List<Long> idList) {
		log.debug("deleteAllById: {}", idList);
		repository.deleteAllByIdInBatch(idList);
	}

	@Transactional(isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRES_NEW)
	@Override
	public void deleteAll() {
		log.debug("deleteAll");
		repository.deleteAllInBatch();
	}
}
