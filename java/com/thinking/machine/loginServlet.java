package com.thinking.machine;

import java.io.IOException;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;
import com.thinking.machine.entity.AdminCompt;
import com.thinking.machine.entity.Login;
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String uname=request.getParameter("uname");
	String upass=request.getParameter("upass");
	String utype=request.getParameter("utype");
	
   String utype1=utype;
   
	uname=uname.toUpperCase();
	utype=utype.toUpperCase();
		
	try {
		 
		MyConnection myConnection=new MyConnection();
		Connection con=myConnection.getMyConnection();
		
		
		HttpSession session=request.getSession();
		HttpSession session1=request.getSession();
		HttpSession session2=request.getSession();
		
		
	    PreparedStatement ps=con.prepareStatement("select * from login where uname='"+uname+"' and upass='"+upass+"' and utype='"+utype+"' ");
        
	    
	ResultSet resultSet=ps.executeQuery();

	
	
	String t;
	if(resultSet.next())
	{
     t=resultSet.getString(3);
     session.setAttribute("uname",uname); 	
 		
	if(t.equalsIgnoreCase("USER"))
	{
	response.sendRedirect("userHomePage.jsp");
			
	}
		
		
		
		
		if(t.equalsIgnoreCase("operator")) 
			{
			response.sendRedirect("operatorHomePage.jsp");	
			}
		
		if(t.equalsIgnoreCase("admin"))
		{
			response.sendRedirect("adminHomePage.jsp");		
		}
	
	
	}
	else
	{
		
		response.sendRedirect("logpage.jsp?utype="+utype1);
		
	}
	ps.close();
	resultSet.close();
	con.close();
		
		
		
	} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	} catch (SQLException e) {

		e.printStackTrace();
	}
	
	
	
		
		
	}
	
	
	
		}
	


