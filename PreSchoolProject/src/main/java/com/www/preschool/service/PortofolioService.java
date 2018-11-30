package com.www.preschool.service;

import org.springframework.web.multipart.MultipartFile;

import com.www.preschool.dto.PortofolioDto;

public interface PortofolioService {
	
	
	void imageUpload(MultipartFile file);
	
	void select();
	
	int insert(PortofolioDto portofolio);
	

}
