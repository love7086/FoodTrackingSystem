package com.foodtrackingsystem.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.foodtrackingsystem.dao.UserDAO;
import com.foodtrackingsystem.exception.AdException;
import com.foodtrackingsystem.pojo.User;

public class ajaxController2 extends AbstractController {

	private UserDAO userDAO = new UserDAO();

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws AdException {
		User u = (User) request.getSession().getAttribute("user");
		String region = request.getParameter("region");
		String phone = request.getParameter("phone");
		String birthdate = request.getParameter("birthDate");
		String nickname = request.getParameter("nickname");
		String emailAddress = request.getParameter("emailAddress");
		try {
			userDAO.update(u, region, Long.valueOf(phone), birthdate, nickname,emailAddress);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
