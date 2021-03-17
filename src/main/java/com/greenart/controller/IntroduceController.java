package com.greenart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greenart.service.BoardService;
import com.greenart.vo.CommentReqVO;
import com.greenart.vo.CommentVO;
import com.greenart.vo.PostVO;

@Controller
public class IntroduceController {
	@Autowired
	BoardService service;
	
	@GetMapping("/notice")
	public String getNotice(@RequestParam @Nullable Integer offset, Model model) {
		if (offset == null) offset = 0; 
		List<PostVO> list = service.getPostList(offset, 1);
		model.addAttribute("list", list);
		return "/introduce/notice";
	}
	
	@GetMapping("/notice/detail")
	public String getNoticeDetail(@RequestParam Integer no, Model model) {
		PostVO data = service.getPostBySeq(no);
		model.addAttribute("data",data);
		
		CommentReqVO vo = new CommentReqVO();
		vo.setBoard_seq(no);
		vo.setOffset(0);
		List<CommentVO> comments = service.selectComment(vo); // 코멘트에 대한 정보 가져오기
		model.addAttribute("comments", comments);
		
		List<Integer> likes = service.selectPostLikesCount(no);
		model.addAttribute("likes",likes);
		
		return "/introduce/detail";
	}
	
	@GetMapping("/notice/write")
	public String getNewNotice() {
		return "/introduce/write";
	}
	
	@GetMapping("/notice/modify")
	public String getModifyNotice(@RequestParam Integer seq, Model model) {
		PostVO vo = service.getPostBySeq(seq);
		model.addAttribute("postInfo", vo); // jsp에서 활용 가능하게 함
		return "/introduce/modify";
	}

}
