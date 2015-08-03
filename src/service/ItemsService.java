package service;

import java.util.List;

import dao.ItemsDAO;
import entity.Items;

/**
* @className:goodsService.java
* @classDescription:
* @author:yeye
* @createTime:2015年7月29日 下午9:20:48
*/
public class ItemsService {
	/**
	 * 商品Dao
	 */
	private ItemsDAO itemsDao;
	
	public ItemsService(){
		this.itemsDao = new ItemsDAO();
	}
	
	/**
	 * 商品列表
	 * @throws Exception 
	 */
	public List<Items>getAllItems() throws Exception{
		return itemsDao.queryAll();
	}

}
