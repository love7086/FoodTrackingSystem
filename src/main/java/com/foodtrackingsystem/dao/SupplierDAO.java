package com.foodtrackingsystem.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.foodtrackingsystem.exception.AdException;
import com.foodtrackingsystem.pojo.Network;
import com.foodtrackingsystem.pojo.Supplier;

public class SupplierDAO extends DAO {

	public SupplierDAO() {
	}

//	public Supplier get(String supplierName) throws AdException {
//		try {
//			begin();
//			Query q = getSession().createQuery("from Supplier where name = :name");
//			q.setString("name", supplierName);
//			Supplier e = (Supplier) q.uniqueResult();
//			commit();
//			return e;
//		} catch (HibernateException e) {
//			rollback();
//			throw new AdException("Could not get supplier " + supplierName, e);
//		} finally {
//			close();
//		}
//	}

	public Supplier get(int supplierId) throws AdException {
		try {
			begin();
			Query q = getSession().createQuery("from Supplier where enterpriseId = :enterpriseId");
			q.setInteger("enterpriseId", supplierId);
			Supplier e = (Supplier) q.uniqueResult();
			commit();
			return e;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not get supplier with enterpriseId" + supplierId, e);
		} finally {
			close();
		}
	}

	public Supplier create(String location, Network network, String name) throws AdException {

		try {
			begin();
			Supplier e = new Supplier();
			e.setName(name);
			e.setLocation(location);
			e.setNetwork(network);
			getSession().save(e);
			commit();
			return e;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Exception while creating supplier: " + e.getMessage());
		} finally {
			close();
		}
	}

	public void delete(int enterpriseId) throws AdException {
		try {
			begin();
			Query q=getSession().createQuery("from Supplier where enterpriseId=:enterpriseId");
			q.setInteger("enterpriseId", enterpriseId);
			Supplier e = (Supplier)q.uniqueResult() ;
			getSession().delete(e);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not delete Supplier with enterpriseId=" + enterpriseId, e);
		} finally {
			close();
		}
	}

	public List<Supplier> listSupplier() throws AdException {
		try {
			begin();
			@SuppressWarnings("unchecked")
			List<Supplier> enterpriseList = getSession().createCriteria(Supplier.class).list();
			commit();
			return enterpriseList;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Can't get all enterprise");
		} finally {
			close();
		}
	}

	public void udpateSupplier(int enterpriseId, String name, String location) throws AdException {
		 try {
		begin();
		Query q = getSession().createQuery("from Supplier where enterpriseId=:enterpriseId");
		q.setInteger("enterpriseId", enterpriseId);
		Supplier e = (Supplier) q.uniqueResult();
		e.setLocation(location);
		e.setName(name);
		getSession().update(e);
		commit();
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Can't update Supplier with enterpriseId=" + enterpriseId);
		} finally {
			close();
		}
	}

}
