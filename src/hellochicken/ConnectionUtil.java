package hellochicken;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	Connection conn = null;
	public static Connection conDB()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			return con;
		} catch (ClassNotFoundException | SQLException ex) {
			System.err.println("ConnectionUtil : "+ex.getMessage());
	           return null;
		}
	}
}
