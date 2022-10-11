package com.thinking.machine;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;


@WebServlet("/AdminComptServlet")
public class AdminComptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		String uname=request.getParameter("uname");
		String compt=request.getParameter("compt");
		String operator_status=request.getParameter("operator_status");
		String o_status="Unsolved";
		MyConnection myConnection=new MyConnection();
		try {
			Connection con=myConnection.getMyConnection();
			PreparedStatement ps=null;
			System.out.println("1");
			if(operator_status.equalsIgnoreCase("Solved"))
			{
				
				 ps=con.prepareStatement("update admin_compt set operator_status=? where uname=? and compt=? ");
				 ps.setString(1, o_status);
				 ps.setString(2, uname);
				 ps.setString(3, compt);
				 ps.execute();
				 ps.close();	
				
			}
			
			
			 ps=con.prepareStatement("select * from operator_compt");
				
			ResultSet r=ps.executeQuery();
			 String uname1;
			 String compt1;
			 while(r.next())
			 {
					
                        uname1=r.getString(1);
				        compt1=r.getString(2);				
		      if(uname.equalsIgnoreCase(uname1) && compt1.equalsIgnoreCase(compt))
		      {
		    	  ps.close();
		    	  r.close();
		    	  con.close();
		    	 
		    	  
		    	  return;
		    	  
		    	  
		      } 
		      
			 
			 }
			 
			 	
			 ps.close();
		     r.close();
			
		    ps=con.prepareStatement("select phone_no from login where uname=? ");
			ps.setString(1,uname);
		    r=ps.executeQuery();
		    
			r.next();
			String phone_no=r.getString(1);
			ps.close();
			r.close();
			ps=con.prepareStatement("insert into operator_compt values(?,?,?,?)");
			ps.setString(1,uname);
			ps.setString(2,compt);
			ps.setString(3, phone_no);
			ps.setString(4,operator_status);
			ps.execute();
			ps.close();
			r.close();
			con.close();
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	    
		
		
		
		
	}

	
	
}
