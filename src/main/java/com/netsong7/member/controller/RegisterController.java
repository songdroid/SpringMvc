package com.netsong7.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {
	@RequestMapping("/register.member")
	public String handleStep1(){
		return "/member/register/step1.jsp";
	}
	
	@RequestMapping("/step2")
	public String handleStep2(){
		return "step2";
	}
	
	@RequestMapping("/step3")
	public String handleStep3(){
		return "step3";
	}
}
