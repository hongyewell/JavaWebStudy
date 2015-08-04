package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.catalina.User;
import entity.Users;
import util.DBHelper;


/**
 * @desc: JspViewListDemo
 * @author: yeye
 * @createTime: 2015年8月4日 下午4:17:46
 * @history:
 * @version: v1.0
*/
public class UserDao {
	
	/**
	 * 根据用户名和密码查询
	 *  
	 */
	public Users queryByUserNameAndPassword(String username ,String password) throws Exception{
		String sql = "select u.username,u.password from t_users u where u.username =? and u.password = ?";
		
		Connection conn = DBHelper.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			
			if(rs.next()){
				String uname = rs.getString("username");
				String pass = rs.getString("password");
				Users user = new Users(uname,pass);
				return user;
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
		
	}
	
	/**
	 * 用户注册
	 * @author: yeye
	 * @createTime: 2015年8月4日 下午3:16:45
	 * @history:
	 * @param user
	 * @return int
	 */
	public int addUser(Users user){
		String sql ="insert into t_users(username,password)values (?,?)";
		Connection conn = DBHelper.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			
			int res = ps.executeUpdate();
			
			return res;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.colose(rs, ps, conn);
		}
		
		return 0;
		
		
	}
	
	/**
	 * 查询用户列表
	 *
	 * @author: yeye
	 * @createTime: 2015年8月4日 下午4:18:09
	 * @history:
	 * @return List<User>
	 */
	
	public List<Users> queryAll() {
		String sql = "select u.id, u.username, u.password from t_users u";
		
		Connection conn = DBHelper.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			// 创建List集合，用户存放查询出来的用户列表
			List<Users> users = new ArrayList<Users>();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String uname = rs.getString("username");
				String pass = rs.getString("password");
				Users user = new Users(id, uname, pass);
				
				users.add(user);
			}
			
			return users;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.colose(rs, ps, conn);
		}
		
		return null;
	}
	
	

}
