package Controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model_BEAN.CustomerBEAN;
import Model_BEAN.OrderBEAN;
import Model_BEAN.PurchaseBEAN;
import Model_BO.CartBO;
import Model_BO.OrderBO;
import Model_BO.PurchaseBO;

/**
 * Servlet implementation class PurchaseController
 */
@WebServlet("/PurchaseController")
public class PurchaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PurchaseController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			HttpSession session = request.getSession();
			CustomerBEAN user = (CustomerBEAN)session.getAttribute("user");
			CartBO cartBO = new CartBO();
			OrderBO orderBO = new OrderBO();
			PurchaseBO purchaseBO = new PurchaseBO();
			
			if(user != null) {
				ArrayList<OrderBEAN> ListOfOrders = orderBO.ListOfOrders(user.getCustomerID());
				ArrayList<PurchaseBEAN> ListOfPurchaseds = purchaseBO.ListOfPurchaseds(user.getCustomerID());
				
				String status = request.getParameter("status");
				
				if(status != null) {
					ListOfOrders = orderBO.ListOfOrders(user.getCustomerID(), status.toUpperCase());
					ListOfPurchaseds = purchaseBO.ListOfPurchaseds(user.getCustomerID(), status.toUpperCase());
				}
				
				session.setAttribute("count", (int)cartBO.CountCartDetail(user.getCustomerID()));
				request.setAttribute("status", status);
				request.setAttribute("ListOfOrders", ListOfOrders);
				request.setAttribute("ListOfPurchaseds", ListOfPurchaseds);
				request.getRequestDispatcher("purchase.jsp").forward(request, response);
			}else {
				session.setAttribute("count", (int)0);
				request.setAttribute("warning", "Please login!");
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
