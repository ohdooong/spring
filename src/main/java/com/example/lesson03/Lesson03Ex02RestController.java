package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;
import com.example.lesson03.domain.Review;

@RestController
public class Lesson03Ex02RestController {
	
	@Autowired
	private ReviewBO reviewBO;

	// 요청 URL: http://localhost/lesson03/ex02/1
	@RequestMapping("lesson03/ex02/1")
	public String ex02_1 () {
		Review review = new Review(); // 일반 자바 bean
		review.setStoreId(7);
		review.setMenu("삼겹혼밥세트");
		review.setUserName("사자고양이");
		review.setPoint(4.1);
		review.setReview("혼자 먹기 딱 적당해요");
		
		int rowCount = reviewBO.addReview(review);
		
		return "성공된 행의 개수:" + rowCount;
	}
	
	// 파라미터 보내는 방식으로
	// 요청 URL: http://localhost/lesson03/ex02/2
	@RequestMapping("lesson03/ex02/2")
	public String ex02_2 () {
		int rowCount = reviewBO.addReviewAsField(4, "콤비네이션R", "오리궁둥이", 5.0, "너무나 맛있는 햄버거집 최고~!");
		return "성공한 행의 개수 : " + rowCount;
	}
	
}
