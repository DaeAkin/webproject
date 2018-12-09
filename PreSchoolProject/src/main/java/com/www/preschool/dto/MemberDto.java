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
//getter, setter 자동생성
@Data
//파라미터가 없는 기본 생성자 생성
@NoArgsConstructor
//@NonNull이 붙은 필드만 생성자에 넣어줌 
@RequiredArgsConstructor
//모든 필드를 생성자에 넣어줌 
@AllArgsConstructor
@Table(name = "MEMBER")
public class MemberDto {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name="db컬럼명")
	@Column(name = "no")
	private String MEMBER_ID;
	
	@NonNull
	@Column(name = "teacher_no")
	private String MEMBER_PWD;
}
