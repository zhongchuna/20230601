package co.jp.netwisdom.action;     

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import co.jp.netwisdom.dao.HobbyDAO;
import co.jp.netwisdom.dao.UserInfoDAO;
import co.jp.netwisdom.entity.UserInfo;
import co.jp.netwisdom.form.UserForm;

public class UserDelAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserForm userForm = (UserForm) form;
		String username = userForm.getUsername();
				
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
					return mapping.findForward("userSearch");
				//}else {
					//跳转童虎更新失败页面
					//request.getRequestDispatcher("/userUpdateErr.jsp").forward(request, response);
				// }
	}


}