package com.codingcat.happy.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import com.codingcat.happy.service.DemoService;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DemoServiceImpl2 implements DemoService {

	private static Logger logger = LoggerFactory.getLogger(DemoServiceImpl2.class);
	
	@Override
	public void apply() {
		logger.debug("In apply public access");
	}
	
	@Override
	public void apply(String title) {
		logger.debug("In apply public access, title: {}", title);
	}
	
	public void applyPublic() {
		logger.debug("In apply public access");
		// self-invocation won't be caught
		apply("Title1");
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
	
	public static void applyStatic() {
		logger.debug("I'm static method!");
	}
	
}
