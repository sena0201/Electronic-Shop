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
import Model_BEAN.NowCartBEAN;
import Model_BO.CartBO;

/**
 * Servlet implementation class CartController
 */
@WebServlet("/CartController")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartController() {
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
			if(user != null) {
				ArrayList<NowCartBEAN> ListOfCarts = cartBO.ListOfCarts(user.getCustomerID());
				
				request.setAttribute("ListOfCarts", ListOfCarts);
				session.setAttribute("count", (int)cartBO.CountCartDetail(user.getCustomerID()));
				request.getRequestDispatcher("cart.jsp").forward(request, response);
			}else {
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
