package com.foodtrackingsystem.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;

import com.foodtrackingsystem.exception.AdException;
import com.foodtrackingsystem.pojo.Food;
import com.foodtrackingsystem.pojo.Supplier;

public class FoodDAO extends DAO {
	public FoodDAO() {
	}

	public Food get(long foodId) throws AdException {
		try {
			begin();
			Criteria c = getSession().createCriteria(Food.class);
			c.add(Restrictions.eq("foodId", foodId));
			Food f = (Food) c.uniqueResult();
			commit();
			return f;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not get food with foodId= " + foodId, e);
		} finally {
			close();
		}
	}

	public void update(int foodId, String name, String harvestDate, String description, int quantity)
			throws AdException {
		try {
			begin();
			Query q = getSession().createQuery("from Food where foodId = :foodId");
			q.setInteger("foodId", foodId);
			Food food = (Food) q.uniqueResult();
			food.setName(name);
			food.setHarvestDate(harvestDate);
			food.setDescription(description);
			food.setQuantity(quantity);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not get food with foodId " + foodId, e);
		} finally {
			close();
		}
	}

	public Food create(Supplier s, String name, String harvestDate, String description, int quantity)
			throws AdException {
		try {
			begin();
			Food food = new Food();
			food.setSupplier(s);
			food.setName(name);
			food.setHarvestDate(harvestDate);
			food.setDescription(description);
			food.setQuantity(quantity);
			getSession().save(food);
			commit();
			return food;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Exception while creating food: " + e.getMessage());
		} finally {
			close();
		}
	}

	public void delete(int foodId) throws AdException {
		try {
			begin();
			Query q = getSession().createQuery("From Food where foodId=:foodId");
			q.setInteger("foodId", foodId);
			Food food = (Food) q.uniqueResult();
			getSession().delete(food);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not delete food with foodId " + foodId, e);
		} finally {
			close();
		}
	}

	public List<Food> listFood() throws AdException {
		try {
			begin();
			@SuppressWarnings("unchecked")
			List<Food> foodList = getSession().createQuery("From Food").list();
			commit();
			return foodList;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Cannot list food!", e);
		} finally {
			close();
		}
	}

	public List<Food> listFoodBySupplier(Supplier s) throws AdException {
		try {
			begin();
			Criteria c=getSession().createCriteria(Food.class);
			Food f=new Food();
			f.setName("firstFood");	
			c.add(Example.create(f).excludeZeroes());
			@SuppressWarnings("unchecked")
			List<Food> foodList = c.list();
			commit();
			return foodList;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Cannot list food with supplier "+s.getName(), e);
		} finally {
			close();
		}
	}

}
