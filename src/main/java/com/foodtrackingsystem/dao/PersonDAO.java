package com.foodtrackingsystem.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.foodtrackingsystem.exception.AdException;
import com.foodtrackingsystem.pojo.Person;

public class PersonDAO extends DAO {

	public PersonDAO() {
	}

	public Person get(int personId) throws AdException {
		try {
			begin();
			Query q = getSession().createQuery("from Person where personId = :personId");
			q.setInteger("personId", personId);
			Person p = (Person) q.uniqueResult();
			commit();
			return p;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not get Person with personId" + personId, e);
		} finally {
			close();
		}
	}

	public Person create(String name, int age, String address) throws AdException {
		try {
			begin();
			Person p = new Person();
			p.setAddress(address);
			p.setName(name);
			p.setAge(age);
			getSession().save(p);
			commit();
			return p;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Exception while creating person: " + e.getMessage());
		} finally {
			close();
		}
	}

	public void delete(int personId) throws AdException {
		try {
			begin();
			Query q = getSession().createQuery("from Person where personId=:personId");
			q.setInteger("personId", personId);
			Person p = (Person) q.uniqueResult();
			getSession().delete(p);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not delete person with personId " + personId, e);
		} finally {
			close();
		}
	}

	public List<Person> listPerson() throws AdException {
		try {
			begin();
			Query q = getSession().createQuery("from Person");
			@SuppressWarnings("unchecked")
			List<Person> personList = q.list();
			commit();
			return personList;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not list person ", e);
		} finally {
			close();
		}
	}

	public void updatePerson(int personId, String name, int age, String address) throws AdException {
		try {
			begin();
			Query q = getSession().createQuery("from Person where personId = :personId");
			q.setInteger("personId", personId);
			Person p = (Person) q.uniqueResult();
			p.setAddress(address);
			p.setAge(age);
			p.setName(name);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not update Person with personId" + personId, e);
		} finally {
			close();
		}
	}
}
