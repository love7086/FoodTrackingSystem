//package com.foodtrackingsystem.dao;
//
//import java.util.List;
//
//import org.hibernate.HibernateException;
//import org.hibernate.Query;
//
//import com.foodtrackingsystem.exception.AdException;
//import com.foodtrackingsystem.pojo.Enterprise;
//import com.foodtrackingsystem.pojo.Network;
//
//public class EnterpriseDAO extends DAO {
//
//	public EnterpriseDAO() {
//	}
//
//	public Enterprise get(String enterpriseName) throws AdException {
//		try {
//			begin();
//			Query q = getSession().createQuery("from Enterprise where name = :name");
//			q.setString("name", enterpriseName);
//			Enterprise e = (Enterprise) q.uniqueResult();
//			commit();
//			return e;
//		} catch (HibernateException e) {
//			rollback();
//			throw new AdException("Could not get Enterprise " + enterpriseName, e);
//		} finally {
//			close();
//		}
//	}
//
//	public Enterprise get(int enterpriseId) throws AdException {
//		try {
//			begin();
//			Query q = getSession().createQuery("from Enterprise where enterpriseId = :enterpriseId");
//			q.setInteger("enterpriseId", enterpriseId);
//			Enterprise e = (Enterprise) q.uniqueResult();
//			commit();
//			return e;
//		} catch (HibernateException e) {
//			rollback();
//			throw new AdException("Could not get Enterprise with enterpriseId" + enterpriseId, e);
//		} finally {
//			close();
//		}
//	}
//
//	public Enterprise create(String location, Network network, String name) throws AdException {
//
//		try {
//			begin();
//			Enterprise e = new Enterprise();
//			e.setName(name);
//			e.setLocation(location);
//			e.setNetwork(network);
//			getSession().save(e);
//			commit();
//			return e;
//		} catch (HibernateException e) {
//			rollback();
//			throw new AdException("Exception while creating enterprise: " + e.getMessage());
//		} finally {
//			close();
//		}
//	}
//
//	public void delete(int enterpriseId) throws AdException {
//		try {
//			begin();
//			Query q=getSession().createQuery("from Enterprise where enterpriseId=:enterpriseId");
//			q.setInteger("enterpriseId", enterpriseId);
//			Enterprise e = (Enterprise)q.uniqueResult() ;
//			getSession().delete(e);
//			commit();
//		} catch (HibernateException e) {
//			rollback();
//			throw new AdException("Could not delete enterprise with enterpriseId=" + enterpriseId, e);
//		} finally {
//			close();
//		}
//	}
//
//	public List<Enterprise> listEnterprise() throws AdException {
//		try {
//			begin();
//			@SuppressWarnings("unchecked")
//			List<Enterprise> enterpriseList = getSession().createCriteria(Enterprise.class).list();
//			commit();
//			return enterpriseList;
//		} catch (HibernateException e) {
//			rollback();
//			throw new AdException("Can't get all enterprise");
//		} finally {
//			close();
//		}
//	}
//
//	public void udpateEnterprise(int enterpriseId, String name, String location) throws AdException {
//		 try {
//		begin();
//		Query q = getSession().createQuery("from Enterprise where enterpriseId=:enterpriseId");
//		q.setInteger("enterpriseId", enterpriseId);
//		Enterprise e = (Enterprise) q.uniqueResult();
//		e.setLocation(location);
//		e.setName(name);
//		getSession().update(e);
//		commit();
//		 } catch (HibernateException e) {
//		 rollback();
//		 throw new AdException("Can't update enterprise with enterpriseId=" +
//		 enterpriseId);
//		 } finally {
//		 close();
//		 }
//	}
//
//}
