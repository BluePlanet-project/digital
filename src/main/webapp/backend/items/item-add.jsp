<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="multipart/form-data; charset=UTF-8">
<title>[後台]新增</title>
<link rel="stylesheet" type="text/css" href="/backend/css/hotnews/style.css" />
<link rel="stylesheet" type="text/css" href="/backend/css/hotnews/add.css" />
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
			<form id="upload" action="/backend/item-add.do" enctype="multipart/form-data" method="post">
				<input type="hidden" id="action" name="action" value="${action}" />
				<div class="tab_div">
				<ul class="tabs">
					<li>
						<input type="radio" checked name="tabs" id="tab1">
				        <label for="tab1">中文</label>
				        <div id="tab-content1" class="tab-content animated fadeIn">
				        	<div id="hotnews-add-table">
								<div class="hotnews-add-tr">
									<div class="hotnews-add-td"><span>新增</span></div>
									<div class="hotnews-add-td"></div>
								</div>
								<div class="hotnews-add-tr">
									<div class="hotnews-add-td"><span>標題</span></div>
									<div class="hotnews-add-td">
										<input type="text" id="title_cht" name="title_cht" formcheck="1" errMsg="請輸入標題"/>
										<div id="title_msg"></div>
									</div>
								</div>
								<div class="hotnews-add-tr">
									<div class="hotnews-add-td">副標題</div>
									<div class="hotnews-add-td">
										<input type="text" id="subtitle_cht" name="subtitle_cht" formcheck="1" errMsg="請輸入副標題"/>
										<div id="subtitle_msg"></div>
									</div>
								</div>
								<div class="hotnews-add-tr">
									<div class="hotnews-add-td">敘述</div>
									<div class="hotnews-add-td">
										<textarea id="description_cht" name="description_cht" formcheck="1" errMsg="請輸入敘述"/></textarea>
										<div id="description_msg"></div>	
									</div>
								</div>
								<div class="hotnews-add-tr" <c:if test="${action == 'homebanner'}">style="display:none;"</c:if>>
									<div class="hotnews-add-td">內容(短)</div>
									<div class="hotnews-add-td">
										<textarea id="content_short_cht" name="content_short_cht" <c:if test="${action != 'homebanner'}">formcheck="1"</c:if> errMsg="請輸入內容(短)"/></textarea>
										<div id="content_short_msg"></div>
									</div>
								</div>
								<div class="hotnews-add-tr" <c:if test="${action == 'homebanner'}">style="display:none;"</c:if>>
									<div class="hotnews-add-td">內容(長)</div>
									<div class="hotnews-add-td">
										<textarea id="content_long_cht" name="content_long_cht" <c:if test="${action != 'homebanner'}">mceEditor="1"</c:if> errMsg="請輸入內容(長)"/></textarea>
										<div id="content_long_msg"></div>
									</div>
								</div>
								<div class="hotnews-add-tr">
									<div class="hotnews-add-td">作者</div>
									<div class="hotnews-add-td">
										<input type="text" id="author_cht" name="author_cht" formcheck="1" errMsg="請輸入作者"/>
										<div id="author_msg"></div>
									</div>
								</div>
								<div class="hotnews-add-tr">
									<div class="hotnews-add-td">連結一</div>
									<div class="hotnews-add-td">
										<input type="text" id="link_1_cht" name="link_1_cht"/>
										<button id="linkgenerator" onclick="generateLink();return false;">產生連結</button>
									</div>
								</div>
								<!-- <div class="hotnews-add-tr">
									<div class="hotnews-add-td">連結二</div>
									<div class="hotnews-add-td"><input type="text" id="link_2_cht" name="link_2_cht"/></div>
								</div>
								<div class="hotnews-add-tr">
									<div class="hotnews-add-td">連結三</div>
									<div class="hotnews-add-td"><input type="text" id="link_3_cht" name="link_3_cht"/></div>
								</div> -->
								<div class="hotnews-add-tr">
									<div class="hotnews-add-td">圖片一</div>
									<div class="hotnews-add-td"><input type="file" id="image_1_cht" name="image_1_cht" formcheck="1" errMsg="請上傳圖片一"/></div>
								</div>
								<!-- <div class="hotnews-add-tr">
									<div class="hotnews-add-td">圖片二</div>
									<div class="hotnews-add-td"><input type="file" id="image_2_cht" name="image_2_cht" /></div>
								</div>
								<div class="hotnews-add-tr">
									<div class="hotnews-add-td">圖片三</div>
									<div class="hotnews-add-td"><input type="file" id="image_3_cht" name="image_3_cht" /></div>
								</div> -->
								<!-- <div class="hotnews-add-tr">
									<div class="hotnews-add-td">分類標籤</div>
									<div class="hotnews-add-td">
										<select id="breadcrumb_1" name="breadcrumb_1_cht">
											<c:forEach items="${level_one}" var="bread">
												<c:if test="${bread.breadcrumb_lang_id == 1}">
													<option value="${bread.breadcrumb_id}">${bread.breadcrumb_name}</option>
												</c:if>
											</c:forEach>
										</select>&nbsp;>&nbsp;
										<select id="breadcrumb_2" name="breadcrumb_2_cht">
											<c:forEach items="${level_two}" var="bread">
												<c:if test="${bread.breadcrumb_lang_id == 1}">
													<option value="${bread.breadcrumb_id}">${bread.breadcrumb_name}</option>
												</c:if>
											</c:forEach>
										</select>&nbsp;>&nbsp;
										<select id="breadcrumb_3" name="breadcrumb_3_cht">
											<c:forEach items="${level_three}" var="bread">
												<c:if test="${bread.breadcrumb_lang_id == 1}">
													<option value="${bread.breadcrumb_id}">${bread.breadcrumb_name}</option>
												</c:if>
											</c:forEach>
										</select>
									</div>
								</div> -->
								<div class="hotnews-add-tr">
									<div class="hotnews-add-td">檔案下載一</div>
									<div class="hotnews-add-td"><input type="file" id="file_1_cht" name="file_1_cht" /></div>
								</div>
								<div class="hotnews-add-tr">
									<div class="hotnews-add-td">檔案下載二</div>
									<div class="hotnews-add-td"><input type="file" id="file_2_cht" name="file_2_cht" /></div>
								</div>
								<div class="hotnews-add-tr">
									<div class="hotnews-add-td">檔案下載三</div>
									<div class="hotnews-add-td"><input type="file" id="file_3_cht" name="file_3_cht" /></div>
								</div>
								<div class="hotnews-add-tr">
									<div class="hotnews-add-td">新增日期</div>
									<div class="hotnews-add-td"></div>
								</div>
								<div class="hotnews-add-tr">
									<div class="hotnews-add-td">瀏覽次數</div>
									<div class="hotnews-add-td"></div>
								</div>
								<div class="hotnews-add-tr">
									<div class="hotnews-add-td">置頂</div>
									<div class="hotnews-add-td">
										<select id="top_cht" name="top_cht">
											<option value="0">否</option>
											<option value="1">是</option>
										</select>
									</div>
								</div>
								<div class="hotnews-add-tr">
									<div class="hotnews-add-td">啟用</div>
									<div class="hotnews-add-td">
										<select id="enabled_cht" name="enabled_cht">
											<option value="0">否</option>
											<option value="1">是</option>
										</select>
									</div>
								</div>
							</div>
							<section>
								<div id="container_buttons">
									<p>
										<a class="function_btn" href="#" onclick="submit();return false;">送出</a>
									</p>
								</div>
							</section>
				        </div>
					</li>
					<li>
						<input type="radio" name="tabs" id="tab2">
				        <label for="tab2">English</label>
				        <div id="tab-content2" class="tab-content animated fadeIn">
				        	<div id="hotnews-add-table">
								<div class="hotnews-add-tr">
									<div class="hotnews-add-td"><span>New Create</span></div>
									<div class="hotnews-add-td"></div>
								</div>
								<div class="hotnews-add-tr">
									<div class="hotnews-add-td">Title</div>
									<div class="hotnews-add-td"><input type="text" id="title_enu" name="title_enu"/></div>
								</div>
								<div class="hotnews-add-tr">
									<div class="hotnews-add-td">Subtitle</div>
									<div class="hotnews-add-td"><input type="text" id="subtitle_enu" name="subtitle_enu"/></div>
								</div>
								<div class="hotnews-add-tr">
									<div class="hotnews-add-td">Description</div>
									<div class="hotnews-add-td"><textarea id="description_enu" name="description_enu"/></textarea></div>
								</div>
								<div class="hotnews-add-tr" <c:if test="${action == 'homebanner'}">style="display:none;"</c:if>>
									<div class="hotnews-add-td">Content(short)</div>
									<div class="hotnews-add-td"><textarea id="content_short_enu" name="content_short_enu"/></textarea></div>
								</div>
								<div class="hotnews-add-tr" <c:if test="${action == 'homebanner'}">style="display:none;"</c:if>>
									<div class="hotnews-add-td">Content(long)</div>
									<div class="hotnews-add-td"><textarea id="content_long_enu" name="content_long_enu"/></textarea></div>
								</div>
								<div class="hotnews-add-tr">
									<div class="hotnews-add-td">Author</div>
									<div class="hotnews-add-td"><input type="text" id="author_enu" name="author_enu"/></div>
								</div>
								<div class="hotnews-add-tr">
									<div class="hotnews-add-td">LinkA</div>
									<div class="hotnews-add-td"><input type="text" id="link_1_enu" name="link_1_enu"/></div>
								</div>
								<!-- <div class="hotnews-add-tr">
									<div class="hotnews-add-td">LinkB</div>
									<div class="hotnews-add-td"><input type="text" id="link_2_enu" name="link_2_enu"/></div>
								</div>
								<div class="hotnews-add-tr">
									<div class="hotnews-add-td">LinkC</div>
									<div class="hotnews-add-td"><input type="text" id="link_3_enu" name="link_3_enu"/></div>
								</div> -->
								<div class="hotnews-add-tr">
									<div class="hotnews-add-td">ImageA</div>
									<div class="hotnews-add-td"><input type="file" id="image_1_enu" name="image_1_enu" /></div>
								</div>
								<!-- <div class="hotnews-add-tr">
									<div class="hotnews-add-td">ImageB</div>
									<div class="hotnews-add-td"><input type="file" id="image_2_enu" name="image_2_enu" /></div>
								</div>
								<div class="hotnews-add-tr">
									<div class="hotnews-add-td">ImageC</div>
									<div class="hotnews-add-td"><input type="file" id="image_3_enu" name="image_3_enu" /></div>
								</div>
								<div class="hotnews-add-tr">
									<div class="hotnews-add-td">Breadcrumb</div>
									<div class="hotnews-add-td">
										<select id="breadcrumb_1" name="breadcrumb_1_enu">
											<c:forEach items="${level_one}" var="bread">
												<c:if test="${bread.breadcrumb_lang_id == 2}">
													<option value="${bread.breadcrumb_id}">${bread.breadcrumb_name}</option>
												</c:if>
											</c:forEach>
										</select>&nbsp;>&nbsp;
										<select id="breadcrumb_2" name="breadcrumb_2_enu">
											<c:forEach items="${level_two}" var="bread">
												<c:if test="${bread.breadcrumb_lang_id == 2}">
													<option value="${bread.breadcrumb_id}">${bread.breadcrumb_name}</option>
												</c:if>
											</c:forEach>
										</select>&nbsp;>&nbsp;
										<select id="breadcrumb_3" name="breadcrumb_3_enu">
											<c:forEach items="${level_three}" var="bread">
												<c:if test="${bread.breadcrumb_lang_id == 2}">
													<option value="${bread.breadcrumb_id}">${bread.breadcrumb_name}</option>
												</c:if>
											</c:forEach>
										</select>
									</div>
								</div> -->
								<div class="hotnews-add-tr">
									<div class="hotnews-add-td">FileA</div>
									<div class="hotnews-add-td"><input type="file" id="file_1_enu" name="file_1_enu" /></div>
								</div>
								<div class="hotnews-add-tr">
									<div class="hotnews-add-td">FileB</div>
									<div class="hotnews-add-td"><input type="file" id="file_2_enu" name="file_2_enu" /></div>
								</div>
								<div class="hotnews-add-tr">
									<div class="hotnews-add-td">FileC</div>
									<div class="hotnews-add-td"><input type="file" id="file_3_enu" name="file_3_enu" /></div>
								</div>
								<div class="hotnews-add-tr">
									<div class="hotnews-add-td">Create Date</div>
									<div class="hotnews-add-td"></div>
								</div>
								<div class="hotnews-add-tr">
									<div class="hotnews-add-td">Page View</div>
									<div class="hotnews-add-td"></div>
								</div>
								<div class="hotnews-add-tr">
									<div class="hotnews-add-td">Top</div>
									<div class="hotnews-add-td">
										<select id="top_enu" name="top_enu">
											<option value="0">No</option>
											<option value="1">Yes</option>
										</select>
									</div>
								</div>
								<div class="hotnews-add-tr">
									<div class="hotnews-add-td">Enabled</div>
									<div class="hotnews-add-td">
										<select id="enabled_enu" name="enabled_enu">
											<option value="0">No</option>
											<option value="1">Yes</option>
										</select>
									</div>
								</div>
							</div>
							<section>
								<div id="container_buttons">
									<p>
										<a class="function_btn" href="#" onclick="submit();return false;">Submit</a>
									</p>
								</div>
							</section>
				        </div>
					</li>
				</ul>
				</div>
			</form>
		</div>
	</div>
