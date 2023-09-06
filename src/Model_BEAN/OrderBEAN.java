package Model_BEAN;

import java.util.Date;

public class OrderBEAN {
	private long orderID;
	private long customerID;
	private long employeeID;
	private Date orderTime;
	private String description;
	private String status;
	public OrderBEAN() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderBEAN(long orderID, long customerID, long employeeID, Date orderTime, String description,
			String status) {
		super();
		this.orderID = orderID;
		this.customerID = customerID;
		this.employeeID = employeeID;
		this.orderTime = orderTime;
		this.description = description;
		this.status = status;
	}
	public long getOrderID() {
		return orderID;
	}
	public void setOrderID(long orderID) {
		this.orderID = orderID;
	}
	public long getCustomerID() {
		return customerID;
	}
	public void setCustomerID(long customerID) {
		this.customerID = customerID;
	}
	public long getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(long employeeID) {
		this.employeeID = employeeID;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
