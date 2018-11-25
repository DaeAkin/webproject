package com.www.preschool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.www.preschool.utils.ImageUploadUtil;

public class PortofolioServiceImpl implements PortofolioService {

	@Autowired
	ImageUploadUtil imageUploadUtil;
	@Override
	public void imageUpload(MultipartFile file) {
		

	}

	@Override
	public void select() {
		// TODO Auto-generated method stub

	}

	@Override
	public void insert() {
		// TODO Auto-generated method stub

	}

	

}
