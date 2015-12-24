package com.netsong7.member.service;

import com.netsong7.exception.IdPasswordNotMachingException;
import com.netsong7.member.repository.Member;

import mybatis.MemberManager;

public class MemberServiceImpl implements MemberService {

	public void setRegister(Member member) {
		MemberManager.setRegister(member);
	}

	public Member selectByEmail(String email){
		return MemberManager.selectByEmail(email);
	}

	public Member authenticate(String email, String password) {
		Member dto = MemberManager.selectByEmail(email);
		if(dto == null){
			throw new IdPasswordNotMachingException();
		}
		
		if(!dto.matchPassword(password)){
			throw new IdPasswordNotMachingException();
		}
		
		return dto;
	}
}
