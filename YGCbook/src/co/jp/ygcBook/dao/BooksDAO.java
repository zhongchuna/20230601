package co.jp.ygcBook.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.key.dbManager.JdbcTemplate;
import cn.key.mapping.UserInfoMapping;
import co.jp.ygcBook.entity.Books;
import co.jp.ygcBook.entity.UserInfo;

public class BooksDAO {
	private JdbcTemplate template = new JdbcTemplate();

	public boolean save(Books books) {
		int row = 0;
		String sql = "insert into books(bookId,title,author,price,inventory)" + "values(?,?,?,?,?)";
		Object[] values = new Object[] { books.getBookId(),books.getTitle(),books.getAuthor(),books.getPrice(),books.getInventory()};
		try {
			row = template.updata(sql, values);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (row == 1);
	}

}
