<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[後台]最新消息</title>
<link rel="stylesheet" type="text/css" href="/backend/css/hotnews/style.css">
<link type="text/css" rel="stylesheet" href="/backend/css/pagination/simplePagination.css"/>
</head>
<body>
<div class="fixed-header">
	<div id="backend-title">TDH後台管理系統</div>
	<div id="logout-btn"><a href="<c:url value="j_spring_security_logout" />">登出</a></div>
</div>
<div id="page-container">
	<div id="page-row">
		<div id="page-column" style="width: 20%">
			<jsp:include page="/backend/header/header-new.jsp">
				 <jsp:param name="menu_action" value="${action}" />
			</jsp:include>
		</div>
		<div id="page-column" style="width: 80%;">
			<div id="top_bar">
				<div class="action_btn">
					<a href="/backend/item-new.do?action=${action}"><div class="action-add-btn">新增</div></a>
				</div>
				<div id="pagination" class="pagination light-theme simple-pagination">
				</div>
			</div>
			<div id="hotnews-list-table">
				<div class="hotnews-list-tr">
					<div class="hotnews-list-td"><span>#</span></div>
					<div class="hotnews-list-td"><span>排序</span></div>
					<div class="hotnews-list-td"><span>編號</span></div>
					<div class="hotnews-list-td"><span>標題</span></div>
					<div class="hotnews-list-td"><span>作者</span></div>
					<div class="hotnews-list-td"><span>新增時間</span></div>
					<div class="hotnews-list-td"><span>功能</span></div>
				</div>
				<c:forEach items="${requestScope.itemList}" var="item" varStatus="number">
				<div class="hotnews-list-tr">
					<div class="hotnews-list-td">${number.index + 1}</div>
					<div class="hotnews-list-td">
						<input type="text" id="displayOrder${item.id}" name="displayOrder${item.id}" value="${item.displayOrder}" size="2"/>&nbsp;
						<a href="#" onclick="updateDisplayOrder(${item.id});return false;"><img src="/backend/images/refresh.png" height="20px"/></a>
					</div>
					<div class="hotnews-list-td"><a href="/backend/item-view.do?action=${action}&id=${item.id}&page=${page}">${item.id}</a></div>
					<div class="hotnews-list-td">${item.title}</div>
					<div class="hotnews-list-td">${item.author}</div>
					<div class="hotnews-list-td">${item.createDate}</div>
					<div class="hotnews-list-td">
						<section>
							<div id="container_buttons">
								<a href="/backend/item-view.do?action=${action}&id=${item.id}&page=${page}"><div class="editor-btn">編輯</div></a>
								<a href="#" onclick="deleteItem(${item.id});return false;"><div class="delete-btn">刪除</div></a>
							</div>
						</section>
					</div>
				</div>
				</c:forEach>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript" src="/backend/js/pagination/jquery.simplePagination.js"></script>
<script type="text/javascript">
$(function() {
    $('#pagination').pagination({
        items: ${totalNumbers},
        currentPage: ${page},
        itemsOnPage: 10,
        displayedPages: 5,
        cssStyle: 'light-theme',
        hrefTextPrefix:'?action=${action}&page='
    });
});

function deleteItem(id){
	if(confirm("確定要刪除?")){
		window.location.href = "/backend/item-delete.do?action=${action}&id=" + id;
	}
}

function updateDisplayOrder(id){
	window.location.href = "/backend/item-updorder.do?action=${action}&id=" + id + "&displayOrder=" + $('#displayOrder' + id).val();
}
</script>
<jsp:include page="/backend/footer/footer.jsp"></jsp:include>
</body>
</html>