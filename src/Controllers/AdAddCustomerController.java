package Controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model_BEAN.EmployeeBEAN;
import Model_BO.CustomerBO;

/**
 * Servlet implementation class AdAddCustomerController
 */
@WebServlet("/AdAddCustomerController")
public class AdAddCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdAddCustomerController() {
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
		CustomerBO customerBO = new CustomerBO();
		
		try {
			HttpSession session = request.getSession();
			EmployeeBEAN user = (EmployeeBEAN)session.getAttribute("user");
			
			if(user != null) {
				if(customerName != null && address != null && phoneNumber != null && userName != null && password != null ) {
					long check = customerBO.CustomerRegister(customerName, address, phoneNumber, userName, password);
					if(check > 0) {
						request.setAttribute("warning", "Success!");
						request.getRequestDispatcher("AdCustomerController").forward(request, response);
					}
					else {
						request.setAttribute("warning", "Failed!");
						request.getRequestDispatcher("AddCustomer.jsp").forward(request, response);
					}
				} else
				if(customerName != null && address == null && phoneNumber == null && userName != null && password != null){
					long check = customerBO.CustomerRegister(customerName, "", "", userName, password);
					if(check > 0) {
						request.setAttribute("warning", "Success!");
						request.getRequestDispatcher("AdCustomerController").forward(request, response);
					}
					else {
						request.setAttribute("warning", "Failed!");
						request.getRequestDispatcher("AddCustomer.jsp").forward(request, response);
					}
				} else if(customerName == null && address == null && phoneNumber == null && userName == null && password == null){
					request.getRequestDispatcher("AddCustomer.jsp").forward(request, response);				
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
