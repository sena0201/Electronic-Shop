package Model_BO;

import java.util.ArrayList;

import Model_BEAN.ProductBEAN;
import Model_DAO.ProductDAO;

public class ProductBO {
	ProductDAO productDAO = new ProductDAO();
	public ArrayList<ProductBEAN> ListOfProducts() throws Exception{
		return productDAO.ProductList();
	}
	
	public int TotalProduct() throws Exception{
		return productDAO.TotalProduct();
	}
	
	public ArrayList<ProductBEAN> PagingProduct(int index, int pageSize) throws Exception{
		return productDAO.PagingProduct(index,pageSize);
	}
	
	public ArrayList<ProductBEAN> ListOfProducts(long categoryID, int index, int pageSize) throws Exception{
		return productDAO.ProductList(categoryID,index,pageSize);
	}
	public ArrayList<ProductBEAN> ListOfProductsASC(int page, int pageSize) throws Exception{
		return productDAO.ProductListASC(page, pageSize);
	}
	public ArrayList<ProductBEAN> ListOfProductsDESC(int page, int pageSize) throws Exception{
		return productDAO.ProductListDESC(page, pageSize);
	}
	
	public int AddProduct(String productName, long quantity, long unitPrice, String unit, long categoryID, String photo) throws Exception{
		return productDAO.AddProduct(productName, quantity, unitPrice, unit, categoryID, photo);
	}
	public int Edit(long productID, String productName, long quantity, long unitPrice, String unit, String photo, long categoryID) throws Exception{
		return productDAO.Edit(productID, productName, quantity, unitPrice, unit, photo, categoryID);
	}
	public int Delete(long productID) throws Exception{
		return productDAO.Delete(productID);
	}
}
