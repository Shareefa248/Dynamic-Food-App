package com.tap.dao;

import java.util.List;

import com.tap.model.User;


public interface UserDao 
{
	int insertUser(User user);
	List<User> getAllUser();
	User getUserById(int id);
	User getUserByemail(String email);
	int deleteUserById(int id);
	int updateUserById(int id,String addeess);
}
