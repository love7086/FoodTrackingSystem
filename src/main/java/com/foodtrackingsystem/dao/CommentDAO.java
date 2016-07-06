package com.foodtrackingsystem.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.foodtrackingsystem.exception.AdException;
import com.foodtrackingsystem.pojo.Comment;
import com.foodtrackingsystem.pojo.Food;
import com.foodtrackingsystem.pojo.User;

public class CommentDAO extends DAO {
	public CommentDAO() {
	}

	public Comment get(int commentId) throws AdException {
		try {
			begin();
			Query q = getSession().createQuery("from Comment where commentId = :commentId");
			q.setInteger("commentId", commentId);
			Comment c = (Comment) q.uniqueResult();
			commit();
			return c;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not get comment with commentId= " + commentId, e);
		} finally {
			close();
		}
	}

	public Comment create(String comment, Food food, User u) throws AdException {

		try {
			begin();
			Comment c = new Comment();
			c.setComment(comment);
			c.setFood(food);
			c.setUser(u);
			getSession().save(c);
			commit();
			return c;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Exception while creating comment: " + e.getMessage());
		} finally {
			close();
		}
	}

	public void delete(Comment c) throws AdException {
		try {
			begin();
			getSession().delete(c);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not delete comment " + c.getCommentId(), e);
		} finally {
			close();
		}
	}

	public List<Comment> listComments() throws AdException {
//		try {
			begin();
			Query q = getSession().createQuery("from Comment");
			@SuppressWarnings("unchecked")
			List<Comment> commentList = q.list();
			commit();
			return commentList;
//		} catch (HibernateException e) {
//			rollback();
//			throw new AdException("Cannot list all comments");
//		} finally {
//			close();
//		}
	}

	public List<Comment> listCommentsByFood(Food f) throws AdException {
		try {
			begin();
			Query q = getSession().createQuery("from Comment where food=:food");
			q.setString("food", f.getName());
			@SuppressWarnings("unchecked")
			List<Comment> commentList = q.list();
			commit();
			return commentList;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Cannot list all comments with FoodId" + f.getFoodId());
		} finally {
			close();
		}
	}
}
