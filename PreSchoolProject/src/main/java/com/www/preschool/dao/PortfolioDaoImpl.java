package com.www.preschool.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.www.preschool.db.DbOperations;
import com.www.preschool.dto.PortfolioDto;

@Repository("portofolioDao")
public class PortfolioDaoImpl implements PortfolioDao{
	
	
	public void setXmlLocation(String xmlLocation) {
		dbOperation.setXmlLocation(xmlLocation);
	}
	
	DbOperations dbOperation = new DbOperations();
	
	
	
	@Override
	public int addPortofolio(PortfolioDto portofolio) {
		// TODO Auto-generated method stub
		
		return dbOperation.addPortofolio(portofolio);
	}

	@Override
	public List<PortfolioDto> getAllList() {
		// TODO Auto-generated method stub
		return dbOperation.getAllList();
	}

	@Override
	public void deleteAllContent() {
		
		dbOperation.deleteAllContent();
	}

	@Override
	public PortfolioDto getOnePortfolio(String title) {
		// TODO Auto-generated method stub
		return dbOperation.getOnePortfolio(title);
	}

	@Override
	public void updatePortfolio(PortfolioDto portfolio) {
		// TODO Auto-generated method stub
		dbOperation.updatePortfolio(portfolio);
	}

	@Override
	public PortfolioDto getOnePortfolio(int portfolio_number) {
		// TODO Auto-generated method stub
		return dbOperation.getOnePortfolio(portfolio_number);
	}
}
