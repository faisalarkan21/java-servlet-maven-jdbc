package com.faisalarkan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.faisalarkan.dao.UserDao;
import com.faisalarkan.model.User;

public class UserController extends HttpServlet  {

	private static final long serialVersionUID = 1L;
	private UserDao dao;

	public UserController (){
	
		dao = new UserDao();
	}

	protected void doPost (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{

		User user = new User();
		user.setEmail(req.getParameter("email"));		
		user.setPassword(req.getParameter("password"));
		
		
		dao.addUser(user);	
	
		
		RequestDispatcher view = req.getRequestDispatcher("index.jsp");
		
		
		view.forward(req, res);


	}




}
