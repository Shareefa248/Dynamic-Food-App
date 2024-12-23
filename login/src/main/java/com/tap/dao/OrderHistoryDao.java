package com.tap.dao;

import java.util.ArrayList;
import java.util.List;

import com.tap.model.Order;
import com.tap.model.OrderHistory;

public interface OrderHistoryDao
{
	int addorderHistory(OrderHistory var1);
	ArrayList<OrderHistory> getAllOrderHistory();
	List<OrderHistory> getOrderHistory(int var1);
	int updateOrderHistory(OrderHistory var1, int var2);
	int deleteOrderHistory(int var1);
}
