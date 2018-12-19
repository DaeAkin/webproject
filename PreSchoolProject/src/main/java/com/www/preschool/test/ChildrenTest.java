package com.www.preschool.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.www.preschool.dto.ChildrenDto;
import com.www.preschool.service.ChildrenService;
import com.www.preschool.service.ChildrenServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "context-testContext.xml")
public class ChildrenTest {
	
	ChildrenDto child;
	
	@Autowired
	ChildrenService childrenService;
						
	
	@Before
	public void setUp() {
		child = new ChildrenDto(1, 
				"name", 2, true, "01011112222", "test.png");
	}
	
	
	@Test
	public void addAndGet() {
		//DB테이블 저눕 삭제
		childrenService.deleteAllContent();
		
		//데이터 1개 주입
		childrenService.insert(child);
		
		List<ChildrenDto> result = 
				childrenService.getAllList();
		
		for (ChildrenDto childrenDto : result) {
			System.out.println(childrenDto.toString());
		}
		
		List<ChildrenDto> result2 = 
				childrenService.getchildrenWithTeacherNo(String.valueOf(child.getTeacher_no()));
		
		for (ChildrenDto childrenDto : result2) {
			System.out.println(childrenDto.toString());
		}
		
		
		
		
		
	}

}
