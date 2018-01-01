package com.codingcat.happy.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement(name = "request")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso(value = { BaseRequestBody.class, SimpleRequestBody.class })
public class Request<T> {
	private RequestHeader header;
	@XmlAnyElement(lax = true)
	private T body;
	public RequestHeader getHeader() {
		return header;
	}
	public void setHeader(RequestHeader header) {
		this.header = header;
	}
	public T getBody() {
		return body;
	}
	public void setBody(T body) {
		this.body = body;
	}
	
}
