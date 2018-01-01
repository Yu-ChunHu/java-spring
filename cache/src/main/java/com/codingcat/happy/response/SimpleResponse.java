package com.codingcat.happy.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SimpleResponse {
	private String item;

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}
	
}
