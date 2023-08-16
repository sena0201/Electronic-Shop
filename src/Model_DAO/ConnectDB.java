package Model_DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
	public Connection cn;
	public void Connect() throws Exception{
		//b1 xac dinh hqtcsdl
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		cn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-P9BL33K\\SQLEXPRESS:1433;databaseName=QLHangHoa;user=sa;password=123");
	}
}
