package Model_DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Model_BEAN.CategoryBEAN;

public class CategoryDAO {
	public ArrayList<CategoryBEAN> CategoryList() throws Exception{
		ArrayList<CategoryBEAN> List = new ArrayList<CategoryBEAN>();
		
		ConnectDB cn = new ConnectDB();
		cn.Connect();
		
		String sql = "SELECT * FROM Categories";
		
		PreparedStatement cmd = cn.cn.prepareStatement(sql);
		
		ResultSet rs = cmd.executeQuery();
		
		while(rs.next()) {
			long categoryID = rs.getLong("categoryID");
			String categoryName = rs.getString("categoryName");
			List.add(new CategoryBEAN(categoryID, categoryName));
		}
		
		return List;
	}
	
}
