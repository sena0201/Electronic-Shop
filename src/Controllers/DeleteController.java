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

/**
 * Servlet implementation class DeleteController
 */
@WebServlet("/DeleteController")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			CartBO cartBO = new CartBO();
			HttpSession session = request.getSession();
			CustomerBEAN user = (CustomerBEAN)session.getAttribute("user");
			if(user != null) {
				String cartID = request.getParameter("cartID");
				String productID = request.getParameter("productID");
				if(cartID != null && productID != null) {
					int check = cartBO.DeleteFromCart(Long.parseLong(cartID), Long.parseLong(productID));
					if(check > 0){
						request.getRequestDispatcher("CartController").forward(request, response);
					}
					else {
						request.getRequestDispatcher("CartController").forward(request, response);
					}
				} else {
					request.getRequestDispatcher("CartController").forward(request, response);
				}
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
