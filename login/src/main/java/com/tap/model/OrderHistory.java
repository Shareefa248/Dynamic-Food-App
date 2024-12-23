package com.tap.model;

import java.util.Date;

public class OrderHistory
{
    private int ohid;       
    private int uid;        
    private int oid;       
    private Date date;      
    private double total;
    private String status;

    public OrderHistory()
    {
    	
    }

    public OrderHistory(int ohid, int uid, int oid, Date date, double total,String status) {
        this.ohid = ohid;
        this.uid = uid;
        this.oid = oid;
        this.date = date;
        this.total = total;
        this.status=status;
    }
    

    public OrderHistory(int uid, int oid, Date date, double total, String status) {
		super();
		this.uid = uid;
		this.oid = oid;
		this.date = date;
		this.total = total;
		this.status = status;
	}
    

	public OrderHistory(int uid, int oid, double total) {
		super();
		this.uid = uid;
		this.oid = oid;
		this.total = total;
	}

	public int getOhid() {
        return ohid;
    }

    public void setOhid(int ohid) {
        this.ohid = ohid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
    public String toString()
    {
        return  ohid +" "+ uid +" "+ oid +" "+ date +" "+ total;
                
    }

	
}
