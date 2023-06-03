package co.jp.ygcBook.dao;

import java.sql.SQLException;
import java.util.List;

import cn.key.dbManager.JdbcTemplate;
import co.jp.ygcBook.entity.Hobby;

public class HobbyDAO {

	private JdbcTemplate template = new JdbcTemplate();

	public boolean insertHObby (Hobby hobby) {
		int row = 0;
		String sql = "insert into hobby values(?,?,0)";
		for(int i =0;i<hobby.getHobbyArray().length;i++) {

			Object[] values = new Object[]{hobby.getUsername(),hobby.getHobbyArray()[i]};

			try {
				row = row + template.updata(sql, values);
			} catch (SQLException e) {
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
				return row == hobby.getHobbyArray(). length;
	}
}

	
