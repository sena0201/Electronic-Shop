package Model_DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Model_BEAN.ProductBEAN;

public class ProductDAO {
	public ArrayList<ProductBEAN> ProductList() throws Exception{
		ArrayList<ProductBEAN> List = new ArrayList<ProductBEAN>();
		
		ConnectDB cn = new ConnectDB();
		cn.Connect();
		
		String sql = "SELECT * FROM Products";
		
		PreparedStatement cmd = cn.cn.prepareStatement(sql);
		
		ResultSet rs = cmd.executeQuery();
		
		while(rs.next()) {
			long productID = rs.getLong("productID");
			String productName = rs.getString("productName");
			long quantity = rs.getLong("quantity"); 
			long unitPrice = rs.getLong("unitPrice"); 
			String unit = rs.getString("unit"); 
			String photo = rs.getString("photo");
			long categoryID = rs.getLong("categoryID");
			List.add(new ProductBEAN(productID, productName, quantity, unitPrice, unit, photo, categoryID));
		}
		
		rs.close();
		cn.cn.close();
		
		return List;
	}
	
	public int TotalProduct() throws Exception{
		int total = 0;
		ConnectDB cn = new ConnectDB();
		cn.Connect();
		
		String sql = "SELECT COUNT(*) as Total FROM Products";
		
		PreparedStatement cmd = cn.cn.prepareStatement(sql);
		
		ResultSet rs = cmd.executeQuery();
		
		if(rs.next()) {
			total = rs.getInt("Total");
		}
		
		rs.close();
		cn.cn.close();
		
		return total;
	}
	
	public ArrayList<ProductBEAN> PagingProduct(int index, int pageSize) throws Exception{
		ArrayList<ProductBEAN> List = new ArrayList<ProductBEAN>();
		
		ConnectDB cn = new ConnectDB();
		cn.Connect();
		
		String sql = "select * from Products\r\n"
				+ "order by productID\r\n"
				+ "offset ? rows fetch next ? row only;";
		
		PreparedStatement cmd = cn.cn.prepareStatement(sql);
		
		cmd.setInt(1, (index - 1) * pageSize);
		cmd.setInt(2, pageSize);
		
		ResultSet rs = cmd.executeQuery();
		
		while(rs.next()) {
			long productID = rs.getLong("productID"); 
			String productName = rs.getString("productName"); 
			long quantity = rs.getLong("quantity");  
			long unitPrice = rs.getLong("unitPrice");  
			String unit = rs.getString("unit"); 
			String photo = rs.getString("photo"); 
			long categoryID = rs.getLong("categoryID"); 
			List.add(new ProductBEAN(productID,productName,quantity,unitPrice,unit,photo,categoryID));
		}
		
		rs.close();
		cn.cn.close();
		
		return List;
	}
	
	public ArrayList<ProductBEAN> ProductList(long categoryID,int index, int pageSize) throws Exception{
		ArrayList<ProductBEAN> List = new ArrayList<ProductBEAN>();
		
		ConnectDB cn = new ConnectDB();
		cn.Connect();
		
		String sql = "select * from Products\r\n"
				+ "where categoryID = ?\r\n"
				+ "order by productID\r\n"
				+ "offset ? rows fetch next ? row only";
		
		PreparedStatement cmd = cn.cn.prepareStatement(sql);
		
		cmd.setLong(1, categoryID);
		cmd.setInt(2, (index-1)*pageSize);
		cmd.setInt(3, pageSize);
		
		
		ResultSet rs = cmd.executeQuery();
		
		while(rs.next()) {
			long productID = rs.getLong("productID");
			String productName = rs.getString("productName");
			long quantity = rs.getLong("quantity"); 
			long unitPrice = rs.getLong("unitPrice"); 
			String unit = rs.getString("unit"); 
			String photo = rs.getString("photo");
			List.add(new ProductBEAN(productID, productName, quantity, unitPrice, unit, photo, categoryID));
		}
		
		rs.close();
		cn.cn.close();
		
		return List;
	}
	
