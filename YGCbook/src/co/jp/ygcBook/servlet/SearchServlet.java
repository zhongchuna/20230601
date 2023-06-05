package co.jp.ygcBook.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jp.ygcBook.dao.HobbyDAO;
import co.jp.ygcBook.dao.UserInfoDAO;
import co.jp.ygcBook.entity.Hobby;
import co.jp.ygcBook.entity.UserInfo;


public class SearchServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 姓名
		String username = request.getParameter("name");
		// 性別
		String gender = request.getParameter("gender");
		// 专业
		String major = request.getParameter("major");
		
		UserInfoDAO userinfoDAO = new UserInfoDAO();
		userinfoDAO.select(null);
	
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}