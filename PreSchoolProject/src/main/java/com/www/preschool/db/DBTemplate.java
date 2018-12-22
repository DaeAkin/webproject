package com.www.preschool.db;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.www.preschool.dto.ChildrenDto;
import com.www.preschool.dto.PortfolioDto;

public class DBTemplate implements SessionCallback{
	private SessionFactory factory;
	
	
	public static String xmlLocation = "hibernate.cfg.xml";
	
	public static void setXmlLocation(String xmlLocation) {
		DBTemplate.xmlLocation = xmlLocation;
	}
	

	
	private SessionFactory buildSessionFacotry() {
    	
	       try {
	            factory = new Configuration().
	            		configure(xmlLocation).
	            		addAnnotatedClass(PortfolioDto.class).
	            		addAnnotatedClass(ChildrenDto.class).
	            		buildSessionFactory();
	           
	         } catch (Throwable ex) { 
	            System.err.println("Failed to create sessionFactory object." + ex);
	            throw new ExceptionInInitializerError(ex); 
	         }
	       return factory;
		}



	@Override
	public <T> T execute(SessionStrategy<T> ssst) {
		
		buildSessionFacotry();
		
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			T t = ssst.doWithSession(session);
			tx.commit();
			return t;
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	
	public List<ChildrenDto> getAllChildren() {
		buildSessionFacotry();
		
		Session session = factory.openSession();
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<ChildrenDto> cr = cb.createQuery(ChildrenDto.class);
		Root<ChildrenDto> root = cr.from(ChildrenDto.class);
	
		cr.select(root);
		
		Query<ChildrenDto> query = session.createQuery(cr);
		return query.getResultList();
	}

	
	public List<ChildrenDto> getchildrenWithTeacherNo(int teacher_no) {
		buildSessionFacotry();
		
		Session session = factory.openSession();
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<ChildrenDto> cr = cb.createQuery(ChildrenDto.class);
		Root<ChildrenDto> root = cr.from(ChildrenDto.class);
		cr.select(root).where(cb.equal(root.get("teacher_no",)));
		
		Query<ChildrenDto> query = session.createQuery(cr);
		return query.getResultList();
	}

}
