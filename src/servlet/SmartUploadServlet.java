package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;


public class SmartUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置上传文件保存路径
		String filePath = this.getServletContext().getRealPath("/")+("/images");
		
		SmartUpload su = new SmartUpload();
		//初始化对象
		su.initialize(getServletConfig(),req,resp);
		//设置上传文件大小
		su.setMaxFileSize(1024*1024*10);
		//设置允许上传文件类型
		su.setAllowedFilesList("txt,jpg,png");
		String result ="上传成功！";
		//上传文件
		
		try {
			su.upload();
			int count = su.save(filePath);
			System.out.println("上传成功"+ count +"个文件！");
		} catch (SmartUploadException e) {
			 result ="上传失败！";
			e.printStackTrace();
		}
		
		req.setAttribute("result", result);
		req.getRequestDispatcher("imgUpload.jsp").forward(req, resp);
		
		
	}

}
