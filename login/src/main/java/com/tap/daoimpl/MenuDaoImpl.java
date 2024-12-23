package com.tap.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.MenuDao;
import com.tap.model.Menu;

public class MenuDaoImpl implements MenuDao
{
	int x=-1;
	Menu menu;
	static Connection con;
	private PreparedStatement pstmt;
	private Statement stmt;
	ArrayList<Menu> menuList=new ArrayList<Menu>();
	private ResultSet res;
	private static String url="jdbc:mysql://localhost:3306/online_food_delivery";
	private static String un="root";
	private static String pwd="Shareefa@248";
	private static final String INSERT_MENU="insert into menu(restaurantid,itemname,description,price,isavailable) values(?,?,?,?,?)";
	private static final String GET_ALL_MENU="select * from menu";
	private static final String GET_MENU_BY_ID="select * from menu where menuid=?";
	private static final String GET_REST_BY_ID="select * from menu where restaurantid=?";
	private static final String DELETE_MENU_BY_ID="delete from menu where menuid=?";
	private static final String UPDATE_ISAVAILABLE_BY_ID="update menu set isavailable=? where menuid=?";
	public MenuDaoImpl()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_food_delivery","root","Shareefa@248");	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public int insertMenu(Menu m)
	{
		try
		{
			pstmt=con.prepareStatement(INSERT_MENU);
			pstmt.setInt(1, m.getRestaurantid());
			pstmt.setString(2, m.getItemname());
			pstmt.setString(3, m.getDescription());
			pstmt.setFloat(4, m.getPrice());
			pstmt.setBoolean(5, m.isIsavailable());
			x=pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return x;
	}

	@Override
	public List<Menu> getAllRestMenu()
	{
		try
		{
			stmt=con.createStatement();
			res=stmt.executeQuery(GET_ALL_MENU);
			menuList=(ArrayList<Menu>) extractMenuListFromResultSet(res);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return menuList;
	}

	@Override
	public Menu getMenuById(int id)
	{
		try
		{
			pstmt=con.prepareStatement(GET_MENU_BY_ID);
			pstmt.setInt(1,id);
			res=pstmt.executeQuery();
			menuList=(ArrayList<Menu>) extractMenuListFromResultSet(res);
			menu=menuList.get(0);
					
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return menu;
	}
	@Override
	public List<Menu> getRestById(int id)
	{
		try
		{
			pstmt=con.prepareStatement(GET_REST_BY_ID);
			pstmt.setInt(1,id);
			res=pstmt.executeQuery();
			menuList=(ArrayList<Menu>) extractMenuListFromResultSet(res);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return menuList;
	}


	@Override
	public int deleteMenuById(int id)
	{
		try
		{
			pstmt=con.prepareStatement(DELETE_MENU_BY_ID);
			pstmt.setInt(1, id);
			x=pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return x;
	}

	@Override
	public int updateMenuById(int id, boolean isavailable)
	{
		try
		{
			pstmt=con.prepareStatement(UPDATE_ISAVAILABLE_BY_ID);
			pstmt.setBoolean(1, isavailable);
			pstmt.setInt(2, id);
			x=pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return x;
	}
	List<Menu>extractMenuListFromResultSet(ResultSet res)
	{
		try
		{
			while(res.next())
			{
				menuList.add(new Menu(res.getInt(1),res.getInt(2),res.getString(3),res.getString(4),
						res.getFloat(5),res.getBoolean(6),res.getString(7)));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return menuList;	
	}

}
