package Model_BO;

import java.util.ArrayList;

import Model_BEAN.CustomerBEAN;
import Model_DAO.CustomerDAO;

public class CustomerBO {
	CustomerDAO customerDAO = new CustomerDAO();
	public ArrayList<CustomerBEAN> ListOfCustomers() throws Exception{
		return customerDAO.ListOfCustumers();
	}
	
	public CustomerBEAN CustomerLogin(String userName, String password) throws Exception{
		return customerDAO.CustomerLogin(userName, password);
	}
	
	public long CustomerRegister(String customerName, String address, String phoneNumber, String userName, String password) throws Exception{
		return customerDAO.CustomerRegister(customerName, address, phoneNumber, userName, password);
	}
	
	public CustomerBEAN Customer(long customerID) throws Exception{
		return customerDAO.Customer(customerID);
	}
	
	public int EditCustomer(long customerID ,String customerName, String address, String phoneNumber, String password) throws Exception{
		return customerDAO.EditCustomer(customerID, customerName, address, phoneNumber, password);
	}
	public int DeleteCustomer(long customerID) throws Exception{
		return customerDAO.DeleteCustomer(customerID);
	}
}
