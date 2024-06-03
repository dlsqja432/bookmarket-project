package com.ibcompany.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibcompany.dao.ProductDAO;
import com.ibcompany.dao.ReviewDAO;
import com.ibcompany.dto.Review;

@Service
public class ReviewServiceImpl implements ReviewService {

	private ReviewDAO reviewDAO;
	private ProductDAO productDAO;

	@Autowired
	public ReviewServiceImpl(ReviewDAO reviewDAO, ProductDAO productDAO) {
		this.reviewDAO = reviewDAO;
		this.productDAO = productDAO;
	}

	@Override
	public List<Review> getReviewList() {
		return reviewDAO.getReviewList();
	}

	@Override
	public List<Review> getProductReviewList(int pno) {
		return reviewDAO.getProductReviewList(pno);
	}

	@Override
	public float avgStar(int pno) {
		return reviewDAO.avgStar(pno);
	}
	
	@Override
	public int productReviewCount(int pno) {
		return reviewDAO.productReviewCount(pno);
	}

	@Override
	public int reviewCount() {
		return reviewDAO.reviewCount();
	}

	@Override
	public void insReview(Review review) {
		reviewDAO.insReview(review);
		Map<String, Object> paramMap = new HashMap<>();
		float star = avgStar(review.getPno());
		paramMap.put("star", star);
		paramMap.put("rcnt", 1);
		paramMap.put("pno", review.getPno());
		productDAO.upStar(paramMap);
	}

	@Override
	public void upReview(Review review) {
		reviewDAO.upReview(review);
	}

	@Override
	public void delReview(int rno) {
		reviewDAO.delReview(rno);
	}

}
