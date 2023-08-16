package Model_BEAN;

public class CartDetailBEAN {
	private long cartDetailID;
	private long cartID;
	private long productID;
	private long quantity;
	private long salePrice;
	public CartDetailBEAN() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartDetailBEAN(long cartDetailID, long cartID, long productID, long quantity, long salePrice) {
		super();
		this.cartDetailID = cartDetailID;
		this.cartID = cartID;
		this.productID = productID;
		this.quantity = quantity;
		this.salePrice = salePrice;
	}
	public long getCartDetailID() {
		return cartDetailID;
	}
	public void setCartDetailID(long cartDetailID) {
		this.cartDetailID = cartDetailID;
	}
	public long getCartID() {
		return cartID;
	}
	public void setCartID(long cartID) {
		this.cartID = cartID;
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
