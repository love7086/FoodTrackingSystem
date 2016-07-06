package com.foodtrackingsystem.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.foodtrackingsystem.exception.AdException;
import com.foodtrackingsystem.pojo.Food;
import com.foodtrackingsystem.pojo.Supplier;

@Controller
public class SupplierController extends MyController {

	private SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");

	@RequestMapping(value = "/addFood.htm", method = RequestMethod.GET)
	public ModelAndView supplierIndex(HttpServletRequest request, HttpServletResponse response)
			throws AdException, ParseException {
		if (!authorization("supplier", request, response)) {
			return new ModelAndView("errorPage");
		}
		ModelAndView mv = new ModelAndView("addFood");
		List<Food> foodList = foodDAO.listFood();
		int foodCount = foodList.size();
		mv.addObject("foodCount", foodCount);
		mv.addObject("foodList", foodList);
		return mv;
	}

	@RequestMapping(value = "/updateFood.htm", method = RequestMethod.GET)
	public ModelAndView updateFood(HttpServletRequest request, HttpServletResponse response) throws AdException {
		if (!authorization("supplier", request, response)) {
			return new ModelAndView("errorPage");
		}
		ModelAndView mv = new ModelAndView("updateFood");
		List<Food> foodList = foodDAO.listFood();
		mv.addObject("foodList", foodList);
		mv.addObject("foodCount", foodList.size());
		return mv;
	}

	@RequestMapping(value = "/addFood.htm", method = RequestMethod.POST)
	public void addFood2(HttpServletRequest request, HttpServletResponse response)
			throws AdException, ParseException, IOException {
		int flag = 1;
		
//		User u = (User) request.getSession().getAttribute("user");
		String foodName = request.getParameter("foodName");
		String harvestDate = request.getParameter("harvestDate");
		String quantity = request.getParameter("quantity");
		String description = request.getParameter("description");
		Supplier s = supplierDAO.get(1);
		JSONObject obj = new JSONObject();
		try {
			Date d = formatter.parse(harvestDate);
			String str = formatter.format(d);
			foodDAO.create(s, foodName, str, description, Integer.valueOf(quantity));
			obj.put("enterprise", s.getName());
		} catch (Exception d) {
			flag = 2;
			return;
		}
		obj.put("flag", flag);
		PrintWriter out = response.getWriter();
		out.print(obj);
	}

	@RequestMapping(value = "/saveFood.htm", method = RequestMethod.POST)
	public void saveFood(HttpServletRequest request, HttpServletResponse response)
			throws AdException, ParseException, IOException {
		int flag = 1;
		String foodId = request.getParameter("foodId");
		String foodName = request.getParameter("foodName");
		String harvestDate = request.getParameter("harvestDate");
		String quantity = request.getParameter("quantity");
		String description = request.getParameter("description");
		try {
			Date d = formatter.parse(harvestDate);
			formatter.format(d);
		} catch (ParseException d) {
			flag = 2;
			return;
		}
		foodDAO.update(Integer.valueOf(foodId), foodName, harvestDate, description, Integer.valueOf(quantity));
		JSONObject obj = new JSONObject();
		obj.put("flag", flag);
		PrintWriter out = response.getWriter();
		out.println(obj);
	}

	@RequestMapping(value = "/deleteFood.htm", method = RequestMethod.POST)
	public void deleteFood(HttpServletRequest request, HttpServletResponse response) throws AdException {
		String foodId = request.getParameter("foodId");
		foodDAO.delete(Integer.valueOf(foodId));
	}

	@RequestMapping(value = "/addTransportation.htm", method = RequestMethod.GET)
	public ModelAndView addTransportation(HttpServletRequest request, HttpServletResponse response) throws AdException {
		if (!authorization("supplier", request, response)) {
			return new ModelAndView("errorPage");
		}
//		Supplier s = supplierDAO.get(1);
		List<Food> foodList = foodDAO.listFood();
		return new ModelAndView("addTransportation", "foodList", foodList);
	}

	@RequestMapping(value = "/addTransportation.htm", method = RequestMethod.POST)
	public void addTransportation2(HttpServletRequest request, HttpServletResponse response)
			throws AdException, IOException {
		int flag = 1;
		String foodId = request.getParameter("foodId");
		String lat1 = request.getParameter("lat1");
		String lon1 = request.getParameter("lon1");
		String lat2 = request.getParameter("lat2");
		String lon2 = request.getParameter("lon2");
		JSONObject obj = new JSONObject();
		try {
			transportationDAO.create(Integer.valueOf(foodId), lat1, lon1, lat2, lon2);
		} catch (Exception d) {
			flag = 2;
			return;
		}
		obj.put("flag", flag);
		PrintWriter out = response.getWriter();
		out.print(obj);
	}
}
