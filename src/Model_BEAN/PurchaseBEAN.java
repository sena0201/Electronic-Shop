package Model_BEAN;

import java.util.Date;

public class PurchaseBEAN {
	private long orderID;
	private long customerID;
	private long employeeID;
	private Date orderTime;
	private String description;
	private String status;
	private long orderDetailID;
	private long productID;
	private long quantity;
	private long salePrice;
	private String productName;
	private long unitPrice;
	private String photo;
	public PurchaseBEAN() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PurchaseBEAN(long orderID, long customerID, long employeeID, Date orderTime, String description,
			String status, long orderDetailID, long productID, long quantity, long salePrice, String productName,
			long unitPrice, String photo) {
		super();
		this.orderID = orderID;
		this.customerID = customerID;
		this.employeeID = employeeID;
		this.orderTime = orderTime;
		this.description = description;
		this.status = status;
		this.orderDetailID = orderDetailID;
		this.productID = productID;
		this.quantity = quantity;
		this.salePrice = salePrice;
		this.productName = productName;
		this.unitPrice = unitPrice;
		this.photo = photo;
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
	public long getOrderDetailID() {
		return orderDetailID;
	}
	public void setOrderDetailID(long orderDetailID) {
		this.orderDetailID = orderDetailID;
	}
	public long getProductID() {
		return productID;
	}
	public void setProductID(long productID) {
		this.productID = productID;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public long getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(long salePrice) {
		this.salePrice = salePrice;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public long getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(long unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
}
