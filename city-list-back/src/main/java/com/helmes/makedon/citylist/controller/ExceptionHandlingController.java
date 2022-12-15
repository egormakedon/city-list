package com.helmes.makedon.citylist.controller;

import com.helmes.makedon.citylist.util.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Yahor Makedon
 */
@ControllerAdvice
@Slf4j
public class ExceptionHandlingController {
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public void handle(Exception e) {
		log.error(e.getLocalizedMessage(), e);
		throw new BaseException(e.getLocalizedMessage(), e);
	}
}
