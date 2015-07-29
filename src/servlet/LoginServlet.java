package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Users;
import service.UserService;

/**
 * @author yeye
 *
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request,response);
	}
	
	/**
	 * 处理登录请求
	 */	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserService userservice = new UserService();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Users user;
		try {
			user = userservice.login(username, password);
			if(user == null)
			{
				request.setAttribute("error", "用户名或密码错误！");
				request.getRequestDispatcher("/login.jsp").forward(request,response);
			}
			else
			{
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				response.sendRedirect(request.getContextPath()+"/index.jsp");
				
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	
	}

}
