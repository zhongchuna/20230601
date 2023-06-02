package co.jp.netwisdom.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import co.jp.netwisdom.dao.HobbyDAO;
import co.jp.netwisdom.dao.UserInfoDAO;
import co.jp.netwisdom.entity.Hobby;
import co.jp.netwisdom.entity.UserInfo;
import co.jp.netwisdom.form.UserForm;

public class UserUpdateAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 姓名
		UserForm userForm = (UserForm) form;
		String username = userForm.getUsername();  
		// 密碼
		String password = userForm.getPassword();
		// 性別
		String sex = userForm.getSex();
		// 专业
		String major = userForm.getMajor();
		// 简介
		String intro = userForm.getIntro();
		String[] hobbyArray = userForm.getHobby();

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

		// 用户爱好表伦理删除

		updateHobbyFlg = hobbyDao.delHobby(username);
		// 用户爱好表登录
		updateHobbyFlg = hobbyDao.save(hobbyList);
		//

		if (updateHobbyFlg) {
			System.out.println("用户爱好表更新成功，问题不大");
		} else {
			System.out.println("用户爱好表更新失败，问题不大");
		}

		UserInfoDAO userinfoDAO = new UserInfoDAO();

		UserInfo userInfo = new UserInfo();
		userInfo.setUsername(username);
		userInfo.setPassword(password);
		userInfo.setSex(sex);
		userInfo.setMajor(major);
		userInfo.setIntro(intro);
		// 用户更新FLG
		boolean updateUserInfoFlg = true;

		// 用户信息表伦理删除

		updateUserInfoFlg = userinfoDAO.delUserInfo(username);
		// 用户信息表登录
		updateUserInfoFlg = userinfoDAO.save(new UserInfo(username, password, sex, major, intro));
		//
		userinfoDAO.delUserInfo(username);
		userinfoDAO.save(new UserInfo(username, password, sex, major, intro));

		if (updateUserInfoFlg = true) {
			// 跳转用户更新成功页面
			
			return mapping.findForward("userUpdateSuccess");
		} else {
			// 跳转童虎更新失败页面
			return mapping.findForward("userUpdateErr");
		}
		
	}

}