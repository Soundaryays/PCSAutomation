package config;
import java.sql.*;
public class JDBCConnection {

	public static Connection getDBConnection() throws ClassNotFoundException,SQLException{
		//Datasource information
		String url="jdbc:mysql://localhost:3306/pcsdb";
		String username="root";
		String password="niit@1234";
		//loading driver
		Class.forName("com.mysql.jdbc.Driver");
		//creating connection object
		Connection conn=DriverManager.getConnection(url,username,password);
		return conn;
	}
}
