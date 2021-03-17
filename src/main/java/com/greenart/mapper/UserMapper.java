package com.greenart.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.greenart.vo.LoginVO;
import com.greenart.vo.UserVO;

@Mapper
public interface UserMapper {
	public Integer selectUserCntById(String userid);
	public void insertUser(UserVO vo);
	public Integer loginUser(LoginVO vo);
	public UserVO selectUserById(LoginVO vo);
	
}
