package com.joya.user.service;

import java.util.List;

import com.joya.common.web.Params;
import com.joya.user.domain.User;

public interface UserService {
public void create(User user);
	
	public void delete(String email);
	
	public User read(String email);
	
	public List<User> listByParams(Params params);
	
	public int pageCount(Params params);
}