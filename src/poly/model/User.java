package poly.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Users database table.
 * 
 */
@Entity
@Table(name="Users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userID;

	@Column(name="Country")
	private String country;

	@Column(name="CreateDate")
	private Date createDate;

	@Column(name="Email")
	private String email;

	@Column(name="Image")
	private String image;

	@Column(name="Password")
	private String password;

	@Column(name="Role")
	private int role;

	@Column(name="Username")
	private String username;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="user")
	private List<Comment> comments;

	//bi-directional many-to-one association to Favorite
	@OneToMany(mappedBy="user")
	private List<Favorite> favorites;

	//bi-directional many-to-one association to History
	@OneToMany(mappedBy="user")
	private List<History> histories;

	//bi-directional many-to-one association to Rate
	@OneToMany(mappedBy="user")
	private List<Rate> rates;

	//bi-directional many-to-one association to Share
	@OneToMany(mappedBy="user")
	private List<Share> shares;

	//bi-directional many-to-one association to AnConmment
	@OneToMany(mappedBy="user")
	private List<AnConmment> anConmments;

	//bi-directional many-to-one association to Notification
	@OneToMany(mappedBy="user")
	private List<Notification> notifications;

	public User() {
	}

	public int getUserID() {
		return this.userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date object) {
		this.createDate = object;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole() {
		return this.role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setUser(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setUser(null);

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
		favorite.setUser(this);

		return favorite;
	}

	public Favorite removeFavorite(Favorite favorite) {
		getFavorites().remove(favorite);
		favorite.setUser(null);

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
		history.setUser(this);

		return history;
	}

	public History removeHistory(History history) {
		getHistories().remove(history);
		history.setUser(null);

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
		rate.setUser(this);

		return rate;
	}

	public Rate removeRate(Rate rate) {
		getRates().remove(rate);
		rate.setUser(null);

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
		share.setUser(this);

		return share;
	}

	public Share removeShare(Share share) {
		getShares().remove(share);
		share.setUser(null);

		return share;
	}

	public List<AnConmment> getAnConmments() {
		return this.anConmments;
	}

	public void setAnConmments(List<AnConmment> anConmments) {
		this.anConmments = anConmments;
	}

	public AnConmment addAnConmment(AnConmment anConmment) {
		getAnConmments().add(anConmment);
		anConmment.setUser(this);

		return anConmment;
	}

	public AnConmment removeAnConmment(AnConmment anConmment) {
		getAnConmments().remove(anConmment);
		anConmment.setUser(null);

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
		notification.setUser(this);

		return notification;
	}

	public Notification removeNotification(Notification notification) {
		getNotifications().remove(notification);
		notification.setUser(null);

		return notification;
	}

}