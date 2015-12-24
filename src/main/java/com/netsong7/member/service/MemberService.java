package com.netsong7.member.service;

import com.netsong7.member.repository.Member;

public interface MemberService {
	public void setRegister(Member member);
	public Member selectByEmail(String email);
	public Member authenticate(String email, String password);
}
