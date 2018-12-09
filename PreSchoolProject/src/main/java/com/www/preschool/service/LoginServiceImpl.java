package com.www.preschool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.www.preschool.dao.MemberDao;
import com.www.preschool.dto.MemberDto;


@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	MemberDao memberDao;
	
	//로그인
	@Override
	public MemberDto login(MemberDto member) {

		return memberDao.login(member);
	}

}
