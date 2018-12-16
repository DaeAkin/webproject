package com.www.preschool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.www.preschool.dao.ChildrenDao;
import com.www.preschool.dto.ChildrenDto;

@Service
public class ChildrenServiceImpl implements ChildrenService {

	@Autowired
	ChildrenDao childrenDao;

	@Override
	public ChildrenDto select(int child_number) {
		// TODO Auto-generated method stub
		return childrenDao.getOneChild(child_number);
	}

	@Override
	public void update(ChildrenDto child) {
		// TODO Auto-generated method stub
		childrenDao.update(child);
	}

	@Override
	public int insert(ChildrenDto child) {
		// TODO Auto-generated method stub
		return childrenDao.add(child);
	}

	@Override
	public List<ChildrenDto> getAllList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllContent() {
		// TODO Auto-generated method stub
		childrenDao.deleteAllContent();
		
	}

	@Override
	public ChildrenDto getOnePortfolio(String title) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
