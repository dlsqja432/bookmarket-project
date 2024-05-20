package com.ibcompany.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibcompany.dto.Sample;

@Repository
public class SampleDAOImpl implements SampleDAO {

	private SqlSession sqlSession;

	@Autowired
	public SampleDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<Sample> getSampleList() {
		return sqlSession.selectList("sample.getSampleList");
	}

	@Override
	public int maxNum() {
		return sqlSession.selectOne("sample.maxNum");
	}

	@Override
	public Sample getSample(int num) {
		return sqlSession.selectOne("sample.getSample");
	}

	@Override
	public void insSample(Sample sample) {
		sqlSession.insert("sample.insSample", sample);
	}

	@Override
	public void upSample(Sample sample) {
		sqlSession.update("sample.upSample", sample);
	}

	@Override
	public void delSample(int num) {
		sqlSession.delete("sample.delSample", num);
	}

}
