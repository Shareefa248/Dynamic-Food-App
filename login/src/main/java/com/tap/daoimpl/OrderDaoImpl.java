package com.tap.daoimpl;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.tap.dao.OrderDao;
import com.tap.model.Order;
import com.tap.model.OrderItem;

public class OrderDaoImpl implements OrderDao 
{
	int x=-1;
	Order order;
	static Connection con;
	private PreparedStatement pstmt;
	private Statement stmt;
	ArrayList<Order> orderList=new ArrayList<Order>();
	private ResultSet res;
	private static String url="jdbc:mysql://localhost:3306/online_food_delivery";
	private static String un="root";
	private static String pwd="Shareefa@248";

	   private static final String INSERT_ORDER = "insert into `order` (uid,restaurantid,totalamount,paymentoption) values(?,?,?,?);";
	   private static final String GET_ALL_ORDERS = "select * from `order`;";
	   private static final String GET_ORDERS_BY_ID = "select * from `order` where oid=?;";
	   private static final String UPDATE_ORDERS_BY_ID = "update `order` set totalamount=?, status=? where oid=?;";
	   private static final String DELETE_ORDERS_BY_ID = "delete from `order` where oid=?";
	   private static final String GET_ORDER_TABLE_BY_ID = "SELECT * FROM `order` WHERE `oid` = (SELECT MAX(oid) FROM order)";
	   public OrderDaoImpl() {
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
		public int insertOrder(Order o)
		{
		 try
		 {
			pstmt=con.prepareStatement(INSERT_ORDER);
			
			pstmt.setInt(1, o.getUid());
			pstmt.setInt(2, o.getRestaurantid());
			pstmt.setDouble(3, o.getTotalamount());
			pstmt.setString(4, o.getPaymentoption());
			
			x=pstmt.executeUpdate();
			System.out.println(x+"java");
		 }
		 catch(Exception e)
		 {
			e.printStackTrace();
		 }
	   return x;
	 }


		public ArrayList<Order> getAllOrders()
		{
			try
			{
				stmt=con.createStatement();
				res=stmt.executeQuery( GET_ALL_ORDERS);
				orderList=(ArrayList<Order>) extractOrderListFromResultSet(res);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return orderList;
		}

		public Order getOrder(int id)
		{
			try
			{
				pstmt=con.prepareStatement(GET_ORDERS_BY_ID);
				pstmt.setInt(1,id);
				res=pstmt.executeQuery();
				orderList=(ArrayList<Order>) extractOrderListFromResultSet(res);
				order=orderList.get(0);
						
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return order;
		}

		public int updateUser(Order o, int id)
		{
			try
			{
				pstmt=con.prepareStatement(UPDATE_ORDERS_BY_ID );
				pstmt.setInt(1,id);
				x=pstmt.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return x;
		}

		
		public int deleteOrder(int id)
		{
			try
			{
				pstmt=con.prepareStatement(DELETE_ORDERS_BY_ID);
				pstmt.setInt(1, id);
				x=pstmt.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return x;
		}

		
		public Order getSpecificOrder()
		{
			try {
		         pstmt =con.prepareStatement("GET_ORDER_TABLE_BY_ID");
		         res = pstmt.executeQuery();
		         orderList = extractOrderListFromResultSet(res);
		         order=orderList.get(0);
		      } 
			  catch (SQLException e) 
			  {
		         e.printStackTrace();
		      }

		      return order;
		}
		private ArrayList<Order> extractOrderListFromResultSet(ResultSet res2)
		{
			try
			{
				while(res.next())
				{
					orderList.add(new Order(res.getInt(1),res.getInt(2),res.getInt(3),res.getDouble(4),res.getString(5),res.getDate(6),res.getString(7)));
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			return orderList;
		}


		
	
	
	
}
