package com.codingcat.happy.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface DemoService {
	void apply();
	void apply(String title);
	
	static void applyStatic() {
		Logger logger = LoggerFactory.getLogger(DemoService.class);
		logger.debug("I'm static method");
	}
}
