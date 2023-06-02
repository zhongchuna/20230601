package co.jp.netwisdom.servlet;     

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jp.netwisdom.dao.HobbyDAO;
import co.jp.netwisdom.dao.UserInfoDAO;
import co.jp.netwisdom.entity.UserInfo;

public class UserDelServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 姓名
		String username = request.getParameter("username");
		
		HobbyDAO hobbyDao = new HobbyDAO();		
		boolean updateHobbyFlg = true;

		//用户爱好表伦理删除
		
		updateHobbyFlg = hobbyDao.delHobby(username);

		if(updateHobbyFlg) {
			System.out.println("用户爱好表伦理删除成功！");
		}else {
			System.out.println("用户爱好表伦理删除失败  再接再厉！");
		}

		
		
		UserInfoDAO userinfoDAO = new UserInfoDAO();

		UserInfo userInfo = new UserInfo();
		userInfo.setUsername(username);
		 
		boolean updateUserInfoFlg = true;

		//用户信息表伦理删除
		
		updateUserInfoFlg = userinfoDAO.delUserInfo(username);
		
		//
		userinfoDAO.delUserInfo(username);
		
		//if(updateUserInfoFlg = true){
			//跳转用户更新成功页面  
			request.getRequestDispatcher("/userSearch.jsp").forward(request, response);
		//}else {
			//跳转童虎更新失败页面
			//request.getRequestDispatcher("/userUpdateErr.jsp").forward(request, response);
		// }
		
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}