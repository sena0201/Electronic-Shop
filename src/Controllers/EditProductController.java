package Controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model_BEAN.CategoryBEAN;
import Model_BEAN.EmployeeBEAN;
import Model_BO.CategoryBO;

/**
 * Servlet implementation class EditProductController
 */
@WebServlet("/EditProductController")
public class EditProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		EmployeeBEAN user = (EmployeeBEAN)session.getAttribute("user");
		
		try {
			if(user != null) {
				CategoryBO categoryBO = new CategoryBO();
				String productID = request.getParameter("productID");
				String productName = request.getParameter("productName");
				String quantity = request.getParameter("quantity");
				String unitPrice = request.getParameter("unitPrice");
				String unit = request.getParameter("unit");
				String categoryID = request.getParameter("categoryID");
				String photo = request.getParameter("photo");
				
				ArrayList<CategoryBEAN> ListOfCategories = categoryBO.ListOfCategories();
				request.setAttribute("productID", productID);
				request.setAttribute("productName", productName);
				request.setAttribute("quantity", quantity);
				request.setAttribute("unitPrice", unitPrice);
				request.setAttribute("unit", unit);
				request.setAttribute("categoryID", categoryID);
				request.setAttribute("photo", photo);
				request.setAttribute("ListOfCategories", ListOfCategories);
				request.getRequestDispatcher("EditProduct.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("LoginController").forward(request, response);
			}
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
