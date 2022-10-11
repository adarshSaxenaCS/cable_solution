package com.thinking.machine.entity;

public class Login {
	private String uname;
	private String upass;
	private String utype;
	private int ward_no;
	private String phone_no;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public String getUtype() {
		return utype;
	}
	public void setUtype(String utype) {
		this.utype = utype;
	}
	public int getWard_no() {
		return ward_no;
	}
	public void setWard_no(int ward_no) {
		this.ward_no = ward_no;
	}
	public String getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	@Override
	public String toString() {
		return "Login [uname=" + uname + ", upass=" + upass + ", utype=" + utype + ", ward_no=" + ward_no
				+ ", phone_no=" + phone_no + "]";
	}
	
			

}
