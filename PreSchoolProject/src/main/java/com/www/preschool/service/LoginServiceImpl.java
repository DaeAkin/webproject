package com.www.preschool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.www.preschool.dao.AdminDao;
import com.www.preschool.dao.MemberDao;
import com.www.preschool.dto.MemberDto;
import com.www.preschool.utils.JWTUtil;


@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	AdminDao adminDao;
	
	//로그인
	@Override
	public MemberDto login(MemberDto member) {
		MemberDto newMember = adminDao.login(member);
		
		// 로그인이 성공 되면
		if(newMember != null) {
			String createdToken = 
					JWTUtil.createToken(member.getMember_id());
		
			System.out.println("생성된 토큰 : " + createdToken);
		// 로그인이 실패 일때 
		} else {
			
		
		}
		
		 
		return newMember;
 	}
	


}
