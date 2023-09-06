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
import Model_BO.CustomerBO;

/**
 * Servlet implementation class AdEditCustomerController
 */
@WebServlet("/AdEditCustomerController")
public class AdEditCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdEditCustomerController() {
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
		CustomerBO customerBO = new CustomerBO();
		String customerName = request.getParameter("customerName");
		String address = request.getParameter("address");
		String phoneNumber = request.getParameter("phoneNumber");
		String password = request.getParameter("password");
		String customerID = request.getParameter("customerID");
		
		try {
			HttpSession session = request.getSession();
			EmployeeBEAN user = (EmployeeBEAN)session.getAttribute("user");
			
			if(user != null) {
				if(customerName != null && address != null && phoneNumber != null && password != null && customerID != null) {
					int check = customerBO.EditCustomer(Long.parseLong(customerID), customerName, address, phoneNumber, password);
					System.out.print(check);
					if(check > 0) {
						request.setAttribute("warning", "Success!");
						request.getRequestDispatcher("AdCustomerController").forward(request, response);
					}
					else {
						CustomerBEAN customer = customerBO.Customer(Long.parseLong(customerID));
						request.setAttribute("customer", customer);
						request.setAttribute("warning", "Failed!");
						request.getRequestDispatcher("EditCustomer.jsp").forward(request, response);
					}
				}
				else
				if(customerID != null) {
					CustomerBEAN customer = customerBO.Customer(Long.parseLong(customerID));
					request.setAttribute("customer", customer);
					request.getRequestDispatcher("EditCustomer.jsp").forward(request, response);
				}else {
					request.getRequestDispatcher("AdCustomerController").forward(request, response);
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
