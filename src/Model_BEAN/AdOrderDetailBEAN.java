package Model_BEAN;

public class AdOrderDetailBEAN {
	private String productName;
	private long quantity;
	private long unitPrice;
	private long salePrice;
	public AdOrderDetailBEAN() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdOrderDetailBEAN(String productName, long quantity, long unitPrice, long salePrice) {
		super();
		this.productName = productName;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.salePrice = salePrice;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public long getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(long unitPrice) {
		this.unitPrice = unitPrice;
	}
	public long getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(long salePrice) {
		this.salePrice = salePrice;
	}
	
}
