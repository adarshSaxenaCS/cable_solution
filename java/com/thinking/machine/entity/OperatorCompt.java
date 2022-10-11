package com.thinking.machine.entity;
public class OperatorCompt {
	private String uname;
	private String compt;
	private String phone_no;
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
	public String getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	public String getOperator_status() {
		return operator_status;
	}
	public void setOperator_status(String operator_status) {
		this.operator_status = operator_status;
	}
	@Override
	public String toString() {
		return "OperatorCompt [uname=" + uname + ", compt=" + compt + ", phone_no=" + phone_no + ", operator_status="
				+ operator_status + "]";
	}
	
	
	

}
