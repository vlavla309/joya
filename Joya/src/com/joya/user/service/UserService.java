package com.joya.user.service;

import java.util.List;

import com.joya.common.web.Params;
import com.joya.user.domain.User;

public interface UserService {
	
//	회원 가입
	public void create(User user);
	
//	회원 탈퇴
	public void delete(String email);
	
//	회원 정보 수정
	public void modify(User user);
	
//	회원 인증
	public User isMember(String id, String passwd);
	
//	회원 정보 상세 조회
	public User read(String email);
	
//	전체 회원 조회
	public List<User> listByParams(Params params);

//	페이징
	public int pageCount(Params params);

//  포인트 수정
	public void pointmodify(String email, int poiont);
	
}