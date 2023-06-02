package cn.key.servlet.frontgroundServlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.key.entity.CustomerInfo;

public class WriteDiscussServlet extends HttpServlet {


	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bookName = request.getParameter("bookName");
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		HttpSession session = request.getSession();
		CustomerInfo customer = (CustomerInfo) session.getAttribute("customer");
		String path = "/background/Error.jsp";
		String returnPath = "/egou/login.jsp";
		String title = "����û�е�¼�������ȵ�¼";
		if(customer != null) {
			request.setAttribute("bookName", bookName);
			request.setAttribute("bookId", bookId);
			path = "writeDiscuss.jsp";
		}
		request.setAttribute("title",title);
		request.setAttribute("returnPath",returnPath);
		request.getRequestDispatcher(path).forward(request, response);
	}


	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
