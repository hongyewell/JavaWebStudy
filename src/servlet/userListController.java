package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import entity.Users;
import service.UserService;

/**
 * @desc: JspViewListDemo
 * @author: yeye
 * @createTime: 2015年8月4日 下午4:12:26
 * @history:
 * @version: v1.0
*/
public class userListController extends HttpServlet {

	/**
	* TODO
	*/
	private static final long serialVersionUID = 1L;
	
	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 resp.setCharacterEncoding("utf-8");
		 
		 UserService userService = new UserService();
		 
		 List<Users> users = userService.getAllUser();
		 
		 Gson gson = new Gson();
		 String userJson = gson.toJson(users);
		 System.out.println(userJson);
		 PrintWriter out = resp.getWriter();
		 out.write(userJson);
		 
				 
	}
}
