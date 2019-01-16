package com.www.preschool.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.www.preschool.dao.ChildrenDao;
import com.www.preschool.dao.JChildrenDao;
import com.www.preschool.dto.ChildrenDto;
import com.www.preschool.dto.JChildrenDto;

@Service
public class JChildrenServiceImpl implements JChildrenService {

	@Autowired
	JChildrenDao JchildrenDao;

	@Override
	public void addChild(JChildrenDto dto) {
		JchildrenDao.addChild(dto);
		
	}

	@Override
	public List<JChildrenDto> getChildrenList() {
		return JchildrenDao.getChildrenList();
	}

	@Override
	public void deleteAllChildren() {
		JchildrenDao.deleteAllChildren();
	}

	@Override
	public void updateChildren(JChildrenDto dto) {
		JchildrenDao.updateChildren(dto);
	}

	@Override
	public JChildrenDto getChild(int child_number) {
		return JchildrenDao.getChild(child_number);
	}

	@Override
	public List<JChildrenDto> getChildrenWithTeacher(String teacher_no) {
		return JchildrenDao.getChildrenWithTeacher(teacher_no);
	}

	
	
	

}
