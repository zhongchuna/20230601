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

public class UserRegAction extends Action {

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

		// 爱好
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

		UserInfoDAO userinfoDAO = new UserInfoDAO();

		UserInfo userInfo = new UserInfo();
		userInfo.setUsername(username);
		userInfo.setPassword(password);
		userInfo.setSex(sex);
		userInfo.setMajor(major);
		userInfo.setIntro(intro);

		boolean flg = userinfoDAO.save(userInfo);

		if (flg = true) {	
			return mapping.findForward("success");
		} else {		
			return mapping.findForward("Err");
		}
	}

}