package com.gym.GYM.board.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gym.GYM.board.dto.BoardDTO;
import com.gym.GYM.board.service.BoardService;

@Controller
public class BoardController {
	
	// ssㄴㄴㄴㄴ
	private BoardService boardsvc;

	private ModelAndView mav = new ModelAndView();

	// boardList : 게시글 목록 페이지 이동
	@GetMapping("/boardList")
	private ModelAndView boardList() {
		mav = boardsvc.boardList();
		return mav;
	}

	// BoardRegistForm : 게시글 작성페이지 이동

	@GetMapping("/boardRegistForm")
	private String boardRegistForm() {
		return "Board/boardRegistForm";

	}

	// BoardRegist:게시글 작성 메소드

	@PostMapping("/boardRegist")
	private ModelAndView boardRegist(@ModelAttribute BoardDTO board) throws IllegalStateException, IOException{
		mav = boardsvc.boardRegist(board);

		return mav;

	}
	
	//BoardView게시글 상세보기
	@GetMapping("/boardView")
	private ModelAndView boardView(@RequestParam("boardNo")int boardNo) {
		mav=boardsvc.boardView(boardNo);
		return mav;
	}
	
	//BoardModifyForm: 게시글 수정 페이지이동 메소드
	
	@GetMapping("/boardModifyForm")
	private ModelAndView boardModifyForm(@RequestParam("boardNo")int boardNo){
		mav=boardsvc.boardModifyForm(boardNo);
		
		return mav;
	}
	
//BoardModify : 게시글 수정 메소드
	@PostMapping("/boardModify")
	private ModelAndView boardModify(@ModelAttribute BoardDTO board) throws IllegalStateException, IOException {
		mav= boardsvc.boardModify(board);


		return mav;	
		}
		
		
	

}
