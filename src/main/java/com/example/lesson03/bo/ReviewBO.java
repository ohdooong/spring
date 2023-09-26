package com.example.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson03.domain.Review;
import com.example.lesson03.mapper.ReviewMapper;

@Service
public class ReviewBO {
	
	@Autowired
	private ReviewMapper reviewMapper;

	// input: id
	// output: Review(단건)
	public Review getReview(int id) {
		return reviewMapper.selectReview(id);
	}
	
	// input : Review 객체 (단건) -> 컨트롤러에서 넘어옴
	// output : int(성공된 행의 개수)
	public int addReview(Review review) {
		return reviewMapper.insertReview(review);
	}
	
	// input : field 
	// output : 성공된 행의 개수 => int
	public int addReviewAsField(int storeId, String menu, 
			String userName, Double point, String review) { // Integer로 하면 nullable로 착각할 수 있다
		return reviewMapper.insertReviewAsField(storeId, menu, userName, point, review);
	}
	
	// input: id, review
	// output: int(성공된 행의 개수)
	public int updateReviewById(int id, String review) {
		return reviewMapper.updateReviewById(id, review);
	}
	
	// input : id
	// output : int
	public void deleteReviewById (int id) {
		reviewMapper.deleteReviewById(id);
	}
}






