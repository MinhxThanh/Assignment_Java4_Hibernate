package poly.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the VideoEp database table.
 * 
 */
@Entity
@NamedQuery(name="VideoEp.findAll", query="SELECT v FROM VideoEp v")
public class VideoEp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="VideoEpID")
	private int videoEpID;

	@Column(name="Content")
	private String content;

	//bi-directional many-to-one association to Video
	@ManyToOne
	@JoinColumn(name="VideoID")
	private Video video;

	public VideoEp() {
	}

	public int getVideoEpID() {
		return this.videoEpID;
	}

	public void setVideoEpID(int videoEpID) {
		this.videoEpID = videoEpID;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Video getVideo() {
		return this.video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

}