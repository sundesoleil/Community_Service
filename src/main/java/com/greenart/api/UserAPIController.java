package com.greenart.api;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.MapConfigurationPropertySource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.greenart.mapper.UserMapper;
import com.greenart.service.UserService;
import com.greenart.utils.AESAlgorithm;
import com.greenart.vo.LoginVO;
import com.greenart.vo.UserVO;

@RestController
public class UserAPIController {
	
	@Autowired
	UserService service;
	
	@PostMapping("/api/useradd")
	public Map<String, String> postUserAdd(@RequestBody UserVO user){
		
		Map<String, String> resultMap = new LinkedHashMap<String, String>();
		Integer result = service.insertUser(user);
		
		if(result == 500 || result == 400) {
			resultMap.put("result", "failed");
		}
		else {
			resultMap.put("result", "success");
		}
		
		return resultMap;
	}
	
	@PostMapping("/api/userchk")
	public Map<String, Boolean> postUserChk(@RequestBody UserVO user){ 
		
		System.out.println(user.getUi_id());
		System.out.println(user.getUi_email());
		Map<String, Boolean> map = new LinkedHashMap<String, Boolean>();
		boolean isDuplicated = service.isDuplicatedUser(user.getUi_id());
		map.put("result", isDuplicated);
		return map;
		
	}
	
	@PostMapping("/api/login")
	public Map<String, Boolean> postUserLogin(@RequestBody LoginVO vo, HttpSession session){
		Map<String, Boolean> map = new LinkedHashMap<String, Boolean>();
		
		try {
			vo.setPwd(AESAlgorithm.Encrypt(vo.getPwd()));
		}
		catch(Exception e){
			
		}
		boolean result = service.loginUser(vo);
		if(result == true) {
			UserVO userInfo = service.selectUserById(vo);
			session.setAttribute("userInfo", userInfo);
		}else {
			session.setAttribute("userInfo", null);
		}
		// session.setAttribute("loginUser", vo);
		map.put("result", result);
		return map;
	}
}
