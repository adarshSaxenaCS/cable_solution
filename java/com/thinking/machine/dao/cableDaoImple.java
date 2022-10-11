package com.thinking.machine.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.thinking.machine.MyConnection;
import com.thinking.machine.entity.AdminCompt;
import com.thinking.machine.entity.Login;
import com.thinking.machine.entity.OperatorCompt;

public class cableDaoImple implements cableDao{

	
	@Override
	public ArrayList<AdminCompt> getAdminComptData() {
		MyConnection myConnection=new MyConnection();
		ArrayList<AdminCompt> ar=new ArrayList<AdminCompt>();
	
		AdminCompt adminCompt;
		
		try {
			Connection con=myConnection.getMyConnection();
			PreparedStatement ps=con.prepareStatement("select * from admin_compt order by user_status desc");
            ResultSet  r=ps.executeQuery();
			while(r.next())
			{
				
			adminCompt=new AdminCompt();
			
			String uname=r.getString(1);
			String compt=r.getString(2);
			String wardNo=r.getString(3);
			String UStatus=r.getString(4);
			String operator=r.getString(5);
			String OStatus=r.getString(6);
			
			
			adminCompt.setUname(uname);
			adminCompt.setCompt(compt);
			adminCompt.setWard_no(wardNo);
			adminCompt.setUser_status(UStatus);
			adminCompt.setOperator(operator);
			adminCompt.setOperator_status(OStatus);
		   ar.add(adminCompt);
			}
			
			con.close();
			ps.close();
			
		
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	
		return ar;
		}

	@Override
	public Login getLoginData(String uname) {
		
		MyConnection myConnection=new MyConnection();
	    Login login=new Login();
		
		Connection con;
		try {
			con = myConnection.getMyConnection();
			PreparedStatement ps=con.prepareStatement("select * from login where uname=?");
			ps.setString(1, uname);
			
			ResultSet r=ps.executeQuery();
			r.next();
			
			login.setUname(r.getString(1));
			login.setUpass(r.getString(2));
			login.setUtype(r.getString(3));
			login.setWard_no(r.getInt(4));
			login.setPhone_no(r.getString(5));
			
			con.close();
			ps.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return login;
	}

	@Override
	public ArrayList<Login> getLoginData() {
	
		MyConnection myConnection=new MyConnection();
		ArrayList<Login> ar=new ArrayList<Login>();
	    
		Connection con;
		try {
			con = myConnection.getMyConnection();
			PreparedStatement ps=con.prepareStatement("select * from login");
			ResultSet r=ps.executeQuery();
			Login login;
			while(r.next())
			{
		      login=new Login();
				
			login.setUname(r.getString(1));
			login.setUpass(r.getString(2));
			login.setUtype(r.getString(3));
			login.setWard_no(r.getInt(4));
			login.setPhone_no(r.getString(5));
			
			ar.add(login);
			
			}
			
			con.close();
			ps.close();
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return ar;
	}

	@Override
	public ArrayList<OperatorCompt> getOperatorComptData() {
		
		MyConnection myConnection=new MyConnection();
		ArrayList<OperatorCompt> ar=new ArrayList<OperatorCompt>();
	    
		Connection con;
		try {
			con = myConnection.getMyConnection();
			PreparedStatement ps=con.prepareStatement("select * from operator_compt");
			ResultSet r=ps.executeQuery();
			OperatorCompt oc;
			while(r.next())
			{
		      oc=new OperatorCompt();
				
			oc.setUname(r.getString(1));
			oc.setCompt(r.getString(2));
			oc.setPhone_no(r.getString(3));
			oc.setOperator_status(r.getString(4));
			
			
			
			
			ar.add(oc);
			
			}
			
			con.close();
			ps.close();
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return ar;

		
		
		}

	@Override
	public Login getOperatorLoginData(int word_no) {
		
		MyConnection myConnection=new MyConnection();
	    Login login=new Login();
		
		Connection con;
		try {
			con = myConnection.getMyConnection();
			PreparedStatement ps=con.prepareStatement("select * from login where utype='OPERATOR' and ward_no=?");
			ps.setInt(1,word_no);
			
			ResultSet r=ps.executeQuery();
			r.next();
			
			login.setUname(r.getString(1));
			login.setUpass(r.getString(2));
			login.setUtype(r.getString(3));
			login.setWard_no(r.getInt(4));
			login.setPhone_no(r.getString(5));
			
			con.close();
			ps.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return login;

		
		
		
		
		
		
	}

	@Override
	public void addAdminComptData(AdminCompt adminCompt) {
   if(adminCompt==null)return;
   
   MyConnection myConnection=new MyConnection();
	int count=0;
	Connection con;
	try {
		con = myConnection.getMyConnection();
		
		PreparedStatement ps=con.prepareStatement("select count(*) from admin_compt ");
		ResultSet r=ps.executeQuery();
		if(r.next()) count=r.getInt(1);
		
		
		
		ps.close();
		r.close();
        
		
		
          ps=con.prepareStatement("select * from admin_compt");
          r=ps.executeQuery();
		String n;
		String c;
		
		String name=adminCompt.getUname();
		String compt=adminCompt.getCompt();
		
		while(r.next())
		{
		n=r.getString(1);
		c=r.getString(2);
		if(n.equalsIgnoreCase(name) && c.equalsIgnoreCase(compt))return;
		}	
		
		ps.close();
		r.close();
		
		 ps=con.prepareStatement("insert into admin_compt values(?,?,?,?,?,?)");
		
		ps.setString(1,adminCompt.getUname());
		ps.setString(2,adminCompt.getCompt());
		ps.setString(3,adminCompt.getWard_no());
		ps.setString(4,String.valueOf(count));
		ps.setString(5,adminCompt.getOperator());
		ps.setString(6,adminCompt.getOperator_status());
		
		ps.execute();
					
				
		con.close();
		ps.close();
		
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

   
   
   
		
		
		
		
		
	}
	
	 public static void sort(ArrayList<AdminCompt> list) {
		  
	        list.sort((o1, o2)-> o2.getUser_status().compareTo(o1.getUser_status()));
	    }

	@Override
	public ArrayList<AdminCompt> getAdminComptData(String name) {
		
		
		MyConnection myConnection=new MyConnection();
		ArrayList<AdminCompt> ar=new ArrayList<AdminCompt>();
	
		AdminCompt adminCompt;
	
		try {
			Connection con=myConnection.getMyConnection();
			
			// select * from admin_compt order by user_status desc
			PreparedStatement ps=con.prepareStatement("select * from admin_compt where uname='"+name+"' ");
			ResultSet r=ps.executeQuery();
			while(r.next())
			{
				
			adminCompt=new AdminCompt();
			
			String uname=r.getString(1);
			String compt=r.getString(2);
			String wardNo=r.getString(3);
			String UStatus=r.getString(4);
			String operator=r.getString(5);
			String OStatus=r.getString(6);
			
			
			adminCompt.setUname(uname);
			adminCompt.setCompt(compt);
			adminCompt.setWard_no(wardNo);
			adminCompt.setUser_status(UStatus);
			adminCompt.setOperator(operator);
			adminCompt.setOperator_status(OStatus);
		   ar.add(adminCompt);
			}
			
			sort(ar);
			
			con.close();
			ps.close();
			
		
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	
		return ar;
	
		
	}
	
	
	

	@Override
	public Boolean getOperatorLoginData(String uname, String compt) {
		MyConnection myConnection=new MyConnection();
	   
	
		
		
		Connection con;
		try {
			con = myConnection.getMyConnection();
			PreparedStatement ps=con.prepareStatement("select * from operator_compt where uname='"+uname+"' and compt='"+compt+"' ");
			
			ResultSet r=ps.executeQuery();
			if(r.next()) return true;
			
			con.close();
			ps.close();
			return false;
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		

		
		

		
		
		
		
		return null;
	}
	
	

}
