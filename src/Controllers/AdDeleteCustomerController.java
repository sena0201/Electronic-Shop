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
 * Servlet implementation class AdDeleteCustomerController
 */
@WebServlet("/AdDeleteCustomerController")
public class AdDeleteCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdDeleteCustomerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CustomerBO customerBO = new CustomerBO();
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			HttpSession session = request.getSession();
			EmployeeBEAN user = (EmployeeBEAN)session.getAttribute("user");
			
			if(user != null) {
				String customerID = request.getParameter("customerID");
				if(customerID != null) {
					customerBO.DeleteCustomer(Long.parseLong(customerID));
					request.getRequestDispatcher("AdCustomerController").forward(request, response);
				}
				else {
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
