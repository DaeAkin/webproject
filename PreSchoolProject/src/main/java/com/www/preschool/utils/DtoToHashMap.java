package com.www.preschool.utils;

import java.util.HashMap;
import java.util.Map;

import com.www.preschool.dto.PortfolioDto;

public class DtoToHashMap {

	public static Map<String, Object> folioDtoToHashMap(
			PortfolioDto portfolioDto) {
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("teacher_no", portfolioDto.getTeacher_no());
		resultMap.put("child_no", portfolioDto.getChild_no());
		resultMap.put("title", portfolioDto.getTitle());
		resultMap.put("comment", portfolioDto.getComment());
		resultMap.put("every_day", portfolioDto.getEvery_day());
		resultMap.put("photos_url", portfolioDto.getPhotos_url());
		
		return resultMap;
	}
}
