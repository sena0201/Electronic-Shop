package Controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model_BO.CustomerBO;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
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
		
		String customerName = request.getParameter("customerName");
		String address = request.getParameter("address");
		String phoneNumber = request.getParameter("phoneNumber");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String repeatPassword = request.getParameter("repeatPassword");
		
		CustomerBO customerBO = new CustomerBO();
		
		try {
			if(customerName != null && address != null && phoneNumber != null && userName != null && password != null && repeatPassword != null) {
				if(password.equals(repeatPassword)) {
					long check = customerBO.CustomerRegister(customerName, address, phoneNumber, userName, password);
					if(check > 0) {
						request.setAttribute("warning", "Sign Up Success");
						request.getRequestDispatcher("Login.jsp").forward(request, response);
					} else {
						request.setAttribute("warning", "Sign Up Failed");
						request.getRequestDispatcher("Register.jsp").forward(request, response);
					}
				} else {
					request.setAttribute("warning", "Sign Up Failed");
					request.getRequestDispatcher("Register.jsp").forward(request, response);
				}
			} else {
				request.getRequestDispatcher("Register.jsp").forward(request, response);
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
