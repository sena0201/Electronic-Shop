package Model_DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Model_BEAN.CustomerBEAN;

public class CustomerDAO {
	public ArrayList<CustomerBEAN> ListOfCustumers() throws Exception{
		ArrayList<CustomerBEAN> List = new ArrayList<CustomerBEAN>();
		
		ConnectDB cn = new ConnectDB();
		cn.Connect();
		
		String sql = "SELECT * FROM Customers";
		
		PreparedStatement cmd = cn.cn.prepareStatement(sql);
		
		ResultSet rs = cmd.executeQuery();
		
		while(rs.next()) {
			long customerID = rs.getLong("customerID");
			String customerName = rs.getString("customerName");
			String address = rs.getString("address"); 
			String phoneNumber = rs.getString("phoneNumber"); 
			String userName = rs.getString("userName");
			String password = rs.getString("password"); 
			String role = rs.getString("role");
			List.add(new CustomerBEAN(customerID,customerName,address,phoneNumber,userName,password,role));
		}
		
		rs.close();
		cn.cn.close();
		
		return List;
	}
	public CustomerBEAN CustomerLogin(String userName, String password) throws Exception{
		CustomerBEAN customer = null;
		
		ConnectDB cn = new ConnectDB();
		cn.Connect();
		
		String sql = "SELECT * FROM Customers WHERE userName = ? AND password = ?";
		
		PreparedStatement cmd = cn.cn.prepareStatement(sql);
		cmd.setString(1, userName);
		cmd.setString(2, password);
		
		ResultSet rs = cmd.executeQuery();
		
		if(rs.next()) {
			long customerID = rs.getLong("customerID");
			String customerName = rs.getString("customerName");
			String address = rs.getString("address"); 
			String phoneNumber = rs.getString("phoneNumber"); 
			String role = rs.getString("role");
			customer = new CustomerBEAN(customerID,customerName,address,phoneNumber,userName,password,role);
		}
		
		rs.close();
		cn.cn.close();
		
		return customer;
	}
	
	public long CustomerRegister(String customerName, String address, String phoneNumber, String userName, String password) throws Exception{
		ConnectDB cn = new ConnectDB();
		cn.Connect();
		
		String sql = "IF not exists (SELECT * FROM Customers WHERE userName = ?)\r\n"
				+ "BEGIN \r\n"
				+ "	INSERT INTO Customers VALUES (?, ?, ?, ?, ?,?)\r\n"
				+ "END";
		PreparedStatement cmd = cn.cn.prepareStatement(sql);
		cmd.setString(1, userName);
		cmd.setString(2, customerName);
		cmd.setString(3, address);
		cmd.setString(4, phoneNumber);
		cmd.setString(5, userName);
		cmd.setString(6, password);
		cmd.setString(7, "KH");
		
		long rowsAffected = cmd.executeUpdate();
		
		cmd.close();
		cn.cn.close();
		
		return rowsAffected;
	}
}
