package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.Users;
import service.UserService;

/**用户注册
* @className:registerController.java
* @classDescription:
* @author:yeye
* @createTime:2015年8月4日 下午2:57:18
*/
public class registerController extends HttpServlet {

	/**
	* TODO
	*/
	private static final long serialVersionUID = 1L;
	
	private UserService userService;
	
	
	@Override
	public void init() throws ServletException {
		
		this.userService = new UserService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect(req.getContextPath()+"/register.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 处理表单数据乱码
				req.setCharacterEncoding("utf-8");
				
				// 获取表单数据
				String username = req.getParameter("username");
				String password = req.getParameter("password");
				
				// 新建用户
				Users user = new Users(username, password);
				
				int res = userService.addUser(user);
				
				if(res == 1) {	// 添加成功
					// 跳转到用户列表页面
					resp.sendRedirect(req.getContextPath()+"/index.jsp");
					
				}else { // 添加失败
					req.setAttribute("message", "添加失败");
					req.getRequestDispatcher("/login_failure.jsp").forward(req, resp);
				}
	}
	

}
