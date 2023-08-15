package co.jp.ygcBook.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jp.ygcBook.dao.BooksDAO;
import co.jp.ygcBook.entity.Books;


public class AddBookServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 标题
	    String title = req.getParameter("title");
	    //作者
	    String author = req.getParameter("author");
	    //价格
	    String price = req.getParameter("price");
	    //库存
	    String inventory = req.getParameter("inventory");
	    
	    BooksDAO booksDAO = new BooksDAO();
	    Books books = new Books();
	    books.setTitle(title);
	    books.setAuthor(author);
	    books.setPrice(price);
	    books.setInventory(inventory);
	    
	    boolean flg =booksDAO.save(books);
	    
	    
	    
	    if (flg) {
	        String message = "66666"; // 提示消息
	        String script = "<script>alert('" + message + "'); window.location.href='/YGCbook/bookAdd.jsp';</script>";
	        resp.getWriter().write(script);
	    } else {
	    	String message = "4444"; // 提示消息
	        String script = "<script>alert('" + message + "'); window.location.href='/YGCbook/bookAdd.jsp';</script>";
	        resp.getWriter().write(script);
	    }
	    
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
	

}
