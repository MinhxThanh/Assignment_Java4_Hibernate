package poly.dao;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import java.util.List;

public abstract class AbstractEntityDao<T> {
	private Class<T> entityClass;

	public AbstractEntityDao(Class<T> cls) {
		this.entityClass = cls;
	}

	public void insert(T entity) {
		EntityManager eManager = JpaUtils.getEntityManager();

		EntityTransaction transaction = eManager.getTransaction();

		try {
			transaction.begin();

			eManager.persist(entity);

			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			throw e;
		} finally {
			eManager.close();
		}
	}

	public void update(T entity) {
		EntityManager eManager = JpaUtils.getEntityManager();

		EntityTransaction transaction = eManager.getTransaction();

		try {
			transaction.begin();

			eManager.merge(entity);

			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			throw e;
		} finally {
			eManager.close();
		}
	}

	public void dalete(int id) {
		EntityManager eManager = JpaUtils.getEntityManager();

		EntityTransaction transaction = eManager.getTransaction();

		try {
			transaction.begin();

			T entityT = eManager.find(entityClass, id);
			eManager.remove(entityT);

			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			throw e;
		} finally {
			eManager.close();
		}
	}

	public T findByID(int id) {
		EntityManager eManager = JpaUtils.getEntityManager();

		T entityT = eManager.find(entityClass, id);

		return entityT;
	}

	public List<T> findAll() {
		EntityManager eManager = JpaUtils.getEntityManager();
		try {
			CriteriaQuery criteriaQuery = eManager.getCriteriaBuilder().createQuery();

			criteriaQuery.select(criteriaQuery.from(entityClass));
			return eManager.createQuery(criteriaQuery).getResultList();
		} finally {
			eManager.close();
		}
	}
	
	public List<T> findAll(int pageIndex) {
		EntityManager eManager = JpaUtils.getEntityManager();
		try {
			CriteriaQuery criteriaQuery = eManager.getCriteriaBuilder().createQuery();
			
			criteriaQuery.select(criteriaQuery.from(entityClass));
			Query query = eManager.createQuery(criteriaQuery);
			
			query.setMaxResults(8);
			query.setFirstResult((pageIndex -1) * 8);
				
//				query.setFirstResult(pageIndex);
//				query.setMaxResults(maxResult);

			
			return query.getResultList();
		} finally  {
			// TODO Auto-generated catch block
			eManager.close();
		}
	}
	
	public Long count() {
		EntityManager eManager = JpaUtils.getEntityManager();
		try {
			CriteriaQuery criteriaQuery = eManager.getCriteriaBuilder().createQuery();

			Root<T> root = criteriaQuery.from(entityClass);
			criteriaQuery.select(eManager.getCriteriaBuilder().count(root));
			
			Query query = eManager.createQuery (criteriaQuery);
			return (Long) query.getSingleResult();
		} finally  {
			// TODO Auto-generated catch block
			eManager.close();
		}
	}
}
