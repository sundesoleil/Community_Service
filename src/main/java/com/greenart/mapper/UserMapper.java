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
	
	public UserVO selectUserBySeq(Integer seq);
	public Integer selectUserPostCount(Integer seq);
	public Integer selectUserGoodBadCount(Integer seq, Integer good_bad);
	
	public void updateUserInfo(UserVO vo);
}
