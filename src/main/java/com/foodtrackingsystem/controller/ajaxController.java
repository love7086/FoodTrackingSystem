package com.foodtrackingsystem.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.foodtrackingsystem.dao.UserDAO;
import com.foodtrackingsystem.exception.AdException;
import com.foodtrackingsystem.pojo.User;

public class ajaxController extends AbstractController {

	private UserDAO userDAO=new UserDAO();

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws AdException {
		User u = (User) request.getSession().getAttribute("user");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String address = request.getParameter("address");
		try {
			userDAO.update(u, password, gender, name, Integer.valueOf(age), address);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
