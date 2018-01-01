package com.codingcat.happy.cglib.proxy;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

import com.codingcat.happy.service.impl.DemoServiceImpl2;

public class CGLibProxySample1 {
	private static Logger logger = LoggerFactory.getLogger(CGLibProxySample1.class);
	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(DemoServiceImpl2.class);
		MethodInterceptor interceptor = (thisEnhancer, method, methodArgs, methodProxy) -> {
			logger.info("IntercepBefore Start");
			logger.debug("=== Invocate method ===");
			logger.debug("{}({})", method.getName(), methodArgs);

		    logger.debug("=== Enhancer class: {} ===", thisEnhancer.getClass());
		    Arrays
		    	.stream(thisEnhancer.getClass().getDeclaredMethods())
		    	.filter(x -> x.getName().contains("apply"))
	  	  		.forEach(x -> logger.debug("{}({})", x.getName(), x.getParameterTypes()));
//		    	.forEach(x -> logger.debug("{}", x));
		    
		    logger.info("IntercepBefore End");
		    
			return methodProxy.invokeSuper(thisEnhancer, methodArgs);
		};
		enhancer.setCallback(interceptor);
		DemoServiceImpl2 ds2 = (DemoServiceImpl2) enhancer.create();
		ds2.apply();
//		ds2.apply("CGLib Proxy");
//		Won't invoke
//		ds2.applyStatic();
	}
}
