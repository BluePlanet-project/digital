package com.digital.backend.bean.user;

public class AuthorityBean {
	int authority_id;
	String authority_name;
	String authority_create_date;
	public int getAuthority_id() {
		return authority_id;
	}
	public void setAuthority_id(int authority_id) {
		this.authority_id = authority_id;
	}
	public String getAuthority_name() {
		return authority_name;
	}
	public void setAuthority_name(String authority_name) {
		this.authority_name = authority_name;
	}
	public String getAuthority_create_date() {
		return authority_create_date;
	}
	public void setAuthority_create_date(String authority_create_date) {
		this.authority_create_date = authority_create_date;
	}
}
