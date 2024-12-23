package com.tap.dao;

import java.util.ArrayList;
import java.util.List;

import com.tap.model.Menu;

public interface MenuDao 
{
	int insertMenu(Menu m);
	List<Menu> getAllRestMenu();
	Menu getMenuById(int id);
	List<Menu> getRestById(int id);
	int deleteMenuById(int id);
	int updateMenuById(int id,boolean isavailable);
}
