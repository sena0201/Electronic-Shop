package Model_DAO;

import java.sql.PreparedStatement;

public class CartDetailDAO {
	public int AddToCartDetail(long cartID, long productID,long quantity, long salePrice) throws Exception{
		int generatedId = 0;
		ConnectDB cn = new ConnectDB();
		cn.Connect();
		
		String sql = "DECLARE @cartDetailID int;\r\n"
				+ "SELECT @cartDetailID = cartDetailID FROM CartDetails WHERE cartID = ? AND productID = ?;\r\n"
				+ "IF(@cartDetailID IS NULL)\r\n"
				+ "BEGIN\r\n"
				+ "	INSERT INTO CartDetails(cartID, productID, Quantity, SalePrice)\r\n"
				+ "    VALUES(?, ?, ?, ?);\r\n"
				+ "END\r\n"
				+ "ELSE\r\n"
				+ "BEGIN\r\n"
				+ "    UPDATE CartDetails SET quantity = quantity + ?, salePrice =salePrice + ?\r\n"
				+ "    WHERE cartDetailID = @cartDetailID;\r\n"
				+ "END";
		PreparedStatement cmd = cn.cn.prepareStatement(sql);
		cmd.setLong(1, cartID);
		cmd.setLong(2, productID);
		cmd.setLong(3, cartID);
		cmd.setLong(4, productID);
		cmd.setLong(5, quantity);
		cmd.setLong(6, salePrice);
		cmd.setLong(7, quantity);
		cmd.setLong(8, salePrice);
		int rowAffected = cmd.executeUpdate();
		
		if(rowAffected > 0) {
			generatedId = rowAffected;
		}
		cmd.close();
		cn.cn.close();
		return generatedId;
	}
}
