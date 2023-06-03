package co.jp.ygcBook.dao;

import java.sql.SQLException;


import cn.key.dbManager.JdbcTemplate;

import co.jp.ygcBook.entity.UserInfo;


public class UserInfoDAO {
	private JdbcTemplate template = new JdbcTemplate();
	
	public boolean save(UserInfo userinfo) {
		int row = 0;
		String sql = "insert into userinfo(username,password,gender,major,intro)"+
				"values(?,?,?,?,?)";
		Object[] values = new Object[] {
				userinfo.getUsername(),
				userinfo.getPassword(),
				userinfo.getGender(),
				userinfo.getMajor(),
				userinfo.getIntro()
				
		};
		try {
			row =template.updata(sql, values);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (row == 1);
	}
}

