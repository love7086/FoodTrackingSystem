package com.foodtrackingsystem.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.foodtrackingsystem.exception.AdException;
import com.foodtrackingsystem.pojo.Network;

public class NetworkDAO extends DAO {

	public NetworkDAO() {
	}

	public Network get(String name) throws AdException {
		try {
			begin();
			Query q = getSession().createQuery("from Network where name = :name");
			q.setString("name", name);
			Network p = (Network) q.uniqueResult();
			commit();
			return p;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not get network " + name, e);
		} finally {
			close();
		}
	}

	public Network create(String name) throws AdException {
		try {
			begin();
			Network n = new Network();
			n.setName(name);
			getSession().save(n);
			commit();
			return n;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Exception while creating Network: " + e.getMessage());
		} finally {
			close();
		}
	}

	public List<Network> listNetwork() throws AdException {
		try {
			begin();
			Query q = getSession().createQuery("from Network");
			@SuppressWarnings("unchecked")
			List<Network> list = q.list();
			commit();
			return list;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not list the network", e);
		} finally {
			close();
		}
	}

	public void save(Network n) throws AdException {
		try {
			begin();
			getSession().update(n);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not save the network" + n.getName(), e);
		} finally {
			close();
		}
	}

	public void delete(String networkName) throws AdException {
		try {
			begin();
			Session s = getSession();
			Query q = s.createQuery("from Network where name=:networkName");
			q.setString("networkName", networkName);
			Network n = (Network) q.uniqueResult();
			getSession().delete(n);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not delete the network" + networkName, e);
		} finally {
			close();
		}
	}

	public void update(String networkId, String newName) throws AdException {
		try {
			begin();
			Query q = getSession().createQuery("update Network set name=:name where networkId = :networkId");
			q.setString("networkId", networkId);
			q.setString("name", newName);
			q.executeUpdate();
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not update the network" + networkId, e);
		} finally {
			close();
		}
	}
}
