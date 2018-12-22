package com.www.preschool.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.www.preschool.db.DBExecute;
import com.www.preschool.db.DBTemplate;
import com.www.preschool.dto.ChildrenDto;

@Repository("childrenDao")
public class ChildrenDaoImpl implements ChildrenDao{
	DBExecute dbExecute = new DBExecute(); 
	DBTemplate dbTemplate = new DBTemplate();

	@Override
	public int add(ChildrenDto child) {
		// TODO Auto-generated method stub
		return dbExecute.addExecute(child);
	}

	@Override
	public List<ChildrenDto> getAllList() {
		// TODO Auto-generated method stub
		return dbTemplate.getAllChildren();
	}

	@Override
	public <T> void deleteAllContent() {
		// TODO Auto-generated method stub
		dbExecute.deleteAllContent("delete from children");
		
	}

	@Override
	public <T> void update(ChildrenDto child) {
		// TODO Auto-generated method stub
		dbExecute.update(child);
	}

	@Override
	public ChildrenDto getOneChild(int child_number) {
		// TODO Auto-generated method stub
		return dbExecute.getOne(child_number, ChildrenDto.class);
	}

	@Override
	public List<ChildrenDto> getchildrenWithTeacherNo(String teacher_no) {
		// TODO Auto-generated method stub
		return dbTemplate.getchildrenWithTeacherNo(teacher_no);
	}
	
}
