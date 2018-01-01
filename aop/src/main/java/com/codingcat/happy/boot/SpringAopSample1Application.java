package com.codingcat.happy.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.codingcat.happy.service.DemoService;
import com.codingcat.happy.service.impl.DemoServiceImpl2;

@SpringBootApplication(scanBasePackages = {
						"com.codingcat.happy.service.impl",
						"com.codingcat.happy.aop.aspect"
					  })
public class SpringAopSample1Application {
	
	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = 
				SpringApplication.run(SpringAopSample1Application.class, args);
		
		// Demo1: Use Java proxy
		DemoService demoService1 = context.getBean("demoServiceImpl1", DemoService.class);
		demoService1.apply();
		
		// Demo2: Use CGLib proxy
		DemoServiceImpl2 demoService2 = context.getBean(DemoServiceImpl2.class);
		demoService2.applyPublic();
	}
}
