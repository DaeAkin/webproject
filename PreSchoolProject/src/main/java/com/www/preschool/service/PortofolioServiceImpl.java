package com.www.preschool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.www.preschool.dao.PortofolioDao;
import com.www.preschool.dao.PortofolioDaoImpl;
import com.www.preschool.dto.PortofolioDto;
import com.www.preschool.utils.ImageUploadUtil;

@Service
public class PortofolioServiceImpl implements PortofolioService {

	@Autowired
	ImageUploadUtil imageUploadUtil;
	
	@Autowired
	PortofolioDao portofolioDao = new PortofolioDaoImpl();
	
	@Override
	public void imageUpload(MultipartFile file) {
		
	}

	@Override
	public void select() {
		// TODO Auto-generated method stub

	}

	@Override
	public int insert(PortofolioDto portofolio) {
		System.out.println("insert service ");
		return portofolioDao.addPortofolio(portofolio);
	}

	

}
