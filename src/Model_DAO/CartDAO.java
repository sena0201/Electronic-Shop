package Model_DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CartDAO {
	public long CreateCart(long customerID) throws Exception{
		long generatedId = 0;
		
		try {
			ConnectDB cn = new ConnectDB();
			cn.Connect();
			
			String sql = "INSERT INTO Carts(customerID) VALUES (?)";
			
			PreparedStatement cmd = cn.cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			cmd.setLong(1, customerID);
			
			int rowsAffected  = cmd.executeUpdate();
			System.out.println(rowsAffected);
	        if (rowsAffected  > 0) {
	        	ResultSet resultSet = cmd.getGeneratedKeys();
	            if (resultSet.next()) {
	                generatedId = resultSet.getLong(1);
	                cmd.close();
	                cn.cn.close();
	                return generatedId;
	            }
	        }
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
}
