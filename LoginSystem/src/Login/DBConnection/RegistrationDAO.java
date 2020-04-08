package Login.DBConnection;

public interface RegistrationDAO
{
	public Boolean insertUser(Users user) throws Exception;
	public Users getUser(String userName, String password) throws Exception;
}
