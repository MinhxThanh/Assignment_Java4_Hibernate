package poly.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the Rate database table.
 * 
 */
@Entity
@NamedQuery(name="Rate.findAll", query="SELECT r FROM Rate r")
public class Rate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rateID;

	@Column(name="Point")
	private float point;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="UserID")
	private User user;

	//bi-directional many-to-one association to Video
	@ManyToOne
	@JoinColumn(name="VideoID")
	private Video video;

	public Rate() {
	}

	public int getRateID() {
		return this.rateID;
	}

	public void setRateID(int rateID) {
		this.rateID = rateID;
	}

	public float getPoint() {
		return this.point;
	}

	public void setPoint(float point) {
		this.point = point;
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