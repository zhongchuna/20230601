package co.jp.netwisdom.form;

import org.apache.struts.action.ActionForm;

public class UserForm extends ActionForm {
	 // 姓名
	private String Username ;
	// 密碼
	private String Password ;
	// 性別 
	private String Sex ;
	// 专业
	private String Major ;
	// 简介
	private String Intro ;
	
	// 爱好
	private String[] Hobby; 

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		this.Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		this.Password = password;
	}

	public String getSex() {
		return Sex;
	}

	public void setSex(String sex) {
		this.Sex = sex;
	}

	public String getMajor() {
		return Major;
	}

	public void setMajor(String major) {
		this.Major = major;
	}

	public String getIntro() {
		return Intro;
	}

	public void setIntro(String intro) {
		this.Intro = intro;
	}

	public String[] getHobby() {
		return Hobby;
	}

	public void setHobby(String[] hobby) {
		this.Hobby = hobby;
	}

	

}
