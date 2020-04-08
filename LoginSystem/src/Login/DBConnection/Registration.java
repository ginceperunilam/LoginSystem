package Login.DBConnection;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/registration")
public class Registration extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    public Registration() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try 
		{
			RegistrationDAO registrationDAO = new RegistrationDAOImpl();
			Users users = new Users();

			String submitType = request.getParameter("submit");
			System.out.println("Registration submitType:"+submitType);
			if(submitType.equals("Sign In"))
			{
				System.out.println("Registration Sign In");
				String userName = request.getParameter("userName");
				String password = request.getParameter("password");
				users = registrationDAO.getUser(userName, password);
				if(users != null)
				{
					System.out.println("Registration users.getName():"+users.getName());
					request.setAttribute("message", users.getName());
					request.getRequestDispatcher("welcome.jsp").forward(request, response);	
				}
				else
				{
					request.setAttribute("message", "Data Not Available, Please Register");
					request.getRequestDispatcher("login.jsp").forward(request, response);	
				}
			}
			else if(submitType.equals("Register"))
			{
				System.out.println("Registration register");
				users.setName(request.getParameter("name"));
				users.setUserName(request.getParameter("userName"));
				users.setPassword(request.getParameter("password1"));
				
				Boolean insertUser = registrationDAO.insertUser(users);
				if(insertUser)
				{
					request.setAttribute("successMessage", "Registered Successfully");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			}
			
		} 
		catch (Exception e)
		{
			System.out.println("Failed doPost in Registration :"+e);
		}
	
	}

}
