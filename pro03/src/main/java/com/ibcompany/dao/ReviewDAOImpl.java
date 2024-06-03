package com.ibcompany.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibcompany.dto.Review;

@Repository
public class ReviewDAOImpl implements ReviewDAO {

	private SqlSession sqlSession;

	@Autowired
	public ReviewDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<Review> getReviewList() {
		return sqlSession.selectList("review.getReviewList");
	}

	@Override
	public List<Review> getProductReviewList(int pno) {
		return sqlSession.selectList("review.getProductReviewList", pno);
	}
	
	@Override
	public float avgStar(int pno) {
		return sqlSession.selectOne("review.avgStar", pno);
	}

	@Override
	public int reviewCount() {
		return sqlSession.selectOne("review.reviewCount");
	}

	@Override
	public void insReview(Review review) {
		sqlSession.insert("review.insReview", review);
	}

	@Override
	public void upReview(Review review) {
		sqlSession.update("review.upReview", review);
	}

	@Override
	public void delReview(int rno) {
		sqlSession.delete("review.delReview", rno);
	}

}
