package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Users;
import util.DBHelper;

/**
* @className:UserDao.java
* @classDescription:
* @author:yeye
* @createTime:2015年7月29日 下午2:03:12
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
		/*finally{
			DBHelper.colose(rs, ps, conn);
		}*/
		return null;
		
	}
	

}
