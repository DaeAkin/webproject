package com.www.preschool.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.www.preschool.dao.JChildrenDao;
import com.www.preschool.dto.ChildrenDto;
import com.www.preschool.dto.JChildrenDto;
import com.www.preschool.service.ChildrenService;
import com.www.preschool.service.ChildrenServiceImpl;
import com.www.preschool.service.JChildrenService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "context-testContext.xml")
public class ChildrenTest {
	
	JChildrenDto child;
	
	@Autowired
	JChildrenService jchildrenService;
						
	@Autowired
	JChildrenDao jchildrenDao;
	
	@Before
	public void setUp() {
	}
	
	
	@Test
	public void addAndGet() {
		System.out.println("hi");
		
		
		//jchildrenService.deleteAllChildren();
		child = new JChildrenDto(3, 3, "john",6,false,"01033333333","test.url");
		
		//jchildrenService.addChild(child);
		
		child.setName("chris");
		//jchildrenService.updateChildren(child);
		//jchildrenService.addChild(child.to);	
		System.out.println(jchildrenDao.getChild(1));
		//System.out.println(child2.getName());
	}

}
