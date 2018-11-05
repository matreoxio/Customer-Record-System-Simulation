//Created by Mateusz Szymanski
//email - Matreoxioo@gmail.com

public class Manager {
	private String username;
	private String password;
	//TODO applications
	/*
	 * Constructor
	 */
	public Manager(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	/*
	 * set and get manager username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}
	
	/*
	 * set and get manager password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}
	
	
}
