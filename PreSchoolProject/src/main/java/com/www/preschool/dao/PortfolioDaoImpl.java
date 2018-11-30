package com.www.preschool.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.www.preschool.dto.PortfolioDto;
import com.www.preschool.utils.DbOperations;

@Repository("portofolioDao")
public class PortfolioDaoImpl implements PortfolioDao{

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

}
