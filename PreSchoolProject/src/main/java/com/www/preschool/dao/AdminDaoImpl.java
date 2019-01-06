package com.www.preschool.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.www.preschool.dto.MemberDto;

@Repository("adminDao")
public class AdminDaoImpl implements AdminDao{
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public MemberDto login(MemberDto member) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("selectMember", member);
	}

}
