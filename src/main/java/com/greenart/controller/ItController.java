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
public class ItController {
	@Autowired
	BoardService service;
	
	@GetMapping("/it")
	public String getIt(
			@RequestParam @Nullable Integer offset, 
			Model model, 
			@RequestParam @Nullable String keyword,
			@RequestParam @Nullable String type) {
		
		if (offset == null) offset = 0; 
		if (keyword == null) keyword = "%%";
		else keyword = "%"+keyword+"%";
		if(type == null) type = "title";
 		List<PostVO> list = service.getPostList(offset, 7, keyword, type);
		
		model.addAttribute("list", list);
		model.addAttribute("board_seq", 7);
		return "/it/list";
	}
	
	@GetMapping("/it/detail")
	public String getItDetail(@RequestParam Integer no, Model model) {
		PostVO data = service.getItBySeq(no);
		model.addAttribute("data",data);
		
		CommentReqVO vo = new CommentReqVO();
		vo.setBoard_seq(no);
		vo.setOffset(0);
		List<CommentVO> comments = service.selectComment(vo); // 코멘트에 대한 정보 가져오기
		model.addAttribute("comments", comments);
		
		List<Integer> likes = service.selectPostLikesCount(no);
		model.addAttribute("likes",likes);
		
		return "/it/detail";
	}
	
	@GetMapping("/it/write")
	public String getNewIt(@RequestParam Integer seq, Model model) {
		model.addAttribute("boardSeq", seq);
		return "/it/write";
	}

	@GetMapping("/it/modify")
	public String getModifyIt(@RequestParam Integer seq, Model model) {
		PostVO vo = service.getItBySeq(seq);
		model.addAttribute("postInfo", vo); 
		return "/it/modify";
	}
	
	// 리뷰단
	@GetMapping("/it/review")
	public String getItReview(
			@RequestParam @Nullable Integer offset, 
			Model model, 
			@RequestParam @Nullable String keyword,
			@RequestParam @Nullable String type
			) {
		if (offset == null) offset = 0; 
		if (keyword == null) keyword = "%%";
		else keyword = "%"+keyword+"%";
		if(type == null) type = "title";
		
 		List<PostVO> list = service.getPostList(offset, 8, keyword, type);
		model.addAttribute("list", list);
		model.addAttribute("board_seq", 8);
		return "/it/review/list";
	}
	
	@GetMapping("/it/review/detail")
	public String getItReviewDetail(@RequestParam Integer no, Model model) {
		PostVO data = service.getItReviewBySeq(no);
		model.addAttribute("data",data);
		
		CommentReqVO vo = new CommentReqVO();
		vo.setBoard_seq(no);
		vo.setOffset(0);
		List<CommentVO> comments = service.selectComment(vo); // 코멘트에 대한 정보 가져오기
		model.addAttribute("comments", comments);
		
		List<Integer> likes = service.selectPostLikesCount(no);
		model.addAttribute("likes",likes);
		
		return "/it/review/detail";
	}
	
	@GetMapping("/it/review/write")
	public String getNewItReview(@RequestParam Integer seq, Model model) {
		model.addAttribute("boardSeq", seq);
		return "/it/review/write";
	}

	@GetMapping("/it/review/modify")
	public String getModifyItReview(@RequestParam Integer seq, Model model) {
		PostVO vo = service.getItReviewBySeq(seq);
		model.addAttribute("postInfo", vo); 
		return "/it/review/modify";
	}

}
