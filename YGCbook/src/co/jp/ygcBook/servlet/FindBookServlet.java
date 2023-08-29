package co.jp.ygcBook.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jp.ygcBook.dao.BooksDAO;

import co.jp.ygcBook.entity.Books;


public class FindBookServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	    BooksDAO booksDAO = new BooksDAO();
	    
		List<Books> bookList = booksDAO.FindBook();
		req.setAttribute("data", bookList);
		
		
		req.getRequestDispatcher("/book.jsp").forward(req, resp);	
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
