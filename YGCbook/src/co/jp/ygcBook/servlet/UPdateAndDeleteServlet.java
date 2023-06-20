package co.jp.ygcBook.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jp.ygcBook.dao.HobbyDAO;
import co.jp.ygcBook.dao.UserInfoDAO;
import co.jp.ygcBook.entity.Hobby;
import co.jp.ygcBook.entity.UserInfo;

public class UPdateAndDeleteServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("usernameForUAD");
		
		UserInfoDAO userinfoDAO = new UserInfoDAO();
		
		UserInfo userInfo = new UserInfo();

		userInfo = userinfoDAO.select(username);

		req.setAttribute("userInfo", userInfo);

		HobbyDAO hobbyDAO = new HobbyDAO();
		
		Hobby hobby = new Hobby();
		hobby = hobbyDAO.selectUpdate(username);
		req.setAttribute("hobby", hobby);
		
		//resp.sendRedirect("updateOrdelete.jsp");
		req.getRequestDispatcher("/updateOrdelete.jsp").forward(req, resp);
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
	

}
