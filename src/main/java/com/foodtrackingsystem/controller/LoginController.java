package com.foodtrackingsystem.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.foodtrackingsystem.exception.AdException;
import com.foodtrackingsystem.pojo.Person;
import com.foodtrackingsystem.pojo.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController extends MyController {

	/**
	 * Simply selects the home view to render by returning its name.
	 * 
	 * @throws AdException
	 */

	@RequestMapping(value = "/login.htm", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws AdException {
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView();
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		User u = userDAO.Login(username, password);
		if (u == null) {
			return new ModelAndView("index", "fail", true);
		} else {
			session.setAttribute("user", u);
			String role = u.getRole();
			if (role.equalsIgnoreCase("admin")) {
				try {
					int networkCount = networkDAO.listNetwork().size();
					int enterpriseCount = supplierDAO.listSupplier().size();
					int userCount = userDAO.listUser().size();
					int personCount = personDAO.listPerson().size();
					session.setAttribute("networkCount", networkCount);
					session.setAttribute("enterpriseCount", enterpriseCount);
					session.setAttribute("userCount", userCount);
					session.setAttribute("personCount", personCount);
				} catch (Exception e) {
				}
			} else if (role.equalsIgnoreCase("customer")) {
				try {
					int transportationCount = transportationDAO.listAllTransportation().size();
					session.setAttribute("transportationCount", transportationCount);
					int foodCount = foodDAO.listFood().size();
					session.setAttribute("foodCount", foodCount);
					int commentCount = commentDAO.listComments().size();
					session.setAttribute("commentCount", commentCount);
					mv.addObject("user", u);
				} catch (Exception e) {
				}
			} else if (role.equalsIgnoreCase("supplier")) {
				// Supplier s = (Supplier) u.getEnterprise();
				try {
					int foodCount = foodDAO.listFood().size();
					session.setAttribute("foodCount", foodCount);
					int transportationCount = transportationDAO.listTransportation((int) u.getUserId()).size();
					session.setAttribute("transportationCount", transportationCount);
				} catch (Exception e) {
				}
				mv.addObject("user", u);
			}
			mv.setViewName(role + "Index");
		}
		return mv;
	}

	@RequestMapping(value = "/login.htm", method = RequestMethod.GET)
	public String logOut(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "index";
	}

	@RequestMapping(value = "register.htm", method = RequestMethod.POST)
	public void register(HttpServletRequest request, HttpServletResponse response) throws IOException {

		JSONObject obj = new JSONObject();
		PrintWriter out = response.getWriter();
		int flag = 1;
		try {
			String name = request.getParameter("name");
			int age = Integer.valueOf(request.getParameter("age"));
			String address = request.getParameter("address");
			Person p = personDAO.create(name, age, address);
			String username = request.getParameter("username");
			String password = request.getParameter("password1");
			User u = userDAO.create(p, "customer", username, password);
			request.getSession().setAttribute("user", u);
			obj.put("message", "Success!");
			obj.put("flag", flag);
		} catch (AdException e) {
			obj.put("message", "This username exists!");
			flag = 2;
			obj.put("flag", flag);
		}
		out.print(obj);
	}

	@RequestMapping(value = "customerIndex.htm", method = RequestMethod.GET)
	public String registerSuccess(HttpServletRequest request, HttpServletResponse response) {
		if (!authorization("customer", request, response)) {
			return "errorPage";
		}
		return "customerIndex";
	}

	@RequestMapping(value = "recover.htm", method = RequestMethod.POST)
	public void recover(HttpServletRequest request, HttpServletResponse response) throws AdException, IOException {
		String emailAddress = request.getParameter("recoverEmail");
		int flag = 1;
		JSONObject obj = new JSONObject();
		try {
			String[] array = userDAO.recover(emailAddress);
			obj.put("username", array[0]);
			obj.put("password", array[1]);
			obj.put("flag", flag);
		} catch (AdException e) {
			flag = 2;
			obj.put("flag", flag);
		}
		PrintWriter out = response.getWriter();
		out.print(obj);
	}
}
