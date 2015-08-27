<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList" %>
<%@page import="com.digital.backend.dao.backmenu.BackMenuDAO" %>
<%
request.setAttribute("menuList", BackMenuDAO.getInstance().getMenu());

int menu_id = 0;
String menu_action = request.getParameter("menu_action") == null ? "" : request.getParameter("menu_action");
if("hotnews".equals(menu_action)){
	menu_id = 1;
}else if("interperspective".equals(menu_action)){
	menu_id = 2;
}else if("converage".equals(menu_action)){
	menu_id = 3;
}else if("research".equals(menu_action)){
	menu_id = 4;
}else if("knowTaiwan".equals(menu_action)){
	menu_id = 5;
}else if("database".equals(menu_action)){
	menu_id = 6;
}else if("dataaddon".equals(menu_action)){
	menu_id = 7;
}else if("researchResource".equals(menu_action)){
	menu_id = 8;
}else if("relatedWeb".equals(menu_action)){
	menu_id = 9;
}else if("academic".equals(menu_action)){
	menu_id = 10;
}else if("homebanner".equals(menu_action)){
	menu_id = 11;
}
request.setAttribute("menu_id", menu_id);

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/backend/css/menubar/styles.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.2.min.js"></script>
</head>
<body>
<div id='cssmenu'>
	<ul>
	   	<c:forEach items="${menuList}" var="menuItem">
		   	<c:if test="${menuItem.enabled == 1}">
			   	<li <c:if test="${menuItem.menu_id == menu_id}">class='active'</c:if>><a href='${menuItem.target}'>${menuItem.menu_name}</a></li>
		   	</c:if>
	   	</c:forEach>
	   	<li style="float:right;"><a href="<c:url value="j_spring_security_logout" />" >登出</a></li>
	</ul>
</div>
</body>
</html>