	public ArrayList<ProductBEAN> ProductListASC(int page, int pageSize) throws Exception{
		ArrayList<ProductBEAN> List = new ArrayList<ProductBEAN>();
		
		ConnectDB cn = new ConnectDB();
		cn.Connect();
		
		String sql = "SELECT * FROM Products ORDER BY unitPrice ASC\r\n"
				+ "OFFSET ? ROWS FETCH NEXT ? ROW ONLY";
		
		PreparedStatement cmd = cn.cn.prepareStatement(sql);
		
		cmd.setInt(1, (page - 1)*pageSize);
		cmd.setInt(2, pageSize);
		
		ResultSet rs = cmd.executeQuery();
		
		while(rs.next()) {
			long productID = rs.getLong("productID");
			String productName = rs.getString("productName");
			long quantity = rs.getLong("quantity"); 
			long unitPrice = rs.getLong("unitPrice"); 
			String unit = rs.getString("unit"); 
			String photo = rs.getString("photo");
			long categoryID = rs.getLong("categoryID");
			List.add(new ProductBEAN(productID, productName, quantity, unitPrice, unit, photo, categoryID));
		}
		
		rs.close();
		cn.cn.close();
		
		return List;
	}
	public ArrayList<ProductBEAN> ProductListDESC(int page, int pageSize) throws Exception{
		ArrayList<ProductBEAN> List = new ArrayList<ProductBEAN>();
		
		ConnectDB cn = new ConnectDB();
		cn.Connect();
		
		String sql = "SELECT * FROM Products ORDER BY unitPrice DESC\r\n"
				+ "OFFSET ? ROWS FETCH NEXT ? ROW ONLY";
		
		PreparedStatement cmd = cn.cn.prepareStatement(sql);
		
		cmd.setInt(1, (page - 1)*pageSize);
		cmd.setInt(2, pageSize);
		
		ResultSet rs = cmd.executeQuery();
		
		while(rs.next()) {
			long productID = rs.getLong("productID");
			String productName = rs.getString("productName");
			long quantity = rs.getLong("quantity"); 
			long unitPrice = rs.getLong("unitPrice"); 
			String unit = rs.getString("unit"); 
			String photo = rs.getString("photo");
			long categoryID = rs.getLong("categoryID");
			List.add(new ProductBEAN(productID, productName, quantity, unitPrice, unit, photo, categoryID));
		}
		
		rs.close();
		cn.cn.close();
		
		return List;
	}
	
	public int AddProduct(String productName, long quantity, long unitPrice, String unit, long categoryID, String photo) throws Exception{
		ConnectDB cn = new ConnectDB();
		cn.Connect();
		String sql = "INSERT INTO Products(productName, quantity, unitPrice, unit, photo, categoryID) VALUES (?,?,?,?,?,?)";
		PreparedStatement cmd = cn.cn.prepareStatement(sql);
		cmd.setString(1, productName);
		cmd.setLong(2, quantity);
		cmd.setLong(3, unitPrice);
		cmd.setString(4, unit);
		cmd.setString(5, photo);
		cmd.setLong(6, categoryID);
		
		int rowAffected = 0;
		rowAffected = cmd.executeUpdate();
		
		cmd.close();
		cn.cn.close();
		return rowAffected;
	}
	
	public int Edit(long productID, String productName, long quantity, long unitPrice, String unit, String photo, long categoryID) throws Exception {
		ConnectDB cn = new ConnectDB();
		cn.Connect();
		String sql = "UPDATE Products SET productName = ?, quantity = ?, unitPrice = ?, unit = ?, photo = ?, categoryID = ? WHERE productID = ? ";
		PreparedStatement cmd = cn.cn.prepareStatement(sql);
		cmd.setString(1, productName);
		cmd.setLong(2, quantity);
		cmd.setLong(3, unitPrice);
		cmd.setString(4, unit);
		cmd.setString(5, photo);
		cmd.setLong(6, categoryID);
		cmd.setLong(7, productID);
		
		int rowAffected = 0;
		rowAffected = cmd.executeUpdate();
		
		cmd.close();
		cn.cn.close();
		return rowAffected;
	}
	
	public int Delete(long productID) throws Exception{
		ConnectDB cn = new ConnectDB();
		cn.Connect();
		String sql = "DELETE FROM Products WHERE productID = ?";
		PreparedStatement cmd = cn.cn.prepareStatement(sql);
		cmd.setLong(1, productID);
		
		int rowAffected = 0;
		rowAffected = cmd.executeUpdate();
		
		cmd.close();
		cn.cn.close();
		return rowAffected;
	}
}
