package cn.key.test;


import java.util.List;
import java.util.Vector;

import cn.key.dao.BookStockDAO;
import cn.key.entity.BookStock;

public class TestBookStockDAO {
	public void testFindAll() {
		BookStockDAO dao = new BookStockDAO();
		List<BookStock> bookStocks = new Vector<>();
		bookStocks = dao.findAll();
		for (BookStock bookStock : bookStocks) {
			System.out.println(bookStock);
		}
	}
	public static void main(String[] args) {
		TestBookStockDAO test = new TestBookStockDAO();
		test.testFindAll();
	}
}
