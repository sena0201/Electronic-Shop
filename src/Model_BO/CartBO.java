package Model_BO;

import Model_DAO.CartDAO;

public class CartBO {
	CartDAO cartDAO = new CartDAO();
	public long CreateCart(long customerID) throws Exception{
		return cartDAO.CreateCart(customerID);
	}
	
	public int CountCartDetail(long customerID) throws Exception{
		return cartDAO.CountCartDetail(customerID);
	}
}
