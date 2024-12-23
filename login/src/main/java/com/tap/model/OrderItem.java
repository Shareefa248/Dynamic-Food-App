package com.tap.model;

public class OrderItem {
    private int oiid;        
    private int oid;         
    private int menuId;      
    private int quantity;     
    private double subTotal;  

    public OrderItem()
    {
    	
    }

    public OrderItem(int oiid, int oid, int menuId, int quantity, double subTotal)
    {
        this.oiid = oiid;
        this.oid = oid;
        this.menuId = menuId;
        this.quantity = quantity;
        this.subTotal = subTotal;
    }
    

    public OrderItem(int oid, int menuId, int quantity, double subTotal) {
		super();
		this.oid = oid;
		this.menuId = menuId;
		this.quantity = quantity;
		this.subTotal = subTotal;
	}

	public int getOiid() {
        return oiid;
    }

    public void setOiid(int oiid) {
        this.oiid = oiid;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    @Override
    public String toString()
    {
        return oiid+" "+oid+" "+menuId+" "+quantity+" "+ subTotal ;
    }
}
