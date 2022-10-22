package poly.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Comment database table.
 * 
 */
@Entity
@NamedQuery(name="Comment.findAll", query="SELECT c FROM Comment c")
public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int commentID;

	@Column(name="Title")
	private String title;

	@Column(name="Content")
	private String content;

	@Column(name="CreateDate")
	private Date createDate;

	@Column(name="Image")
	private String image;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="UserID")
	private User user;

	//bi-directional many-to-one association to Video
	@ManyToOne
	@JoinColumn(name="VideoID")
	private Video video;

	//bi-directional many-to-one association to AnConmment
	@OneToMany(mappedBy="comment")
	private List<AnConmment> anConmments;

	//bi-directional many-to-one association to Notification
	@OneToMany(mappedBy="comment")
	private List<Notification> notifications;

	public Comment() {
	}

	public int getCommentID() {
		return this.commentID;
	}

	public void setCommentID(int commentID) {
		this.commentID = commentID;
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

	public List<AnConmment> getAnConmments() {
		return this.anConmments;
	}

	public void setAnConmments(List<AnConmment> anConmments) {
		this.anConmments = anConmments;
	}

	public AnConmment addAnConmment(AnConmment anConmment) {
		getAnConmments().add(anConmment);
		anConmment.setComment(this);

		return anConmment;
	}

	public AnConmment removeAnConmment(AnConmment anConmment) {
		getAnConmments().remove(anConmment);
		anConmment.setComment(null);

		return anConmment;
	}

	public List<Notification> getNotifications() {
		return this.notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public Notification addNotification(Notification notification) {
		getNotifications().add(notification);
		notification.setComment(this);

		return notification;
	}

	public Notification removeNotification(Notification notification) {
		getNotifications().remove(notification);
		notification.setComment(null);

		return notification;
	}

}