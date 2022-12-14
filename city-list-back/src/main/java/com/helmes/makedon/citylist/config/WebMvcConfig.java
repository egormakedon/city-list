package com.helmes.makedon.citylist.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Yahor Makedon
 */
@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {
	@Bean
	public FilterRegistrationBean<CharacterEncodingFilter> encodingFilter() {
		FilterRegistrationBean<CharacterEncodingFilter> filterRegistrationBean = new FilterRegistrationBean<>();
		filterRegistrationBean.setFilter(new CharacterEncodingFilter("UTF-8", true, true));
		filterRegistrationBean.addUrlPatterns("/*");
		return filterRegistrationBean;
	}
}
