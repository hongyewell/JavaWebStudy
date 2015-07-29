package service;

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
	 * @throws Exception 
	 */
	public Users login(String username,String password) throws Exception{
		return userDao.queryByUserNameAndPassword(username, password);
		
	}

}
