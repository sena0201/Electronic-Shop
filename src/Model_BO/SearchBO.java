package Model_BO;

import java.util.ArrayList;

import Model_BEAN.SearchBEAN;
import Model_DAO.SearchDAO;

public class SearchBO {
	SearchDAO searchDAO = new SearchDAO();
	public ArrayList<SearchBEAN> SearchList(String searchValue, int page, int pageSize) throws Exception{
		return searchDAO.SearchList(searchValue, page, pageSize);
	}
}
