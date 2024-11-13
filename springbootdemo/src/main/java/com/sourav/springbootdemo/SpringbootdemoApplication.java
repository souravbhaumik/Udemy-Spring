package com.sourav.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootdemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringbootdemoApplication.class, args);

		Alien obj = context.getBean(Alien.class);
		obj.code();
		System.out.println(obj);

		Alien obj1 = context.getBean(Alien.class);
		obj1.code();
		System.out.println(obj1);
	}

}
