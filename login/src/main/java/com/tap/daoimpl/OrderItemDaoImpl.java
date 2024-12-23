package com.tap.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.OrderItemDao;
import com.tap.model.Menu;
import com.tap.model.OrderItem;

public class OrderItemDaoImpl implements OrderItemDao
{
	int x=-1;
	OrderItem orderitem;
	static Connection con;
	private PreparedStatement pstmt;
	private Statement stmt;
	ArrayList<OrderItem> items=new ArrayList<OrderItem>();
	private ResultSet res;
	private static String url="jdbc:mysql://localhost:3306/online_food_delivery";
	private static String un="root";
	private static String pwd="Shareefa@248";
	private static final String CREATE_ORDER_ITEMS = "insert into `orderitems`(oid,menuId,quantity,subTotal) values(?,?,?,?);";
	private static final String GET_ALL_ORDER_ITEMS = "select * from `orderitems`;";
	private static final String GET_ORDER_ITEMS_BY_ID = "SELECT * FROM `orderitems` WHERE `oiid` = (SELECT MAX(oiid) FROM orderitems)";
	private static final String UPDATE_ORDER_ITEMS_BY_ID = "update `orderitems` set quantity=?,subTotal=? where oid=?;";
	private static final String DELETE_ORDER_ITEMS_BY_ID = "delete from `orderitems` where oiid=?";
	private static final String GET_SPECIFIC_ORDERITEMS_BY_ID = "select from `orderitems` where `oid`=?;";
	public OrderItemDaoImpl() {
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
	public int addItem(OrderItem oi)
	{
		 try
		 {
	         pstmt =con.prepareStatement("CREATE_ORDER_ITEMS");
	         pstmt.setInt(1, oi.getOid() );
	         pstmt.setInt(2, oi.getMenuId());
	         pstmt.setInt(3, oi.getQuantity());
	         pstmt.setDouble(4, oi.getSubTotal());
	         x = this.pstmt.executeUpdate();
	      }
		 catch (SQLException var3)
		 {
	         var3.printStackTrace();
	      }

	      return x;
	}

	@Override
	public ArrayList<OrderItem> getAllItems()
	{
		try
		{
	         stmt = con.createStatement();
	         this.res = stmt.executeQuery("GET_ALL_ORDER_ITEMS");
	         items = (ArrayList<OrderItem>) extractOrderItemListFromResultSet(this.res);
	    }
		catch (SQLException var2)
		{
	         var2.printStackTrace();
	    }

	      return items;
	}

	@Override
	public int updateItem(OrderItem oi, int oiid)
	{
		 try
		 {
	         pstmt = con.prepareStatement("UPDATE_ORDER_ITEMS_BY_ID");
	         pstmt.setInt(1, oi.getQuantity());
	         pstmt.setDouble(2, oi.getSubTotal());
	         pstmt.setInt(3, oi.getOid());
	         x = pstmt.executeUpdate();
	     }
		 catch (SQLException e)
		 {
	         e.printStackTrace();
	     }

	      return x;
	}

	@Override
	public int deleteItem(int oiid)
	{
		try
		{
	         pstmt = con.prepareStatement("DELETE_ORDER_ITEMS_BY_ID ");
	         pstmt.setInt(1, oiid);
	         x =pstmt.executeUpdate();
	    }
		catch (SQLException e)
		{
	         e.printStackTrace();
	    }

	      return x;
	}

	@Override
	public ArrayList<OrderItem> getItem()
	{
		try
		{
	         stmt = con.createStatement();
	         res = this.stmt.executeQuery("GET_ORDER_ITEMS_BY_ID");
	         items = (ArrayList<OrderItem>) extractOrderItemListFromResultSet(res);
	    } 
		catch (SQLException var2)
		{
	         var2.printStackTrace();
	    }

	      return this.items;
	}

	@Override
	public ArrayList<OrderItem> getSpecificItem(int id)
	{	
		try
		{
			System.out.println(id);
	         pstmt = con.prepareStatement("select * from `orderitems` where `oiid`=?");
	         pstmt.setInt(1, id);
	         res = pstmt.executeQuery();
	         
	         items = (ArrayList<OrderItem>) extractOrderItemListFromResultSet(res);
	         System.out.println(items);
	    } 
		catch (SQLException var3)
		{
	         var3.printStackTrace();
	    }

	      return items;
	}
	List<OrderItem> extractOrderItemListFromResultSet(ResultSet res)
	{
		try
		{
			while(res.next())
			{
				items.add(new OrderItem(res.getInt(1),res.getInt(2),res.getInt(3),res.getInt(4),res.getDouble(5)));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return items;	
	}

}
