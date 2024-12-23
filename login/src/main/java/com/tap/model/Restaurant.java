package com.tap.model;

public class Restaurant 
{
	private int restaurantid;
	private String name;
	private String cuisiveType;
	private int deliveryTime;
	private boolean isActive;
	private int rating;
	private String imgPath;
	public Restaurant(int restaurantid, String name, String cuisiveType, int deliveryTime, boolean isActive, int rating,
			String imgPath) {
		super();
		this.restaurantid = restaurantid;
		this.name = name;
		this.cuisiveType = cuisiveType;
		this.deliveryTime = deliveryTime;
		this.isActive = isActive;
		this.rating = rating;
		this.imgPath = imgPath;
	}
	public Restaurant(int restaurantid, String name, String cuisiveType, int deliveryTime, boolean isActive, int rating)
	{
		super();
		this.restaurantid = restaurantid;
		this.name = name;
		this.cuisiveType = cuisiveType;
		this.deliveryTime = deliveryTime;
		this.isActive = isActive;
		this.rating = rating;
	}
	public Restaurant()
	{
		super();
	}
	public int getRestaurantid() {
		return restaurantid;
	}
	public void setRestaurantid(int restaurantid) {
		this.restaurantid = restaurantid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCuisiveType() {
		return cuisiveType;
	}
	public void setCuisiveType(String cuisiveType) {
		this.cuisiveType = cuisiveType;
	}
	public int getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(int deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	@Override
	public String toString()
	{
		return  restaurantid + " " + name + " " + cuisiveType
				+ " " + deliveryTime + " " + isActive + " " + rating + " ";
				
	}
}
