package poly.domain;

public class ChangePassword {
	String email, oldPassword, newPassword, comfrimPassword;

	public ChangePassword() {
	}

	public ChangePassword(String email, String oldPassword, String newPassword, String comfrimPassword) {
		this.email = email;
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
		this.comfrimPassword = comfrimPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getComfrimPassword() {
		return comfrimPassword;
	}

	public void setComfrimPassword(String comfrimPassword) {
		this.comfrimPassword = comfrimPassword;
	}
	
}
