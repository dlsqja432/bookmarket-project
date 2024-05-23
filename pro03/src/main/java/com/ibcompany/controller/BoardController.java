package com.ibcompany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ibcompany.dto.Board;
import com.ibcompany.service.BoardService;

@Controller
@RequestMapping("/board/")
public class BoardController {
	
	private BoardService boardService;

	@Autowired
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@GetMapping("boardList.do")
	public String boardList(Model model) {
		List<Board> boardList = boardService.getBoardList();
		model.addAttribute("boardList", boardList);
		return "board/boardList";
	}
	
	@GetMapping("getBoard.do")
	public String getBoard(@RequestParam("bno") int bno, Model model) {
		Board board = boardService.getBoard(bno);
		model.addAttribute("board", board);
		return "board/getBoard";
	}
	
	@GetMapping("insBoard.do")
	public String insBoard(Model model) {
		return "board/insBoard";
	}
	
	@PostMapping("insBoardPro.do")
	public String insProBoard(@RequestParam("title") String title,
			@RequestParam("content") String content, Model mode) {
		Board board = new Board();
		board.setTitle(title);
		board.setContent(content);
		boardService.insBoard(board);
		return "redirect:boardList.do";
	}
	
	@GetMapping("editBoard.do")
	public String editBoard(@RequestParam("bno") int bno, Model model) {
		Board board = boardService.getBoard(bno);
		model.addAttribute("board",board);
		return "board/editBoard";
	}
	
	@PostMapping("editBoardPro.do")
	public String editProBoard(@RequestParam("bno") int bno, @RequestParam("title") String title, 
			@RequestParam("content") String content, Model model) {
		Board board = new Board();
		board.setBno(bno);
		board.setTitle(title);
		board.setContent(content);
		boardService.upBoard(board);
		return "redirect:boardList.do";
	}
	
	@GetMapping("delBoard.do")
	public String delBoard(@RequestParam("bno") int bno, Model model) {
		boardService.delBoard(bno);
		return "redirect:boardList.do";
	}
}
