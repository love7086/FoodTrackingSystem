package com.foodtrackingsystem.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.foodtrackingsystem.exception.AdException;
import com.foodtrackingsystem.pojo.Comment;
import com.foodtrackingsystem.pojo.Food;
import com.foodtrackingsystem.pojo.Transportation;
import com.foodtrackingsystem.pojo.User;

@Controller
public class CustomerController extends MyController {

	@Autowired
	@Qualifier("userValidator")
	UserValidator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(value = "updateProfile.htm", method = RequestMethod.GET)
	public String updateProfile(HttpServletRequest req, HttpServletResponse res) {
		if (!authorization("customer", req, res)) {
			return "errorPage";
		} else {
			return "redirect:/flows/updateProfile.htm";
		}
	}

	@RequestMapping(value = "viewTransportation.htm", method = RequestMethod.GET)
	public ModelAndView viewTransportation(HttpServletRequest req, HttpServletResponse res) throws AdException {

		if (!authorization("customer", req, res)) {
			return new ModelAndView("errorPage");
		} else {
			ModelAndView mv = new ModelAndView("viewTransportation");
			List<Transportation> transportationList = transportationDAO.listAllTransportation();
			mv.addObject("transportationList", transportationList);
			return mv;
		}
	}

	@RequestMapping(value = "viewFood.htm", method = RequestMethod.GET)
	public ModelAndView viewFood(HttpServletRequest req, HttpServletResponse res) throws AdException {
		if (!authorization("customer", req, res)) {
			return new ModelAndView("errorPage");
		} else {
			ModelAndView mv = new ModelAndView("viewFood");
			List<Food> foodList = foodDAO.listFood();
			mv.addObject("foodList", foodList);
			return mv;
		}
	}

	@RequestMapping(value = "addComment.htm", method = RequestMethod.GET)
	public ModelAndView addComment(HttpServletRequest req, HttpServletResponse res) throws AdException {
		if (!authorization("customer", req, res)) {
			return new ModelAndView("errorPage");
		} else {
			ModelAndView mv = new ModelAndView("addComment");
			List<Food> foodList = foodDAO.listFood();
			mv.addObject("foodList", foodList);
			return mv;
		}
	}

	@RequestMapping(value = "addComment2.htm", method = RequestMethod.POST)
	public void addComment2(HttpServletRequest req, HttpServletResponse res) throws AdException, IOException {
		JSONObject obj = new JSONObject();
		String foodId = req.getParameter("foodId");
		String comment = req.getParameter("comment");
		User u = (User) req.getSession().getAttribute("user");
		try {
			Food f = foodDAO.get(Long.valueOf(foodId));
			commentDAO.create(comment, f, u);
			obj.put("flag", 1);
		} catch (Exception e) {
		}
		PrintWriter out = res.getWriter();
		out.print(obj);
	}

	@RequestMapping(value = "viewComments.htm", method = RequestMethod.GET)
	public ModelAndView viewComments(HttpServletRequest req, HttpServletResponse res) throws AdException {
		if (!authorization("customer", req, res)) {
			return new ModelAndView("errorPage");
		} else {
			List<Comment> commentList = commentDAO.listComments();
			ModelAndView mv = new ModelAndView("viewComment");
			mv.addObject("commentList", commentList);
			return mv;
		}
	}

	@RequestMapping(value = "uploadPhoto.htm", method = RequestMethod.GET)
	public String uploadPhoto(HttpServletRequest request, HttpServletResponse response) {
				return "uploadPhoto";
	}

	@RequestMapping(value = "uploadPhoto.htm", method = RequestMethod.POST)
	protected ModelAndView test(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("file") MultipartFile file) throws IOException, AdException {
		User user = (User) request.getSession().getAttribute("user");
		if (!file.isEmpty() && user != null) {

			user.setPhoto(file);
			System.out.println(file.getOriginalFilename() + "***File name");
			user.setPhotoName(file.getOriginalFilename());
			userDAO.updatePhoto(user, user.getPhotoName());
			byte[] bytes = user.getPhoto().getBytes();
			BufferedOutputStream buffStream = new BufferedOutputStream(new FileOutputStream(new File(
					"C:\\Users\\asus\\Documents\\NetBeansProjects\\STSNewWorkSpace\\FoodTrackingSystem\\src\\main\\webapp\\resources\\img\\"
							+ user.getPhotoName())));
			buffStream.write(bytes);
			buffStream.close();
			return new ModelAndView("uploadPhoto", "src", user.getPhotoName());

		} else
			return new ModelAndView("uploadPhoto");

	}

}
