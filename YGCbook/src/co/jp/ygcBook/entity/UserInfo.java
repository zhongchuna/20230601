package co.jp.ygcBook.entity;

public class UserInfo {
	private  String username;
	private String password;
	private  String gender;
	private  String major;
	private  String intro;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
	public UserInfo(String username, String password, String gender, String major, String intro) {
		super();
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.major = major;
		this.intro = intro;
	}
	public UserInfo() {
		super();
		
	}
	
	

}
