package Model_BEAN;

public class SearchBEAN {
	private long productID;
	private String productName;
	private long quantity;
	private long unitPrice;
	private String unit;
	private String photo;
	private String categoryName;
	public SearchBEAN() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SearchBEAN(long productID, String productName, long quantity, long unitPrice, String unit, String photo,
			String categoryName) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.unit = unit;
		this.photo = photo;
		this.categoryName = categoryName;
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
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
}
