package com.netsong7.survey;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SurveyController {
	@RequestMapping()
	public String form(){
		return null;
	}
	
	@RequestMapping()
	public String submit(){
		return null;
	}
}
