package Controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model_BEAN.EmployeeBEAN;
import Model_BO.ProductBO;

/**
 * Servlet implementation class AdDeleteProductController
 */
@WebServlet("/AdDeleteProductController")
public class AdDeleteProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdDeleteProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProductBO productBO = new ProductBO();
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			HttpSession session = request.getSession();
			EmployeeBEAN user = (EmployeeBEAN)session.getAttribute("user");
			
			if(user != null) {
				String productID = request.getParameter("productID");
				System.out.println(productID);
				if(productID != null) {
					productBO.Delete(Long.parseLong(productID));
					request.getRequestDispatcher("AdProductController").forward(request, response);
				}
				else {
					request.getRequestDispatcher("AdProductController").forward(request, response);
				}
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
