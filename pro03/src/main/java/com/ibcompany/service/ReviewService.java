package com.ibcompany.service;

import java.util.List;

import com.ibcompany.dto.Review;

public interface ReviewService {
	public List<Review> getReviewList();
	public List<Review> getProductReviewList(int pno);
	public float avgStar(int pno);
	public int productReviewCount(int pno);
	public int reviewCount();
	public void insReview(Review review);
	public void upReview(Review review);
	public void delReview(int rno);
}
