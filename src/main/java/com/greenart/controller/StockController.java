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
public class StockController {
	@Autowired
	BoardService service;
	
	@GetMapping("/stock")
	public String getStock(@RequestParam @Nullable Integer offset, Model model, @RequestParam @Nullable String keyword) {
		
		if (offset == null) offset = 0; 
		if (keyword == null) keyword = "%%";
		else keyword = "%"+keyword+"%";
 		List<PostVO> list = service.getPostList(offset, 5, keyword);
		
//		Integer total = service.getBoardPostCount(1);
//		for(int i = 0; i<list.size(); i++) {
//			list.get(i).setNo(total-i-offset);
//		}
		
		model.addAttribute("list", list);
		model.addAttribute("board_seq",5);
		return "/stock/list";
	}
	
	@GetMapping("/stock/detail")
	public String getStockDetail(@RequestParam Integer no, Model model) {
		PostVO data = service.getStockBySeq(no);
		model.addAttribute("data",data);
		
		CommentReqVO vo = new CommentReqVO();
		vo.setBoard_seq(no);
		vo.setOffset(0);
		List<CommentVO> comments = service.selectComment(vo); // 코멘트에 대한 정보 가져오기
		model.addAttribute("comments", comments);
		
		List<Integer> likes = service.selectPostLikesCount(no);
		model.addAttribute("likes",likes);
		
		return "/stock/detail";
	}
	
	@GetMapping("/stock/write")
	public String getStockWrite(@RequestParam Integer seq, Model model) {
		model.addAttribute("boardSeq", seq);
		return "/stock/write";
	}

	@GetMapping("/stock/modify")
	public String getStockModify(@RequestParam Integer seq, Model model) {
		PostVO vo = service.getStockBySeq(seq);
		model.addAttribute("postInfo", vo); 
		return "/stock/modify";
	}

	
}
