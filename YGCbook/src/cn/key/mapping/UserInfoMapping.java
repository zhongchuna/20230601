package cn.key.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.key.dbManager.IResultSetMapping;
import co.jp.ygcBook.entity.UserInfo;


public class UserInfoMapping implements IResultSetMapping{

	@Override
	public UserInfo mapping(ResultSet rs) throws SQLException {
		int i = 1;
		UserInfo userInfo = new UserInfo(
				rs.getString(i++), 
				rs.getString(i++), 
				rs.getString(i++), 
				rs.getString(i++), 
				rs.getString(i++));
		return userInfo;
	}
}
  