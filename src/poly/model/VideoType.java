package poly.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the VideoType database table.
 * 
 */
@Entity
@NamedQuery(name="VideoType.findAll", query="SELECT v FROM VideoType v")
public class VideoType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="VideoTypeID")
	private int videoTypeID;

	@Column(name="Name")
	private String name;

	//bi-directional many-to-one association to Video
	@OneToMany(mappedBy="videoType")
	private List<Video> videos;

	public VideoType() {
	}

	public int getVideoTypeID() {
		return this.videoTypeID;
	}

	public void setVideoTypeID(int videoTypeID) {
		this.videoTypeID = videoTypeID;
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
		video.setVideoType(this);

		return video;
	}

	public Video removeVideo(Video video) {
		getVideos().remove(video);
		video.setVideoType(null);

		return video;
	}

}