package com.greenart.dao;

import org.springframework.stereotype.Repository;

import com.greenart.vo.LoginVO;
import com.greenart.vo.UserVO;

@Repository
public interface UserDao {
	public Integer selectUserCntById(String userid);
	public void insertUser(UserVO vo);
	public Integer loginUser(LoginVO vo);
	public UserVO selectUserById(LoginVO vo);
}
