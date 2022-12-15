package com.helmes.makedon.citylist.controller;

import com.helmes.makedon.citylist.util.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Yahor Makedon
 */
@ControllerAdvice
@Slf4j
public class ExceptionHandlingController {
	@ExceptionHandler(Exception.class)
	public void handle(Exception e) {
		log.error(e.getLocalizedMessage(), e);
		throw new BaseException(e.getLocalizedMessage(), e);
	}
}
