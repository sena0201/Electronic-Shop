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
import Model_BO.EmployeeBO;

/**
 * Servlet implementation class AdEmployeeController
 */
@WebServlet("/AdEmployeeController")
public class AdEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdEmployeeController() {
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
		HttpSession session = request.getSession();
		EmployeeBEAN user = (EmployeeBEAN)session.getAttribute("user");
		try {
			if(user != null) {
				EmployeeBO employeeBO = new EmployeeBO();
				ArrayList<EmployeeBEAN> ListOfEmployees = employeeBO.ListOfEmployees();
				request.setAttribute("ListOfEmployees", ListOfEmployees);
				request.getRequestDispatcher("ademployee.jsp").forward(request, response);
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
