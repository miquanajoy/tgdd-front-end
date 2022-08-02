package com.group1.dto;

import org.springframework.web.multipart.MultipartFile;

public class ColorVariantUpdateDTO {
	
	private MultipartFile[] updateFileDatas;
	private Integer forColorID;
	private String forColorName;

	public ColorVariantUpdateDTO() {
	}

	public ColorVariantUpdateDTO(MultipartFile[] updateFileDatas, Integer forColorID, String forColorName) {
		super();
		this.updateFileDatas = updateFileDatas;
		this.forColorID = forColorID;
		this.forColorName = forColorName;
				
	}

	public MultipartFile[] getUpdateFileDatas() {
		return updateFileDatas;
	}

	public void setUpdateFileDatas(MultipartFile[] updateFileDatas) {
		this.updateFileDatas = updateFileDatas;
	}

	public Integer getForColorID() {
		return forColorID;
	}

	public void setForColorID(Integer forColorID) {
		this.forColorID = forColorID;
	}

	public String getForColorName() {
		return forColorName;
	}

	public void setForColorName(String forColorName) {
		this.forColorName = forColorName;
	}

	@Override
	public String toString() {
		return "forColorID=" + forColorID + "\n       forColorName=" + forColorName;
	}

	

}


