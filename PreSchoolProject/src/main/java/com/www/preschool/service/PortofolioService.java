package com.www.preschool.service;

import org.springframework.web.multipart.MultipartFile;

public interface PortofolioService {
	
	
	void imageUpload(MultipartFile file);
	
	void select();
	
	void insert();
	
	
	
	

}
