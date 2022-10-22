package poly.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the Notification database table.
 * 
 */
@Entity
@NamedQuery(name="Notification.findAll", query="SELECT n FROM Notification n")
public class Notification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="NotificationID")
	private int notificationID;

	@Column(name="Content")
	private String content;

	@Column(name="CreateDate")
	private Date createDate;

	@Column(name="Image")
	private String image;

	@Column(name="Title")
	private String title;

	//bi-directional many-to-one association to Comment
	@ManyToOne
	@JoinColumn(name="CommentID")
	private Comment comment;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="UserID")
	private User user;

	//bi-directional many-to-one association to Video
	@ManyToOne
	@JoinColumn(name="VideoID")
	private Video video;

	public Notification() {
	}

	public int getNotificationID() {
		return this.notificationID;
	}

	public void setNotificationID(int notificationID) {
		this.notificationID = notificationID;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Comment getComment() {
		return this.comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Video getVideo() {
		return this.video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

}