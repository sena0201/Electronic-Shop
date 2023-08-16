package Model_BO;

import java.util.ArrayList;

import Model_BEAN.CategoryBEAN;
import Model_DAO.CategoryDAO;

public class CategoryBO {
	CategoryDAO categoryDAO = new CategoryDAO();
	public ArrayList<CategoryBEAN> ListOfCategories() throws Exception{
		return categoryDAO.CategoryList();
	}
}
