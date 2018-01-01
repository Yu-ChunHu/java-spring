package com.codingcat.happy.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codingcat.happy.request.BaseRequestBody;
import com.codingcat.happy.request.Request;
import com.codingcat.happy.request.SimpleRequestBody;
import com.codingcat.happy.response.SimpleResponse;
import com.codingcat.happy.service.EchoService;
import com.codingcat.happy.service.CacheService;

@RestController
public class DemoController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private EchoService echoService;
	@Autowired
	private CacheService cacheService;
	
	@Value("${other}")
	private String other;
	
	@RequestMapping(value = "/getItem", method = RequestMethod.POST)
	public SimpleResponse getItem(
			@RequestBody Request<SimpleRequestBody> input, HttpServletRequest request) {
		logger.info("Client input: {}", ToStringBuilder.reflectionToString(input));
		SimpleRequestBody reqBody = input.getBody();
		SimpleResponse res = new SimpleResponse();
		res.setItem(cacheService.getItem(reqBody.getId()).orElse("Don't have this item's id!"));
		return res;
	}
	
	@RequestMapping(value = "/removeItem", method = RequestMethod.POST)
	public String removeItem(@RequestBody Request<SimpleRequestBody> input) {
		logger.info("Client input: {}", ToStringBuilder.reflectionToString(input));
		cacheService.removeItem(input.getBody().getId());
		return "Remove Success!";
	}
	
	@RequestMapping(value = "/emptyBody", method = RequestMethod.POST)
	public String emptyBody(@RequestBody Request<BaseRequestBody> input) {
		logger.info("Client input: {}", ToStringBuilder.reflectionToString(input));
		BaseRequestBody reqBody = input.getBody();
		logger.info("Reqeust body: {}", ToStringBuilder.reflectionToString(reqBody));
		return "Get empty body success!";
	}
}
