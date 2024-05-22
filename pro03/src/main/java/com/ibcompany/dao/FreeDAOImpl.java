package com.ibcompany.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibcompany.dto.Free;

@Repository
public class FreeDAOImpl implements FreeDAO {

	private SqlSession sqlSession;

	@Autowired
	public FreeDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<Free> getFreeList() {
		return sqlSession.selectList("free.getFreeList");
	}

	@Override
	public int maxNum() {
		return sqlSession.selectOne("free.maxNum");
	}

	@Override
	public Free getFree(int no) {
		return sqlSession.selectOne("free.getFree", no);
	}

	@Override
	public void insFree(Free free) {
		sqlSession.insert("free.insFree", free);
	}

	@Override
	public void upFree(Free free) {
		sqlSession.update("free.upFree", free);
	}

	@Override
	public void upHits(int no) {
		sqlSession.update("free.upHits", no);
	}

	@Override
	public void delFree(int no) {
		sqlSession.delete("free.delFree", no);
	}

}
