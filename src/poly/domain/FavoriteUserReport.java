package poly.domain;

import java.util.Date;

public class FavoriteUserReport {
	private int userID;
	private String username, email;
	private Date likeDate;
	
	public FavoriteUserReport() {
	}

	public FavoriteUserReport(int userID, String username, String email, Date likeDate) {
		this.userID = userID;
		this.username = username;
		this.email = email;
		this.likeDate = likeDate;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
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

	public Date getLikeDate() {
		return likeDate;
	}

	public void setLikeDate(Date likeDate) {
		this.likeDate = likeDate;
	}
	
}
