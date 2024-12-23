package com.tap.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.AdminDao;
import com.tap.model.Admin;

public class AdminDaoImpl implements AdminDao
{
	int x=-1;
	Admin admin;
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet res;
	ArrayList<Admin> adminList=new ArrayList<Admin>();
	String url="jdbc:mysql://localhost:3306/onlin_food_delivery";
	String un="root";
	String pwd="Shareefa@248";
	final String INSERT="insert into admin(email,password) values(?,?)";
	final String GET_ALL="select * from admin";
	final String GET_EMAIL="select * from admin where email=?";
	public AdminDaoImpl()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,un,pwd);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public int insertAdmin(Admin a) 
	{
		try
		{
			pstmt=con.prepareStatement(INSERT);
			pstmt.setString(1,a.getEmail());
			pstmt.setString(2,a.getPassword());
			x=pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return x;
	}

	@Override
	public List<Admin> getAdmins() 
	{
		try
		{
			stmt=con.createStatement();
			res=stmt.executeQuery(GET_ALL);
			while(res.next())
			{
				adminList.add(new Admin(res.getString(1),res.getString(2)));
			}	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return adminList;
	}

	@Override
	public  Admin getEmail(String email) 
	{
		try
		{
			pstmt=con.prepareStatement(GET_EMAIL);
			pstmt.setString(1,email);
			pstmt.executeQuery();
			while(res.next())
			{
				adminList.add(new Admin(res.getString(1),res.getString(2)));
			}
			admin=adminList.get(0);	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return admin;
	}

}
