package com.netsong7.member.service;

import com.netsong7.member.repository.Member;

import mybatis.MemberManager;

public class MemberServiceImpl implements MemberService {

	public void setRegister(Member member) {
		MemberManager.setRegister(member);
	}

	public Member selectByEmail(String email){
		return MemberManager.selectByEmail(email);
	}
}
