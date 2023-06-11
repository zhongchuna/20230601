package co.jp.ygcBook.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.key.dbManager.IResultSetMapping;
import co.jp.ygcBook.entity.Hobby;


public class Hobbymapping implements IResultSetMapping {

	@Override
	public Hobby mapping(ResultSet rs) throws SQLException {
		int i = 1;
		Hobby hobby = new Hobby(rs.getString(i++),rs.getString(i++));
		return hobby;
	}
}
