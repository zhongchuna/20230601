package cn.key.servlet.bookInfoServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.key.dao.BookInfoDAO;

public class DeUpdateBookStatesServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		BookInfoDAO dao = new BookInfoDAO();
		String path = "/Error.jsp";
		String returnPath = "/FindAllBookInfoServlet";
		if(dao.upDelete(3,bookId)) {
			path = "/Success.jsp";
		}
		request.setAttribute("title","���ò�����");
		request.setAttribute("returnPath",returnPath);
		RequestDispatcher rd =  request.getRequestDispatcher("/background"+ path);
		rd.forward(request, response);
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
