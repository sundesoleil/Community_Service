package com.greenart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import org.springframework.stereotype.Service;

import com.greenart.dao.UserDao;
import com.greenart.utils.AESAlgorithm;
import com.greenart.vo.LoginVO;
import com.greenart.vo.UserVO;

@Service
@Configurable
public class UserServiceImpl implements UserService{
	@Autowired
	UserDao dao;
	@Override
	public boolean isDuplicatedUser(String userid) {
		/*if(dao.selectUserCntById(userid) == 1{
		 * return true;
		 * }else{
		 * return false;
		 * }*/
		return dao.selectUserCntById(userid) == 1;
	}
	
	@Override
	public Integer insertUser(UserVO vo) {
		
		/* front에서 이미 validation을 했으나, ARC같은 RestRequest tool로 하는 강제 요청을 막아주는 역할을 함
		 * Front에서 Validation한 항목을 Back에서 한 번 더 확인*/
		
		if(vo.getUi_id().equals("") || vo.getUi_id() == null) {
			System.out.println("아이디 누락");
			return 400;
		}
		if(vo.getUi_pwd().equals("") || vo.getUi_pwd() == null) {
			System.out.println("비밀번호누락");
			return 400;
		}
		if(vo.getUi_name().equals("") || vo.getUi_name() == null) {
			System.out.println("이름 누락");
			return 400;
		}
		if(vo.getUi_email().equals("") || vo.getUi_email() == null) {
			System.out.println("이메일 누락");
			return 400;
		}
		
		/*암호화*/
		String pwd = vo.getUi_pwd(); // pwd 불러오기
		
		try {
			pwd = AESAlgorithm.Encrypt(pwd); // 암호화 한 후
			vo.setUi_pwd(pwd); // 저장해야 암호화가 제대로 된다 :)
		} 
		catch (Exception e) {
			System.out.println("암호화 실패: " + e.getMessage());
			return 500;
		}
		
		dao.insertUser(vo);
		return 200;

	}
	
	@Override
	public boolean loginUser(LoginVO vo) {
		Integer result = dao.loginUser(vo);
		if(result == 1) return true;
		return false;
	}
	
	@Override
	public UserVO selectUserById(LoginVO vo) {
		return dao.selectUserById(vo);
	}
}
