package poly.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the VideoCountry database table.
 * 
 */
@Entity
@NamedQuery(name="VideoCountry.findAll", query="SELECT v FROM VideoCountry v")
public class VideoCountry implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int videoCountryID;

	@Column(name="Name")
	private String name;

	//bi-directional many-to-one association to Video
	@OneToMany(mappedBy="videoCountry")
	private List<Video> videos;

	public VideoCountry() {
	}

	public int getVideoCountryID() {
		return this.videoCountryID;
	}

	public void setVideoCountryID(int videoCountryID) {
		this.videoCountryID = videoCountryID;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Video> getVideos() {
		return this.videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

	public Video addVideo(Video video) {
		getVideos().add(video);
		video.setVideoCountry(this);

		return video;
	}

	public Video removeVideo(Video video) {
		getVideos().remove(video);
		video.setVideoCountry(null);

		return video;
	}

}