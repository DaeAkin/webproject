package com.www.preschool.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;


@Data // getter, setter 자동생성
@NoArgsConstructor //파라미터가 없는 기본 생성자 생성
@RequiredArgsConstructor
@AllArgsConstructor
public class JChildrenDto {
	//@Column(name="db컬럼명")
	@NonNull private int no;
	@NonNull private Integer teacher_no;
	@NonNull private String name;
	@NonNull private Integer age;
	@NonNull private boolean gender;
	@NonNull private String parentPhone;
	private String photo_url;
	
	@Override
	public String toString() {
		return "{no=" + no + ", teacher_no=" + teacher_no + ", name=" + name + ", age=" + age + ", gender="
				+ gender + ", parentPhone=" + parentPhone + ", photo_url=" + photo_url + "}";
	}
	
	
}
