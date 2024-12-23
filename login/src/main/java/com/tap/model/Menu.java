package com.tap.model;

public class Menu 
{
	private int menuid;
	private int restaurantid;
	private String itemname;
	private String description;
	private float price;
	private boolean isavailable;
	private String imgpath;
	public Menu(int menuid, int restaurantid, String itemname, String description, float price, boolean isavailable,
			String imgpath) {
		super();
		this.menuid = menuid;
		this.restaurantid = restaurantid;
		this.itemname = itemname;
		this.description = description;
		this.price = price;
		this.isavailable = isavailable;
		this.imgpath = imgpath;
	}
	public Menu(int restaurantid, String itemname, String description, float price, boolean isavailable) {
		super();
		this.restaurantid = restaurantid;
		this.itemname = itemname;
		this.description = description;
		this.price = price;
		this.isavailable = isavailable;
	}
	
	public Menu()
	{
		super();
	}
	public int getMenuid() {
		return menuid;
	}
	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}
	public int getRestaurantid() {
		return restaurantid;
	}
	public void setRestaurantid(int restaurantid) {
		this.restaurantid = restaurantid;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public boolean isIsavailable() {
		return isavailable;
	}
	public void setIsavailable(boolean isavailable) {
		this.isavailable = isavailable;
	}
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	@Override
	public String toString()
	{
		return  menuid + " " + restaurantid + " " + itemname + " "
				+ description + " " + price + " " + isavailable + " " + imgpath;
	}
	
}
