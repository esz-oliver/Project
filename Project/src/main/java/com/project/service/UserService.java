package com.project.service;

import com.project.entity.User;

public interface UserService {

	public User findByEmail(String email);
	
	public String registerUser(User user);
	
	public String userActivation(String code);
}
