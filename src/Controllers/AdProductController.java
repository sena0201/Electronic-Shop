package Controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model_BEAN.EmployeeBEAN;
import Model_BEAN.ProductBEAN;
import Model_BO.ProductBO;

/**
 * Servlet implementation class AdProductController
 */
@WebServlet("/AdProductController")
public class AdProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		EmployeeBEAN user = (EmployeeBEAN)session.getAttribute("user");
		if(user != null) {
			ProductBO productBO = new ProductBO();
			try {
	
				ArrayList<ProductBEAN> ListOfProducts = productBO.ListOfProducts();
				request.setAttribute("ListOfProducts", ListOfProducts);
				request.setAttribute("user", user);
				request.getRequestDispatcher("adproduct.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		else {
			request.getRequestDispatcher("LoginController").forward(request, response);
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
