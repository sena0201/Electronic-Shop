package Model_BO;

import Model_DAO.CartDetailDAO;

public class CartDetailBO {
	CartDetailDAO cartDetailDAO = new CartDetailDAO();
	public int AddToCartDetail(long cartID, long productID,long quantity, long salePrice) throws Exception{
		return cartDetailDAO.AddToCartDetail(cartID, productID, quantity, salePrice);
	}
}
