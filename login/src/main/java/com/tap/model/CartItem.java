package com.tap.model;

public class CartItem 
{
	private int menuId;
	private int restaurantId;
	private String name;
	private int quantity;
	private double price;
	private float subTotal;
	
	public CartItem(int menuId, int restaurantId, String name, int quantity, double price, float subTotal) {
		super();
		this.menuId = menuId;
		this.restaurantId = restaurantId;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.subTotal = subTotal;
	}
	
	public CartItem(int menuId, int restaurantId, String name, int quantity, double price) {
		super();
		this.menuId = menuId;
		this.restaurantId = restaurantId;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

	public int getMenuId()
	{
		return menuId;
	}
	public void setMenuId(int menuId)
	{
		this.menuId = menuId;
	}
	public int getRestaurantId()
	{
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId)
	{
		this.restaurantId = restaurantId;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getQuantity()
	{
		return quantity;
	}
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	public double getPrice()
	{
		return price;
	}
	public void setPrice(double price)
	{
		this.price = price;
	}
	
	public float getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	}
	@Override
	public String toString()
	{
		return  menuId + " " + restaurantId + " " + name + " "
				+ quantity + " " + price +" "+subTotal;
	}
	
}
