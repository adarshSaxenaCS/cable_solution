package com.thinking.machine.dao;
import java.util.ArrayList;
import com.thinking.machine.entity.AdminCompt;
import com.thinking.machine.entity.Login;
import com.thinking.machine.entity.OperatorCompt;

public interface cableDao {
	

public ArrayList<AdminCompt>  getAdminComptData();
public ArrayList<AdminCompt>  getAdminComptData(String uname);


public void  addAdminComptData(AdminCompt adminCompt);


public Login  getLoginData(String uname);
public Login  getOperatorLoginData(int word_no);
public Boolean  getOperatorLoginData(String uname,String compt);




public ArrayList<Login>  getLoginData();
public ArrayList<OperatorCompt>  getOperatorComptData();







}