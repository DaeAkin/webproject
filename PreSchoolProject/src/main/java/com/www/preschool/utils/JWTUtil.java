package com.www.preschool.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JWTUtil {
	
	//토큰 생성 HMAC256 인코딩 사용 
	public static String createToken() {
		
		try {
			//토큰 발급
			Algorithm algorithm = Algorithm.HMAC256("pre");
			String token = JWT.create()
					.withIssuer("preschool")
//					.withClaim("name", "id Test")
//					.withExpiresAt(new Date(1))
					
					
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
			
			return true;
			
		} catch (JWTVerificationException e) {
			System.out.println("토큰 오류");
			//
			return false;
		}
		
	}
	

}
