package com.www.preschool.dao;

import org.springframework.stereotype.Repository;

import com.www.preschool.dto.PortofolioDto;
import com.www.preschool.utils.DbOperations;

@Repository("portofolioDao")
public class PortofolioDaoImpl implements PortofolioDao{

	DbOperations dbOperation = new DbOperations();
	
	@Override
	public int addPortofolio(PortofolioDto portofolio) {
		// TODO Auto-generated method stub
		
		return dbOperation.addPortofolio(portofolio);
	}

}
