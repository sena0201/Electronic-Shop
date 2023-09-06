package Model_BO;

import java.util.ArrayList;

import Model_BEAN.EmployeeBEAN;
import Model_DAO.EmployeeDAO;

public class EmployeeBO {
	EmployeeDAO employeeDAO = new EmployeeDAO();
	public EmployeeBEAN Employee(String userName, String password) throws Exception{
		return employeeDAO.Employee(userName, password);
	}
	
	public ArrayList<EmployeeBEAN> ListOfEmployees() throws Exception{
		return employeeDAO.ListOfEmployees();
	}
	
	public int AddEmployee(String employeeName,String photo, String userName, String password) throws Exception{
		return employeeDAO.AddEmployee(employeeName, photo, userName, password);
	}
	public int Edit(long employeeID ,String employeeName, String photo, String password) throws Exception{
		return employeeDAO.Edit(employeeID, employeeName, photo, password);
	}
	public int Delete(long employeeID) throws Exception{
		return employeeDAO.Delete(employeeID);
	}
	public EmployeeBEAN Employee(long employeeID) throws Exception{
		return employeeDAO.Employee(employeeID);
	}
}
