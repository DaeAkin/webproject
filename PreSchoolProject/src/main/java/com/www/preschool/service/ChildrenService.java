package com.www.preschool.service;

import java.util.List;

import com.www.preschool.dto.ChildrenDto;

public interface ChildrenService {
	
	  	ChildrenDto select(int child_number);
		
		void update(ChildrenDto child);
		
		int insert(ChildrenDto child);
		
		List<ChildrenDto> getAllList();
		
		void deleteAllContent();

		ChildrenDto getOnePortfolio(String title);

}
