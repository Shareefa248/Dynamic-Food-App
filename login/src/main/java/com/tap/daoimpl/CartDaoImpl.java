package com.tap.daoimpl;

import java.util.Map;

import com.tap.model.CartItem;

public class CartDaoImpl 
{
	public Map<Integer,CartItem> addItem(CartItem newItem,Map<Integer,CartItem> items)
	{
		int itemId=newItem.getMenuId();
		if(items.containsKey(itemId))
		{
			System.out.println("old item");
			CartItem existingItem=items.get(itemId);
			existingItem.setQuantity(existingItem.getQuantity()+ newItem.getQuantity());
		}
		else 
		{
			System.out.println("new item");
			items.put(itemId, newItem);
		}
		return items;
	}
}
