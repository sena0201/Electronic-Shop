package Model_BEAN;

public class OrderDetailBEAN {
	private long orderDetailID;
	private long orderID;
	private long productID;
	private long quantity;
	private long salePrice;
	public OrderDetailBEAN() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderDetailBEAN(long orderDetailID, long orderID, long productID, long quantity, long salePrice) {
		super();
		this.orderDetailID = orderDetailID;
		this.orderID = orderID;
		this.productID = productID;
		this.quantity = quantity;
		this.salePrice = salePrice;
	}
	public long getOrderDetailID() {
		return orderDetailID;
	}
	public void setOrderDetailID(long orderDetailID) {
		this.orderDetailID = orderDetailID;
	}
	public long getOrderID() {
		return orderID;
	}
	public void setOrderID(long orderID) {
		this.orderID = orderID;
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
	
}
