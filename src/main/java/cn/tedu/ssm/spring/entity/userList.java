package cn.tedu.ssm.spring.entity;

public class userList {
	private int id ;
	private String username;

	private String email;

	private String mobile;

	private String state;
	
	private String stateStr;

	public userList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public userList(int id, String username, String email, String mobile, String state, String stateStr) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.mobile = mobile;
		this.state = state;
		this.stateStr = stateStr;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStateStr() {
		return stateStr;
	}

	public void setStateStr(String stateStr) {
		this.stateStr = stateStr;
	}

	@Override
	public String toString() {
		return "userList [id=" + id + ", username=" + username + ", email=" + email + ", mobile=" + mobile + ", state="
				+ state + ", stateStr=" + stateStr + "]";
	}
	
}
