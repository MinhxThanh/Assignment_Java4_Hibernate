package poly.domain;

import java.util.Date;

public class CommentUser {
	int userID, videoID;
	private String title, content;
	private Date createDate;
	
	public CommentUser() {
	}

	public CommentUser(int userID, int videoID, String title, String content, Date createDate) {
		this.userID = userID;
		this.videoID = videoID;
		this.title = title;
		this.content = content;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
