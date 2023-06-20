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


public class UpdateOrDeleteServlet11 extends HttpServlet {

	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 姓名
		String usernameForUAD = request.getParameter("usernameForUAD");
		System.out.println(usernameForUAD);
//		// 性別
//		String gender = request.getParameter("gender");
//		// 专业
//		String major = request.getParameter("major");
//
//		UserInfoDAO userinfoDAO = new UserInfoDAO();
//		
//		UserInfo userInfo = new UserInfo();
//
//		userInfo = userinfoDAO.select(username);
//
//		request.setAttribute("data", userInfo);
//
//		HobbyDAO hobbyDAO = new HobbyDAO();
//		
//		Hobby hobby = new Hobby();
//		hobby = hobbyDAO.selectUpdate(username);
//		request.setAttribute("data1", hobby);
//		
//		response.sendRedirect("updateOrDelete.jsp");

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}