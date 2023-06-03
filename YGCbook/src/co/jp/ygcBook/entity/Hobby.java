package co.jp.ygcBook.entity;

public class Hobby {
	private String username;
	private String[] hobbyArray;
	private String hobby;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String[] getHobbyArray() {
		return hobbyArray;
	}
	public void setHobbyArray(String[] hobbyArray) {
		this.hobbyArray = hobbyArray;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public Hobby(String username, String[] hobbyArray, String hobby) {
		super();
		this.username = username;
		this.hobbyArray = hobbyArray;
		this.hobby = hobby;
	}
	public Hobby() {
		super();
		
	}
	


}
