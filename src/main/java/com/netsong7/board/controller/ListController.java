package com.netsong7.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.netsong7.board.service.BoardService;

@Controller
public class ListController {
	private BoardService boardService;
	
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}

	@RequestMapping("/list.board")
	public ModelAndView pageHandler(){
		ModelAndView mav = new ModelAndView("/WEB-INF/views/board/list.jsp");
		try{
			List list = boardService.getList();
			mav.addObject("list", list);
		}
		catch(Exception err){
			System.out.println("ListController:pageHandler():" + err);
		}
		return mav;
	}
}
