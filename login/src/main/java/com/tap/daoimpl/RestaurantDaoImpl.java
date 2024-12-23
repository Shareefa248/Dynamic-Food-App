package com.tap.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.tap.dao.RestaurantDao;
import com.tap.model.Restaurant;

public class RestaurantDaoImpl implements RestaurantDao
{
	int x=-1;
	Restaurant rest;
	static Connection con;
	private PreparedStatement pstmt;
	private Statement stmt;
	ArrayList<Restaurant> restList=new ArrayList<Restaurant>();
	private ResultSet res;
	private static String url="jdbc:mysql://localhost:3306/online_food_delivery";
	private static String un="root";
	private static String pwd="Shareefa@248";
	private static final String INSERT="insert into restaurant(restaurantid,name,cuisiveType,deliveryTime,isActive,rating)values(?,?,?,?,?,?)";
	private static final String GET_ALL_REST="select * from restaurant";
	private static final String GET_REST_BY_ID="select * from restaurant where restaurantid=?";
	private static final String DELETE_REST_BY_ID="delete from restaurant where restaurantid=?";
	private static final String UPDATE_ISACTIVE_BY_ID="update restaurant set isActive=? where restaurantid=?";
	public void Myconnection()
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
	public int insertRestaurant(Restaurant res)
	{
		try
		{
			pstmt=con.prepareStatement(INSERT);
			pstmt.setInt(1,res.getRestaurantid());
			pstmt.setString(2, res.getName());
			pstmt.setString(3,res.getCuisiveType());
			pstmt.setInt(4,res.getDeliveryTime());
			pstmt.setBoolean(5,res.isActive());
			pstmt.setInt(6,res.getRating());
			x=pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return x;
		
	}
	@Override
	public List<Restaurant> getAllRest()
	{
		try
		{
			stmt=con.createStatement();
			res=stmt.executeQuery(GET_ALL_REST);
			restList=(ArrayList<Restaurant>) extractRestaurantListFromResultSet(res);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return restList;
	}

	@Override
	public Restaurant getRestById(int id)
	{
		try
		{
			pstmt=con.prepareStatement(GET_REST_BY_ID);
			pstmt.setInt(1, id);
			res=pstmt.executeQuery();
			restList=(ArrayList<Restaurant>) extractRestaurantListFromResultSet(res);
			rest=restList.get(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return rest;
	}

	@Override
	public int deleteRestById(int id)
	{
		try
		{
			pstmt=con.prepareStatement(DELETE_REST_BY_ID);
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
	public int updateRestById(int id,boolean isActive)
	{
		try
		{
			pstmt=con.prepareStatement(UPDATE_ISACTIVE_BY_ID);
			pstmt.setInt(2, id);
			pstmt.setBoolean(1, isActive);
			x=pstmt.executeUpdate();	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return x;
	}
	List<Restaurant> extractRestaurantListFromResultSet(ResultSet res)
	{
		try
		{
			while(res.next())
			{
				restList.add(new Restaurant(res.getInt(1),res.getString(2),res.getString(3),res.getInt(4),
						res.getBoolean(5),res.getInt(6),res.getString(7)));
				
				//System.out.println(new Restaurant(res.getInt(1),res.getString(2),res.getString(3),res.getInt(4),
						//res.getBoolean(5),res.getInt(6),res.getString(7)));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return restList;	
	}


}
