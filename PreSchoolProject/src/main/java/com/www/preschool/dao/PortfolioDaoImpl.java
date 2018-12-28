package com.www.preschool.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.www.preschool.db.DBExecute;
import com.www.preschool.db.DBTemplate;
import com.www.preschool.db.SessionStrategy;
import com.www.preschool.dto.PortfolioDto;

@Repository("portfolioDao")
public class PortfolioDaoImpl implements PortfolioDao{
	
	

	
	@Autowired
	private SqlSession sqlSession;
	
	DBTemplate dbTemplate = new DBTemplate();
	DBExecute dbExecute = new DBExecute();
	
	public PortfolioDaoImpl() {
		
	}
	
	@Override
	public int addPortofolio(Map<String, Object> paramMap) {
		System.out.println("addPortfolio ParamMap : " + paramMap.toString());
		return sqlSession.insert("addPortofolio",paramMap);
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
	public void deleteAllContent() {
		System.out.println("---- deleteAllContent ----");
		System.out.println("check sqlSession null :"+  sqlSession);
		System.out.println("deleteAllContent sqlSession : " + sqlSession);
		sqlSession.delete("deleteAllPortfolio");
	}


	@Override
	public int updatePortfolio(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return sqlSession.update("updatePortfolio",paramMap);
	}

	@Override
	public PortfolioDto getOnePortfolio(final int portfolio_number) {
		return dbExecute.getOne(portfolio_number , PortfolioDto.class);
	}

	@Override
	public List<PortfolioDto> getOnePortfolioWtihChildren_no(int children_no) {
		// TODO Auto-generated method stub
		System.out.println("sqlSession null ? : " + sqlSession);
		return sqlSession.selectList("getOnePortfolioWtihChildren_no",children_no);
	}

	@Override
	public int delete(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return 0;
	}
}
