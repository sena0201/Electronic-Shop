package Model_BO;

import java.util.ArrayList;

import Model_BEAN.AdOrderDetailBEAN;
import Model_BEAN.OrderDetailBEAN;
import Model_BEAN.ProcessedBEAN;
import Model_DAO.OrderDetailDAO;

public class OrderDetailBO {
	OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
	public int AddOrderDetail(long orderID, long productID, long quantity, long salePrice) throws Exception{
		return orderDetailDAO.AddOrderDetail(orderID, productID, quantity, salePrice);
	}
	
	public ArrayList<OrderDetailBEAN> ListOfOrderDetails() throws Exception{
		return orderDetailDAO.ListOfOrderDetails();
	}
	
	public ArrayList<AdOrderDetailBEAN> ListOfOrderDetails(long orderID) throws Exception{
		return orderDetailDAO.ListOfOrderDetails(orderID);
	}
	
	public ArrayList<ProcessedBEAN> ListOfProcesseds(String status) throws Exception{
		return orderDetailDAO.ListOfProcesseds(status);
	}
}
