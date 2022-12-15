package com.helmes.makedon.citylist.service;

import com.helmes.makedon.citylist.domain.BaseBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Yahor Makedon
 */
public interface PagingService<ENTITY extends BaseBean> {
	Page<ENTITY> getAll(Pageable pageable);
}
