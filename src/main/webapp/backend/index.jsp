<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList" %>
<%@page import="com.digital.backend.dao.backmenu.BackMenuDAO" %>
<%
request.setAttribute("menuList", BackMenuDAO.getInstance().getMenu());

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TDH後台管理系統</title>
<link rel="stylesheet" href="/backend/css/index/index-style.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.2.min.js"></script>
</head>
<body>
<div class="fixed-header">
	<div id="backend-title">TDH後台管理系統</div>
	<div id="logout-btn"><a href="<c:url value="j_spring_security_logout" />">登出</a></div>
</div>
<div id="container">
	<div id="main" class="table-item">
		<div class="row-item">
			<div class="column-item menu">
				<!-- Menu bar -->
				<div class="table-menu">
					<c:forEach items="${menuList}" var="menuItem">
						<div class="row-menu">
							<div class="column-menu">
								<a href="${menuItem.target}"><div class="button">${menuItem.menu_name}</div></a>
							</div>
						</div>
					</c:forEach>
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