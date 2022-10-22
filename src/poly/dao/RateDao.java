package poly.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import poly.model.Rate;

public class RateDao extends AbstractEntityDao<Rate>{

	public RateDao() {
		super(Rate.class);
		// TODO Auto-generated constructor stub
	}

	public Rate findUseridAndVideoidInRate(int userID, int videoID) {
		EntityManager em = JpaUtils.getEntityManager();
		String sql = "SELECT o FROM Rate o WHERE o.user.userID = ?0 and o.video.videoID = ?1";
		TypedQuery<Rate> query = em.createQuery(sql, Rate.class);
    	query.setParameter(0, userID);
    	query.setParameter(1, videoID);
		
		List<Rate> result = query.getResultList();
		if (result.isEmpty()) {
			return null;
		}
		System.out.println("Findding success!");
		return result.get(0);
	}
	public Rate findUserRate(int userID) {
		EntityManager em = JpaUtils.getEntityManager();
		String sql = "SELECT o FROM Rate o WHERE o.user.userID = ?0";
		TypedQuery<Rate> query = em.createQuery(sql, Rate.class);
    	query.setParameter(0, userID);
		
		List<Rate> result = query.getResultList();
		if (result.isEmpty()) {
			return null;
		}
		System.out.println("Findding success!");
		return result.get(0);
	}
	
	public double getMediumRatingVideo(int videoID) {
		EntityManager eManager = JpaUtils.getEntityManager();
		TypedQuery<Double> query = eManager.createQuery("SELECT SUM(r.point)/COUNT(r.user.userID) FROM Rate r WHERE r.video.videoID = ?0", Double.class);
		query.setParameter(0, videoID);
		if (query.getSingleResult() == null) {
			return 0;
		}
		
		System.out.println("getMediumRatingVideo: " + query.getSingleResult());
		return query.getSingleResult();
	}

	public Long getTotalUserRated(int videoID) {
		EntityManager eManager = JpaUtils.getEntityManager();
		TypedQuery<Long> query = eManager.createQuery("SELECT COUNT(r.user.userID) FROM Rate r WHERE r.video.videoID = ?0", Long.class);
		query.setParameter(0, videoID);
		if (query.getSingleResult() == null) {
			return null;
		}
		return query.getSingleResult();
	}
}
