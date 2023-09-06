package Controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model_BEAN.AdWaitOrderBEAN;
import Model_BEAN.EmployeeBEAN;
import Model_BEAN.ProcessedBEAN;
import Model_BO.OrderBO;
import Model_BO.OrderDetailBO;

/**
 * Servlet implementation class AdOrderController
 */
@WebServlet("/AdOrderController")
public class AdOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdOrderController() {
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
				OrderBO orderBO = new OrderBO();
				OrderDetailBO orderDetailBO = new OrderDetailBO();
				ArrayList<AdWaitOrderBEAN> ListOfAdOrders = orderBO.ListOfAdOrders();
				ArrayList<ProcessedBEAN> ListOfProcesseds = null;
				String status = request.getParameter("status");
				if(status != null) {
					if(status.toUpperCase().equals("WAIT")) {
						ListOfAdOrders = orderBO.ListOfAdOrders(status.toUpperCase());
						session.setAttribute("user", (EmployeeBEAN)user);
						request.setAttribute("ListOfAdOrders", ListOfAdOrders);
						request.setAttribute("ListOfProcesseds", ListOfProcesseds);
						request.setAttribute("status", status);
						request.getRequestDispatcher("adorder.jsp").forward(request, response);	
					}else
					if(status.toUpperCase().equals("DONE")) {
						ListOfAdOrders = null;
						ListOfProcesseds = orderDetailBO.ListOfProcesseds(status.toUpperCase());
						session.setAttribute("user", (EmployeeBEAN)user);
						request.setAttribute("ListOfAdOrders", ListOfAdOrders);
						request.setAttribute("ListOfProcesseds", ListOfProcesseds);
						request.setAttribute("status", status);
						request.getRequestDispatcher("adorder.jsp").forward(request, response);	
					}else
					if(status.toUpperCase().equals("CANCEL")) {
						ListOfAdOrders = null;
						ListOfProcesseds = orderDetailBO.ListOfProcesseds(status.toUpperCase());
						session.setAttribute("user", (EmployeeBEAN)user);
						request.setAttribute("ListOfAdOrders", ListOfAdOrders);
						request.setAttribute("ListOfProcesseds", ListOfProcesseds);
						request.setAttribute("status", status);
						request.getRequestDispatcher("adorder.jsp").forward(request, response);	
					}
				}else {
					session.setAttribute("user", (EmployeeBEAN)user);
					request.setAttribute("ListOfAdOrders", ListOfAdOrders);
					request.setAttribute("ListOfProcesseds", ListOfProcesseds);
					request.setAttribute("status", status);
					request.getRequestDispatcher("adorder.jsp").forward(request, response);		
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
