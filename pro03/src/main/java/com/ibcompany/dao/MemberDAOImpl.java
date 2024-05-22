package com.ibcompany.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibcompany.dto.Member;

@Repository
public class MemberDAOImpl implements MemberDAO{

	private SqlSession sqlSession;

	@Autowired
	public MemberDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<Member> getMemberList() {
		return sqlSession.selectList("member.getMemberList");
	}

	@Override
	public int maxNum() {
		return sqlSession.selectOne("member.maxNum");
	}

	@Override
	public Member getMember(String id) {
		return sqlSession.selectOne("member.getMember", id);
	}

	@Override
	public void insMember(Member member) {
		sqlSession.insert("member.insMember", member);
	}

	@Override
	public void upPw(Member member) {
		sqlSession.update("member.upPw", member);
	}

	@Override
	public void upInfo(Member member) {
		sqlSession.update("member.upInfo", member);
	}
	
	@Override
	public void upPoint(Member member) {
		sqlSession.update("member.upPoint", member);
	}

	@Override
	public void delMember(String id) {
		sqlSession.delete("member.delMember", id);
	}
}
