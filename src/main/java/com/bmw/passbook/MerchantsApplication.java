package com.bmw.passbook;

import com.bmw.passbook.security.AuthCheckInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import javax.annotation.Resource;

@SpringBootApplication
public class MerchantsApplication {
	@Resource
	private AuthCheckInterceptor authCheckInterceptor;
	private InterceptorRegistry registry;

	public static void main(String[] args) {
		SpringApplication.run(MerchantsApplication.class, args);
	}





}
