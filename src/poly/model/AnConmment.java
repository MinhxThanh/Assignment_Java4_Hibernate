package poly.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the AnConmment database table.
 * 
 */
@Entity
@NamedQuery(name="AnConmment.findAll", query="SELECT a FROM AnConmment a")
public class AnConmment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="AnCommentID")
	private int anCommentID;

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

	public AnConmment() {
	}

	public int getAnCommentID() {
		return this.anCommentID;
	}

	public void setAnCommentID(int anCommentID) {
		this.anCommentID = anCommentID;
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