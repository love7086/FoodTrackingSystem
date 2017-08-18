package com.foodtrackingsystem.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.foodtrackingsystem.exception.AdException;
import com.foodtrackingsystem.pojo.Enterprise;
import com.foodtrackingsystem.pojo.Network;
import com.foodtrackingsystem.pojo.Person;
import com.foodtrackingsystem.pojo.Supplier;
import com.foodtrackingsystem.pojo.User;

@Controller
public class AdminController extends MyController {
	//Updated at 2017.8.18
	@RequestMapping(value = "/addNetwork1.htm")
	public ModelAndView redirectToAddNetwork(HttpServletRequest request, HttpServletResponse response)
			throws AdException {
		if (!authorization("admin", request, response)) {
			return new ModelAndView("errorPage");
		}
		List<Network> networks = networkDAO.listNetwork();
		ModelAndView mv = new ModelAndView("addNetwork", "networks", networks);
		return mv;
	}

	@RequestMapping(value = "/updateNetwork.htm")
	public ModelAndView redirectToUdateNetwork(HttpServletRequest request, HttpServletResponse response)
			throws AdException {
		if (!authorization("admin", request, response)) {
			return new ModelAndView("errorPage");
		}
		List<Network> networks = networkDAO.listNetwork();
		ModelAndView mv = new ModelAndView("updateNetwork", "networks", networks);
		return mv;
	}

	@RequestMapping(value = "/addNetwork2.htm", method = RequestMethod.POST)
	public void addNetwork(HttpServletRequest request, HttpServletResponse response) throws AdException, IOException {

		int flag = 0;

		String networkName = request.getParameter("networkName");
		try {
			networkDAO.create(networkName);
			flag = 1;
		} catch (AdException e) {
			flag = 2;
		}

		JSONObject obj = new JSONObject();
		obj.put("flag", flag);
		obj.put("network", networkName);
		PrintWriter out = response.getWriter();
		out.print(obj);
	}

	@RequestMapping(value = "/saveNetwork.htm", method = RequestMethod.POST)
	public void saveNetworks(HttpServletRequest request, HttpServletResponse response) throws AdException, IOException {
		String networkName = request.getParameter("network");
		String networkId = request.getParameter("networkId");
		networkDAO.update(networkId, networkName);
	}

	@RequestMapping(value = "/viewNetwork.htm", method = RequestMethod.GET)
	public ModelAndView viewNetworks(HttpServletRequest request, HttpServletResponse response) throws AdException {
		if (!authorization("admin", request, response)) {
			return new ModelAndView("errorPage");
		}
		List<Network> networks = networkDAO.listNetwork();
		ModelAndView mv = new ModelAndView("viewNetwork", "networks", networks);
		return mv;
	}

	@RequestMapping(value = "/deleteNetwork.htm", method = RequestMethod.POST)
	public void deleteNetwork(HttpServletRequest request, HttpServletResponse response) throws AdException {
		String networkName = (String) request.getParameter("networkName");
		networkDAO.delete(networkName);
	}

	@RequestMapping(value = "/addEnterprise.htm", method = RequestMethod.GET)
	public ModelAndView addEnterprise1(HttpServletRequest request, HttpServletResponse response) throws AdException {
		if (!authorization("admin", request, response)) {
			return new ModelAndView("errorPage");
		}
		ModelAndView mv = new ModelAndView();
		List<Network> networkList = networkDAO.listNetwork();
		mv.addObject("networkList", networkList);
		mv.setViewName("addEnterprise");
		return mv;
	}

	@RequestMapping(value = "/addEnterprise2.htm", method = RequestMethod.POST)
	public void addEnterprise(HttpServletRequest request, HttpServletResponse response)
			throws AdException, IOException {
		int flag = 1;
		String enterpriseName = request.getParameter("enterpriseName");
		String location = request.getParameter("location");
		String network = request.getParameter("network");
		Network n = networkDAO.get(network);
		Iterator<Enterprise> i = n.getEnterpriseDir().iterator();
		while (i.hasNext()) {
			Enterprise e = (Enterprise) i.next();
			if (e.getName().equals(enterpriseName))
				flag = 2;
			break;
		}
		if (flag == 1) {
			supplierDAO.create(location, n, enterpriseName);
		}
		JSONObject obj = new JSONObject();
		obj.put("flag", flag);
		PrintWriter out = response.getWriter();
		out.print(obj);
	}

	@RequestMapping(value = "/updateEnterprise.htm", method = RequestMethod.GET)
	public ModelAndView updateNetwork(HttpServletRequest request, HttpServletResponse response) throws AdException {
		if (!authorization("admin", request, response)) {
			return new ModelAndView("errorPage");
		}
		ModelAndView mv = new ModelAndView();
		List<Supplier> enterpriseList = supplierDAO.listSupplier();
		mv.addObject("Enterprises", enterpriseList);
		mv.setViewName("updateEnterprise");
		return mv;
	}

	@RequestMapping(value = "/saveEnterprise.htm", method = RequestMethod.POST)
	public void saveEnterprise(HttpServletRequest request, HttpServletResponse response)
			throws AdException, IOException {
		String enterpriseName = request.getParameter("enterpriseName");
		String enterpriseId = request.getParameter("enterpriseId");
		String location = request.getParameter("location");
		supplierDAO.udpateSupplier(Integer.valueOf(enterpriseId), enterpriseName, location);

	}

