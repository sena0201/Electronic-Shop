package Model_BO;

import java.util.ArrayList;

import Model_BEAN.NowCartBEAN;
import Model_DAO.CartDAO;

public class CartBO {
	CartDAO cartDAO = new CartDAO();
	public long CreateCart(long customerID) throws Exception{
		return cartDAO.CreateCart(customerID);
	}
	
	public int CountCartDetail(long customerID) throws Exception{
		return cartDAO.CountCartDetail(customerID);
	}
	
	public ArrayList<NowCartBEAN> ListOfCarts(long customerID) throws Exception{
		return cartDAO.ListOfCarts(customerID);
	}
	
	public int DeleteFromCart(long cartID, long productID) throws Exception{
		return cartDAO.DeleteFromCart(cartID, productID);
	}
	
	public long GetCartID(long customerID) throws Exception{
		return cartDAO.GetCartID(customerID);
	}
}
