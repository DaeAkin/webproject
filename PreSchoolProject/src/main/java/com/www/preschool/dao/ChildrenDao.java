package com.www.preschool.dao;

import java.util.List;

import com.www.preschool.dto.ChildrenDto;

public interface ChildrenDao{
	int add(ChildrenDto child);
	
	List<ChildrenDto> getAllList();
	
	<T> void deleteAllContent();
	
	<T> void update(ChildrenDto child);
	
	ChildrenDto getOneChild(int child_number);
	
	List<ChildrenDto> getchildrenWithTeacherNo(String teacher_no);

	

}
