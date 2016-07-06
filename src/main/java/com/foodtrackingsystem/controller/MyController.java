package com.foodtrackingsystem.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.foodtrackingsystem.dao.CommentDAO;
import com.foodtrackingsystem.dao.FoodDAO;
import com.foodtrackingsystem.dao.NetworkDAO;
import com.foodtrackingsystem.dao.PersonDAO;
import com.foodtrackingsystem.dao.SupplierDAO;
import com.foodtrackingsystem.dao.TransportationDAO;
import com.foodtrackingsystem.dao.UserDAO;
import com.foodtrackingsystem.pojo.User;

@Controller
public abstract class MyController {
	@Autowired
	@Qualifier("personDAO")
	PersonDAO personDAO;

	@Autowired
	@Qualifier("userDAO")
	UserDAO userDAO;

//	@Autowired
//	@Qualifier("enterpriseDAO")
//	EnterpriseDAO enterpriseDAO;

	@Autowired
	@Qualifier("networkDAO")
	NetworkDAO networkDAO;
	@Autowired
	@Qualifier("foodDAO")
	FoodDAO foodDAO;

	@Autowired
	@Qualifier("supplierDAO")
	SupplierDAO supplierDAO;

	@Autowired
	@Qualifier("transportationDAO")
	TransportationDAO transportationDAO;
	
	@Autowired
	@Qualifier("commentDAO")
	CommentDAO commentDAO;

	public boolean authorization(String role, HttpServletRequest req, HttpServletResponse res) {
		User u = (User) req.getSession().getAttribute("user");
		if (u == null)
			return false;
		else if (!u.getRole().equalsIgnoreCase(role)) {
			return false;
		}
		return true;
	}
}