</div>
<script type="text/javascript" src="/backend/js/formcheck/script.js"></script>
<script type="text/javascript" src="/backend/js/formcheck/inputlimit.js"></script>
<script src="//tinymce.cachefly.net/4.1/tinymce.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	tinymce.init({
		selector:'textarea#content_long_cht,textarea#content_long_enu',
		menubar : true,
		plugins: "image link media"
	});
});

function submit(){
	if(formCheck($('#upload'))){
		if(mceChecker($('#upload'))){
			$('#description_cht').val($('#description_cht').val().replace(/\n/g, "<br />"));
			$('#upload').submit();
		}
	}
}

function generateLink(){
	$('#link_1_cht').val('/detail.do?action=${action}&id=%ID%');
}

function ReplaceAll(strOrg,strFind,strReplace)
{
    return strOrg.replace(new RegExp(strFind,"g"),strReplace);
}

$(function() {
    $('#title_cht').ChineseLengthLimit({
      limitCount: 130,
      isByte: true,
      callback: function (data) {
        $("#title_msg").html("目前輸入:" + data.input + "/" + data.max + " 還剩:" + data.left + "字元");
      }
    }).focus();

    $('#subtitle_cht').ChineseLengthLimit({
        limitCount: 130,
        isByte: true,
        callback: function (data) {
          $("#subtitle_msg").html("目前輸入:" + data.input + "/" + data.max + " 還剩:" + data.left + "字元");
        }
    }).focus();

    $('#description_cht').ChineseLengthLimit({
        limitCount: 1000,
        isByte: true,
        callback: function (data) {
          $("#description_msg").html("目前輸入:" + data.input + "/" + data.max + " 還剩:" + data.left + "字元");
        }
    }).focus();

    $('#content_short_cht').ChineseLengthLimit({
        limitCount: 2500,
        isByte: true,
        callback: function (data) {
          $("#content_short_msg").html("目前輸入:" + data.input + "/" + data.max + " 還剩:" + data.left + "字元");
        }
    }).focus();

    $('#author_cht').ChineseLengthLimit({
        limitCount: 40,
        isByte: true,
        callback: function (data) {
          $("#author_msg").html("目前輸入:" + data.input + "/" + data.max + " 還剩:" + data.left + "字元");
        }
    }).focus();
});
</script>
<jsp:include page="/backend/footer/footer.jsp"></jsp:include>
</body>
</html>