package com.codingcat.happy.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CacheService {
	private Logger logger = LoggerFactory.getLogger(getClass());
	private static Map<Integer, String> map = new HashMap<>(); 
	static {
		map.put(1, "One");
		map.put(2, "Two");
		map.put(3, "Three");
		map.put(4, "Four");
		map.put(5, "Five");
	}
	
	public String test() {
		return "aloha";
	}
	
	@Cacheable("item")
	public Optional<String> getItem(int key) {
		logger.info("Map: {}, Get and cache {} item...", map, key);
		return Optional.ofNullable(map.get(key));
	}
	
	@CacheEvict("item")
	public void removeItem(int key) {
		logger.info("Remove {} item...", key);
		map.remove(key);
	}
}
