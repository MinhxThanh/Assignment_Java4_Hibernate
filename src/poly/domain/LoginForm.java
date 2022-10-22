package poly.domain;

public class LoginForm {
	private String email, password;
	private boolean remember;
	
	 
	public LoginForm() {

	}
	public LoginForm(String email, String password, boolean remember) {
		this.email = email;
		this.password = password;
		this.remember = remember;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isRemember() {
		return remember;
	}
	public void setRemember(boolean remember) {
		this.remember = remember;
	}	
}
