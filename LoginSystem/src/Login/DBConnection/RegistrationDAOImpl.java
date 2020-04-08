package Login.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class RegistrationDAOImpl extends DBConnection implements RegistrationDAO
{
	@Override
	public Boolean insertUser(Users user) throws Exception 
	{
		Connection conn = null;
		try 
		{
			conn = getConnection();

			String query = " insert into users (name, user_Name, password) values (?, ?, ?)";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, user.getName());
			preparedStmt.setString(2, user.getUserName());
			preparedStmt.setString(3, user.getPassword());

			Boolean execute = preparedStmt.execute();

			return execute;
		} 
		catch (Exception e)
		{
			System.out.println("Failed insertUser in RegistrationDAOImpl :"+e);
			throw e;
 		}
		finally
		{
			conn.close();
		}
	}

	@Override
	public Users getUser(String userName, String password) throws Exception 
	{
		Users users = new Users();
		try 
		{
			
			System.out.println("RegistrationDAOImpl getUser 1");
			
			

		} 
		catch (Exception e) 
		{
			System.out.println("Failed getUser in RegistrationDAOImpl :"+e);
			throw e;		
		}
		finally
		{
		}
		return users;
	}

}
