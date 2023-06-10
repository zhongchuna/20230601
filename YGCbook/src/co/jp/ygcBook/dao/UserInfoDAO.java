package co.jp.ygcBook.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.key.dbManager.JdbcTemplate;
import cn.key.mapping.UserInfoMapping;
import co.jp.ygcBook.entity.UserInfo;

public class UserInfoDAO {
	private JdbcTemplate template = new JdbcTemplate();

	public boolean save(UserInfo userinfo) {
		int row = 0;
		String sql = "insert into userinfo(username,password,gender,major,intro)" + "values(?,?,?,?,?)";
		Object[] values = new Object[] { userinfo.getUsername(), userinfo.getPassword(), userinfo.getGender(),
				userinfo.getMajor(), userinfo.getIntro()

		};
		try {
			row = template.updata(sql, values);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (row == 1);
	}

	// 搜索机能的方法
	public List<UserInfo> select(String username, String gender, String major) {

		String sql = "select * from userinfo where 1=1 ";

		// 如果username存在，那么就把username放入sql文当中作为筛选条件
		if (!"".equals(username)) {
			sql = sql + " and username ='" + username + "'";
		}

		// sex为前台必传的，那么不用判断是否为空字符串，直接放入sql文当中作为筛选条件
		if (!"".equals(gender)) {
			sql = sql + " and gender ='" + gender + "' ";
		}
		
		// 如果major存在，那么就把major放入sql文当中作为筛选条件
		if (!"".equals(major)) {
			sql = sql + " and major ='" + major + "'";
		}
		List<UserInfo> list = new ArrayList<UserInfo>();
		try {
			list = template.selete(sql, new UserInfoMapping());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

}
