package Login.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegistrationDAOImpl extends DBConnection implements RegistrationDAO 
{
	@Override
	public Boolean insertUser(Users user) throws Exception 
	{
		Connection conn = null;
		PreparedStatement preparedStmt = null;
		try 
		{
			conn = getConnection();

			String query = " insert into users (name, user_Name, password) values (?, ?, ?)";
			preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, user.getName());
			preparedStmt.setString(2, user.getUserName());
			preparedStmt.setString(3, user.getPassword());

			int rowsInserted = preparedStmt.executeUpdate();
			if (rowsInserted > 0)
			    return true;
			else
				return false;
		} 
		catch (SQLException se) 
		{
			// Handle errors for JDBC
			se.printStackTrace();
			System.out.println("Failed insertUser in RegistrationDAOImpl.. :" + se);
			throw se;
		} 
		catch (Exception e) 
		{
			System.out.println("Failed insertUser in RegistrationDAOImpl :" + e);
			throw e;
		} 
		finally 
		{
			if(preparedStmt != null)
				preparedStmt.close();
			if(conn != null)
				conn.close();
		}
	}

	@Override
	public Users getUser(String userName, String password) throws Exception 
	{
		Users users = new Users();
		Connection conn = null;
		PreparedStatement preparedStmt = null;
		ResultSet rs = null;
		try 
		{
			conn = getConnection();// Open a connection

			System.out.println("RegistrationDAOImpl getUser 1");
			String query = "select NAME, USER_NAME from USERS where USER_NAME = ? and PASSWORD = ?";
			preparedStmt = conn.prepareStatement(query);// Execute a query
			preparedStmt.setString(1, userName);
			preparedStmt.setString(2, password);
			rs = preparedStmt.executeQuery();
			
			// Extract data from result set
			if (rs.next() == false) 
			{ 
				return null; 
			} 
			else 
			{
				// Retrieve by column name
				users.setName(rs.getString("NAME"));
				users.setUserName(rs.getString("USER_NAME"));
				// Display values
				System.out.print("NAME: " + rs.getString("NAME"));
			}

			rs.close();
		} 
		catch (SQLException se) 
		{
			// Handle errors for JDBC
			se.printStackTrace();
			System.out.println("Failed getUser in RegistrationDAOImpl.. :" + se);
			throw se;
		} 
		catch (Exception e) 
		{
			System.out.println("Failed getUser in RegistrationDAOImpl :" + e);
			throw e;
		} 
		finally 
		{
			if(rs != null)
				rs.close();
			if(preparedStmt != null)
				preparedStmt.close();
			if(conn != null)
				conn.close();
			
		}
		return users;
	}

}
