package com.www.preschool.utils;

import java.util.UUID;

public class CommonUtils {
	//UUID용 메소드
	public static String getRandomString() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
