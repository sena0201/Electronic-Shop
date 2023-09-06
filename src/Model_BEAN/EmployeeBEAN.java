package Model_BEAN;

public class EmployeeBEAN {
	private long employeeID;
	private String employeeName;
	private String photo;
	private String userName;
	private String password;
	private String role;
	public EmployeeBEAN() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeBEAN(long employeeID, String employeeName, String photo, String userName,
			String password, String role) {
		super();
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.photo = photo;
		this.userName = userName;
		this.password = password;
		this.role = role;
	}
	public long getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(long employeeID) {
		this.employeeID = employeeID;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
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
