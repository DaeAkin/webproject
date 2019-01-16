package com.www.preschool.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.www.preschool.db.DBExecute;
import com.www.preschool.db.DBTemplate;
import com.www.preschool.dto.JChildrenDto;

@Repository("jchildrenDao")
public class JChildrenDaoImpl implements JChildrenDao{
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public void addChild(JChildrenDto dto) {
		sqlSession.insert("insertChild",dto);
	}

	@Override
	public List<JChildrenDto> getChildrenList() {
		return sqlSession.selectList("selectAllChildren");
	}

	@Override
	public void deleteAllChildren() {
		sqlSession.delete("deleteAllChildren");
	}

	@Override
	public void updateChildren(JChildrenDto dto) {
		sqlSession.update("updateChildren",dto);
	}

	@Override
	public JChildrenDto getChild(int child_number) {
		return sqlSession.selectOne("selectChild");
	}

	@Override
	public List<JChildrenDto> getChildrenWithTeacher(String teacher_no) {
		return sqlSession.selectList("selectChildrenWithTeacher");
	}
}
