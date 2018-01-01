package com.codingcat.happy.java.dynamic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codingcat.happy.service.DemoService;
import com.codingcat.happy.service.impl.DemoServiceImpl1;

public class JavaDynamicProxySample1 {
	
	private static Logger logger = LoggerFactory.getLogger(JavaDynamicProxySample1.class);
	
	public static void main(String[] args) throws Exception {
		
		DemoServiceImpl1 ds1 = new DemoServiceImpl1();
		InvocationHandler handler = (proxy, method, methodArgs) -> {
			logger.info("InvocateBefore Start");
			
			logger.debug("=== Target class: {} ===", ds1.getClass());
			logger.debug("invoke method: {}({})", method.getName(), methodArgs);
		    Arrays
		    	.stream(ds1.getClass().getDeclaredMethods())
		    	.forEach(x -> logger.debug("{}({})", x.getName(), x.getParameterTypes()));
		    
		    logger.debug("=== Proxy class: {} ===", proxy.getClass());
		    Arrays
		    	.stream(proxy.getClass().getDeclaredMethods())
		    	.filter(x -> x.getName().contains("apply"))
	  	  		.forEach(x -> logger.debug("{}({})", x.getName(), x.getParameterTypes()));
		    
		    logger.info("InvocateBefore End");
			return method.invoke(ds1, methodArgs);
			
		};
		DemoService proxyService = createProxy(DemoServiceImpl1.class, handler);
		proxyService.apply();
//		proxyService.apply("Java Dynamic Proxy");
		
//		Compiler Error: This static method of interface DemoService can only be accessed as DemoService.applyStatic
//		proxyService.applyStatic();
	}
	
	@SuppressWarnings("unchecked")
	private static <T> T createProxy(Class<? extends T> target, InvocationHandler handler) {
		Class<?>[] allInterfaces = target.getInterfaces();

	    return (T) Proxy.newProxyInstance(
	        target.getClassLoader(),
	        allInterfaces,
	        handler);
	}
}
