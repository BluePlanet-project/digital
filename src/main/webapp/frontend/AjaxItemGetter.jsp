<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.oreilly.servlet.ParameterParser" %>
<%@ page import="com.digital.frontend.action.dao.converage.ConverageDAO" %>
<%@ page import="com.digital.frontend.action.dao.interperspective.InterPerspectiveDAO" %>
<%@ page import="com.digital.frontend.action.dao.hotnews.HotNewsDAO" %>
<%@ page import="com.digital.frontend.common.bean.CommonDataBean" %>
<%@ page import="org.json.simple.JSONArray" %>
<%@ page import="org.json.simple.JSONObject" %>
<%
	ParameterParser parser = new ParameterParser(request);

	int action = parser.getIntParameter("action", 0);
	JSONArray jsonArray = new JSONArray();
	if(action == 1){//hotnews
		jsonArray = HotNewsDAO.getInstance().getAJAXData(1);
	}else if(action == 2){//research planning
		
	}else if(action == 3){//research resource
		
	}else if(action == 4){//theme report
		jsonArray = ConverageDAO.getInstance().getAJAXData(1);
	}else if(action == 5){//international perspective
		jsonArray = InterPerspectiveDAO.getInstance().getAJAXData(1);
	}else if(action == 6){//seeing Taiwan
		
	}
	out.clear();
	out.println(jsonArray.toJSONString());
%>