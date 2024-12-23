package com.tap.model;

import java.util.Date;

public class Order
{
	    private int oid; 
	    private int uid; 
	    private int restaurantid; 
	    private double totalamount; 
	    private String status; 
	    private Date date; 
	    private String paymentoption; 

	    public Order()
	    {
	    	
	    }
	    public Order(int oid, int uid, int restaurantid, double totalamount, String status, Date date, String paymentoption) {
	        this.oid = oid;
	        this.uid = uid;
	        this.restaurantid = restaurantid;
	        this.totalamount = totalamount;
	        this.status = status;
	        this.date = date;
	        this.paymentoption = paymentoption;
	    }

	    public Order(int uid, int restaurantid, double totalamount, String status, Date date, String paymentoption) {
			super();
			this.uid = uid;
			this.restaurantid = restaurantid;
			this.totalamount = totalamount;
			this.status = status;
			this.date = date;
			this.paymentoption = paymentoption;
		}
	    

	    public Order(int uid, int restaurantid, double totalamount, String paymentoption) {
			super();
			this.uid = uid;
			this.restaurantid = restaurantid;
			this.totalamount = totalamount;
			this.paymentoption = paymentoption;
		}
		public int getOid() {
	        return oid;
	    }

	    public void setOid(int oid) {
	        this.oid = oid;
	    }

	    public int getUid() {
	        return uid;
	    }

	    public void setUid(int uid) {
	        this.uid = uid;
	    }

	    public int getRestaurantid() {
	        return restaurantid;
	    }

	    public void setRestaurantid(int restaurantid) {
	        this.restaurantid = restaurantid;
	    }

	    public double getTotalamount() {
	        return totalamount;
	    }

	    public void setTotalamount(double totalamount) {
	        this.totalamount = totalamount;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }

	    public Date getDate() {
	        return date;
	    }

	    public void setDate(Date date) {
	        this.date = date;
	    }

	    public String getPaymentoption() {
	        return paymentoption;
	    }

	    public void setPaymentoption(String paymentoption) {
	        this.paymentoption = paymentoption;
	    }
	    @Override
	    public String toString()
	    {
	        return oid + uid +restaurantid +totalamount +
	                status + date + paymentoption;
	    }
		
}
