package com.group1.dto;

import java.io.Serializable;

public class Attributes implements Serializable{
	
	public String key;
	public Object value;

	public Attributes() {
	
	}

	public Attributes(String key, Object value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return key + ":" + value;
	}
	
}
