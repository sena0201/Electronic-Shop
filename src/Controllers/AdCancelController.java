package Controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model_BEAN.EmployeeBEAN;
import Model_BO.OrderBO;

/**
 * Servlet implementation class AdCancelController
 */
@WebServlet("/AdCancelController")
public class AdCancelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdCancelController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String orderID = request.getParameter("orderID");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		EmployeeBEAN user = (EmployeeBEAN)session.getAttribute("user");
		
		if(user != null) {
			try {
				if(orderID != null) {
					OrderBO orderBO = new OrderBO();
					int check = orderBO.Processing(Long.parseLong(orderID), user.getEmployeeID(), "CANCEL");
					if(check > 0) {
						request.setAttribute("warning", "Completed!");
						request.getRequestDispatcher("AdOrderController").forward(request, response);
					}
					else {
						request.setAttribute("warning", "Failed!");
						request.getRequestDispatcher("AdOrderController").forward(request, response);
					}
				}
				else {
					request.getRequestDispatcher("AdOrderController").forward(request, response);
				}
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
