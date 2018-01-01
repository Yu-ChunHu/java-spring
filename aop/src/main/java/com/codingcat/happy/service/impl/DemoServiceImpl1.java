package com.codingcat.happy.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.codingcat.happy.service.DemoService;

@Service("demoServiceImpl1")
public class DemoServiceImpl1 implements DemoService {

	private static Logger logger = LoggerFactory.getLogger(DemoServiceImpl1.class);
	
	@Override
	public void apply() {
		logger.debug("In apply public access");
		// self-invocation won't be caught
		apply("Title");
	}
	
	@Override
	public void apply(String title) {
		logger.debug("In apply public access, title: {}", title);
	}
	
	public void applyPublic() {
		logger.debug("In apply public access");
	}
	
	protected void applyProtected() {
		logger.debug("In apply protected access");
	}
	
	void applyPackage() {
		logger.debug("In apply package access");
	}
	
	@SuppressWarnings("unused")
	private void applyPrivate() {
		logger.debug("In apply private access");
	}
}
