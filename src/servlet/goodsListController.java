package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import entity.Items;
import service.ItemsService;


public class goodsListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public goodsListController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	
	/**
	 * 获取商品列表
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置中文编码
		resp.setCharacterEncoding("utf-8");
		ItemsService itemsService  = new ItemsService();
		List<Items> items;
		try {
			items = itemsService.getAllItems();
			Gson gson = new Gson();
			String itemsJson = gson.toJson(items);	// 将List<User>集合中的User转换成json格式的字符串数据
			// 将json格式的用户列表返回的浏览器端
			PrintWriter out = resp.getWriter();
			out.write(itemsJson);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}

}
