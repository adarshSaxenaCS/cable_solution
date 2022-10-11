package com.thinking.machine.entity;

public class AdminCompt {
private String uname;
private String compt;
private String ward_no;
private String user_status;
private String operator;
private String operator_status;
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public String getCompt() {
	return compt;
}
public void setCompt(String compt) {
	this.compt = compt;
}
public String getWard_no() {
	return ward_no;
}
public void setWard_no(String ward_no) {
	this.ward_no = ward_no;
}
public String getUser_status() {
	return user_status;
}
public void setUser_status(String user_status) {
	this.user_status = user_status;
}
public String getOperator() {
	return operator;
}
public void setOperator(String operator) {
	this.operator = operator;
}
public String getOperator_status() {
	return operator_status;
}
public void setOperator_status(String operator_status) {
	this.operator_status = operator_status;
}
@Override
public String toString() {
	return "AdminCompt [uname=" + uname + ", compt=" + compt + ", ward_no=" + ward_no + ", user_status=" + user_status
			+ ", operator=" + operator + ", operator_status=" + operator_status + "]";
}

	
	
	

}
