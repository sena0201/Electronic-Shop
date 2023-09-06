package Controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model_BEAN.EmployeeBEAN;
import Model_BO.EmployeeBO;

/**
 * Servlet implementation class AdDeleteEmployeeController
 */
@WebServlet("/AdDeleteEmployeeController")
public class AdDeleteEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdDeleteEmployeeController() {
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
		EmployeeBO employeeBO = new EmployeeBO();
		try {
			HttpSession session = request.getSession();
			EmployeeBEAN user = (EmployeeBEAN)session.getAttribute("user");
			
			if(user != null) {
				String employeeID = request.getParameter("employeeID");
				if(employeeID != null) {
					employeeBO.Delete(Long.parseLong(employeeID));
					request.getRequestDispatcher("AdEmployeeController").forward(request, response);
				}
				else {
					request.getRequestDispatcher("AdEmployeeController").forward(request, response);
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
