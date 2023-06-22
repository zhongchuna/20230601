package co.jp.ygcBook.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.key.dbManager.JdbcTemplate;
import cn.key.mapping.UserInfoMapping;
import co.jp.ygcBook.entity.Hobby;
import co.jp.ygcBook.entity.UserInfo;
import co.jp.ygcBook.mapping.Hobbymapping;

public class HobbyDAO {

	private JdbcTemplate template = new JdbcTemplate();

	public boolean insertHObby(Hobby hobby) {
		int row = 0;
		String sql = "insert into hobby values(?,?,0)";
		for (int i = 0; i < hobby.getHobbyArray().length; i++) {

			Object[] values = new Object[] { hobby.getUsername(), hobby.getHobbyArray()[i] };

			try {
				row = row + template.updata(sql, values);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

		return row == hobby.getHobbyArray().length;
	}

	// 搜索机能的方法
	public List<Hobby> select(String username) {

		String sql = "SELECT username, GROUP_CONCAT(hobby SEPARATOR ', ') AS hobby  FROM hobby GROUP BY username";

		// 如果username存在，那么就把username放入sql文当中作为筛选条件
		List<Hobby> list = new ArrayList<Hobby>();
		try { 
			list = template.selete(sql, new Hobbymapping());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
	// 搜索机能的方法
	public Hobby selectUpdate(String username) {

		String sql = "SELECT username, GROUP_CONCAT(hobby SEPARATOR ', ') AS hobby  FROM hobby GROUP BY username  having username= '" + username + "'";

		// 如果username存在，那么就把username放入sql文当中作为筛选条件
		List<Hobby> list = new ArrayList<Hobby>();
		try {
			list = template.selete(sql, new Hobbymapping());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list.get(0);
	}
	
	// 更新机能的方法
	public boolean  updateByUsername(String username)  {
		

		String sql = "update hobby set delFlag = 1  where username =? and delFlag = 0";
		
		int row = 0;
		
		Object[] values =new Object[]{username};

			try {
				row = template.updata(sql,values);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

		return true;
	}

	
}
