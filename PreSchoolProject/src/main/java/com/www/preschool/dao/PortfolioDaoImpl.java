package com.www.preschool.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.www.preschool.db.DBExecute;
import com.www.preschool.db.DBTemplate;
import com.www.preschool.db.DbOperations;
import com.www.preschool.db.SessionStrategy;
import com.www.preschool.dto.PortfolioDto;

@Repository("portofolioDao")
public class PortfolioDaoImpl implements PortfolioDao{
	
	

	
	@Autowired
	SqlSession sqlSession;
	
	DBTemplate dbTemplate = new DBTemplate();
	DBExecute dbExecute = new DBExecute();
	
	
	@Override
	public int addPortofolio(final PortfolioDto portofolio) {
		return dbExecute.addExecute(portofolio);
	}

	//리펙토링 안함.
	@Override
	public List<PortfolioDto> getAllList() {
		// TODO Auto-generated method stub
		 return dbTemplate.execute(new SessionStrategy<List<PortfolioDto>>() {
			@Override
			public List<PortfolioDto> doWithSession(Session session) {
				// TODO Auto-generated method stub
				return session.createNativeQuery("select * from portfolio").list();
			}
			 
		});
	}

	@Override
	public <T> void deleteAllContent() {
		sqlSession.delete("deleteAllPortfolio");
	}


	@Override
	public <T> void updatePortfolio(final PortfolioDto portfolio) {
		// TODO Auto-generated method stub
		dbExecute.update(portfolio);
	}

	@Override
	public PortfolioDto getOnePortfolio(final int portfolio_number) {
		return dbExecute.getOne(portfolio_number , PortfolioDto.class);
	}
}
