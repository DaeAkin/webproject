package com.www.preschool.test;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

import com.www.preschool.utils.ImageUploadUtil;

public class ImageUploadTest {
	
	
	byte[] bytes = null;
	File file = null;
	
	ImageUploadUtil imageUploadUtil = new ImageUploadUtil();
	@Before
	public void setUp() throws IOException {
		
		file = new File("/Users/donghyeonmin/git/webproject/PreSchoolProject/src/main/java/com/www/preschool/test/apple.jpg");
		InputStream is = new FileInputStream(file);
		bytes = IOUtils.toByteArray(is);
		
		
		
	}
	
	@Test
	public void imageUploadTest() throws Exception {
		System.out.println(file.getName());
		
		String uploadPath = "/Users/donghyeonmin/git/webproject/PreSchoolProject/src/main/java/com/www/preschool/test/apple.jpg";
		
		imageUploadUtil.uploadFile(uploadPath, file.getName(), bytes);
	}

}
