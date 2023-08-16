package Model_BO;

import Model_DAO.CartDetailDAO;

public class CartDetailBO {
	CartDetailDAO cartDetailDAO = new CartDetailDAO();
	public void AddToCartDetail(long cartID, long productID,long quantity, long salePrice) throws Exception{
		cartDetailDAO.AddToCartDetail(cartID, productID, quantity, salePrice);
	}
}
