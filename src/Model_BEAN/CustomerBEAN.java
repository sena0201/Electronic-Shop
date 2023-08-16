package Model_BEAN;

public class CustomerBEAN {
	private long customerID;
	private String customerName;
	private String address;
	private String phoneNumber;
	private String userName;
	private String password;
	private String role;
	public CustomerBEAN() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerBEAN(long customerID, String customerName, String address, String phoneNumber, String userName,
			String password, String role) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.userName = userName;
		this.password = password;
		this.role = role;
	}
	public long getCustomerID() {
		return customerID;
	}
	public void setCustomerID(long customerID) {
		this.customerID = customerID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
