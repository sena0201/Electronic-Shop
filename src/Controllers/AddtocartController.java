package Controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model_BEAN.CustomerBEAN;
import Model_BO.CartBO;
import Model_BO.CartDetailBO;

/**
 * Servlet implementation class AddtocartController
 */
@WebServlet("/AddtocartController")
public class AddtocartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddtocartController() {
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
			String productID = request.getParameter("productID");
			String quantity = request.getParameter("quantity");
			String unitPrice = request.getParameter("unitPrice");
			
			CartBO cartBO = new CartBO();
			CartDetailBO cartDetailBO = new CartDetailBO();
				
			if(user != null) {
				long cartID = cartBO.CreateCart(user.getCustomerID());
				if(productID != null && quantity != null && unitPrice != null) {
					if(cartID != 0) {
						cartDetailBO.AddToCartDetail(cartID, Long.parseLong(productID), Long.parseLong(quantity), Long.parseLong(unitPrice)*Long.parseLong(quantity));
						request.setAttribute("warning", "Success!");
						session.setAttribute("count", cartBO.CountCartDetail(user.getCustomerID()));
						request.getRequestDispatcher("ProductController?productid="+productID).forward(request, response);
					}
					else {
						request.setAttribute("warning", "Failed!");
						request.getRequestDispatcher("ProductController").forward(request, response);
					}
				}
				else {
					request.setAttribute("warning", "Please choose a product!");
					request.getRequestDispatcher("ShopController").forward(request, response);
				}
			} else {
				request.setAttribute("warning", "Please log in!");
				request.getRequestDispatcher("HomeController").forward(request, response);
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
