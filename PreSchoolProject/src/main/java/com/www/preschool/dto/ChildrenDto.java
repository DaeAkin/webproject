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

@Entity
// getter, setter 자동생성
@Data
//파라미터가 없는 기본 생성자 생성
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "children")

public class ChildrenDto {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name="db컬럼명")
	@Column(name = "no")
	private int no;
	
	@Column(name="teacher_no")
	@NonNull private Integer teacher_no;
	@Column(name="name")
	@NonNull private String name;
	@Column(name="age")
	@NonNull private Integer age;
	@Column(name="gender")
	@NonNull private boolean gender;
	@Column(name="parentPhone")
	@NonNull private String parentPhone;
	@Column(name="photo_url")
	@NonNull private String photo_url;
	
}
