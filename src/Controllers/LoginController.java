package Controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model_BEAN.CustomerBEAN;
import Model_BEAN.EmployeeBEAN;
import Model_BO.CartBO;
import Model_BO.CustomerBO;
import Model_BO.EmployeeBO;

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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		try {
			CustomerBO customerBO = new CustomerBO();
			EmployeeBO employeeBO = new EmployeeBO();
			CartBO cartBO = new CartBO();
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			
			HttpSession session = request.getSession();
			
			if(userName != null && password != null) {
				CustomerBEAN customer = customerBO.CustomerLogin(userName, password);
				EmployeeBEAN employee = employeeBO.Employee(userName, password);
				if(customer == null && employee == null) {
					request.setAttribute("warning", "Login Failed!");
					request.getRequestDispatcher("Login.jsp").forward(request, response);
				}
				else
					if(customer != null) {
						session.setAttribute("user", (CustomerBEAN)customer);
						session.setAttribute("count", (int)cartBO.CountCartDetail(customer.getCustomerID()));
						request.getRequestDispatcher("ShopController").forward(request, response);
					}
					else if(employee != null) {
						session.setAttribute("user", (EmployeeBEAN)employee);
						request.getRequestDispatcher("AdminController").forward(request, response);
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
