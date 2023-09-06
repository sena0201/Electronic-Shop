package Model_DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import Model_BEAN.PurchaseBEAN;

public class PurchaseDAO {
	public ArrayList<PurchaseBEAN> ListOfPurchaseds(long customerID) throws Exception{
		ArrayList<PurchaseBEAN> List = new ArrayList<PurchaseBEAN>();
		
		ConnectDB cn = new ConnectDB();
		cn.Connect();
		
		String sql = "SELECT Orders.orderID AS orderID, customerID, employeeID,orderTime, description, status, orderDetailID, OrderDetails.productID AS productID,OrderDetails.quantity AS quantity, salePrice, productName, unitPrice, photo\r\n"
				+ "FROM Orders JOIN OrderDetails ON Orders.orderID = OrderDetails.orderID JOIN Products ON OrderDetails.productID = Products.productID\r\n"
				+ "WHERE customerID = ?";
		PreparedStatement cmd = cn.cn.prepareStatement(sql);
		cmd.setLong(1, customerID);
		
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			long orderID = rs.getLong("orderID"); 
			long employeeID = rs.getLong("employeeID"); 
			Date orderTime = rs.getDate("orderTime"); 
			String description = rs.getString("description");
			String status = rs.getString("status"); 
			long orderDetailID = rs.getLong("orderDetailID"); 
			long productID = rs.getLong("productID"); 
			long quantity = rs.getLong("quantity"); 
			long salePrice = rs.getLong("salePrice");
			String productName = rs.getString("productName");
			long unitPrice = rs.getLong("unitPrice");
			String photo = rs.getString("photo");
			List.add(new PurchaseBEAN(orderID, customerID, employeeID, orderTime, description, status, orderDetailID, productID, quantity, salePrice, productName, unitPrice, photo));
		}
		
		rs.close();
		cmd.close();
		cn.cn.close();
		return List;
	}
	public ArrayList<PurchaseBEAN> ListOfPurchaseds(long customerID, String status) throws Exception{
		ArrayList<PurchaseBEAN> List = new ArrayList<PurchaseBEAN>();
		
		ConnectDB cn = new ConnectDB();
		cn.Connect();
		
		String sql = "SELECT Orders.orderID AS orderID, customerID, employeeID,orderTime, description, status, orderDetailID, OrderDetails.productID AS productID,OrderDetails.quantity AS quantity, salePrice, productName, unitPrice, photo\r\n"
				+ "FROM Orders JOIN OrderDetails ON Orders.orderID = OrderDetails.orderID JOIN Products ON OrderDetails.productID = Products.productID\r\n"
				+ "WHERE customerID = ? AND status = ?";
		PreparedStatement cmd = cn.cn.prepareStatement(sql);
		cmd.setLong(1, customerID);
		cmd.setString(2, status);
		
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			long orderID = rs.getLong("orderID"); 
			long employeeID = rs.getLong("employeeID"); 
			Date orderTime = rs.getDate("orderTime"); 
			String description = rs.getString("description");
			long orderDetailID = rs.getLong("orderDetailID"); 
			long productID = rs.getLong("productID"); 
			long quantity = rs.getLong("quantity"); 
			long salePrice = rs.getLong("salePrice");
			String productName = rs.getString("productName");
			long unitPrice = rs.getLong("unitPrice");
			String photo = rs.getString("photo");
			List.add(new PurchaseBEAN(orderID, customerID, employeeID, orderTime, description, status, orderDetailID, productID, quantity, salePrice, productName, unitPrice, photo));
		}
		
		rs.close();
		cmd.close();
		cn.cn.close();
		return List;
	}
}
