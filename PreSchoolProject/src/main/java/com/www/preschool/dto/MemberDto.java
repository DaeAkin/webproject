package com.www.preschool.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import org.hibernate.annotations.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

//getter, setter 자동생성
@Data
//파라미터가 없는 기본 생성자 생
//@NoArgsConstructor
//@NonNull이 붙은 필드만 생성자에 넣어줌 
@RequiredArgsConstructor
//모든 필드를 생성자에 넣어줌 
@AllArgsConstructor
//@Entity
//@Table(appliesTo = "MEMBER")
public class MemberDto {
	
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name="MEMBER_ID")
	private String member_Id;
	
	private String member_pwd;
	
//	@Column(name="MEMBER_NAME")
//	private String memberName;
//	
//	@Column(name="MEMBER_JOIN_DT")
//	private String memberJoinDt;
//	
//	@Column(name="MEMBER_LASTLOGIN_DT")
//	private String memberLastloginDt;
//	
//	@Column(name="APPLY_GRADE_NM")
//	private String applyGradeNm;
//	
//	@Column(name="APPLY_GRADE_DT")
//	private String applyGradeDt;
}
	
	
