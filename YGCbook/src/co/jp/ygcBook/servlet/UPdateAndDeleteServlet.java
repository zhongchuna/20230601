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

public class UPdateAndDeleteServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String INITFLAG = "0";
	private static final String UPDATEFLAG = "1";
	private static final String DELETEFLAG = "2";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String handle = req.getParameter("handle");

		if (handle.equals(INITFLAG)) {
			
			String username = req.getParameter("usernameForUAD");

			UserInfoDAO userinfoDAO = new UserInfoDAO();

			UserInfo userInfo = new UserInfo();

			userInfo = userinfoDAO.select(username);

			req.setAttribute("userInfo", userInfo);

			HobbyDAO hobbyDAO = new HobbyDAO();

			Hobby hobby = new Hobby();
			hobby = hobbyDAO.selectUpdate(username);
			req.setAttribute("hobby", hobby);

			// resp.sendRedirect("updateOrdelete.jsp");
			req.getRequestDispatcher("/updateOrdelete.jsp").forward(req, resp);

		}
		if(handle.equals(UPDATEFLAG)) {
			
			boolean updatehobbyFlag = false;
			boolean updateUserinfoFlag = false;
			
			String username = req.getParameter("username");
			UserInfoDAO userInfoDAO = new UserInfoDAO();
			boolean update1step  = userInfoDAO.updateByUsername(username);
			if(update1step) {
				// 密碼
				String password = req.getParameter("password");
				// 性別
				String gender = req.getParameter("gender");
				// 专业
				String major = req.getParameter("major");
				// 简介
				String intro = req.getParameter("intro");
				
				UserInfo userInfo = new UserInfo(username,password,gender,major,intro);
				updateUserinfoFlag = userInfoDAO.save(userInfo);
			}
			
			HobbyDAO hobbyDao = new HobbyDAO();
			boolean update2step  = hobbyDao.updateByUsername(username);
			
			if(update2step) {
				String[] hobbyArray =req.getParameterValues("hobby");
				Hobby hobby =new Hobby();
				hobby.setUsername(username);
				hobby.setHobbyArray(hobbyArray);
				updatehobbyFlag = hobbyDao.insertHObby(hobby);
			}
			
			if(updateUserinfoFlag && updatehobbyFlag) {
				resp.sendRedirect("userUpdateSuccess.jsp");
			}else {
				System.out.println("出错了");
			}
			
		}
		
		
		if(handle.equals(DELETEFLAG)) {
			String username = req.getParameter("username");
			UserInfoDAO userInfoDAO = new UserInfoDAO();
			boolean update1step  = userInfoDAO.updateByUsername(username);  
			HobbyDAO hobbyDao = new HobbyDAO();
			boolean update2step  = hobbyDao.updateByUsername(username);
			
			if(update1step && update2step) {
				resp.sendRedirect("userUpdateSuccess.jsp");
			}else {
				System.out.println("出错了");
			}
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
