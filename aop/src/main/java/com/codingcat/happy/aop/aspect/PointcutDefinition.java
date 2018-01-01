package com.codingcat.happy.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutDefinition {
	
	@Pointcut("within(@org.springframework.stereotype.Service *)")
	public void serviceLayer() {
		
	}
}
