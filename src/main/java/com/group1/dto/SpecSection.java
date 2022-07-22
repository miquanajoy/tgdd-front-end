package com.group1.dto;

import java.io.Serializable;
import java.util.List;

public class SpecSection implements Serializable{

	String section;
	public List<Attributes> attributes;
	
	public SpecSection() {
		
	}

	public SpecSection(String section, List<Attributes> attributes) {
		super();
		this.section = section;
		this.attributes = attributes;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public List<Attributes> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<Attributes> attributes) {
		this.attributes = attributes;
	}

	@Override
	public String toString() {
		return section + "\n    " + attributes;
	}

	
}