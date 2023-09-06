package Controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model_BEAN.CategoryBEAN;
import Model_BEAN.ProductBEAN;
import Model_BEAN.SearchBEAN;
import Model_BO.CategoryBO;
import Model_BO.ProductBO;
import Model_BO.SearchBO;

/**
 * Servlet implementation class ShopController
 */
@WebServlet("/ShopController")
public class ShopController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			CategoryBO categoryBO = new CategoryBO();
			ProductBO productBO = new ProductBO();
			SearchBO searchBO = new SearchBO();
						
			ArrayList<CategoryBEAN> ListOfCategories = new ArrayList<CategoryBEAN>();
			ArrayList<ProductBEAN> ListOfProducts = new ArrayList<ProductBEAN>();
			ArrayList<SearchBEAN> SearchProducts = new ArrayList<SearchBEAN>();
			
			
			int pageSize = 6;
			
			String page = request.getParameter("page");
			String categoryID = request.getParameter("categoryID");
			String searchValue = request.getParameter("searchValue");
			String filter = request.getParameter("filter");
			
			ListOfProducts = productBO.ListOfProducts();	
			int endPage = ListOfProducts.size()/pageSize;
			if(ListOfProducts.size()%pageSize != 0) {
				endPage = endPage + 1;
			}		

			if(searchValue != null && page == null) {
				SearchProducts = searchBO.SearchList(searchValue, 1, pageSize);
				endPage = SearchProducts.size()/pageSize;
				if(SearchProducts.size()%pageSize != 0) {
					endPage = endPage + 1;
				}
			} else if(searchValue != null && page != null) {
				SearchProducts = searchBO.SearchList(searchValue, Integer.parseInt(page), pageSize);
				endPage = SearchProducts.size()/pageSize;
				if(SearchProducts.size()%pageSize != 0) {
					endPage = endPage + 1;
				}
			}
			
			if(categoryID != null && page != null) {
				ListOfProducts = productBO.ListOfProducts(Long.parseLong(categoryID), Integer.parseInt(page), pageSize);
				endPage = ListOfProducts.size()/pageSize;
				if(ListOfProducts.size()%pageSize != 0) {
					endPage = endPage + 1;
				}
			} else if(categoryID != null) {
				ListOfProducts = productBO.ListOfProducts(Long.parseLong(categoryID), 1, pageSize);
				endPage = ListOfProducts.size()/pageSize;
				if(ListOfProducts.size()%pageSize != 0) {
					endPage = endPage + 1;
				}
			} else if(page == null) {
				ListOfProducts = productBO.PagingProduct(1, pageSize);
			} else {
				ListOfProducts = productBO.PagingProduct(Integer.parseInt(page),pageSize);
			}
			
			if(filter != null && page != null) {
				if(filter.equals("ascending")) {
					ListOfProducts = productBO.ListOfProductsASC(Integer.parseInt(page),pageSize);
				}
				else if(filter.equals("decrease")) {
					ListOfProducts = productBO.ListOfProductsDESC(Integer.parseInt(page),pageSize);
					}
			} else if(filter != null){
				if(filter.equals("ascending")) {
					ListOfProducts = productBO.ListOfProductsASC(1 ,pageSize);
				}
				else if(filter.equals("decrease")) {
					ListOfProducts = productBO.ListOfProductsDESC(1 ,pageSize);
					}
			}

			ListOfCategories = categoryBO.ListOfCategories();
			request.setAttribute("filter", filter);
			request.setAttribute("searchValue", searchValue);
			request.setAttribute("SearchProducts", SearchProducts);
			request.setAttribute("categoryID", categoryID);
			request.setAttribute("page", page);
			request.setAttribute("endP", endPage);
			request.setAttribute("ListOfProducts", ListOfProducts);
			request.setAttribute("ListOfCategories", ListOfCategories);
			RequestDispatcher rd = request.getRequestDispatcher("shop.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
