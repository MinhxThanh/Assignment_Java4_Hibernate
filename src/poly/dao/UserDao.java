package poly.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import poly.model.User;

public class UserDao extends AbstractEntityDao<User>{

	public UserDao() {
		super(User.class);
		// TODO Auto-generated constructor stub
	}
	
	public User Login(String email, String password) {
		EntityManager em = JpaUtils.getEntityManager();
		String sql = "SELECT o FROM User o WHERE o.email = ?0 AND o.password = ?1";
		TypedQuery<User> query = em.createQuery(sql, User.class);
    	query.setParameter(0, email);
    	query.setParameter(1, password);
		
		List<User> result = query.getResultList();
		if (result.isEmpty()) {
			return null;
		}
		System.out.println("Login success!");
		return result.get(0);
	}
	
	public User findByEmail(String email) {
		EntityManager em = JpaUtils.getEntityManager();
		String sql = "SELECT o FROM User o WHERE o.email = ?0";
		TypedQuery<User> query = em.createQuery(sql, User.class);
    	query.setParameter(0, email);
		
		List<User> result = query.getResultList();
		if (result.isEmpty()) {
			return null;
		}
		System.out.println("Findding success!");
		return result.get(0);
	}
	
	public void changePassword(String email, String oldPassword, String newPassword) throws Exception {
		EntityManager eManager = JpaUtils.getEntityManager();
		
		EntityTransaction transaction = eManager.getTransaction();
		
		String jpql = "SELECT o FROM User o WHERE o.email = ?0 AND o.password = ?1";
		try {
			transaction.begin();
			TypedQuery<User> query = eManager.createQuery(jpql, User.class);
			query.setParameter(0, email);
	    	query.setParameter(1, oldPassword);
	    	
	    	User user = query.getSingleResult();
	    	if (user == null) {
				throw new Exception("New Password Or Old Password Incorrect!");
			}
	    	user.setPassword(newPassword);
	    	
	    	eManager.merge(user);
	    	
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			throw e;
		}finally {
			eManager.close();
		}
	}
	
}