	@RequestMapping(value = "/deleteEnterprise.htm", method = RequestMethod.POST)
	public void deleteEnterprise(HttpServletRequest request, HttpServletResponse response)
			throws AdException, IOException {
		String enterpriseId = request.getParameter("enterpriseId");
		supplierDAO.delete(Integer.valueOf(enterpriseId));
	}

	@RequestMapping(value = "/addPerson.htm", method = RequestMethod.GET)
	public ModelAndView addPerson1(HttpServletRequest request, HttpServletResponse response) throws AdException {
		if (!authorization("admin", request, response)) {
			return new ModelAndView("errorPage");
		}
		ModelAndView mv = new ModelAndView();
		List<Person> people = personDAO.listPerson();
		mv.addObject("people", people);
		mv.setViewName("addPerson");
		return mv;
	}

	@RequestMapping(value = "/addPerson2.htm", method = RequestMethod.POST)
	public void addPerson2(HttpServletRequest request, HttpServletResponse response) throws AdException, IOException {
		int flag = 2;
		String personName = request.getParameter("personName");
		String personAge = request.getParameter("personAge");
		String personAddress = request.getParameter("personAddress");
		JSONObject obj = new JSONObject();
		try {
			personDAO.create(personName, Integer.valueOf(personAge), personAddress);
			flag = 1;
			obj.put("personName", personName);
			obj.put("personAge", personAge);
			obj.put("personAddress", personAddress);
		} catch (AdException e) {
			flag = 2;
		}
		obj.put("flag", flag);
		PrintWriter out = response.getWriter();
		out.print(obj);
	}

	@RequestMapping(value = "/updatePerson.htm", method = RequestMethod.GET)
	public ModelAndView updatePerson(HttpServletRequest request, HttpServletResponse response) throws AdException {
		if (!authorization("admin", request, response)) {
			return new ModelAndView("errorPage");
		}
		ModelAndView mv = new ModelAndView();
		List<Person> people = personDAO.listPerson();
		mv.addObject("people", people);
		mv.setViewName("updatePerson");
		return mv;
	}

	@RequestMapping(value = "/savePerson.htm", method = RequestMethod.POST)
	public void savePerson(HttpServletRequest request, HttpServletResponse response) throws AdException, IOException {
		String personId = request.getParameter("personId");
		String name = request.getParameter("personName");
		String age = request.getParameter("personAge");
		String address = request.getParameter("personAddress");
		personDAO.updatePerson(Integer.valueOf(personId), name, Integer.valueOf(age), address);
	}

	@RequestMapping(value = "/deletePerson.htm", method = RequestMethod.POST)
	public void deletePerson(HttpServletRequest request, HttpServletResponse response) throws AdException, IOException {
		String personId = request.getParameter("personId");
		personDAO.delete(Integer.valueOf(personId));
	}

	@RequestMapping(value = "/addUser.htm", method = RequestMethod.GET)
	public ModelAndView addUser1(HttpServletRequest request, HttpServletResponse response) throws AdException {
		if (!authorization("admin", request, response)) {
			return new ModelAndView("errorPage");
		}
		ModelAndView mv = new ModelAndView();
		List<Person> people = personDAO.listPerson();
		mv.addObject("people", people);
		mv.setViewName("addUser");
		return mv;
	}

	@RequestMapping(value = "/addUser2.htm", method = RequestMethod.POST)
	public void addUser2(HttpServletRequest request, HttpServletResponse response) throws AdException, IOException {
		int flag = 2;
		String personId = request.getParameter("personId");
		String username = request.getParameter("userUsername");
		String password = request.getParameter("userPassword");
		String role = request.getParameter("userRole");
		Person p = personDAO.get(Integer.valueOf(personId));
		JSONObject obj = new JSONObject();
		try {
			if (p.getUser() == null) {
				userDAO.create(p, role, username, password);
				flag = 1;
				obj.put("personId", personId);
				obj.put("username", username);
			} else {
				flag = 2;
			}
		} catch (AdException e) {
			flag = 2;
		}
		obj.put("flag", flag);
		PrintWriter out = response.getWriter();
		out.print(obj);
	}

	@RequestMapping(value = "/updateUser.htm", method = RequestMethod.GET)
	public ModelAndView updateUser(HttpServletRequest request, HttpServletResponse response) throws AdException {
		if (!authorization("admin", request, response)) {
			return new ModelAndView("errorPage");
		}
		ModelAndView mv = new ModelAndView();
		List<User> users = userDAO.listUser();
		mv.addObject("users", users);
		mv.setViewName("updateUser");
		return mv;
	}

	@RequestMapping(value = "/saveUser.htm", method = RequestMethod.POST)
	public void saveUser(HttpServletRequest request, HttpServletResponse response) throws AdException {
		String userId = request.getParameter("userId");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		User u = userDAO.get(Integer.valueOf(userId));
		u.setUsername(username);
		u.setPassword(password);
		u.setRole(role);
	}

	@RequestMapping(value = "/deleteUser.htm", method = RequestMethod.POST)
	public void deleteUser(HttpServletRequest request, HttpServletResponse response) throws AdException {
		String userId = request.getParameter("userId");
		User u = userDAO.get(Integer.valueOf(userId));
		if (u != null)
			userDAO.delete(u);
	}
}
