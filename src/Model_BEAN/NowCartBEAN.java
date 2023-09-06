package Model_BEAN;

public class NowCartBEAN {
	private long cartID;
	private long customerID;
	private long cartDetailID;
	private long productID;
	private long quantity;
	private long salePrice;
	private String productName;
	private String productPhoto;
	private long unitPrice;
	
	public NowCartBEAN(long cartID, long customerID, long cartDetailID, long productID, long quantity, long salePrice,
			String productName, String productPhoto, long unitPrice) {
		super();
		this.cartID = cartID;
		this.customerID = customerID;
		this.cartDetailID = cartDetailID;
		this.productID = productID;
		this.quantity = quantity;
		this.salePrice = salePrice;
		this.productName = productName;
		this.productPhoto = productPhoto;
		this.unitPrice = unitPrice;
	}
	public NowCartBEAN() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getCartID() {
		return cartID;
	}
	public void setCartID(long cartID) {
		this.cartID = cartID;
	}
	public long getCustomerID() {
		return customerID;
	}
	public void setCustomerID(long customerID) {
		this.customerID = customerID;
	}
	public long getCartDetailID() {
		return cartDetailID;
	}
	public void setCartDetailID(long cartDetailID) {
		this.cartDetailID = cartDetailID;
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
	public String getProductPhoto() {
		return productPhoto;
	}
	public void setProductPhoto(String productPhoto) {
		this.productPhoto = productPhoto;
	}
	public long getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(long unitPrice) {
		this.unitPrice = unitPrice;
	}
	
}
