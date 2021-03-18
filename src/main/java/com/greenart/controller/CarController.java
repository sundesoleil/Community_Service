package com.greenart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greenart.service.BoardService;
import com.greenart.vo.CommentReqVO;
import com.greenart.vo.CommentVO;
import com.greenart.vo.PostVO;

@Controller
public class CarController {
	@Autowired
	BoardService service;
	
	@GetMapping("/car")
	public String getCar(@RequestParam @Nullable Integer offset, Model model) {
		if (offset == null) offset = 0; 
		List<PostVO> list = service.getPostList(offset, 6);
		model.addAttribute("list", list);
		model.addAttribute("board_seq", 6);
		return "/car/list";
	}
	
	@GetMapping("/car/detail")
	public String getCarDetail(@RequestParam Integer no, Model model) {
		PostVO data = service.getCarBySeq(no);
		model.addAttribute("data",data);
		
		CommentReqVO vo = new CommentReqVO();
		vo.setBoard_seq(no);
		vo.setOffset(0);
		List<CommentVO> comments = service.selectComment(vo); // 코멘트에 대한 정보 가져오기
		model.addAttribute("comments", comments);
		
		List<Integer> likes = service.selectPostLikesCount(no);
		model.addAttribute("likes",likes);
		
		return "/car/detail";
	}
	
	@GetMapping("/car/write")
	public String getNewCar(@RequestParam Integer seq, Model model) {
		model.addAttribute("boardSeq", seq);
		return "/car/write";
	}

	@GetMapping("/car/modify")
	public String getModifyCar(@RequestParam Integer seq, Model model) {
		PostVO vo = service.getCarBySeq(seq);
		model.addAttribute("postInfo", vo); 
		return "/car/modify";
	}

}
