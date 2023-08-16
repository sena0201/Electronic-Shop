package Model_DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Model_BEAN.SearchBEAN;

public class SearchDAO {
	public ArrayList<SearchBEAN> SearchList(String searchValue, int page, int pageSize) throws Exception{
		ArrayList<SearchBEAN> List = new ArrayList<SearchBEAN>();
		
		ConnectDB cn = new ConnectDB();
		cn.Connect();
		
		String sql = "select * from Products join Categories on Products.categoryID = Categories.categoryID\r\n"
				+ "where productName like ? or categoryName like ?\r\n"
				+ "order by productID\r\n"
				+ "offset ? rows fetch next ? row only;";
		
		PreparedStatement cmd = cn.cn.prepareStatement(sql);
		cmd.setString(1, "%"+searchValue+"%");
		cmd.setString(2, "%"+searchValue+"%");
		cmd.setInt(3, (page-1)*pageSize);
		cmd.setInt(4, pageSize);
		
		ResultSet rs = cmd.executeQuery();
		
		while(rs.next()) {
			long productID = rs.getLong("productID");
			String productName = rs.getString("productName");
			long quantity = rs.getLong("quantity"); 
			long unitPrice = rs.getLong("unitPrice"); 
			String unit = rs.getString("unit"); 
			String photo = rs.getString("photo");
			String categoryName = rs.getString("categoryName");
			List.add(new SearchBEAN(productID, productName, quantity, unitPrice, unit, photo, categoryName));
		}
		return List;
	}
}
