package com.digital.backend.bean.backmenu;

public class BackMenuBean {
	int menu_id;
	int authority_id;
	String menu_name;
	String menu_name_enu;
	int enabled;
	String target;
	public int getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}
	public int getAuthority_id() {
		return authority_id;
	}
	public void setAuthority_id(int authority_id) {
		this.authority_id = authority_id;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getMenu_name_enu() {
		return menu_name_enu;
	}
	public void setMenu_name_enu(String menu_name_enu) {
		this.menu_name_enu = menu_name_enu;
	}
}
