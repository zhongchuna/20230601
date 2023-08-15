package co.jp.ygcBook.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.key.dbManager.IResultSetMapping;
import co.jp.ygcBook.entity.Books;
import co.jp.ygcBook.entity.UserInfo;

public class Booksmapping implements IResultSetMapping {

	@Override
	public Books mapping(ResultSet rs) throws SQLException {
		int i = 1;
		Books books = new Books(rs.getString(i++), rs.getString(i++), rs.getString(i++),rs.getString(i++),rs.getString(i++));
		return books;
	}
}
