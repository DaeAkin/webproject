package com.www.preschool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.www.preschool.dao.PortfolioDao;
import com.www.preschool.dao.PortfolioDaoImpl;
import com.www.preschool.dto.PortfolioDto;
import com.www.preschool.utils.ImageUploadUtil;

@Service
public class PortfolioServiceImpl implements PortfolioService {

	@Autowired
	ImageUploadUtil imageUploadUtil;
	
	@Autowired
	PortfolioDao portfolioDao = new PortfolioDaoImpl();
	
	@Override
	public void imageUpload(MultipartFile file) {
		
	}

	@Override
	public void select() {
		// TODO Auto-generated method stub

	}

	@Override
	public int insert(PortfolioDto portofolio) {
		System.out.println("insert service ");
		return portfolioDao.addPortofolio(portofolio);
	}

	@Override
	public List<PortfolioDto> getAllList() {
		
		return portfolioDao.getAllList();
	}

	

}
