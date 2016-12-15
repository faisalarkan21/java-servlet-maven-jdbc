package com.faisalarkan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;

import com.faisalarkan.config.Dbconf;
import com.faisalarkan.model.User;

public class UserDao {

	private Connection connection ;

	public UserDao (){

		this.connection = Dbconf.getConnection();

	}

	public void addUser (User user){

		try{

			PreparedStatement pre = connection.prepareStatement("insert into user(email,password) values (?,?)");


			pre.setString(1, user.getEmail());
			pre.setString(2, user.getPassword());

			pre.executeUpdate();

			System.out.println("SUKSES !!!!aAAAA");

		}catch (Exception e){
			e.printStackTrace();
		}
	}




}
