package poly.domain;

import java.util.Date;

public class FavoriteUser {
	private int userID, videoID;
	private String title, poster;
	private Date createDate;
	
	public FavoriteUser() {
	}
	public FavoriteUser(int userID, int videoID, String title, String poster, Date createDate) {
		this.userID = userID;
		this.videoID = videoID;
		this.title = title;
		this.poster = poster;
		this.createDate = createDate;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getVideoID() {
		return videoID;
	}
	public void setVideoID(int videoID) {
		this.videoID = videoID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
