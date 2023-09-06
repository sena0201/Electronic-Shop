package Model_BO;

import java.util.ArrayList;
import java.util.Date;

import Model_BEAN.AdWaitOrderBEAN;
import Model_BEAN.OrderBEAN;
import Model_DAO.OrderDAO;

public class OrderBO {
	OrderDAO orderDAO = new OrderDAO();
	public long CreateOrder(long customerID, Date orderTime, String description, String status) throws Exception{
		return orderDAO.CreateOrder(customerID, orderTime, description, status);
	}
	
	public ArrayList<OrderBEAN> ListOfOrders(long customerID) throws Exception{
		return orderDAO.ListOfOrders(customerID);
	}
	
	public ArrayList<OrderBEAN> ListOfOrders() throws Exception{
		return orderDAO.ListOfOrders();
	}
	
	public ArrayList<OrderBEAN> ListOfOrders(long customerID, String status) throws Exception{
		return orderDAO.ListOfOrders(customerID, status);
	}
	
	public ArrayList<AdWaitOrderBEAN> ListOfAdOrders(String status) throws Exception{
		return orderDAO.ListOfAdOrders(status);
	}
	public ArrayList<AdWaitOrderBEAN> ListOfAdOrders() throws Exception{
		return orderDAO.ListOfAdOrders();
	}
	public int Processing(long orderID, long employeeID, String status) throws Exception{
		return orderDAO.Processing(orderID, employeeID, status);
	}
}
