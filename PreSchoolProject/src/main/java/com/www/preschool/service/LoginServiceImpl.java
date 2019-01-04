package com.www.preschool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.www.preschool.dao.AdminDao;
import com.www.preschool.dao.MemberDao;
import com.www.preschool.dto.MemberDto;


@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	AdminDao adminDao;
	
	//로그인
	@Override
	public MemberDto login(MemberDto member) {

		return adminDao.login(member);
	}

}
