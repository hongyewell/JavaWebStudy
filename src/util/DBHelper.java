package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBHelper {
	// 定义连接数据库
		private static Connection ct = null;
		// 定义操作数据库的类
		private static PreparedStatement ps = null;
		// 输出数据的类
		private static ResultSet rs = null;

		// 静态方式取得链接
		public static Connection getConnection() {
			// 数据库用户名
			String username = "root";
			// 数据库用户密码
			String passwd = "1234";
			String url = "jdbc:mysql://localhost:3306/shopping?useUnicode=true&characterEncoding=UTF-8";
			// 获取驱动
			try {
				Class.forName("com.mysql.jdbc.Driver");
				ct = DriverManager.getConnection(url, username, passwd);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return ct;
		}
   
	/*private static final String driver = "com.mysql.jdbc.Driver"; //数据库驱动
	//连接数据库的URL地址
	private static final String url="jdbc:mysql://localhost:3306/shopping?useUnicode=true&characterEncoding=UTF-8"; 
	private static final String username="root";//数据库的用户名
	private static final String password="1234";//数据库的密码
    
	private static Connection conn=null;
	
	//静态代码块负责加载驱动
	static 
	{
		try
		{
			Class.forName(driver);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	//单例模式返回数据库连接对象
	public static Connection getConnection() throws Exception
	{
		if(conn==null)
		{
			conn = DriverManager.getConnection(url, username, password);
			return conn;
		}
		return conn;
	}
		
	public static void main(String[] args) {
			
			try
			{
			   Connection conn = DBHelper.getConnection();
			   if(conn!=null)
			   {
				   System.out.println("数据库连接成功啦！");
		   }
		   else
		   {
			   System.out.println("数据库连接异常！");
		   }
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}*/
	/**
	 * 关闭资源
	 * @param rs
	 * @param ps
	 * @param conn
	 */
	
	public static void colose(ResultSet rs, PreparedStatement ps, Connection conn) {
		try {
			if(rs != null) {
				rs.close();
			}
			if(ps != null) {
				ps.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
