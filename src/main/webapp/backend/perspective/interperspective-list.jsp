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
<jsp:include page="/backend/header/header.jsp">
	 <jsp:param name="menu_id" value="1" />
</jsp:include>
<script type="text/javascript" src="/backend/js/pagination/jquery.simplePagination.js"></script>
<script type="text/javascript">
$(function() {
    $('#pagination').pagination({
        items: ${totalNumbers},
        currentPage: ${page},
        itemsOnPage: 10,
        displayedPages: 5,
        cssStyle: 'light-theme',
        hrefTextPrefix:'?page='
    });
});

function deleteItem(id){
	if(confirm("確定要刪除?")){
		window.location.href = "/backend/hotnews-delete.do?hotnews_id=" + id;
	}
}
</script>
<hr />
<div id="top_bar">
	<div class="action_btn">
		<a class="function_btn" href="/backend/hotnews-new.do">新增</a>
	</div>
	<div id="pagination" class="pagination light-theme simple-pagination">
	</div>
</div>
<form action="">

<div id="hotnews-list-table">
	<div class="hotnews-list-tr">
		<div class="hotnews-list-td"><span>#</span></div>
		<div class="hotnews-list-td"><span>編號</span></div>
		<div class="hotnews-list-td"><span>標題</span></div>
		<div class="hotnews-list-td"><span>作者</span></div>
		<div class="hotnews-list-td"><span>新增時間</span></div>
		<div class="hotnews-list-td"><span>功能</span></div>
	</div>
	<c:forEach items="${requestScope.hotnewsList}" var="hotnews" varStatus="number">
	<div class="hotnews-list-tr">
		<div class="hotnews-list-td">${number.index + 1}</div>
		<div class="hotnews-list-td"><a href="/backend/hotnews-view.do?hotnews_id=${hotnews.hotnews_id}">${hotnews.hotnews_id}</a></div>
		<div class="hotnews-list-td">${hotnews.title}</div>
		<div class="hotnews-list-td">${hotnews.author}</div>
		<div class="hotnews-list-td">${hotnews.createDate}</div>
		<div class="hotnews-list-td">
			<section>
				<div id="container_buttons">
					<p>
						<a class="function_btn" href="/backend/hotnews-view.do?hotnews_id=${hotnews.hotnews_id}">編輯</a>
					</p>
					<p>
						<a class="function_btn delete_btn" href="#" onclick="deleteItem(${hotnews.hotnews_id});return false;">刪除</a>
					</p>
				</div>
			</section>
		</div>
	</div>
	</c:forEach>
</div>

</form>
<jsp:include page="/backend/footer/footer.jsp"></jsp:include>
</body>
</html>