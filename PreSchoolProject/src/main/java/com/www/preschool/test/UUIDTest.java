package com.www.preschool.test;

import org.junit.Test;

import com.www.preschool.utils.CommonUtils;

public class UUIDTest {
	
	@Test
	public void test() {
		System.out.println(CommonUtils.createUUID());
		System.out.println(CommonUtils.getToday());
		System.out.println(CommonUtils.createUUID() + CommonUtils.getToday());
	}

}
