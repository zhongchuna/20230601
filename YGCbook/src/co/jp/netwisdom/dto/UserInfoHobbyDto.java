 package co.jp.netwisdom.dto;

import java.util.ArrayList;
import java.util.List;

public class UserInfoHobbyDto {
	private  String username;
	private  String password;
	private  String sex;
	private  String major;
	private  String intro;
	private  List<HobbyDto> hobbyList = new ArrayList<>();
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	
	public UserInfoHobbyDto(String username, String password, String sex, String major, String intro) {
		super();
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.major = major;
		this.intro = intro;
		
	}
	public UserInfoHobbyDto() {
		super();
		
	}
	public List<HobbyDto> getHobbyList() {
		return hobbyList;
	}
	public void setHobbyList(List<HobbyDto> hobbyList) {
		this.hobbyList = hobbyList;
	} 
	
	
}
