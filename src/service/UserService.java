package service;

import java.util.List;

import org.apache.catalina.User;

import dao.UserDao;
import entity.Users;

/**
* @className:UserService.java
* @classDescription:
* @author:yeye
* @createTime:2015年7月29日 下午2:01:23
*/
public class UserService {
	/**
	 * 用户Dao
	 */
	private UserDao userDao;
	
	public UserService(){
		this.userDao = new UserDao();
	}
	
	/**
	 * 用户登录
	 *
	 * @author: yeye
	 * @createTime: 2015年8月4日 下午3:19:44
	 * @history:
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception Users
	 */
	public Users login(String username,String password) throws Exception{
		return userDao.queryByUserNameAndPassword(username, password);
		
	}
	
	/**
	 * 用户注册
	 *
	 * @author: yeye
	 * @createTime: 2015年8月4日 下午3:22:32
	 * @history:
	 * @param user
	 * @return int
	 */
	public int addUser( Users user) {
		return userDao.addUser(user);	
	}
	
	/**
	 * 获取用户列表
	 *
	 * @author: yeye
	 * @createTime: 2015年8月4日 下午4:27:23
	 * @history:
	 * @return List<Users>
	 */
	public List<Users>getAllUser(){
		return userDao.queryAll();
	}
	

}
