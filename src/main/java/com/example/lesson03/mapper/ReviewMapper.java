package com.example.lesson03.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson03.domain.Review;

@Repository
public interface ReviewMapper {
	public Review selectReview(int id);
	
	// return int(MyBatis가 성공된 행의 개수를 리턴해준다.)
	public int insertReview(Review review); // 파라미터가 한개이므로 @Param 생략 
	public int insertReviewAsField(
			
			// 파라미터 2개 이상이면 => map으로 만든다 => 하나의 맵 => 하나의 객체가 돼서 xml로 갈 수 있다. @Param => 맵으로 만들어주는 어노테이션
			@Param("storeId") int storeId, 
			@Param("menu") String menu, 
			@Param("userName") String userName, 
			@Param("point") Double point, 
			@Param("review") String review);
	
	public int updateReviewById(
			@Param("id") int id, 
			@Param("review") String review);
	
	public int deleteReviewById (int id);
}