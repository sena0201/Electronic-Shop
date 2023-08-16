package Controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model_BEAN.ProductBEAN;
import Model_BO.ProductBO;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String productID = request.getParameter("productid");
			if(productID != null) {
				ProductBO productBO = new ProductBO();
				ArrayList<ProductBEAN> ListOfProducts = productBO.ListOfProducts();
				for(ProductBEAN product:ListOfProducts) {
					if(Long.parseLong(productID) == product.getProductID()) {
						request.setAttribute("product", product);
						RequestDispatcher rd = request.getRequestDispatcher("product.jsp");
						rd.forward(request, response);
					}
				}
			}
			else response.sendRedirect("ShopController");
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
