package Model_BEAN;

import java.util.Date;

public class ProcessedBEAN {
	private long orderID;
	private String customerName;
	private Date orderTime;
	private String status;
	private String employeeName;
	public ProcessedBEAN() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProcessedBEAN(long orderID, String customerName, Date orderTime, String status, String employeeName) {
		super();
		this.orderID = orderID;
		this.customerName = customerName;
		this.orderTime = orderTime;
		this.status = status;
		this.employeeName = employeeName;
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
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
}
