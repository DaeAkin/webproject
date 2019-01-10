package com.www.preschool.utils;

import java.util.Calendar;
import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.www.preschool.exception.TokeninvalidException;

public class JWTUtil {
	
	//토큰 생성 HMAC256 인코딩 사용 
	public static String createToken(String id) {
		
		//Create the token with a validity of 15 minutes and client context (fingerprint) information
		Calendar c = Calendar.getInstance();
		Date now = c.getTime();
		c.add(Calendar.MINUTE, 15);
		Date expirationDate = c.getTime();
		
		try {
			//토큰 발급
			Algorithm algorithm = Algorithm.HMAC256("pre");
			String token = JWT.create()
					.withIssuer("preschool")
					.withSubject(id)
//					.withClaim("name", "id Test")
					.withExpiresAt(expirationDate) // 15분후 만료
					
					
					.sign(algorithm);
			
			return token;
		} catch (JWTCreationException e) {
			System.out.println(" 토큰 생성 실패");
		}
		return null;
		
	}
	
	
	// 토큰 인증 
	// 
	public static Boolean verifyToken(String token) {
			try {
			
			
			Algorithm algorithm = Algorithm.HMAC256("pre");
			System.out.println(token);
			JWTVerifier verifier = JWT.require(algorithm)
					.withIssuer("preschool") // 생성해준 사람 
//					.acceptLeeway(1)
//					.acceptExpiresAt(1)
					.build();
			DecodedJWT jwf = verifier.verify(token);
			
			System.out.println("토큰인증 성공");
			return true;
			
		} catch (JWTVerificationException e) {
			System.out.println("토큰 오류");
			throw new TokeninvalidException();
			//
			
		}
		
	}
	

}
