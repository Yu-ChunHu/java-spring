package com.codingcat.happy.aop.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {
	
	private static Logger logger = LoggerFactory.getLogger(LoggerAspect.class);
	
	@Before(value = "PointcutDefinition.serviceLayer()")
	public void logBefore(JoinPoint joinPoint) {
		logger.info("logBefore Start");
		
		MethodSignature signature = (MethodSignature)joinPoint.getSignature();
	    logger.debug("=== Signature class: {} ===", signature.getDeclaringType().getName());
	    logger.debug("{}({})", signature.getMethod().getName(), joinPoint.getArgs());
	    
	    Object targetBean = joinPoint.getTarget();
	    logger.debug("=== Target class: {} ===", targetBean.getClass());
	    Arrays
	    	.stream(targetBean.getClass().getDeclaredMethods())
	    	.forEach(x -> logger.debug("{}({})", x.getName(), x.getParameterTypes()));
	    
	    Object thisBean = joinPoint.getThis();
	    logger.debug("=== This class: {} ===", thisBean.getClass());
	    
	    Arrays
	    	.stream(thisBean.getClass().getDeclaredMethods())
	    	.filter(x -> x.getName().contains("apply"))
  	  		.forEach(x -> logger.debug("{}({})", x.getName(), x.getParameterTypes()));
	    
	    logger.info("logBefore End");
	}
	
}
