package com.www.preschool.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
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
	SqlSession sqlSession;
	
	@Autowired
	PortfolioDao portfolioDao = new PortfolioDaoImpl();
	
	@Override
	public void imageUpload(MultipartFile file) {
		
	}

	@Override
	public PortfolioDto select(int portfolio_number) {
		// TODO Auto-generated method stub
		System.out.println("select service");
		return portfolioDao.getOnePortfolio(portfolio_number);
	}
	
	@Override
	public void update(PortfolioDto portfolio) {
		// TODO Auto-generated method stub
		System.out.println("update success");
		portfolioDao.updatePortfolio(portfolio);;
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

	@Override
	public void deleteAllContent() {
		portfolioDao.deleteAllContent();
		
	}

	@Override
	public PortfolioDto getOnePortfolio(String title) {
		// TODO Auto-generated method stub
		return portfolioDao.getOnePortfolio(title);
	}

	@Override
	public List<PortfolioDto> getOnePortfolioWtihChildren_no(int children_no) {
		// TODO Auto-generated method stub
		return portfolioDao.getOnePortfolioWtihChildren_no(children_no);
	}

	

}
