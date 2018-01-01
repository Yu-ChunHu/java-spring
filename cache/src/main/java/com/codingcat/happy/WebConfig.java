package com.codingcat.happy;

import java.util.List;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableWebMvc
@EnableCaching
@EnableSwagger2
@ComponentScan({ "com.codingcat.happy.controller" })
public class WebConfig extends WebMvcConfigurerAdapter {
 
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    	converters.add(new MappingJackson2HttpMessageConverter());
    	converters.add(new Jaxb2RootElementHttpMessageConverter());
        super.configureMessageConverters(converters);
    }
    
    @Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    registry
	    	.addResourceHandler("swagger-ui.html")
	    	.addResourceLocations("classpath:/META-INF/resources/");
	    registry
	    	.addResourceHandler("/webjars/**")
	    	.addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
	
	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
        	.select()
        		.apis(RequestHandlerSelectors.basePackage("com.codingcat.happy.controller"))
        		.paths(PathSelectors.any())
        		.build();
    }
    
}
