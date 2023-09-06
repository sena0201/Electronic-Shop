package Model_BO;

import java.util.ArrayList;

import Model_BEAN.PurchaseBEAN;
import Model_DAO.PurchaseDAO;

public class PurchaseBO {
	PurchaseDAO purchaseDAO = new PurchaseDAO();
	public ArrayList<PurchaseBEAN> ListOfPurchaseds(long customerID) throws Exception{
		return purchaseDAO.ListOfPurchaseds(customerID);
	}
	public ArrayList<PurchaseBEAN> ListOfPurchaseds(long customerID, String status) throws Exception{
		return purchaseDAO.ListOfPurchaseds(customerID, status);
	}
}
