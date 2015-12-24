package com.netsong7.member.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import com.netsong7.exception.IdPasswordNotMachingException;
import com.netsong7.member.repository.LoginCommand;
import com.netsong7.member.repository.Member;
import com.netsong7.member.service.MemberService;

@Controller
public class LoginController {
	private MemberService memberService;

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@RequestMapping("/login.member")
	public String form(LoginCommand loginCommand, 
			@CookieValue(value="remember", required=false) Cookie cook){
		if(cook != null){
			loginCommand.setEmail(cook.getValue());
		}
		return "login";
	}
	
	@RequestMapping(value="/login.member", params={"command=submit"})
	public String submit(LoginCommand loginCommand, HttpSession session, HttpServletResponse resp){
		try{
			Member result = 
				memberService.authenticate(loginCommand.getEmail(), loginCommand.getPassword());
			
			if(result != null){
				session.setAttribute("name", result.getName());
			}
			
			Cookie rememberCook = new Cookie("remember", loginCommand.getEmail());
			if(loginCommand.isRememberEmail()){
				rememberCook.setMaxAge(60 * 60 * 24 * 30);
			}
			else{
				rememberCook.setMaxAge(0);
			}
			resp.addCookie(rememberCook);
			
			return "loginSuccess";
		}
		catch(IdPasswordNotMachingException err){
			return "login";
		}
	}
}
