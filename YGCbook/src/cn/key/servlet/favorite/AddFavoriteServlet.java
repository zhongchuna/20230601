package cn.key.servlet.favorite;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.key.Tools.DataTool;
import cn.key.dao.BookInfoDAO;
import cn.key.dao.FavoriteDAO;
import cn.key.entity.BookInfo;
import cn.key.entity.CustomerInfo;
import cn.key.entity.Favorite;

public class AddFavoriteServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		int customerId = 0;
		HttpSession session = request.getSession();
		CustomerInfo customer = (CustomerInfo) session.getAttribute("customer");
		String path = "/background/Error.jsp";
		String returnPath = "/egou/login.jsp";
		String title = "����û�е�¼�������ȵ�¼";
		FavoriteDAO favoriteDAO = new FavoriteDAO();
		if(customer != null) {
			if (favoriteDAO.findByBookId(bookId,customer.getCustomerId()) != null) {
				title = "�ղؼ����Ѵ��ڱ�����Ŀ";
				returnPath = "/FindBookTypeServlet";
			}else {
				customerId = customer.getCustomerId();
				BookInfoDAO dao = new BookInfoDAO();
				BookInfo book = dao.findById(bookId);
				Date date = null;
				try {
					date = DataTool.allStringtoDate(DataTool.allDatetoString(new Date()));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				Favorite favorite = new Favorite(book.getBookId(), book.getBookName(), customer.getCustomerId(), date, book.getContext());
				if(favoriteDAO.save(favorite)) {
					List<Favorite> favorites = favoriteDAO.findByCustomerId(customerId);
					request.setAttribute("favorites", favorites);
					path = "favorite.jsp";
				}else {
					title = "�ղ��鼮";
					returnPath = "/FindBookTypeServlet";
				}
			}
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
