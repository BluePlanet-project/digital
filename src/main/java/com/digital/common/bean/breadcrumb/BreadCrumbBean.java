package com.digital.common.bean.breadcrumb;

public class BreadCrumbBean {
	int id;
	int breadcrumb_id;
	int breadcrumb_lang_id;
	String breadcrumb_name;
	String breadcrumb_url;
	boolean breadcrumb_enabled;
	int breadcrumb_level;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBreadcrumb_id() {
		return breadcrumb_id;
	}
	public void setBreadcrumb_id(int breadcrumb_id) {
		this.breadcrumb_id = breadcrumb_id;
	}
	public int getBreadcrumb_lang_id() {
		return breadcrumb_lang_id;
	}
	public void setBreadcrumb_lang_id(int breadcrumb_lang_id) {
		this.breadcrumb_lang_id = breadcrumb_lang_id;
	}
	public String getBreadcrumb_name() {
		return breadcrumb_name;
	}
	public void setBreadcrumb_name(String breadcrumb_name) {
		this.breadcrumb_name = breadcrumb_name;
	}
	public String getBreadcrumb_url() {
		return breadcrumb_url;
	}
	public void setBreadcrumb_url(String breadcrumb_url) {
		this.breadcrumb_url = breadcrumb_url;
	}
	public boolean isBreadcrumb_enabled() {
		return breadcrumb_enabled;
	}
	public void setBreadcrumb_enabled(boolean breadcrumb_enabled) {
		this.breadcrumb_enabled = breadcrumb_enabled;
	}
	public int getBreadcrumb_level() {
		return breadcrumb_level;
	}
	public void setBreadcrumb_level(int breadcrumb_level) {
		this.breadcrumb_level = breadcrumb_level;
	}
}
