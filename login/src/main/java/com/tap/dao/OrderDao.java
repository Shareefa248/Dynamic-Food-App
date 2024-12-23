package com.tap.dao;

import java.util.ArrayList;
import java.util.List;

import com.tap.model.Menu;
import com.tap.model.Order;
import com.tap.model.OrderHistory;
import com.tap.model.OrderItem;
import com.tap.model.OrderItem;

public interface OrderDao 
{
	int insertOrder(Order o);
	ArrayList<Order> getAllOrders();
	Order getOrder(int var1);
	int updateUser(Order var1, int var2);
	int deleteOrder(int var1);
	Order getSpecificOrder();
}
