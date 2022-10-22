package poly.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import poly.domain.FavoriteReport;
import poly.domain.FavoriteUser;
import poly.domain.FavoriteUserReport;
import poly.model.Favorite;

public class FavoriteDao extends AbstractEntityDao<Favorite>{

	public FavoriteDao() {
		super(Favorite.class);
		// TODO Auto-generated constructor stub
	}
	public Favorite deleteVideoFavoriteUser(int userID, int videoID) {
		Favorite entity = null; 
		String jpql = "from Favorite f WHERE f.user.userID = ?0 and f.video.videoID = ?1";
		EntityManager eManager = JpaUtils.getEntityManager();
		try {
			eManager.getTransaction().begin();
			
			TypedQuery<Favorite> query = eManager.createQuery(jpql, Favorite.class);
			
			query.setParameter(0, userID);
			query.setParameter(1, videoID);
			
			entity = query.getSingleResult();
			if (entity != null) {
				eManager.remove(entity);
			}
			eManager.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			eManager.getTransaction().rollback();
			throw e;
		} finally {
			eManager.close();
		}
		return entity;
	}
	
//	public Favorite remove(String idUser, String idVideo) {
//		Favorite entity = null;
//		em.getTransaction().begin();
//		try {
//			TypedQuery<Favorite> query = em.createQuery("FROM Favorite where user.id = :idUser AND video.id = :idVideo", Favorite.class);
//			query.setParameter("idUser", idUser);
//			query.setParameter("idVideo", idVideo);
//			entity = query.getSingleResult();
//			if(entity != null)
//				em.remove(entity);
//			em.getTransaction().commit();
//		} catch (Exception ex) {
//			em.getTransaction().rollback();
//		}
//		
//	}
	
	public List<FavoriteUser> favoriteUserVideo(int userID){
		String jpql = "select new poly.domain.FavoriteUser(f.user.userID, f.video.videoID, f.video.title, f.video.poster, "
				+ " f.video.createDate) from Favorite f where f.user.userID = ?0";
	
		EntityManager eManager = JpaUtils.getEntityManager();
		
		List<FavoriteUser> list = null;
		try {
			TypedQuery<FavoriteUser> query = eManager.createQuery(jpql, FavoriteUser.class);
			
			query.setParameter(0, userID);
			
			list = query.getResultList();
		} finally {
			eManager.close(); 
		}
		return list;
	}
	
	public List<FavoriteUserReport> reportFavoriteUsersByVideo(int videoID) {
		String jpql = "select new poly.domain.FavoriteUserReport(f.user.userID, f.user.username, "
				+ "f.user.email, f.likeDate) from Favorite f where f.video.videoID = ?0";
	
		EntityManager eManager = JpaUtils.getEntityManager();
		
		List<FavoriteUserReport> list = null;
		try {
			TypedQuery<FavoriteUserReport> query = eManager.createQuery(jpql, FavoriteUserReport.class);
			
			query.setParameter(0, videoID);
			
			list = query.getResultList();
		} finally {
			eManager.close(); 
		}
		return list;
	}
	
	public List<FavoriteReport> reportFavariteByViddeos() {
		String jpqlString = "select new poly.domain.FavoriteReport(f.video.title, count(f), min(f.likeDate), max(f.likeDate)) "
				+ " from Favorite f group by f.video.title ";
		
		EntityManager eManager = JpaUtils.getEntityManager();
		
		List<FavoriteReport> list = null;
		
		try {
			TypedQuery<FavoriteReport> query = eManager.createQuery(jpqlString, FavoriteReport.class);
			
			list = query.getResultList();
			
		} finally {
			eManager.close(); 
		}
		return list;
			
	}
}
