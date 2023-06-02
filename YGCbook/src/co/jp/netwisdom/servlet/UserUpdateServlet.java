package co.jp.netwisdom.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jp.netwisdom.dao.HobbyDAO;
import co.jp.netwisdom.dao.UserInfoDAO;
import co.jp.netwisdom.entity.Hobby;
import co.jp.netwisdom.entity.UserInfo;

public class UserUpdateServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 姓名
		String username = request.getParameter("username");
		// 密碼
		String password = request.getParameter("password");
		// 性別
		String sex = request.getParameter("sex7");
		// 专业
		String major = request.getParameter("major");
		// 简介
		String intro = request.getParameter("intro");
		
		// 爱好
		String[] hobbyArray = request.getParameterValues("hobby");

		List<Hobby> hobbyList = new ArrayList<>();
		
		for (String rs : hobbyArray) {
			
			Hobby hobby = new Hobby(); 
			hobby.setUsername(username);
			hobby.setHoppy(rs);
			hobbyList.add(hobby);
			
		}
		
		HobbyDAO hobbyDao = new HobbyDAO();
		boolean hobbyFlag = hobbyDao.save(hobbyList);
		
		
		boolean updateHobbyFlg = true;

		//用户爱好表伦理删除
		
		updateHobbyFlg = hobbyDao.delHobby(username);
		//用户爱好表登录    
		updateHobbyFlg = hobbyDao.save(hobbyList);
		//

	
		if(updateHobbyFlg) {
			System.out.println("用户爱好表更新成功，问题不大");
		}else {
			System.out.println("用户爱好表更新失败，问题不大");
		}

		
		
		UserInfoDAO userinfoDAO = new UserInfoDAO();

		UserInfo userInfo = new UserInfo();
		userInfo.setUsername(username);
		userInfo.setPassword(password);
		userInfo.setSex(sex);
		userInfo.setMajor(major);
		userInfo.setIntro(intro);
		//用户更新FLG
		boolean updateUserInfoFlg = true;

		//用户信息表伦理删除
		
		updateUserInfoFlg = userinfoDAO.delUserInfo(username);
		//用户信息表登录    
		updateUserInfoFlg = userinfoDAO.save(new UserInfo(username,password,sex,major,intro));
		//
		userinfoDAO.delUserInfo(username);
		userinfoDAO.save(new UserInfo(username,password,sex,major,intro));
		
		if(updateUserInfoFlg = true){
			//跳转用户更新成功页面
			request.getRequestDispatcher("/userUpdateSuccess.jsp").forward(request, response);
		}else {
			//跳转童虎更新失败页面
			request.getRequestDispatcher("/userUpdateErr.jsp").forward(request, response);
		 }
		
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}