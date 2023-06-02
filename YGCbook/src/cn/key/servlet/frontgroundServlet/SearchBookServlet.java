package cn.key.servlet.frontgroundServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.key.dao.SearchBookDAO;
import cn.key.entity.SearchBook;

public class SearchBookServlet extends HttpServlet {

		@Override
		public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
		}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String bookName = request.getParameter("bookName");
			String author = request.getParameter("author");
			String pbName = request.getParameter("pbName");
			String email = request.getParameter("email");
			String context = request.getParameter("context");
			SearchBook book = new SearchBook(bookName, author, pbName, email, context);
			System.out.println(book);
			SearchBookDAO dao = new SearchBookDAO();
			String path = "/Error.jsp";
			String title = "������д��ȷ��ͼ����Ϣ��";
			if(dao.save(book)) {
				path = "/Success.jsp";
				title = "���ύ����Ϣ�����Ѿ��յ����������ĵȴ�����ע���ǵ�����ͼ����Ϣ��";
			}
			request.setAttribute("title",title);
			request.setAttribute("returnPath","/FindBookTypeServlet");
			RequestDispatcher rd =  request.getRequestDispatcher(request.getContextPath() + "/background"+ path);
			rd.forward(request, response);

		}

}
