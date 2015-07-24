package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Users;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Users u = new Users();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		u.setUsername(username);
		u.setPassword(password);
		//判断用户名和密码是否合法
		if(u.getUsername().equals("admin")&&u.getPassword().equals("123"))
		{
			HttpSession session = request.getSession();
			session.setAttribute("username", u.getUsername());
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}
		else
		{
			response.sendRedirect(request.getContextPath()+"/login_failure.jsp");
			
		}
	
	
	}

}
