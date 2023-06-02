package co.jp.netwisdom.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jp.netwisdom.dao.UserInfoDAO;
import co.jp.netwisdom.dto.HobbyDto;
import co.jp.netwisdom.dto.UserInfoHobbyDto;
import co.jp.netwisdom.entity.UserInfoHobby;

public class UserUpdateInitServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		/*
		 * 前台拿到的搜索条件
		 */
		// 姓名
		String userName = request.getParameter("username");	
		// 我们要使用UserInfoDAO里面的findUserInfoAndHobby方法，就必须先new 一个UserInfoDAO的实体对象
		UserInfoDAO userinfoDAO = new UserInfoDAO();
		
		// 调用dao里面的findUserInfoAndHobby，三个参数username sex major，返回值是List<UserInfoHobby>
		List<UserInfoHobby> list = userinfoDAO.findUserInfoAndHobby(userName);
		List<UserInfoHobbyDto> dtos = new ArrayList<UserInfoHobbyDto>();
		//Map<String,String>userNameMap = new HashMap<String,String>();
		List<String>userNames= new ArrayList<String>();
		
		System.out.println("用户信息如下:");
		for(UserInfoHobby userinfoHobby: list) {
			
		   if(!userNames.contains(userinfoHobby.getUsername())) {
			   UserInfoHobbyDto dto = new UserInfoHobbyDto(
						userinfoHobby.getUsername(),
						userinfoHobby.getPassword(),
				 		userinfoHobby.getSex(),
						userinfoHobby.getMajor(),
						userinfoHobby.getIntro());
			   dtos.add(dto);
			   userNames.add(userinfoHobby.getUsername());
		  
		   dto.getHobbyList().add(new HobbyDto(userinfoHobby.getHobby()));
		   }else {
			   //取得以往添加过的大的dto
			   for(UserInfoHobbyDto temp : dtos) {
				   if(temp.getUsername().equals(userinfoHobby.getUsername())) {
					  temp.getHobbyList().add(new HobbyDto(userinfoHobby.getHobby()));
				   }
			   }   
		   }		
		}
		// 把咱们的dtos传给前台
		request.setAttribute("dto", dtos.get(0));
		List<String> hobbys = new ArrayList<>();
		for(HobbyDto rs : dtos.get(0).getHobbyList()){
			
			hobbys.add(rs.getHobby());
			
		}
		request.setAttribute("hobbys", hobbys);
		
		// 查询成功后原地跳转
		request.getRequestDispatcher ("/userReg.jsp").forward(request, response);
		

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}