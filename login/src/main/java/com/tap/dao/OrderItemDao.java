package com.tap.dao;

import java.util.ArrayList;

import com.tap.model.Order;
import com.tap.model.OrderItem;

public interface OrderItemDao
{
	int addItem(OrderItem var1);
	ArrayList<OrderItem> getAllItems();
	int updateItem(OrderItem var1, int var2);
	int deleteItem(int var1);
	ArrayList<OrderItem> getItem();
	ArrayList<OrderItem> getSpecificItem(int var1);
}
