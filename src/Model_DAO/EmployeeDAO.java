package Model_DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Model_BEAN.EmployeeBEAN;

public class EmployeeDAO {
	public EmployeeBEAN Employee(String userName, String password) throws Exception{
		EmployeeBEAN employee = null;
		
		ConnectDB cn = new ConnectDB();
		cn.Connect();
		
		String sql = "SELECT * FROM Employees WHERE userName = ? AND password = ?";
		
		PreparedStatement cmd = cn.cn.prepareStatement(sql);
		cmd.setString(1, userName);
		cmd.setString(2, password);
		
		ResultSet rs = cmd.executeQuery();
		
		if(rs.next()) {
			long employeeID = rs.getLong("employeeID");
			String employeeName = rs.getString("employeeName");
			String photo = rs.getString("photo"); 
			String role = rs.getString("role");
			employee = new EmployeeBEAN(employeeID, employeeName, photo, userName, password, role);
		}
		
		rs.close();
		cn.cn.close();
		
		return employee;
	}
	
	public ArrayList<EmployeeBEAN> ListOfEmployees() throws Exception{
		ArrayList<EmployeeBEAN> List = new ArrayList<EmployeeBEAN>();
		
		ConnectDB cn = new ConnectDB();
		cn.Connect();
		
		String sql = "SELECT * FROM Employees";
		
		PreparedStatement cmd = cn.cn.prepareStatement(sql);
		
		ResultSet rs = cmd.executeQuery();
		
		while(rs.next()) {
			long employeeID = rs.getLong("employeeID");
			String employeeName = rs.getString("employeeName"); 
			String photo = rs.getString("photo");
			String userName = rs.getString("userName");
			String password = rs.getString("password");
			String role = rs.getString("role");
			List.add(new EmployeeBEAN(employeeID, employeeName, photo, userName, password, role));
		}
		
		rs.close();
		cn.cn.close();
		
		return List;
	}
	
	public int AddEmployee(String employeeName,String photo, String userName, String password) throws Exception{
		ConnectDB cn = new ConnectDB();
		cn.Connect();
		
		String sql = "IF not exists (SELECT * FROM Employees WHERE userName = ?)\r\n"
				+ "BEGIN \r\n"
				+ "	INSERT INTO Employees VALUES (?, ?, ?, ?, ?)\r\n"
				+ "END";
		PreparedStatement cmd = cn.cn.prepareStatement(sql);
		cmd.setString(1, userName);
		cmd.setString(2, employeeName);
		cmd.setString(3, photo);
		cmd.setString(4, userName);
		cmd.setString(5, password);
		cmd.setString(6, "NV");
		
		int rowsAffected = cmd.executeUpdate();
		
		cmd.close();
		cn.cn.close();
		
		return rowsAffected;
	}
	
	public int Edit(long employeeID ,String employeeName, String photo, String password) throws Exception{
		ConnectDB cn = new ConnectDB();
		cn.Connect();
		
		String sql ="UPDATE Employees SET employeeName = ? , photo = ?, password = ?\r\n"
				+ "WHERE employeeID = ?";
		
		PreparedStatement cmd = cn.cn.prepareStatement(sql);
		cmd.setString(1, employeeName);
		cmd.setString(2, photo);
		cmd.setString(3, password);
		cmd.setLong(4, employeeID);
		
		int rowAffected = 0;
		
		rowAffected = cmd.executeUpdate();
		
		cmd.close();
		cn.cn.close();
		return rowAffected;
	}
	
	public int Delete(long employeeID) throws Exception{
		ConnectDB cn = new ConnectDB();
		cn.Connect();
		String sql = "DELETE FROM Employees WHERE employeeID = ?";
		PreparedStatement cmd = cn.cn.prepareStatement(sql);
		cmd.setLong(1, employeeID);
		
		int rowAffected = 0;
		
		rowAffected = cmd.executeUpdate();
		
		cmd.close();
		cn.cn.close();
		return rowAffected;
	}
	
	public EmployeeBEAN Employee(long employeeID) throws Exception{
		EmployeeBEAN employee = null;
		
		ConnectDB cn = new ConnectDB();
		cn.Connect();
		
		String sql = "SELECT * FROM Employees WHERE employeeID = ?";
		
		PreparedStatement cmd = cn.cn.prepareStatement(sql);
		cmd.setLong(1, employeeID);
		
		ResultSet rs = cmd.executeQuery();
		
		if(rs.next()) {
			String employeeName = rs.getString("employeeName"); 
			String photo = rs.getString("photo");
			String userName = rs.getString("userName");
			String password = rs.getString("password");
			String role = rs.getString("role");
			employee = new EmployeeBEAN(employeeID, employeeName, photo, userName, password, role);
		}
		
		rs.close();
		cn.cn.close();
		
		return employee;
	}
}
