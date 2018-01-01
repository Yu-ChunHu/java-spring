package com.codingcat.happy.request;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "body")
public class SimpleRequestBody extends BaseRequestBody {
	private Integer id;
	private String name;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
