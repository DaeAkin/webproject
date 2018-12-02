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
//파라미터가 없는 기본 생성자 생  \
@NoArgsConstructor
//@NonNull이 붙은 필드만 생성자에 넣어줌 
@RequiredArgsConstructor
//모든 필드를 생성자에 넣어줌 
@AllArgsConstructor
@Table(name = "portfolio")
public class PortfolioDto {
	//기본키 , 기본키 생성을 DB에게 맡김 
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name="db컬럼명")
	@Column(name = "no")
	private int no;
	
	@Column(name = "teacher_no")
	@NonNull private Integer teacher_no;
	@Column(name = "child_no")
	@NonNull private Integer child_no;
	@Column(name = "title")
	@NonNull private String title;
	@Column(name = "comment")
	@NonNull private String comment;
	@Column(name = "every_day")
	@NonNull private String every_day;
	@Column(name = "photos_url")
	@NonNull private String photos_url;
	
}
