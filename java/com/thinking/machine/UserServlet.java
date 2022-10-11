package com.thinking.machine;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thinking.machine.dao.cableDaoImple;
import com.thinking.machine.entity.AdminCompt;
import com.thinking.machine.entity.Login;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
        String compt=request.getParameter("compt");
		String uname=request.getParameter("uname");
		
		
		cableDaoImple cd=new cableDaoImple();
        Login userData=cd.getLoginData(uname);
        
        
        
        int ward_no=userData.getWard_no();
        Login operatorData=cd.getOperatorLoginData(ward_no);
        
        
        AdminCompt adminCompt=new AdminCompt();
        
        adminCompt.setUname(userData.getUname());
        adminCompt.setCompt(compt);
        
        adminCompt.setWard_no(String.valueOf(ward_no));        
        adminCompt.setUser_status("Unsolved");
        
        adminCompt.setOperator(operatorData.getUname());
        adminCompt.setOperator_status("Unsolved");
       
        
        cd.addAdminComptData(adminCompt);
		
        
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
