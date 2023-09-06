package Model_BEAN;

import java.util.Date;

public class AdWaitOrderBEAN {
	private long orderID;
	private String customerName; 
	private Date orderTime;
	private String status;
	public AdWaitOrderBEAN() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdWaitOrderBEAN(long orderID, String customerName, Date orderTime, String status) {
		super();
		this.orderID = orderID;
		this.customerName = customerName;
		this.orderTime = orderTime;
		this.status = status;
	}
	public long getOrderID() {
		return orderID;
	}
	public void setOrderID(long orderID) {
		this.orderID = orderID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
