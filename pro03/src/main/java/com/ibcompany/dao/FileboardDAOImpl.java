package com.ibcompany.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibcompany.dto.Fileboard;

@Repository
public class FileboardDAOImpl implements FileboardDAO {

	private SqlSession sqlSession;

	@Autowired
	public FileboardDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<Fileboard> getFileboardList() {
		return sqlSession.selectList("fileboard.getFileboardList");
	}

	@Override
	public int maxNum() {
		return sqlSession.selectOne("fileboard.maxNum");
	}

	@Override
	public Fileboard getFileboard(int no) {
		return sqlSession.selectOne("fileboard.getFileboard", no);
	}

	@Override
	public void insFileboard(Fileboard fileboard) {
		sqlSession.insert("fileboard.insFileboard", fileboard);
	}

	@Override
	public void upFileboard(Fileboard fileboard) {
		sqlSession.update("fileboard.upFileboard", fileboard);
	}

	@Override
	public void upHits(int no) {
		sqlSession.update("fileboard.upHits", no);
	}

	@Override
	public void delFileboard(int no) {
		sqlSession.delete("fileboard.delFileboard", no);
	}

}
