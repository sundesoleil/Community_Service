package com.greenart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.greenart.service.BoardService;
import com.greenart.vo.PostVO;

@Controller
public class MainController {
	@Autowired
	BoardService service;
	
	@GetMapping("/")
	public String getMain(Model model) {
		List<PostVO> noticeList = service.getPostList(0, 1, "%%");
		List<PostVO> newNoticeList = new ArrayList<PostVO>();
		
		
		int limit = 0;
		// 5개보다 적으면 리스트 크기로 설정
		if(noticeList.size()<5) limit = noticeList.size();
		else limit=5;
		
		for(int i=0; i < limit; i++) {
			newNoticeList.add(noticeList.get(i));
		}
		
		List<PostVO> stockList = service.getPostList(0, 5, "%%");
		List<PostVO> newStockList = new ArrayList<PostVO>();
		
		if(stockList.size()<5) limit = stockList.size();
		else limit=5;
		
		for(int i=0; i < limit; i++) {
			newStockList.add(stockList.get(i));
		}
		
		model.addAttribute("noticeList", newNoticeList);
		model.addAttribute("stockList", newStockList);
		
		return "/main";
	}
	@GetMapping("/member/join")
	public String getJoin() {
		return "/member/join";
	}
	@GetMapping("/member/login")
	public String getLogin() {
		return "/member/login";
	}
	@GetMapping("/member/logout")
	public String getLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}
