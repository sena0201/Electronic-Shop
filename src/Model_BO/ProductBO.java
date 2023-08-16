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
}
