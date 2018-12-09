package com.www.preschool.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.www.preschool.db.DbOperations;
import com.www.preschool.dto.MemberDto;


public class MemberDao {
	
	DbOperations dbOperation = new DbOperations();

	public MemberDto login(MemberDto member) {
		
		return dbOperation.login(member);
	}

}
