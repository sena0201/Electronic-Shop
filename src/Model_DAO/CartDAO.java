package Model_DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Model_BEAN.NowCartBEAN;

public class CartDAO {
	public long CreateCart(long customerID) throws Exception{
		long generatedId = 0;
		
		try {
			ConnectDB cn = new ConnectDB();
			cn.Connect();
			
			String sql = "DECLARE @cartID int\r\n"
					+ "SELECT @cartID = cartID FROM Carts WHERE customerID = ?\r\n"
					+ "IF(@cartID IS NULL)\r\n"
					+ "BEGIN\r\n"
					+ "		INSERT INTO Carts(customerID)\r\n"
					+ "    	VALUES(?);SELECT SCOPE_IDENTITY() as cartID;"
					+ "END\r\n"
					+ "ELSE\r\n"
					+ "BEGIN\r\n"
					+ "	SELECT @cartID as cartID\r\n"
					+ "END";
			
			PreparedStatement cmd = cn.cn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			cmd.setLong(1, customerID);
			cmd.setLong(2, customerID);
			
			ResultSet rs = cmd.executeQuery();
			if(rs.next()) {
				generatedId = rs.getLong("cartID");
			}
			cmd.close();
			cn.cn.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return generatedId;
	}
	
	public int CountCartDetail(long customerID) throws Exception{
		ConnectDB cn = new ConnectDB();
		cn.Connect();
		
		String sql = "SELECT COUNT(*) AS Total FROM Carts JOIN CartDetails ON Carts.cartID = CartDetails.cartID WHERE customerID = ?";
		
		PreparedStatement cmd = cn.cn.prepareStatement(sql);
		cmd.setLong(1, customerID);
		
		int total = 0;
		ResultSet rs = cmd.executeQuery();
		if(rs.next()) {
			total = rs.getInt("Total");
		}
		return total;
	}
	
	public ArrayList<NowCartBEAN> ListOfCarts(long customerID) throws Exception{
		ArrayList<NowCartBEAN> List = new ArrayList<NowCartBEAN>();
		
		ConnectDB cn = new ConnectDB();
		cn.Connect();
		
		String sql="SELECT * FROM Carts JOIN CartDetails ON Carts.cartID = CartDetails.cartID JOIN Products on CartDetails.productID=Products.productID WHERE customerID = ? ORDER BY cartDetailID DESC";
		
		PreparedStatement cmd = cn.cn.prepareStatement(sql);
		cmd.setLong(1, customerID);
		
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			long cartID = rs.getLong("cartID");  
			long cartDetailID = rs.getLong("cartDetailID");  
			long productID = rs.getLong("productID");  
			long quantity = rs.getLong("quantity");  
			long salePrice = rs.getLong("salePrice");
			String productName = rs.getString("productName");
			String productPhoto = rs.getString("photo");
			long unitPrice = rs.getLong("unitPrice");
			List.add(new NowCartBEAN(cartID, customerID, cartDetailID, productID, quantity, salePrice,productName,productPhoto,unitPrice));
		}
		
		rs.close();
		cmd.close();
		cn.cn.close();
		return List;
	}
	public int DeleteFromCart(long cartID, long productID) throws Exception{
		int rowAffected = 0;
		
		ConnectDB cn = new ConnectDB();
		cn.Connect();
		
		String sql = "delete from CartDetails where cartID = ? and productID = ?";
		PreparedStatement cmd = cn.cn.prepareStatement(sql);
		
		cmd.setLong(1, cartID);
		cmd.setLong(2, productID);
		
		rowAffected = cmd.executeUpdate();
		
		return rowAffected;
	}
	
	public long GetCartID(long customerID) throws Exception{
		long cartID = 0;
		ConnectDB cn = new ConnectDB();
		cn.Connect();
		
		String sql ="SELECT * FROM Carts WHERE customerID = ?";
		PreparedStatement cmd = cn.cn.prepareStatement(sql);
		cmd.setLong(1, customerID);
		
		ResultSet rs = cmd.executeQuery();
		if(rs.next()) {
			cartID = rs.getLong("cartID");
		}
		
		return cartID;
	}
}
