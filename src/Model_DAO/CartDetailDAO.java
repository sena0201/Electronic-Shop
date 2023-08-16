package Model_DAO;

import java.sql.PreparedStatement;

public class CartDetailDAO {
	public void AddToCartDetail(long cartID, long productID,long quantity, long salePrice) throws Exception{
		ConnectDB cn = new ConnectDB();
		cn.Connect();
		
		String sql = "INSERT INTO CartDetails VALUES (?,?,?,?)";
		
		PreparedStatement cmd = cn.cn.prepareStatement(sql);
		cmd.setLong(1, cartID);
		cmd.setLong(2, productID);
		cmd.setLong(3, quantity);
		cmd.setLong(4, salePrice);
		
		int rowsInserted = cmd.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Dữ liệu đã được thêm thành công vào cơ sở dữ liệu.");
        }
        cmd.close();
		
		cmd.close();
		cn.cn.close();
	}
}
