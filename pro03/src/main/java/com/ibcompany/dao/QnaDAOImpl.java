package com.ibcompany.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibcompany.dto.Qna;

@Repository
public class QnaDAOImpl implements QnaDAO {

	private SqlSession sqlSession;

	@Autowired
	public QnaDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<Qna> getQnaList() {
		return sqlSession.selectList("qna.getQnaList");
	}

	@Override
	public int maxNum() {
		return sqlSession.selectOne("qna.maxNum");
	}

	@Override
	public Qna getQna(int no) {
		return sqlSession.selectOne("qna.getQna", no);
	}

	@Override
	public void insQuestion(Qna qna) {
		sqlSession.insert("qna.insQuestion", qna);
	}

	@Override
	public void insAnswer(Qna qna) {
		sqlSession.insert("qna.insAnswer", qna);
	}

	@Override
	public void upParno() {
		sqlSession.update("qna.upParno");
	}

	@Override
	public void upQna(Qna qna) {
		sqlSession.update("qna.upQna", qna);
	}

	@Override
	public void upHits(int no) {
		sqlSession.update("qna.upHits", no);
	}

	@Override
	public void delQuestion(int parno) {
		sqlSession.delete("qna.delQuestion", parno);
	}

	@Override
	public void delAnswer(int no) {
		sqlSession.delete("qna.delAnswer", no);
	}

}
