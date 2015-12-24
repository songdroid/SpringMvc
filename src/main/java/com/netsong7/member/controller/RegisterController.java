package com.netsong7.member.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.netsong7.exception.AlreadyExistingMemberException;
import com.netsong7.member.repository.Member;
import com.netsong7.member.repository.RegisterRequest;
import com.netsong7.member.service.MemberService;

import mybatis.MemberManager;

@Controller
public class RegisterController {
	private MemberService memberService;

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping("/register.member")
	public String handleStep1(){
		return "/member/register/step1";
	}
	
	@RequestMapping("/step2")
	public String handleStep2(@RequestParam(value="agree", defaultValue="false") Boolean agree){
		if(!agree){
			return "/member/register/step1.jsp";
		}
		else{
			return "step2";
		}
	}
	
	/*
	@RequestMapping("/step3")
	public ModelAndView handleStep3(RegisterRequest regReq){
		// DB가입 처리
		ModelAndView mav = new ModelAndView("step3");
		mav.addObject("mem", regReq);
		return mav;
	}
	*/
	
	@RequestMapping(value="/step3", method=RequestMethod.POST)
	public String handleStep3(@ModelAttribute("mem") RegisterRequest regReq){
		try{
			Member dto = new Member(regReq.getEmail(), regReq.getPassword(), regReq.getName(), new Date());
			memberService.setRegister(dto);
			return "step3";
		}
		catch(AlreadyExistingMemberException err){
			return "step2";
		}
	}
}
