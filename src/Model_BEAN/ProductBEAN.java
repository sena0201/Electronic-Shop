package Model_BEAN;

public class ProductBEAN {
	private long productID;
	private String productName;
	private long quantity;
	private long unitPrice;
	private String unit;
	private String photo;
	private long categoryID;
	public ProductBEAN() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductBEAN(long productID, String productName, long quantity, long unitPrice, String unit, String photo,
			long categoryID) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.unit = unit;
		this.photo = photo;
		this.categoryID = categoryID;
	}
	public long getProductID() {
		return productID;
	}
	public void setProductID(long productID) {
		this.productID = productID;
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
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public long getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(long categoryID) {
		this.categoryID = categoryID;
	}
}
