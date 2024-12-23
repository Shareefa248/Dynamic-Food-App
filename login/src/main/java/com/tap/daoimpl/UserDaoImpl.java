package com.tap.daoimpl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.UserDao;
import com.tap.model.User;

public class UserDaoImpl implements UserDao
{
	int x=-1;
	User user;
	private static Connection con;
	private PreparedStatement pstmt;
	private Statement stmt;
	ArrayList<User> userList=new ArrayList<User>();
	private ResultSet res;
	private static String url="jdbc:mysql://localhost:3306/online_food_delivery";
	private static String un="root";
	private static String pwd="Shareefa@248";
	private static final String INSERT_USER="insert into user(username,password,email,address,role) values(?,?,?,?,?)";
	private static final String GET_ALL_USERS="select * from user";
	private static final String GET_USER_BY_ID="select * from user where user_id=?";
	private static final String GET_USER_BY_EMAIL="select * from user where email=?";
	private static final String DELETE_USER_BY_ID="delete from user where user_id=?";
	private static final String UPDATE_ADDRESS_BY_ID="update user set address=? where user_id=?";
	public UserDaoImpl() {
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
	public int insertUser(User user)
	{
		try
		{
			pstmt=con.prepareStatement(INSERT_USER);
			pstmt.setString(1,user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getAddress());
			pstmt.setString(5, user.getRole());
			 x=pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return x;
	}

	@Override
	public List<User> getAllUser()
	{
		try
		{
			stmt=con.createStatement();
			res=stmt.executeQuery(GET_ALL_USERS);
			userList=(ArrayList<User>) extractUserListFromResultSet(res);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public User getUserById(int id)
	{
		try
		{
			pstmt=con.prepareStatement(GET_USER_BY_ID);
			pstmt.setInt(1, id);
			res=pstmt.executeQuery();
			userList=(ArrayList<User>) extractUserListFromResultSet(res);
			user=userList.get(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return user;
	}
	@Override
	public User getUserByemail(String email)
	{
		try
		{
			pstmt=con.prepareStatement(GET_USER_BY_EMAIL);
			pstmt.setString(1, email);
			res=pstmt.executeQuery();
			while(res.next())
			{
				user =new User(res.getInt("user_id"),res.getString("username"),res.getString("password"),res.getString("email"),res.getString("address"),res.getString("role"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return user;
	}


	@Override
	public int deleteUserById(int id)
	{
		try
		{
			pstmt=con.prepareStatement(DELETE_USER_BY_ID);
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
	public int updateUserById(int id, String addeess)
	{
		try
		{
			pstmt=con.prepareStatement(UPDATE_ADDRESS_BY_ID);
			pstmt.setInt(2, id);
			pstmt.setString(1, addeess);
			x=pstmt.executeUpdate();	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return x;
	}
	List<User>extractUserListFromResultSet(ResultSet res)
	{
		try
		{
			while(res.next())
			{
				userList.add(new User(res.getInt(1),res.getString(2),res.getString(3),
						res.getString(4),res.getString(5),res.getString(6)));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return userList;	
	}
}
