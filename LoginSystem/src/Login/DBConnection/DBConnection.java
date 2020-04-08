package Login.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection 
{
	public Connection getConnection() 
	{
		Connection con = null;
		String userName = "root";
		String password = "root";
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sql_db", userName, password);

		} 
		catch (ClassNotFoundException ex) 
		{
			System.out.println("Error: unable to load driver class!");
		} 
		catch (Exception e) 
		{
			System.out.println("Error: unable to instantiate driver!");
		}
		return con;
	}
}
