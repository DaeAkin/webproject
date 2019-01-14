package com.www.preschool.service;

import java.util.List;
import java.util.Map;

import com.www.preschool.dto.ChildrenDto;
import com.www.preschool.dto.JChildrenDto;

public interface JChildrenService{
	void addChild(JChildrenDto dto);
	
	List<JChildrenDto> getChildrenList();
	
	void deleteAllChildren();
	
	void updateChildren(JChildrenDto dto);
	
	JChildrenDto getChild(int child_number);
	
	List<JChildrenDto> getChildrenWithTeacher(String teacher_no);

	

}
