package com.greenart.service;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.greenart.vo.LoginVO;
import com.greenart.vo.UserVO;

@Service
@Configurable 
public interface UserService {
	public boolean isDuplicatedUser(String userid);
	public Integer insertUser(UserVO vo);
	public boolean loginUser(LoginVO vo);
	public UserVO selectUserById(LoginVO vo);
	public UserVO selectUserBySeq(Integer seq);
	public Integer selectUserPostCount(Integer seq);
	public Integer selectUserGoodBadCount(Integer seq, Integer good_bad);
}
