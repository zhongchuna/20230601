package co.jp.netwisdom.entity;
/**
 *
 * @author baijianguang   8888888
 *
 */
public class Hobby {
	private String username;
	private String hoppy;
	  
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getHoppy() {
		return hoppy;
	}
	public void setHoppy(String hoppy) {
		this.hoppy = hoppy;
	}
	public Hobby(String username, String hoppy) {
		super();
		this.username = username;
		this.hoppy = hoppy;
	}
	public Hobby() {
		super();
		
	}



}
