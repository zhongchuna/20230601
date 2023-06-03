package co.jp.ygcBook.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import co.jp.ygcBook.dao.UserInfoDAO;
import co.jp.ygcBook.entity.UserInfo;


public class UserRegisterServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 姓名
		String username = request.getParameter("username");
		// 密碼
		String password = request.getParameter("password");
		// 性別
		String gender = request.getParameter("gender");
		// 专业
		String major = request.getParameter("major");
		// 简介
		String intro = request.getParameter("intro");
		
		UserInfoDAO userinfoDAO = new UserInfoDAO();
		
		UserInfo userInfo = new UserInfo();
		userInfo.setUsername(username);
		userInfo.setPassword(password);
		userInfo.setGender(gender);
		userInfo.setMajor(major);
		userInfo.setIntro(intro);
		
		boolean flg = userinfoDAO.save(userInfo);
		
		if(flg = true){
			request.getRequestDispatcher("/userSearchSuccess.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/userSearchErr.jsp").forward(request, response);
		 }
		
		// 爱好
		//String[] hobbyArray = request.getParameterValues("hobby");

//		List<Hobby> hobbyList = new ArrayList<>();
//		
//		for (String rs : hobbyArray) {
//			
//			Hobby hobby = new Hobby(); 
//			hobby.setUsername(username);
//			hobby.setHoppy(rs);
//			hobbyList.add(hobby);
//			
//		}
//		
//		HobbyDAO hobbyDao = new HobbyDAO();
//		boolean hobbyFlag = hobbyDao.save(hobbyList);
//		
//		if(hobbyFlag) {
//			System.out.println("爱好表插入成功，问题不大");
//		}else {
//			System.out.println("爱好表插入失败，问题不大");
//		}
//
//		
//		
//		UserInfoDAO userinfoDAO = new UserInfoDAO();
//
//		UserInfo userInfo = new UserInfo();
//		userInfo.setUsername(username);
//		userInfo.setPassword(password);
//		userInfo.setSex(sex);
//		userInfo.setMajor(major);
//		userInfo.setIntro(intro);
//		
//		

//		
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}