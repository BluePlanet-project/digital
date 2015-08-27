<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% String contextName = request.getContextPath(); %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[後台]最新消息-修改</title>
<link rel="stylesheet" type="text/css" href="/backend/css/hotnews/style.css" />
<link rel="stylesheet" type="text/css" href="/backend/css/hotnews/add.css" />
</head>
<body>
<jsp:include page="/backend/header/header.jsp">
	<jsp:param name="menu_id" value="1" />
</jsp:include>
<script type="text/javascript" src="/backend/js/formcheck/script.js"></script>
<script type="text/javascript">
function submit(){
	if(formCheck($('#upload'))){
		$('#upload').submit();
	}
}
</script>
<hr />
<form id="upload" action="/backend/hotnews-edit.do" enctype="multipart/form-data" method="post">
<div class="tab_div">
<ul class="tabs">
	<c:forEach items="${hotnewsList}" var="hotnews" varStatus="number">
		<c:choose>
			<c:when test="${hotnews.lang_id == 1}">
				<li>
					<input type="radio" checked name="tabs" id="tab1">
					<label for="tab1">中文</label>
					<div id="tab-content1" class="tab-content animated fadeIn">
						<div id="hotnews-add-table">
							<div class="hotnews-add-tr">
								<div class="hotnews-add-td"><span>修改最新消息</span></div>
								<div class="hotnews-add-td"></div>
							</div>
							<div class="hotnews-add-tr">
								<div class="hotnews-add-td"><span>編號</span></div>
								<div class="hotnews-add-td">
									<input type="hidden" name="hotnews_id" value="${hotnews.hotnews_id}"/>
									${hotnews.hotnews_id}
								</div>
							</div>
							<div class="hotnews-add-tr">
								<div class="hotnews-add-td"><span>標題</span></div>
								<div class="hotnews-add-td"><input type="text" id="title_cht" name="title_cht" value="${hotnews.title}" formcheck="1" errMsg="請輸入標題"/></div>
							</div>
							<div class="hotnews-add-tr">
								<div class="hotnews-add-td">副標題</div>
								<div class="hotnews-add-td"><input type="text" id="subtitle_cht" name="subtitle_cht" value="${hotnews.subtitle}" formcheck="1" errMsg="請輸入副標題"/></div>
							</div>
							<div class="hotnews-add-tr">
								<div class="hotnews-add-td">敘述</div>
								<div class="hotnews-add-td"><textarea id="description_cht" name="description_cht" formcheck="1" errMsg="請輸入敘述"/>${hotnews.description}</textarea></div>
							</div>
							<div class="hotnews-add-tr">
								<div class="hotnews-add-td">作者</div>
								<div class="hotnews-add-td"><input type="text" id="author_cht" name="author_cht" value="${hotnews.author}" formcheck="1" errMsg="請輸入作者"/></div>
							</div>
							<div class="hotnews-add-tr">
								<div class="hotnews-add-td">連結一</div>
								<div class="hotnews-add-td">
									<input type="text" id="link_1_cht" name="link_1_cht" value="${hotnews.linkA}"/>&nbsp;
									<c:if test="${hotnews.linkA != ''}">
										<a href="${hotnews.linkA}" target="_blank">預覽</a>
									</c:if>
								</div>
							</div>
							<div class="hotnews-add-tr">
								<div class="hotnews-add-td">連結二</div>
								<div class="hotnews-add-td">
									<input type="text" id="link_2_cht" name="link_2_cht" value="${hotnews.linkB}"/>&nbsp;
									<c:if test="${hotnews.linkB != ''}">
										<a href="${hotnews.linkB}" target="_blank">預覽</a>
									</c:if>
								</div>
							</div>
							<div class="hotnews-add-tr">
								<div class="hotnews-add-td">連結三</div>
								<div class="hotnews-add-td">
									<input type="text" id="link_3_cht" name="link_3_cht" value="${hotnews.linkC}"/>&nbsp;
									<c:if test="${hotnews.linkC != ''}">
										<a href="${hotnews.linkC}" target="_blank">預覽</a>
									</c:if>
								</div>
							</div>
							<div class="hotnews-add-tr">
								<div class="hotnews-add-td">圖片一</div>
								<div class="hotnews-add-td"><input type="file" id="image_1_cht" name="image_1_cht" /><br />
									<c:if test="${hotnews.imageApath != ''}">
										<img src="<%=contextName%>${hotnews.imageApath}" height="200px"/>
									</c:if>
								</div>
							</div>
							<div class="hotnews-add-tr">
								<div class="hotnews-add-td">圖片二</div>
								<div class="hotnews-add-td"><input type="file" id="image_2_cht" name="image_2_cht" /><br />
									<c:if test="${hotnews.imageBpath != ''}">
										<img src="<%=contextName%>${hotnews.imageBpath}" height="200px"/>
									</c:if>
								</div>
							</div>
							<div class="hotnews-add-tr">
								<div class="hotnews-add-td">圖片三</div>
								<div class="hotnews-add-td"><input type="file" id="image_3_cht" name="image_3_cht" /><br />
									<c:if test="${hotnews.imageCpath != ''}">
										<img src="<%=contextName%>${hotnews.imageCpath}" height="200px"/>
									</c:if>
								</div>
							</div>
							<div class="hotnews-add-tr">
								<div class="hotnews-add-td">分類標籤</div>
								<div class="hotnews-add-td">
									<select id="breadcrumb_1" name="breadcrumb_1_cht">
										<c:forEach items="${level_one}" var="bread">
											<c:if test="${bread.breadcrumb_lang_id == 1}">
												<option value="${bread.breadcrumb_id}" <c:if test="${bread.breadcrumb_id == hotnews.breadcrumbA}">selected</c:if>>${bread.breadcrumb_name}</option>
											</c:if>
										</c:forEach>
									</select>&nbsp;>&nbsp;
									<select id="breadcrumb_2" name="breadcrumb_2_cht">
										<c:forEach items="${level_two}" var="bread">
											<c:if test="${bread.breadcrumb_lang_id == 1}">
												<option value="${bread.breadcrumb_id}" <c:if test="${bread.breadcrumb_id == hotnews.breadcrumbB}">selected</c:if>>${bread.breadcrumb_name}</option>
											</c:if>
										</c:forEach>
									</select>&nbsp;>&nbsp;
									<select id="breadcrumb_3" name="breadcrumb_3_cht">
										<c:forEach items="${level_three}" var="bread">
											<c:if test="${bread.breadcrumb_lang_id == 1}">
												<option value="${bread.breadcrumb_id}" <c:if test="${bread.breadcrumb_id == hotnews.breadcrumbC}">selected</c:if>>${bread.breadcrumb_name}</option>
											</c:if>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="hotnews-add-tr">
								<div class="hotnews-add-td">檔案下載一</div>
								<div class="hotnews-add-td"><input type="file" id="file_1_cht" name="file_1_cht" />&nbsp;
									<c:if test="${hotnews.fileApath != ''}">
										<a href="${hotnews.fileApath}" target="_blank">下載</a>
									</c:if>
								</div>
							</div>
							<div class="hotnews-add-tr">
								<div class="hotnews-add-td">檔案下載二</div>
								<div class="hotnews-add-td"><input type="file" id="file_2_cht" name="file_2_cht" />&nbsp;
									<c:if test="${hotnews.fileBpath != ''}">
										<a href="${hotnews.fileBpath}" target="_blank">下載</a>
									</c:if>
								</div>
							</div>
							<div class="hotnews-add-tr">
								<div class="hotnews-add-td">檔案下載三</div>
								<div class="hotnews-add-td"><input type="file" id="file_3_cht" name="file_3_cht" />&nbsp;
									<c:if test="${hotnews.fileCpath != ''}">
										<a href="${hotnews.fileCpath}" target="_blank">下載</a>
									</c:if>
								</div>
							</div>
							<div class="hotnews-add-tr">
								<div class="hotnews-add-td">新增日期</div>
								<div class="hotnews-add-td">${hotnews.createDate}</div>
							</div>
							<div class="hotnews-add-tr">
								<div class="hotnews-add-td">瀏覽次數</div>
								<div class="hotnews-add-td">${hotnews.pageviews}</div>
							</div>
							<div class="hotnews-add-tr">
								<div class="hotnews-add-td">置頂</div>
								<div class="hotnews-add-td">
									<select id="top_cht" name="top_cht">
										<option value="0" <c:if test="${hotnews.top == 0}">selected</c:if>>否</option>
										<option value="1" <c:if test="${hotnews.top == 1}">selected</c:if>>是</option>
									</select>
								</div>
							</div>
							<div class="hotnews-add-tr">
								<div class="hotnews-add-td">啟用</div>
								<div class="hotnews-add-td">
									<select id="enabled_cht" name="enabled_cht">
										<option value="0" <c:if test="${hotnews.enabled == 0}">selected</c:if>>否</option>
										<option value="1" <c:if test="${hotnews.enabled == 1}">selected</c:if>>是</option>
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
			</c:when>
			<c:otherwise>
				<li>
					<input type="radio" name="tabs" id="tab2">
			        <label for="tab2">English</label>
			        <div id="tab-content2" class="tab-content animated fadeIn">
			        	<div id="hotnews-add-table">
							<div class="hotnews-add-tr">
								<div class="hotnews-add-td"><span>Modify HotNews</span></div>
								<div class="hotnews-add-td"></div>
							</div>
							<div class="hotnews-add-tr">
								<div class="hotnews-add-td"><span>ID</span></div>
								<div class="hotnews-add-td">${hotnews.hotnews_id}</div>
							</div>
							<div class="hotnews-add-tr">
								<div class="hotnews-add-td">Title</div>
								<div class="hotnews-add-td"><input type="text" id="title_enu" name="title_enu" value="${hotnews.title}"/></div>
							</div>
							<div class="hotnews-add-tr">
								<div class="hotnews-add-td">Subtitle</div>
								<div class="hotnews-add-td"><input type="text" id="subtitle_enu" name="subtitle_enu" value="${hotnews.subtitle}"/></div>
							</div>
							<div class="hotnews-add-tr">
								<div class="hotnews-add-td">Description</div>
								<div class="hotnews-add-td"><textarea id="description_enu" name="description_enu"/>${hotnews.description}</textarea></div>
							</div>
							<div class="hotnews-add-tr">
								<div class="hotnews-add-td">Author</div>
								<div class="hotnews-add-td"><input type="text" id="author_enu" name="author_enu" value="${hotnews.author}"/></div>
							</div>
							<div class="hotnews-add-tr">
								<div class="hotnews-add-td">LinkA</div>
								<div class="hotnews-add-td"><input type="text" id="link_1_enu" name="link_1_enu" value="${hotnews.linkA}"/>&nbsp;
									<c:if test="${hotnews.linkA != ''}">
										<a href="${hotnews.linkA}" target="_blank">Preview</a>
									</c:if>
								</div>
							</div>
							<div class="hotnews-add-tr">
								<div class="hotnews-add-td">LinkB</div>
								<div class="hotnews-add-td"><input type="text" id="link_2_enu" name="link_2_enu" value="${hotnews.linkB}"/>&nbsp;
									<c:if test="${hotnews.linkB != ''}">
										<a href="${hotnews.linkB}" target="_blank">Preview</a>
									</c:if>
								</div>
							</div>
							<div class="hotnews-add-tr">
								<div class="hotnews-add-td">LinkC</div>
								<div class="hotnews-add-td"><input type="text" id="link_3_enu" name="link_3_enu" value="${hotnews.linkC}"/>&nbsp;
									<c:if test="${hotnews.linkC != ''}">
										<a href="${hotnews.linkC}" target="_blank">Preview</a>
									</c:if>
								</div>
							</div>
							<div class="hotnews-add-tr">
								<div class="hotnews-add-td">ImageA</div>
								<div class="hotnews-add-td"><input type="file" id="image_1_enu" name="image_1_enu" /><br />
									<c:if test="${hotnews.imageApath != ''}">
										<img src="<%=contextName%>${hotnews.imageApath}" height="200px"/>
									</c:if>
								</div>
							</div>
							<div class="hotnews-add-tr">
								<div class="hotnews-add-td">ImageB</div>
								<div class="hotnews-add-td"><input type="file" id="image_2_enu" name="image_2_enu" /><br />
									<c:if test="${hotnews.imageBpath != ''}">
										<img src="<%=contextName%>${hotnews.imageBpath}" height="200px"/>
									</c:if>
								</div>
							</div>
							<div class="hotnews-add-tr">
								<div class="hotnews-add-td">ImageC</div>
								<div class="hotnews-add-td"><input type="file" id="image_3_enu" name="image_3_enu" /><br />
									<c:if test="${hotnews.imageCpath != ''}">
										<img src="<%=contextName%>${hotnews.imageCpath}" height="200px"/>
									</c:if>
								</div>
							</div>
							<div class="hotnews-add-tr">
								<div class="hotnews-add-td">Breadcrumb</div>
								<div class="hotnews-add-td">
									<select id="breadcrumb_1" name="breadcrumb_1_enu">
										<c:forEach items="${level_one}" var="bread">
											<c:if test="${bread.breadcrumb_lang_id == 2}">
												<option value="${bread.breadcrumb_id}" <c:if test="${bread.breadcrumb_id == hotnews.breadcrumbA}">selected</c:if>>${bread.breadcrumb_name}</option>
											</c:if>
										</c:forEach>
									</select>&nbsp;>&nbsp;
									<select id="breadcrumb_2" name="breadcrumb_2_enu">
										<c:forEach items="${level_two}" var="bread">
											<c:if test="${bread.breadcrumb_lang_id == 2}">
												<option value="${bread.breadcrumb_id}" <c:if test="${bread.breadcrumb_id == hotnews.breadcrumbB}">selected</c:if>>${bread.breadcrumb_name}</option>
											</c:if>
										</c:forEach>
									</select>&nbsp;>&nbsp;
									<select id="breadcrumb_3" name="breadcrumb_3_enu">
										<c:forEach items="${level_three}" var="bread">
											<c:if test="${bread.breadcrumb_lang_id == 2}">
												<option value="${bread.breadcrumb_id}" <c:if test="${bread.breadcrumb_id == hotnews.breadcrumbC}">selected</c:if>>${bread.breadcrumb_name}</option>
											</c:if>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="hotnews-add-tr">
								<div class="hotnews-add-td">FileA</div>
								<div class="hotnews-add-td"><input type="file" id="file_1_enu" name="file_1_enu" />&nbsp;
									<c:if test="${hotnews.fileApath != ''}">
										<a href="${hotnews.fileApath}" target="_blank">Download</a>
									</c:if>
								</div>
							</div>
							<div class="hotnews-add-tr">
								<div class="hotnews-add-td">FileB</div>
								<div class="hotnews-add-td"><input type="file" id="file_2_enu" name="file_2_enu" />&nbsp;
									<c:if test="${hotnews.fileBpath != ''}">
										<a href="${hotnews.fileBpath}" target="_blank">Download</a>
									</c:if>
								</div>
							</div>
							<div class="hotnews-add-tr">
								<div class="hotnews-add-td">FileC</div>
								<div class="hotnews-add-td"><input type="file" id="file_3_enu" name="file_3_enu" />&nbsp;
									<c:if test="${hotnews.fileCpath != ''}">
										<a href="${hotnews.fileCpath}" target="_blank">Download</a>
									</c:if>
								</div>
							</div>
							<div class="hotnews-add-tr">
								<div class="hotnews-add-td">Create Date</div>
								<div class="hotnews-add-td"></div>
							</div>
							<div class="hotnews-add-tr">
								<div class="hotnews-add-td">Page View</div>
								<div class="hotnews-add-td">${hotnews.pageviews}</div>
							</div>
							<div class="hotnews-add-tr">
								<div class="hotnews-add-td">Top</div>
								<div class="hotnews-add-td">
									<select id="top_enu" name="top_enu">
										<option value="0" <c:if test="${hotnews.top == 0}">selected</c:if>>No</option>
										<option value="1" <c:if test="${hotnews.top == 1}">selected</c:if>>Yes</option>
									</select>
								</div>
							</div>
							<div class="hotnews-add-tr">
								<div class="hotnews-add-td">Enabled</div>
								<div class="hotnews-add-td">
									<select id="enabled_enu" name="enabled_enu">
										<option value="0" <c:if test="${hotnews.enabled == 0}">selected</c:if>>No</option>
										<option value="1" <c:if test="${hotnews.enabled == 1}">selected</c:if>>Yes</option>
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
			</c:otherwise>
		</c:choose>
	</c:forEach>
</ul>
</div>
</form>
<jsp:include page="/backend/footer/footer.jsp"></jsp:include>
</body>
</html>