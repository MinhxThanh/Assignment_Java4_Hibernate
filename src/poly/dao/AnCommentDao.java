package poly.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import poly.model.AnConmment;

public class AnCommentDao extends AbstractEntityDao<AnConmment>{

	public AnCommentDao() {
		super(AnConmment.class);
		// TODO Auto-generated constructor stub
	}
	public List<AnConmment> getAllCommmentByVideoIDAndCommentID(int videoID, int commentID) {
		String jpql = "select c from AnConmment c where c.video.videoID = ?0 and c.comment.commentID = ?1 ORDER BY CreateDate DESC";
//		String jpql = "select c from Comment c where c.video.videoID = ?0 ORDER BY CreateDate DESC";

		EntityManager eManager = JpaUtils.getEntityManager();
		
		List<AnConmment> list = null;
		try {
			TypedQuery<AnConmment> query = eManager.createQuery(jpql, AnConmment.class);
			
			query.setParameter(0, videoID);
			query.setParameter(1, commentID);
			
			list = query.getResultList();
		} finally {
			eManager.close(); 
		}
		return list;
	}
	
	public List<AnConmment> getAllCommmentByVideoID(int videoID) {
		String jpql = "select a from AnConmment a where a.video.videoID = ?0 ORDER BY CreateDate DESC";
	
		EntityManager eManager = JpaUtils.getEntityManager();
		
		List<AnConmment> list = null;
		try {
			TypedQuery<AnConmment> query = eManager.createQuery(jpql, AnConmment.class);
			
			query.setParameter(0, videoID);
			
			
			list = query.getResultList();
		} finally {
			eManager.close(); 
		}
		return list;
	}
}
