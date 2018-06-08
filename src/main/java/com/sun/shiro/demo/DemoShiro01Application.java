package com.sun.shiro.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sun.shiro.demo.respository")
public class DemoShiro01Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoShiro01Application.class, args);
	}
}
