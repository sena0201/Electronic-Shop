package Model_BEAN;

public class CategoryBEAN {
	private long categoryID;
	private String categoryName;
	public CategoryBEAN() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CategoryBEAN(long categoryID, String categoryName) {
		super();
		this.categoryID = categoryID;
		this.categoryName = categoryName;
	}
	public long getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(long categoryID) {
		this.categoryID = categoryID;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
