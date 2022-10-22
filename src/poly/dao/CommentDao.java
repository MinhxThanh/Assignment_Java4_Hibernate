package poly.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import poly.model.Comment;

public class CommentDao extends AbstractEntityDao<Comment>{

	public CommentDao() {
		super(Comment.class);
		// TODO Auto-generated constructor stub
	}

	public List<Comment> getAllCommmentByVideoID(int videoID) {
		String jpql = "select c from Comment c where c.video.videoID = ?0 ORDER BY CreateDate DESC";
	
		EntityManager eManager = JpaUtils.getEntityManager();
		
		List<Comment> list = null;
		try {
			TypedQuery<Comment> query = eManager.createQuery(jpql, Comment.class);
			
			query.setParameter(0, videoID);
			
			list = query.getResultList();
		} finally {
			eManager.close(); 
		}
		return list;
	}
}
