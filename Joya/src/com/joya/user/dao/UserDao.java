package com.joya.user.dao;

import java.util.List;

import com.joya.common.web.Params;
import com.joya.user.domain.User;

public interface UserDao {
	
//	회원 가입
	public void create(User user);
	
//	회원 탈퇴
	public void delete(String email);
	
//	회원 정보 수정
	public void modify(User user);
	
//	회원 정보 상세 조회
	public User read(String email);
	
//	전체 회원 조회
	public List<User> listByParams(Params params);

//	페이징
	public int pageCount(Params params);
}
