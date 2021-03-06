package com.foodtrackingsystem.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.foodtrackingsystem.exception.AdException;
import com.foodtrackingsystem.pojo.Person;
import com.foodtrackingsystem.pojo.User;

public class TransportationCompanyDAO extends DAO {
	public TransportationCompanyDAO() {
	}

	public User get(int userId) throws AdException {
		try {
			begin();
			Query q = getSession().createQuery("from User where userId = :userId");
			q.setInteger("userId", userId);
			User user = (User) q.uniqueResult();
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not get user with userId= " + userId, e);
		} finally {
			close();
		}
	}

	public void update(int userId, String username, String password, String role) throws AdException {
		try {
			begin();
			Query q = getSession().createQuery("from User where userId = :userId");
			q.setInteger("userId", userId);
			User user = (User) q.uniqueResult();
			user.setPassword(password);
			user.setUsername(username);
			user.setRole(role);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not get user " + username, e);
		} finally {
			close();
		}
	}

	public User create(Person p, String role, String username, String password) throws AdException {
		if (p.getUser() != null) {
			throw new AdException("The Person " + p + " has already been registered!");
		}
		try {
			begin();
			User user = new User();
			p.setUser(user);
			user.setPerson(p);
			user.setRole(role);
			user.setUsername(username);
			user.setPassword(password);
			getSession().save(user);
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			// throw new AdException("Could not create user " + username, e);
			throw new AdException("Exception while creating user: " + e.getMessage());
		} finally {
			close();
		}
	}

	public void delete(User user) throws AdException {
		try {
			begin();
			getSession().delete(user);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not delete user " + user.getUsername(), e);
		} finally {
			close();
		}
	}

	public User Login(String username, String password) throws AdException {
		try {
			begin();
			Query q = getSession().createQuery("from User where username=:username and password=:password");
			q.setString("username", username);
			q.setString("password", password);
			User u = (User) q.uniqueResult();
			commit();
			return u;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Invalid username password pair!");
		} finally {
			close();
		}
	}

	public List<User> listUser() throws AdException {
		try {
			begin();
			Query q = getSession().createQuery("from User");
			@SuppressWarnings("unchecked")
			List<User> users = q.list();
			commit();
			return users;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Cannot list all users");
		} finally {
			close();
		}
	}
}
