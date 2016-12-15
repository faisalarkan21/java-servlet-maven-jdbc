package com.faisalarkan.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.faisalarkan.config.Dbconf;
import com.faisalarkan.dao.UserDao;
import com.faisalarkan.model.User;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID= 1L;
	
	private UserDao dao;
	private Connection connection;

	public LoginServlet (){
	
		dao = new UserDao();
		this.connection = Dbconf.getConnection();
		
	}
	
	
	
	protected void doPost (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		
		
		User user = new User();

		try{

			PreparedStatement pre = connection.prepareStatement("select * from user where email= ?");

			

			pre.setString(1, email);

			ResultSet rs=  pre.executeQuery();
			

			if (rs.next()){

				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));

			

			}

			System.out.println(	user.getEmail());
			System.out.println(	user.getPassword());
			

		}catch (Exception e){
			e.printStackTrace();
		}
		
	
		
		
		if (user.getEmail().equals("")){
			
			RequestDispatcher view = req.getRequestDispatcher("login.jsp");
			System.out.println("kaga ada!");
			
		}else if (email.equals(user.getEmail()) && password.equals(user.getPassword())){
			
			
			System.out.println("sama ada gannn!");
			Cookie loginCookie = new Cookie("user",email);
			res.addCookie(loginCookie);
			res.sendRedirect("dashboard.jsp");
			
		}else{
			
			System.out.println("Kaga sama!");
			
		}
		
		
	}
	
}
