package Controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model_BEAN.CustomerBEAN;
import Model_BO.CartBO;
import Model_BO.CustomerBO;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			CustomerBO customerBO = new CustomerBO();
			CartBO cartBO = new CartBO();
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			
			HttpSession session = request.getSession();
			
			if(userName != null && password != null) {
				CustomerBEAN customer = customerBO.CustomerLogin(userName, password);
				if(customer == null) {
					request.setAttribute("warning", "Login Failed!");
					request.getRequestDispatcher("Login.jsp").forward(request, response);
				}
				else {
					session.setAttribute("user", (CustomerBEAN)customer);
					session.setAttribute("count", cartBO.CountCartDetail(customer.getCustomerID()));
					request.getRequestDispatcher("HomeController").forward(request, response);
				}
			}
			if(userName == null || password == null) {
				request.getRequestDispatcher("Login.jsp").forward(request, response);
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
