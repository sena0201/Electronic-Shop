package Model_BEAN;

public class CartBEAN {
	private long cartID;
	private long customerID;
	public CartBEAN() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartBEAN(long cartID, long customerID) {
		super();
		this.cartID = cartID;
		this.customerID = customerID;
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
}
