package com.greenart.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.greenart.mapper.UserMapper;
import com.greenart.vo.LoginVO;
import com.greenart.vo.UserVO;

@Repository
@Primary
public class UserDaoImpl implements UserDao{
	@Autowired
	UserMapper mapper;
	
	@Override
	public Integer selectUserCntById(String userid) {
		return mapper.selectUserCntById(userid);
	}
	
	@Override
	public void insertUser(UserVO vo) {
		mapper.insertUser(vo);
	}
	
	@Override
	public Integer loginUser(LoginVO vo) {
		return mapper.loginUser(vo);
	}
	
	@Override
	public UserVO selectUserById(LoginVO vo) {
		return mapper.selectUserById(vo);
	}
}
