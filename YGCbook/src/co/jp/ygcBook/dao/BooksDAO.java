package co.jp.ygcBook.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.key.dbManager.JdbcTemplate;
import cn.key.mapping.UserInfoMapping;
import co.jp.ygcBook.entity.Books;
import co.jp.ygcBook.entity.UserInfo;
import co.jp.ygcBook.mapping.Booksmapping;

public class BooksDAO {
	private JdbcTemplate template = new JdbcTemplate();

	// 添加机能的方法
	public boolean save(Books books) {
		int row = 0;
		String sql = "insert into books(bookId,title,author,price,inventory)" + "values(?,?,?,?,?)";
		Object[] values = new Object[] { books.getBookId(), books.getTitle(), books.getAuthor(), books.getPrice(),
				books.getInventory() };
		try {
			row = template.updata(sql, values);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (row == 1);
	}

	 //搜索机能的方法
	public List<Books> FindBook() {

		String sql = "select * from books ";

		List<Books> list = new ArrayList<Books>();
		try {
			list = template.selete(sql, new Booksmapping());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
	
	// 搜索机能的方法
		public List<Books> select(String bookId,String title, String author) {

			String sql = "select * from books where 1=1 ";
			
			// 如果存在，那么就放入sql文当中作为筛选条件
			if (!"".equals(bookId)) {
				sql = sql + " and bookId ='" + bookId + "' ";
			}
			// 如果存在，那么就放入sql文当中作为筛选条件 
			if (!"".equals(title)) {
				sql = sql + " and title ='" + title + "' ";
			}

			// 如果存在，那么就放入sql文当中作为筛选条件
			if (!"".equals(author)) {
				sql = sql + " and author ='" + author + "'";
			}
			List<Books> list = new ArrayList<Books>();
			try {
				list = template.selete(sql, new Booksmapping());
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return list;
		}


}
