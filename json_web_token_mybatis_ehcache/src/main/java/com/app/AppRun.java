package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import com.app.filter.JwtFilter;


/**
 * Json Web Token demo and Use Ehcache to cache the token
 * based on 
 * http://www.ibloger.net/article/3088.html
 * (https://github.com/X-rapido/jwt-spring-boot-restful-api/)
 * 
 *
 */
@SpringBootApplication
@EnableCaching
public class AppRun {

	/**
	 * JWT 过滤器配置
	 */
	@Bean
	public FilterRegistrationBean jwtFilter() {
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new JwtFilter());
		registrationBean.addUrlPatterns("/secure/*");
		return registrationBean;
	}


	public static void main(String[] args) {
		SpringApplication.run(AppRun.class, args);
	}
}
