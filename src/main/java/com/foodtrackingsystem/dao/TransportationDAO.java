package com.foodtrackingsystem.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

import com.foodtrackingsystem.exception.AdException;
import com.foodtrackingsystem.pojo.Enterprise;
import com.foodtrackingsystem.pojo.Food;
import com.foodtrackingsystem.pojo.Supplier;
import com.foodtrackingsystem.pojo.Transportation;

public class TransportationDAO extends DAO {
	public TransportationDAO() {
	}

	public Transportation get(int transportationId) throws AdException {
		try {
			begin();
			Query q = getSession().createQuery("from Transportation where transportationId = :transportationId");
			q.setInteger("transportationId", transportationId);
			Transportation transportation = (Transportation) q.uniqueResult();
			commit();
			return transportation;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not get transportation with transportationId= " + transportationId, e);
		} finally {
			close();
		}
	}

	public Transportation create(int foodId, String lat1, String lon1, String lat2, String lon2) throws AdException {
		try {
			begin();

			Query q = getSession().createQuery("from Food where foodId=:foodId");
			Transportation transportation = new Transportation();
			q.setInteger("foodId", foodId);
			Food f = (Food) q.uniqueResult();
			transportation.setFood(f);
			transportation.setLat1(lat1);
			transportation.setLat2(lat2);
			transportation.setLon1(lon1);
			transportation.setLon2(lon2);
			getSession().save(transportation);
			commit();
			return transportation;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Exception while creating transportaion: " + e.getMessage());
		} finally {
			close();
		}
	}

	public void delete(int transportationId) throws AdException {
		try {
			begin();
			Transportation t = get(transportationId);
			getSession().delete(t);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not delete transportation with id" + transportationId, e);
		} finally {
			close();
		}
	}

	public List<Transportation> listTransportation(int userId) throws AdException {
		try {
			begin();
			Query q = getSession().createQuery("select enterprise from User where userId=:userId");
			q.setInteger("userId", userId);
			Enterprise e = (Enterprise) q.uniqueResult();
			Food f = new Food();
			f.setSupplier((Supplier) e);
			Transportation t = new Transportation();
			t.setFood(f);
			Criteria crit1 = getSession().createCriteria(Food.class);
			crit1.add(Example.create(f).excludeProperty("quantity").excludeProperty("transportation"));
			Criteria crit2 = crit1.createCriteria("transportation");
			crit2.add(Example.create(t).excludeProperty("endDate"));
			@SuppressWarnings("unchecked")
			List<Transportation> transportationList = crit2.list();
			commit();
			return transportationList;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Cannot list all transportation with userId" + userId);
		} finally {
			close();
		}
	}
	
	public List<Transportation> listAllTransportation() throws AdException {
		try {
			begin();
			Query q = getSession().createQuery("from Transportation");
			@SuppressWarnings("unchecked")
			List<Transportation> transportationList = q.list();
			commit();
			return transportationList;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Cannot list all transportation " );
		} finally {
			close();
		}
	}
}
