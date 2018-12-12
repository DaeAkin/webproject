package com.www.preschool.dao;

import org.springframework.stereotype.Repository;

import com.www.preschool.db.DBExecute;
import com.www.preschool.db.DbOperations;
import com.www.preschool.dto.MemberDto;

@Repository("memberDao")
public class MemberDaoImpl implements MemberDao{
	
	DBExecute dbExecute = new DBExecute();

	@Override
	public int addMember(MemberDto memberDto) {
		// TODO Auto-generated method stub
		return dbExecute.addExecute(memberDto);
	}

}
