package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entity.Items;
import util.DBHelper;

//商品的业务逻辑类
/**
 * @desc: JspViewListDemo
 * @author: yeye
 * @createTime: 2015年8月3日 下午3:39:30
 * @history:
 * @version: v1.0
*/
public class ItemsDAO {
	/**
	 *
	 * @author: yeye
	 * @createTime: 2015年8月3日 下午3:39:10
	 * @history:
	 * @return
	 * @throws Exception List<Items>
	*/
	public List<Items>queryAll() throws Exception{
		String sql = " select *from items ";
		
		Connection conn = DBHelper.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			// 创建List集合，用户存放查询出来的用户列表
			List<Items> Itmes = new ArrayList<Items>();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String city = rs.getString("city");
				int number = rs.getInt("number");
				int price = rs.getInt("price");
				String picture = rs.getString("picture");
				Items Items = new Items(id,name, city, number,price,picture);
				
				Itmes.add(Items);
			}
			
			return Itmes;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.colose(rs, ps, conn);
		}
		
		return null;
		
	}
	
	//获取所有的商品信息
	public ArrayList<Items>getAllItems()
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Items>list = new ArrayList<Items>();//商品集合
		
		try
		{
			conn = DBHelper.getConnection();
			String sql = "select * from items;";//sql语句
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while( rs.next())
			{
				Items item = new Items();
				item.setId(rs.getInt("id"));
				item.setName(rs.getString("name"));
				item.setCity(rs.getString("city"));
				item.setNumber(rs.getInt("number"));
				item.setPrice(rs.getInt("price"));
				item.setPicture(rs.getString("picture"));
				list.add(item);//把一个商品加入集合
						
			}
			return list;//返回集合
			
		}
		catch(Exception ex)
		{
				ex.printStackTrace();
				return null;
			
		}
		finally
		{
			//释放数据集对象
			if(rs != null)
			{
				try {
					rs.close();
					rs = null;
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
				
			}
			//释放语句对象
			if(stmt != null)
			{
				try {
					stmt.close();
					stmt = null;
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
				
			}
		}
	}
	
	//根据商品编号获取商品详细信息
	/**
	 *
	 * @author: yeye
	 * @createTime: 2015年8月3日 下午3:39:59
	 * @history:
	 * @param id
	 * @return Items
	*/
	public Items getItemsById(int id)
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try
		{
			conn = DBHelper.getConnection();
			String sql = "select * from items where id = ?;";//sql语句
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if( rs.next())
			{
				Items item = new Items();
				item.setId(rs.getInt("id"));
				item.setName(rs.getString("name"));
				item.setCity(rs.getString("city"));
				item.setNumber(rs.getInt("number"));
				item.setPrice(rs.getInt("price"));
				item.setPicture(rs.getString("picture"));
				return item;//把一个商品加入集合
						
			}
			else
			{
				return null;
			}
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
		finally
		{
			//释放数据集对象
			if(rs != null)
			{
				try {
					rs.close();
					rs = null;
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
				
			}
			//释放语句对象
			if(stmt != null)
			{
				try {
					stmt.close();
					stmt = null;
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
				
			}
		}
		
	}
	
	//获取最近浏览的前五条商品信息
	
	/**
	 *
	 * @author: yeye
	 * @createTime: 2015年8月3日 下午3:40:29
	 * @history:
	 * @param list
	 * @return ArrayList<Items>
	*/
	public ArrayList<Items>getViewList(String list)
	{
		ArrayList<Items> itemlist = new ArrayList<Items>();
		int iCount = 3;//每次返回前五条记录
		if(list!=null&&list.length()>0)
		{
			String[] arr = list.split(",");
			//如果商品记录大于等于5条
			if(arr.length>=3)
			{
				for(int i=arr.length-1;i>=arr.length-iCount;i--)
				{
					itemlist.add(getItemsById(Integer.parseInt(arr[i])));
				}
				
			}
			else
			{
				for(int i = arr.length-1;i>=0;i--)
				{
					itemlist.add(getItemsById(Integer.parseInt(arr[i])));
				}
			}
			return itemlist;
		}
		else
		{
			return null;
		}
		
	}
}
