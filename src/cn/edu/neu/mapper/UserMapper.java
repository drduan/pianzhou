package cn.edu.neu.mapper;

import java.util.List;

import cn.edu.neu.core.common.Page;
import cn.edu.neu.model.User;

public interface UserMapper {

	User checkUser(User user);
	
	int checkUserName(User user);
	
}
