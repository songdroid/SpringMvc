package com.netsong7.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.netsong7.board.repository.BoardDto;
import com.netsong7.board.service.BoardService;

@Controller
public class WriteController {
	private BoardService boardService;
	
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}

	@RequestMapping(value="/write.board", method=RequestMethod.GET)
	public String pageHandler(){
		return "board/write.jsp";
	}
	
	@RequestMapping(value="/write.board", method=RequestMethod.POST)
	public ModelAndView submitted(@ModelAttribute BoardDto dto){
		try{
			boardService.write(dto);
		}
		catch(Exception err){
			System.out.println("WriteController:submitted():" + err);
		}
		return new ModelAndView("redirect:list.board");
	}
}
