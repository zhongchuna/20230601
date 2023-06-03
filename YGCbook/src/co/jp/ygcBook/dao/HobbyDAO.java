package co.jp.ygcBook.dao;

import java.sql.SQLException;
import java.util.List;

import cn.key.dbManager.JdbcTemplate;
import co.jp.netwisdom.entity.Hobby;

public class HobbyDAO {
	private JdbcTemplate template = new JdbcTemplate();
	public boolean save(List list) {
		int row = 0;
		String sql = "insert into hobby(username,hobby)"+
						"values(?,?)";
		try {

			for(Object object :list) {
				Hobby hobbyObject =(Hobby)object;
				Object[] values =null;
				//String username =hobbyObject.getUsername();
				//String hobby = hobbyObject.getHoppy();
				values = new Object[]{
						hobbyObject.getUsername(),
						hobbyObject.getHoppy()};
				row = template.updata(sql, values);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return true;
	}
	// 伦理删除
	public boolean delHobby(String username) {
		String sql = "update hobby set delFlg='1'  where username = ?";
		
		Object[] values = new Object[]{ 
		           username};
		try {
		 template.updata(sql, values);
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return true;
	}


}
