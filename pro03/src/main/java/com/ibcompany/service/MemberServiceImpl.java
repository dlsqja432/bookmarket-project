package com.ibcompany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibcompany.dao.MemberDAO;
import com.ibcompany.dto.Member;

@Service
public class MemberServiceImpl implements MemberService {

	private MemberDAO memberDAO;
	
	@Autowired
	public MemberServiceImpl(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	@Override
	public List<Member> getMemberList() {
		return memberDAO.getMemberList();
	}

	@Override
	public int maxNum() {
		return memberDAO.maxNum();
	}

	@Override
	public Member getMember(String id) {
		return memberDAO.getMember(id);
	}

	@Override
	public void insMember(Member member) {
		memberDAO.insMember(member);
	}

	@Override
	public void upPw(Member member) {
		memberDAO.upPw(member);
	}

	@Override
	public void upInfo(Member member) {
		memberDAO.upInfo(member);
	}
	
	@Override
	public void upPoint(Member member) {
		memberDAO.upPoint(member);
	}

	@Override
	public void delMember(String id) {
		memberDAO.delMember(id);
	}
}
