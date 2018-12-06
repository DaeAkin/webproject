package com.www.preschool.db;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.www.preschool.dto.PortfolioDto;

import javassist.compiler.ast.NewExpr;
import sun.net.www.content.text.plain;

public class DbOperations {

	DBTemplate dbTemplate = new DBTemplate();
	

	
	 /* 데이터베이스에 Portofolio 추가하는 메소드 */
	 public Integer addPortofolio(final PortfolioDto portfolio) {
		return dbTemplate.execute(new SessionStrategy<Integer>() {
			@Override
			public Integer doWithSession(Session session) {
				// TODO Auto-generated method stub
				
				return (Integer) session.save(portfolio);
			}
		});
	 }


	// 포토폴리오의 모든 리스트를 가져오는 함수
	 public List<PortfolioDto> getAllList() {
		 return dbTemplate.execute(new SessionStrategy<List<PortfolioDto>>() {
			@Override
			public List<PortfolioDto> doWithSession(Session session) {
				// TODO Auto-generated method stub
				return session.createNativeQuery("select * from portfolio").list();
			}
			 
		});
	 }


	public <T> void deleteAllContent() {
		dbTemplate.execute(new SessionStrategy<T>() {

			@Override
			public T doWithSession(Session session) {
				// TODO Auto-generated method stub
				session.createNativeQuery("delete from portfolio").executeUpdate();
				return null;
			}
			
		});
	}
	
	public <T> void updatePortfolio(final PortfolioDto portfolio) {
		dbTemplate.execute(new SessionStrategy<T>() {

			@Override
			public T doWithSession(Session session) {
				// TODO Auto-generated method stub
				session.update(portfolio);
				return null;
			}
		});
	}
	

	
	public PortfolioDto getOnePortfolio(final int portfolio_number) {
		return dbTemplate.execute(new SessionStrategy<PortfolioDto>() {

			@Override
			public PortfolioDto doWithSession(Session session) {
				// TODO Auto-generated method stub
				return session.get(PortfolioDto.class, portfolio_number);
			}
			
		});
	}
				



}
