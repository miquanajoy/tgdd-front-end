package com.group1.dto;

import org.springframework.web.multipart.MultipartFile;

public class MultiFieldsFilePathDTO {

	MultipartFile[] imageFile;
	MultipartFile[] cameraShotsFile;
	MultipartFile[] featureFile;
	MultipartFile[] unboxingFile;
	
	public MultiFieldsFilePathDTO() {
		
	}

	public MultiFieldsFilePathDTO(MultipartFile[] imageFile, MultipartFile[] cameraShotsFile,
			MultipartFile[] featureFile, MultipartFile[] unboxingFile) {
		super();
		this.imageFile = imageFile;
		this.cameraShotsFile = cameraShotsFile;
		this.featureFile = featureFile;
		this.unboxingFile = unboxingFile;
	}

	public MultipartFile[] getImageFile() {
		return imageFile;
	}

	public void setImageFile(MultipartFile[] imageFile) {
		this.imageFile = imageFile;
	}

	public MultipartFile[] getCameraShotsFile() {
		return cameraShotsFile;
	}

	public void setCameraShotsFile(MultipartFile[] cameraShotsFile) {
		this.cameraShotsFile = cameraShotsFile;
	}

	public MultipartFile[] getFeatureFile() {
		return featureFile;
	}

	public void setFeatureFile(MultipartFile[] featureFile) {
		this.featureFile = featureFile;
	}

	public MultipartFile[] getUnboxingFile() {
		return unboxingFile;
	}

	public void setUnboxingFile(MultipartFile[] unboxingFile) {
		this.unboxingFile = unboxingFile;
	}

	
}
