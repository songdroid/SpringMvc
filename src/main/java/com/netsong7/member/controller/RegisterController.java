package com.netsong7.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.netsong7.member.repository.RegisterRequest;

@Controller
public class RegisterController {
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
		// DB가입 처리
		return "step3";
	}
}
