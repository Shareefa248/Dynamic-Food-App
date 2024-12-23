package com.tap.dao;

import java.util.List;

import com.tap.model.Admin;
import com.tap.model.Menu;

public interface AdminDao 
{
	int insertAdmin(Admin a);
	List<Admin> getAdmins();
	Admin getEmail(String email);
	
}
