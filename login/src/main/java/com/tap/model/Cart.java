package com.tap.model;
import java.util.HashMap;
import java.util.Map;
public class Cart 
{
	private HashMap<Integer,CartItem> cart;
	public Cart()
	{
		this.cart=new HashMap<>();
	}
	
	public void addItem(CartItem item)
	{
		System.out.println("Cart.java 14"+item);
		int menuid=item.getMenuId();
		if(cart.containsKey(menuid))
		{
			CartItem existingItem=cart.get(menuid);
			existingItem.setQuantity(existingItem.getQuantity()+item.getQuantity());
		}
		else 
		{
			cart.put(menuid, item);
		}
	}

	public void updateItem(int menuid,int quantity)
	{
		if(cart.containsKey(menuid))
		{
			if(quantity<=0)
			{
				cart.remove(menuid);
			}
			else 
			{
				cart.get(menuid).setQuantity(quantity);
			}
		}
	}
	public void removeItem(int menuid)
	{
		cart.remove(menuid);
	}
	public Map<Integer,CartItem> getCart()
	{
		return cart;
	}

	public Map<Integer, CartItem> getItems()
	{
        return cart;
    }

    // Clear the cart
    public void clear()
    {
        cart.clear();
    }
}
