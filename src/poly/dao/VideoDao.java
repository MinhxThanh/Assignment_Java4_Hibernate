package poly.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import poly.model.Video;

public class VideoDao extends AbstractEntityDao<Video>{

	public VideoDao() {
		super(Video.class);
		// TODO Auto-generated constructor stub
	}
	
	public List<Video> getVideoPaging(int page) {
		EntityManager eManager = JpaUtils.getEntityManager();
		TypedQuery<Video> query = eManager.createQuery("FROM Video ORDER BY CreateDate DESC", Video.class);
		query.setFirstResult(page * 4);
		query.setMaxResults(4);
		return query.getResultList();
	}

	public Long getTotalPage() {
		EntityManager eManager = JpaUtils.getEntityManager();
		TypedQuery<Long> query = eManager.createQuery("SELECT COUNT(*) FROM Video", Long.class);
		return (long) Math.ceil(query.getSingleResult() / 4.0);
	}
}
