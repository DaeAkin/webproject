package com.www.preschool.test;

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

public class JWFTest {
	
	//String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXUyJ9.eyJpc3MiOiJhdXRoMCJ9.AbIJTDMFc7yUa5MhvcP03nJPyCPzZtQcGEp-zWfOkEE";
	String token;
	@Test
	public void createToken() throws InterruptedException  {
		
		
		System.out.println(JWTUtil.createToken("test"));	

		
//		try {
//		    DecodedJWT jwt = JWT.decode(token);
//		    System.out.println(jwt.getContentType());
//		} catch (JWTDecodeException exception){
//		    //Invalid token
//		}
		
		
	}
	

	
	

}
