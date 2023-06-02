package co.jp.netwisdom.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import co.jp.netwisdom.dao.UserInfoDAO;
import co.jp.netwisdom.dto.HobbyDto;
import co.jp.netwisdom.dto.UserInfoHobbyDto;
import co.jp.netwisdom.entity.UserInfoHobby;
import co.jp.netwisdom.form.UserForm;

public class UserSearchAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 姓名
		UserForm userForm = (UserForm) form;
		String username = userForm.getUsername();

		// 性別
		String sex = userForm.getSex();
		// 专业
		String major = userForm.getMajor();

		// 我们要使用UserInfoDAO里面的findUserInfoAndHobby方法，就必须先new 一个UserInfoDAO的实体对象
		UserInfoDAO userinfoDAO = new UserInfoDAO();

		// 调用dao里面的findUserInfoAndHobby，三个参数username sex major，返回值是List<UserInfoHobby>
		List<UserInfoHobby> list = userinfoDAO.findUserInfoAndHobby(username, sex, major);
		List<UserInfoHobbyDto> dtos = new ArrayList<UserInfoHobbyDto>();
		// Map<String,String>userNameMap = new HashMap<String,String>();
		List<String> userNames = new ArrayList<String>();

		System.out.println("用户信息如下:");
		for (UserInfoHobby userinfoHobby : list) {

			if (!userNames.contains(userinfoHobby.getUsername())) {
				UserInfoHobbyDto dto = new UserInfoHobbyDto(userinfoHobby.getUsername(), userinfoHobby.getPassword(),
						userinfoHobby.getSex(), userinfoHobby.getMajor(), userinfoHobby.getIntro());
				dtos.add(dto);
				userNames.add(userinfoHobby.getUsername());

				dto.getHobbyList().add(new HobbyDto(userinfoHobby.getHobby()));
			} else {
				// 取得以往添加过的大的dto
				for (UserInfoHobbyDto temp : dtos) {
					if (temp.getUsername().equals(userinfoHobby.getUsername())) {
						temp.getHobbyList().add(new HobbyDto(userinfoHobby.getHobby()));
					}
				}
			}
		}
		for (UserInfoHobbyDto result : dtos) {
			System.out.println("------------------------------");
			System.out.println("姓名:" + result.getUsername());
			System.out.println("密码:" + result.getPassword());
			System.out.println("性别:" + result.getSex());
			System.out.println("专业:" + result.getMajor());
			System.out.println("简介:" + result.getIntro());
			System.out.println("爱好是：");
			StringBuffer sb = new StringBuffer("");
			for (HobbyDto hobbyDto : result.getHobbyList()) {
				// System.out.print(hobbyDto.getHobby() + ",");
				sb.append(hobbyDto.getHobby() + ",");
			}
			if (",".equals(sb.toString().substring(sb.toString().length() - 1))) {
				System.out.print(sb.toString().substring(0, sb.toString().length() - 1));
			} else {
				System.out.print(sb.toString());
			}

		}

		// 把咱们的dtos传给前台  
		request.setAttribute("dtos", dtos);

		// 查询成功后原地跳转
		return mapping.findForward("userSearch");
	}
}