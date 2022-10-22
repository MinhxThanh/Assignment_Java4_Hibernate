package poly.dao;

import javax.persistence.EntityManager;

import poly.model.VideoCountry;

public class VideoCountryDao extends AbstractEntityDao<VideoCountry>{

	public VideoCountryDao() {
		super(VideoCountry.class);
		// TODO Auto-generated constructor stub
	}
	
	public VideoCountry findByID(VideoCountry id) {
		EntityManager eManager = JpaUtils.getEntityManager();

		VideoCountry entityT = eManager.find(VideoCountry.class, id);

		return entityT;
	}
}
