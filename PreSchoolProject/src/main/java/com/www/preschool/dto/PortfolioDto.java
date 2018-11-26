package com.www.preschool.dto;

import java.util.Date;

import lombok.Data;

@Data
public class PortfolioDto {

	private int no;
	private int teacher_no;
	private int child_no;
	private String title;
	private String comment;
	private Date every_day;
	private String photos_url;
	
}
