package Model_DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import Model_BEAN.AdWaitOrderBEAN;
import Model_BEAN.OrderBEAN;

public class OrderDAO {
	public long CreateOrder(long customerID, Date orderTime, String description, String status) throws Exception{
		long generatedId = 0;
		
		ConnectDB cn = new ConnectDB();
		cn.Connect();
		
		String sql = "INSERT INTO Orders(customerID,orderTime,description,status) VALUES (?,?,?,?)";
		PreparedStatement cmd = cn.cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		cmd.setLong(1, customerID);
		cmd.setDate(2, new java.sql.Date(orderTime.getTime()));
		cmd.setString(3, description);
		cmd.setString(4, status);
		
		int rowsAffected  = cmd.executeUpdate();
        if (rowsAffected  > 0) {
        	ResultSet resultSet = cmd.getGeneratedKeys();
            if (resultSet.next()) {
                generatedId = resultSet.getLong(1);
                return generatedId;
            }
        }
        
        cmd.close();
        cn.cn.close();
		return generatedId;
	}
	
	public ArrayList<OrderBEAN> ListOfOrders() throws Exception{
		ArrayList<OrderBEAN> List = new ArrayList<OrderBEAN>();
		
		ConnectDB cn = new ConnectDB();
		cn.Connect();
		
		String sql = "SELECT * FROM Orders ORDER BY orderID DESC";
		PreparedStatement cmd = cn.cn.prepareStatement(sql);
		
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			long orderID = rs.getLong("orderID"); 
			long customerID = rs.getLong("customerID");  
			long employeeID = rs.getLong("employeeID");  
			Date orderTime = rs.getDate("orderTime");  
			String description = rs.getString("description"); 
			String status = rs.getString("status"); 
			List.add(new OrderBEAN(orderID, customerID, employeeID, orderTime, description,status));
		}
		
		rs.close();
		cmd.close();
		cn.cn.close();
		
		return List;
	}
	
	public ArrayList<AdWaitOrderBEAN> ListOfAdOrders(String status) throws Exception{
		ArrayList<AdWaitOrderBEAN> List = new ArrayList<AdWaitOrderBEAN>();
		
		ConnectDB cn = new ConnectDB();
		cn.Connect();
		
		String sql = "SELECT orderID, customerName, orderTime, status FROM Customers JOIN Orders ON Customers.customerID = Orders.customerID WHERE status = ? ORDER BY Orders.orderID DESC";
		PreparedStatement cmd = cn.cn.prepareStatement(sql);
		cmd.setString(1, status);
		
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			long orderID = rs.getLong("orderID"); 
			String customerName = rs.getString("customerName");  
			Date orderTime = rs.getDate("orderTime");  
			List.add(new AdWaitOrderBEAN(orderID, customerName, orderTime,status));
		}
		
		rs.close();
		cmd.close();
		cn.cn.close();
		
		return List;
	}
	
	public ArrayList<AdWaitOrderBEAN> ListOfAdOrders() throws Exception{
		ArrayList<AdWaitOrderBEAN> List = new ArrayList<AdWaitOrderBEAN>();
		
		ConnectDB cn = new ConnectDB();
		cn.Connect();
		
		String sql = "SELECT orderID, customerName, orderTime, status FROM Customers JOIN Orders ON Customers.customerID = Orders.customerID";
		PreparedStatement cmd = cn.cn.prepareStatement(sql);
		
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			long orderID = rs.getLong("orderID"); 
			String customerName = rs.getString("customerName");  
			Date orderTime = rs.getDate("orderTime");  
			String status = rs.getString("status");
			List.add(new AdWaitOrderBEAN(orderID, customerName, orderTime,status));
		}
		
		rs.close();
		cmd.close();
		cn.cn.close();
		
		return List;
	}
	
	public ArrayList<OrderBEAN> ListOfOrders(long customerID) throws Exception{
		ArrayList<OrderBEAN> List = new ArrayList<OrderBEAN>();
		
		ConnectDB cn = new ConnectDB();
		cn.Connect();
		
		String sql = "SELECT * FROM Orders WHERE customerID = ?";
		PreparedStatement cmd = cn.cn.prepareStatement(sql);
		cmd.setLong(1, customerID);
		
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			long orderID = rs.getLong("orderID"); 
			long employeeID = rs.getLong("employeeID");  
			Date orderTime = rs.getDate("orderTime");  
			String description = rs.getString("description"); 
			String status = rs.getString("status"); 
			List.add(new OrderBEAN(orderID, customerID, employeeID, orderTime, description,status));
		}
		
		rs.close();
		cmd.close();
		cn.cn.close();
		return List;
	}
	public ArrayList<OrderBEAN> ListOfOrders(long customerID, String status) throws Exception{
		ArrayList<OrderBEAN> List = new ArrayList<OrderBEAN>();
		
		ConnectDB cn = new ConnectDB();
		cn.Connect();
		
		String sql = "SELECT * FROM Orders WHERE customerID = ? AND status = ?";
		PreparedStatement cmd = cn.cn.prepareStatement(sql);
		cmd.setLong(1, customerID);
		cmd.setString(2, status);
		
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			long orderID = rs.getLong("orderID"); 
			long employeeID = rs.getLong("employeeID");  
			Date orderTime = rs.getDate("orderTime");  
			String description = rs.getString("description"); 
			List.add(new OrderBEAN(orderID, customerID, employeeID, orderTime, description,status));
		}
		
		rs.close();
		cmd.close();
		cn.cn.close();
		return List;
	}
	
	public int Processing(long orderID, long employeeID, String status) throws Exception{
		ConnectDB cn = new ConnectDB();
		cn.Connect();
		
		String sql ="UPDATE Orders SET employeeID = ?, status = ? WHERE orderID = ?";
		PreparedStatement cmd = cn.cn.prepareStatement(sql);
		cmd.setLong(1, employeeID);
		cmd.setString(2, status);
		cmd.setLong(3, orderID);
		
		int rowAffected = 0;
		rowAffected = cmd.executeUpdate();

		cmd.close();
		cn.cn.close();
		return rowAffected;
	}
}
