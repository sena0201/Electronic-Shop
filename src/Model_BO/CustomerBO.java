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
}
