package com.www.preschool.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
// getter, setter 자동생성
@Data
//파라미터가 없는 기본 생성자 생
@NoArgsConstructor
//@NonNull이 붙은 필드만 생성자에 넣어줌 
@RequiredArgsConstructor
//모든 필드를 생성자에 넣어줌 
@AllArgsConstructor
public class PortfolioDto {

	private int no;
	
	@NonNull private Integer teacher_no;
	@NonNull private Integer child_no;
	@NonNull private String title;
	@NonNull private String comment;
	@NonNull private String every_day;
	@NonNull private String photos_url;
	
}
