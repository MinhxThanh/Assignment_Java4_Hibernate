package poly.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Video database table.
 * 
 */
@Entity
@NamedQuery(name="Video.findAll", query="SELECT v FROM Video v")
public class Video implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int videoID;

	@Column(name="Action")
	private int action;

	@Column(name="CreateDate")
	private Date createDate;

	@Column(name="DesCription")
	private String desCription;

	@Column(name="OtherName")
	private String otherName;

	@Column(name="Poster")
	private String poster;

	@Column(name="Title")
	private String title;

	@Column(name="Views")
	private int views;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="video")
	private List<Comment> comments;

	//bi-directional many-to-one association to Favorite
	@OneToMany(mappedBy="video")
	private List<Favorite> favorites;

	//bi-directional many-to-one association to History
	@OneToMany(mappedBy="video")
	private List<History> histories;

	//bi-directional many-to-one association to Rate
	@OneToMany(mappedBy="video")
	private List<Rate> rates;

	//bi-directional many-to-one association to Share
	@OneToMany(mappedBy="video")
	private List<Share> shares;

	//bi-directional many-to-one association to VideoCountry
	@ManyToOne
	@JoinColumn(name="VideoCountryID")
	private VideoCountry videoCountry;

	//bi-directional many-to-one association to VideoType
	@ManyToOne
	@JoinColumn(name="VideoTypeID")
	private VideoType videoType;

	//bi-directional many-to-one association to VideoEp
	@OneToMany(mappedBy="video")
	private List<VideoEp> videoEps;

	//bi-directional many-to-one association to AnConmment
	@OneToMany(mappedBy="video")
	private List<AnConmment> anConmments;

	//bi-directional many-to-one association to Notification
	@OneToMany(mappedBy="video")
	private List<Notification> notifications;

	public Video() {
	}

	public int getVideoID() {
		return this.videoID;
	}

	public void setVideoID(int videoID) {
		this.videoID = videoID;
	}

	public int getAction() {
		return this.action;
	}

	public void setAction(int action) {
		this.action = action;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDesCription() {
		return this.desCription;
	}

	public void setDesCription(String desCription) {
		this.desCription = desCription;
	}

	public String getOtherName() {
		return this.otherName;
	}

	public void setOtherName(String otherName) {
		this.otherName = otherName;
	}

	public String getPoster() {
		return this.poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getViews() {
		return this.views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setVideo(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setVideo(null);

		return comment;
	}

	public List<Favorite> getFavorites() {
		return this.favorites;
	}

	public void setFavorites(List<Favorite> favorites) {
		this.favorites = favorites;
	}

	public Favorite addFavorite(Favorite favorite) {
		getFavorites().add(favorite);
		favorite.setVideo(this);

		return favorite;
	}

	public Favorite removeFavorite(Favorite favorite) {
		getFavorites().remove(favorite);
		favorite.setVideo(null);

		return favorite;
	}

	public List<History> getHistories() {
		return this.histories;
	}

	public void setHistories(List<History> histories) {
		this.histories = histories;
	}

	public History addHistory(History history) {
		getHistories().add(history);
		history.setVideo(this);

		return history;
	}

	public History removeHistory(History history) {
		getHistories().remove(history);
		history.setVideo(null);

		return history;
	}

	public List<Rate> getRates() {
		return this.rates;
	}

	public void setRates(List<Rate> rates) {
		this.rates = rates;
	}

	public Rate addRate(Rate rate) {
		getRates().add(rate);
		rate.setVideo(this);

		return rate;
	}

	public Rate removeRate(Rate rate) {
		getRates().remove(rate);
		rate.setVideo(null);

		return rate;
	}

	public List<Share> getShares() {
		return this.shares;
	}

	public void setShares(List<Share> shares) {
		this.shares = shares;
	}

	public Share addShare(Share share) {
		getShares().add(share);
		share.setVideo(this);

		return share;
	}

	public Share removeShare(Share share) {
		getShares().remove(share);
		share.setVideo(null);

		return share;
	}

	public VideoCountry getVideoCountry() {
		return this.videoCountry;
	}

	public void setVideoCountry(VideoCountry videoCountry) {
		this.videoCountry = videoCountry;
	}

	public VideoType getVideoType() {
		return this.videoType;
	}

	public void setVideoType(VideoType videoType) {
		this.videoType = videoType;
	}

	public List<VideoEp> getVideoEps() {
		return this.videoEps;
	}

	public void setVideoEps(List<VideoEp> videoEps) {
		this.videoEps = videoEps;
	}

	public VideoEp addVideoEp(VideoEp videoEp) {
		getVideoEps().add(videoEp);
		videoEp.setVideo(this);

		return videoEp;
	}

	public VideoEp removeVideoEp(VideoEp videoEp) {
		getVideoEps().remove(videoEp);
		videoEp.setVideo(null);

		return videoEp;
	}

	public List<AnConmment> getAnConmments() {
		return this.anConmments;
	}

	public void setAnConmments(List<AnConmment> anConmments) {
		this.anConmments = anConmments;
	}

	public AnConmment addAnConmment(AnConmment anConmment) {
		getAnConmments().add(anConmment);
		anConmment.setVideo(this);

		return anConmment;
	}

	public AnConmment removeAnConmment(AnConmment anConmment) {
		getAnConmments().remove(anConmment);
		anConmment.setVideo(null);

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
		notification.setVideo(this);

		return notification;
	}

	public Notification removeNotification(Notification notification) {
		getNotifications().remove(notification);
		notification.setVideo(null);

		return notification;
	}

}