package com.www.preschool.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.www.preschool.utils.JWTUtil;
import com.www.preschool.utils.TokenContainer;

public class JWFTest {
	
	
	@Test
	public void JWTTest()  {
		String id= "test1";
		
		String token_id = JWTUtil.createToken();
		
		TokenContainer.tokenMap.put(id, token_id);
		
		System.out.println("id의 토큰 : " + token_id);
		
		assertThat(JWTUtil.verifyToken(TokenContainer.tokenMap.get(id)), is(false));
		
		
		
		
	}
	

	
	

}
