package Controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model_BEAN.AdOrderDetailBEAN;
import Model_BEAN.EmployeeBEAN;
import Model_BO.OrderDetailBO;

/**
 * Servlet implementation class AdOrderDetailController
 */
@WebServlet("/AdOrderDetailController")
public class AdOrderDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdOrderDetailController() {
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
		
		if(user != null) {
			try {
				String orderID = request.getParameter("orderID");
				if(orderID != null) {
					OrderDetailBO orderDetailBO = new OrderDetailBO();
					ArrayList<AdOrderDetailBEAN> ListOfOrderDetails = orderDetailBO.ListOfOrderDetails(Long.parseLong(orderID));
					request.setAttribute("ListOfOrderDetails", ListOfOrderDetails);
					request.setAttribute("orderID", orderID);
					request.getRequestDispatcher("AdOrderDetail.jsp").forward(request, response);
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
