package Controllers;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model_BEAN.CustomerBEAN;
import Model_BO.CartBO;
import Model_BO.OrderBO;
import Model_BO.OrderDetailBO;

/**
 * Servlet implementation class PayController
 */
@WebServlet("/PayController")
public class PayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		CustomerBEAN user = (CustomerBEAN)session.getAttribute("user");
		CartBO cartBO = new CartBO();
		OrderBO orderBO = new OrderBO();
		OrderDetailBO orderDetailBO = new OrderDetailBO();
		
		try {
			if(user != null){
				long millis = System.currentTimeMillis();
				java.sql.Date orderTime = new java.sql.Date(millis);
				
				
				Enumeration<String> d= request.getParameterNames();
				
				int check = 0;
				long orderID = 0;
				if(d.hasMoreElements()) {
					orderID = orderBO.CreateOrder(user.getCustomerID(), orderTime, "", "WAIT");
				}
				while(d.hasMoreElements()){
					String ms = d.nextElement();
					String gt = request.getParameter(ms);
					String quantity = request.getParameter("quantity"+gt);
					String salePrice = request.getParameter("salePrice"+gt);
					if(ms.equals("checked"+gt)) {
						if(gt != null && gt.length() > 0 && quantity != null && salePrice != null){
							check = orderDetailBO.AddOrderDetail(orderID, Long.parseLong(gt), Long.parseLong(quantity), Long.parseLong(salePrice));
							long cartID = cartBO.GetCartID(user.getCustomerID());
							cartBO.DeleteFromCart(cartID, Long.parseLong(gt));
						}
					}
				}
				if(check > 0) {
					request.setAttribute("warning", "Success!");
					request.getRequestDispatcher("CartController").forward(request, response);
				}else {
					request.setAttribute("warning", "Failed!");
					request.getRequestDispatcher("CartController").forward(request, response);
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
