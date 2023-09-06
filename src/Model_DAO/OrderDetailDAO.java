package Model_DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import Model_BEAN.AdOrderDetailBEAN;
import Model_BEAN.OrderDetailBEAN;
import Model_BEAN.ProcessedBEAN;

public class OrderDetailDAO {
	public int AddOrderDetail(long orderID, long productID, long quantity, long salePrice) throws Exception{
		ConnectDB cn = new ConnectDB();
		cn.Connect();
		
		String sql = "INSERT INTO OrderDetails(orderID,productID,quantity,salePrice) VALUES (?,?,?,?)";
		PreparedStatement cmd = cn.cn.prepareStatement(sql);
		cmd.setLong(1, orderID);
		cmd.setLong(2, productID);
		cmd.setLong(3, quantity);
		cmd.setLong(4, salePrice);
		
		int rowAffected = 0;
		rowAffected = cmd.executeUpdate();
		
		cmd.close();
		cn.cn.close();
		return rowAffected;
	}
	
	public ArrayList<OrderDetailBEAN> ListOfOrderDetails() throws Exception{
		ArrayList<OrderDetailBEAN> List = new ArrayList<OrderDetailBEAN>();
		
		ConnectDB cn = new ConnectDB();
		cn.Connect();
		
		String sql = "SELECT * FROM OrderDetails";
		PreparedStatement cmd = cn.cn.prepareStatement(sql);
		
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			long orderDetailID = rs.getLong("orderDetailID"); 
			long orderID = rs.getLong("orderID");  
			long productID = rs.getLong("productID");  
			long quantity = rs.getLong("quantity"); 
			long salePrice = rs.getLong("salePrice"); 
			List.add(new OrderDetailBEAN(orderDetailID, orderID, productID, quantity, salePrice));
		}
		
		rs.close();
		cmd.close();
		cn.cn.close();
		
		return List;
	}
	
	public ArrayList<AdOrderDetailBEAN> ListOfOrderDetails(long orderID) throws Exception{
		ArrayList<AdOrderDetailBEAN> List = new ArrayList<AdOrderDetailBEAN>();
		
		ConnectDB cn = new ConnectDB();
		cn.Connect();
		
		String sql = "SELECT productName, OrderDetails.quantity AS quantity, unitPrice, salePrice FROM OrderDetails JOIN Products ON OrderDetails.productID = Products.productID WHERE orderID = ?";
		PreparedStatement cmd = cn.cn.prepareStatement(sql);
		cmd.setLong(1, orderID);
		
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			String productName = rs.getString("productName");
			long quantity = rs.getLong("quantity");  
			long unitPrice = rs.getLong("unitPrice"); 
			long salePrice = rs.getLong("salePrice"); 
			List.add(new AdOrderDetailBEAN(productName,quantity,unitPrice, salePrice));
		}
		
		rs.close();
		cmd.close();
		cn.cn.close();
		
		return List;
	}
	
	public ArrayList<ProcessedBEAN> ListOfProcesseds(String status) throws Exception{
		ArrayList<ProcessedBEAN> List = new ArrayList<ProcessedBEAN>();
		ConnectDB cn = new ConnectDB();
		cn.Connect();
		
		String sql = "SELECT * FROM Orders JOIN Customers ON Orders.customerID = Customers.customerID JOIN Employees ON Orders.employeeID = Employees.employeeID\r\n"
				+ "WHERE status = ? ORDER BY orderID DESC";
		PreparedStatement cmd = cn.cn.prepareStatement(sql);
		cmd.setString(1, status);
		
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			long orderID = rs .getLong("orderID"); 
			String customerName = rs .getString("customerName"); 
			Date orderTime = rs.getDate("orderTime");
			String employeeName = rs .getString("employeeName"); 
			List.add(new ProcessedBEAN(orderID, customerName, orderTime, status, employeeName));
		}
		
		rs.close();
		cmd.close();
		cn.cn.close();
		return List;
	}
}
