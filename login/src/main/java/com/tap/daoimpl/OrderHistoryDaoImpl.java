package com.tap.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.OrderHistoryDao;
import com.tap.model.OrderHistory;

public class OrderHistoryDaoImpl implements OrderHistoryDao
{
	int x=-1;
	List<OrderHistory> orderhistory;
	static Connection con;
	private PreparedStatement pstmt;
	private Statement stmt;
	
	private ResultSet res;
	private static String url="jdbc:mysql://localhost:3306/online_food_delivery";
	private static String un="root";
	private static String pwd="Shareefa@248";
	private static final String CREATE_ORDERHISTORY = "insert into `orderhistory` (oid,uid,total) values(?,?,?)";
	private static final String GET_ALL_ORDERSHISTORY = "select * from `orderhistory`;";
	
	private static final String GET_ORDERSHISTORY_BY_USERID = "select * from `orderhistory` where `uid` = ?";
	private static final String UPDATE_ORDERSHISTORY_BY_ID = "update `orderhistory` set total=?, status=? where ohid=?";
	private static final String DELETE_ORDERSHISTORY_BY_ID = "delete from `orderhistory` where ohid=?";
	
	public OrderHistoryDaoImpl()
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
	public int addorderHistory(OrderHistory oh)
	{
		try
		{
	         pstmt = con.prepareStatement(CREATE_ORDERHISTORY);
	         pstmt.setInt(1, oh.getOid());
	         pstmt.setInt(2, oh.getUid());
	         pstmt.setDouble(3, oh.getTotal());
	         x = pstmt.executeUpdate();
	    }
		catch (SQLException e)
		{
	         e.printStackTrace();
	    }

	      return x;
	}

	@Override
	public ArrayList<OrderHistory> getAllOrderHistory()
	{
		ArrayList<OrderHistory> orderhistoryList=new ArrayList<OrderHistory>();
		try
		{
	         stmt = con.createStatement();
	         res =stmt.executeQuery("GET_ALL_ORDERSHISTORY");
	         orderhistoryList = (ArrayList<OrderHistory>) extractOrderHistoryListFromResultSet(res);
	    }
		catch (SQLException e)
		{
	         e.printStackTrace();
	    }

	      return  orderhistoryList;
	}

	@Override
	public List<OrderHistory> getOrderHistory(int uid)
	{
		System.out.println(uid);
		List<OrderHistory> orderhistoryList1 = null;
		try
		{
	         pstmt =con.prepareStatement(GET_ORDERSHISTORY_BY_USERID);
	         pstmt.setInt(1,uid);
	         System.out.println("pstmt "+pstmt);
	         res = pstmt.executeQuery();
	         
	         
	         
	         
	         orderhistoryList1 = extractOrderHistoryListFromResultSet(res);
	         for (OrderHistory orderHistory : orderhistoryList1) {
				System.out.println(orderHistory);
			}
	         
	   }
		catch (SQLException e)
		{
	         e.printStackTrace();
	    }

	      return orderhistoryList1;
	}

	@Override
	public int updateOrderHistory(OrderHistory oh, int ohid)
	{
		 try
		 {
	         pstmt =con.prepareStatement("UPDATE_ORDERSHISTORY_BY_ID");
	         pstmt.setDouble(1, oh.getTotal());
	         pstmt.setString(2, oh.getStatus());
	         pstmt.setInt(3, ohid);
	         x = pstmt.executeUpdate();
	     }
		 catch (SQLException e)
		 {
	         e.printStackTrace();
	     }

	      return x;
	}

	@Override
	public int deleteOrderHistory(int ohid)
	{
		 try
		 {
	         pstmt = con.prepareStatement(DELETE_ORDERSHISTORY_BY_ID );
	         pstmt.setInt(1, ohid);
	         x = this.pstmt.executeUpdate();
	     }
		 catch (SQLException var3)
		 {
	         var3.printStackTrace();
	     }

	      return x;
	}
	
	
	List<OrderHistory> extractOrderHistoryListFromResultSet(ResultSet res)
	{
		ArrayList<OrderHistory> orderhistoryList=new ArrayList<OrderHistory>();
		System.out.println("hello");
		try
		{
			while(res.next())
			{
				System.out.println("Inside while of extractOrderHistoryListFromResultSet ");
				orderhistoryList.add(new OrderHistory(res.getInt(1), res.getInt(2),res.getInt(3),res.getDate(4),res.getDouble(5),res.getString(6)));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return orderhistoryList;	
	}


}
