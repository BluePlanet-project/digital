<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<title>TDH後台管理系統</title>
<link rel="stylesheet" href="/backend/css/header/style.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.2.min.js"></script>
</head>
<body>
<div id="container">
	<div id="main" class="table-item">
		<div class="row-item">
			<div class="column-item menu">
				<!-- Menu bar -->
				<div class="table-menu">
					<c:forEach items="${menuList}" var="menuItem">
						<div class="row-menu">
							<div class="column-menu">
								<a href="${menuItem.target}"><div class="button <c:if test="${menuItem.menu_id == menu_id}">active</c:if> ">${menuItem.menu_name}</div></a>
							</div>
						</div>
					</c:forEach>
					<!-- Preview for homepage -->
					<div class="row-menu">
						<div class="column-menu">
							<a href="/index.do" target="_blank"><div class="button">首頁預覽</div></a>
						</div>
					</div>
				</div>
			</div>
			<!-- <div class="column-item">
				<div id="pane-item">
					
				</div>
			</div> -->
		</div>
	</div>
</div>
</body>
</html>