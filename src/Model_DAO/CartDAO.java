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
}
