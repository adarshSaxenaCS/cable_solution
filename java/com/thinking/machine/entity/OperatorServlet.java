package com.thinking.machine.entity;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thinking.machine.MyConnection;

@WebServlet("/OperatorServlet")
public class OperatorServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("uname");
		String compt=request.getParameter("compt");
		String phone_no=request.getParameter("phone_no");
		String status=request.getParameter("status");
		
		System.out.println(uname);
		System.out.println(compt);
		System.out.println(phone_no);
		System.out.println(status);
		
		
		MyConnection myConnection=new MyConnection();
		try {
			Connection con=myConnection.getMyConnection();
			PreparedStatement ps=con.prepareStatement("delete from operator_compt where uname=? and compt=? ");
			ps.setString(1, uname);
			ps.setString(2, compt);
			ps.execute();
			
			ps.close();
			
			
			ps=con.prepareStatement("update admin_compt set operator_status=? where uname=? and compt=? ");
			ps.setString(1,status);
			ps.setString(2, uname);
			ps.setString(3, compt);
			ps.execute();
			
			ps.close();
			
			con.close();
			
			
			
			
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		//delete from operator_compt where uname='ADARSH123' and compt='no signal'
		//update admin_compt set operator_status='Unsolved' where uname='ADARSH123' and compt='cable break';
		
		
		
		
		
		
		
	}
	

		

}
