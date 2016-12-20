package cn.edu.neu.service;

import java.util.List;

import cn.edu.neu.core.common.Page;

import cn.edu.neu.model.User;


public interface UserService {
	
	User checkUser(User user);
	
	boolean checkUserName(String userName);
	
	

}
