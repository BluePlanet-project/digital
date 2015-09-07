<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />

	<title>科技部數位人文交流平台</title>
	<link rel="stylesheet" href="/frontend/stylesheets/layout02.css">
	<link rel="stylesheet" href="/frontend/stylesheets/modify.css">
	<link rel="stylesheet" href="/frontend/stylesheets/flexslider.css">
	<link rel="stylesheet" href="/frontend/css/font-awesome.min.css">
	<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
  	
  	<script src="/frontend/js/jquery.flexslider.js"></script>
    <script src="/frontend/js/js.js"></script>
    <style type="text/css">
.flex-caption {
    width: 100%;
    padding: 20px 10% 20px 10%;
    left: 0;
    bottom: 0;
    background: rgba(0,0,0,.9);
    color: #fff;
    text-shadow: 0 -1px 0 rgba(0,0,0,.3);
    font-size: 14px;
    line-height: 18px;
}
</style>
	<script type="text/javascript">

    $(window).load(function() {
    	$('.flexslider').flexslider({
    		animation: "slide"
    	});
    });
	</script>

<body>

<header>
	<div class="logo">
		<a href="/index.do">
			<img src="/frontend/images/logo.png" height="60" width="300" alt="">
		</a>
	</div>	

	<div class="toplink">
		<ul>
			<li><a href="#">關於我們</a></li>
			<li><a href="mailto:dhintaiwan@gmail.com">我要投稿</a></li>
			<li><a href="mailto:dhintaiwan@gmail.com">聯絡我們</a></li>
			
		</ul>
	</div>

	<div class="topsocial">
		<a href="https://www.facebook.com/pages/%E6%95%B8%E4%BD%8D%E4%BA%BA%E6%96%87%E4%BA%A4%E6%B5%81%E5%B9%B3%E5%8F%B0Taiwan-Digital-Humanities-Forum/1566523080258285" target="_blank"><img src="/frontend/images/btn_fb.png" height="35" width="35" alt=""></a>
	</div>

	<div class="search">
<script>
  (function() {
    var cx = '002640562740318145717:es0pjra8g94';
    var gcse = document.createElement('script');
    gcse.type = 'text/javascript';
    gcse.async = true;
    gcse.src = (document.location.protocol == 'https:' ? 'https:' : 'http:') +
        '//cse.google.com/cse.js?cx=' + cx;
    var s = document.getElementsByTagName('script')[0];
    s.parentNode.insertBefore(gcse, s);
  })();
</script>
<gcse:search></gcse:search>
	</div>

</header>


<div class="mainsection_gellary">
	<div class="bg_nav">
		<!-- desktop menu -->
		<nav>
			<ul>
				<li><a href="/index.do">首頁</a></li>
				<li class="nav_line"></li>
				<li><a href="/gallery.do?action=hotnews">最新消息</a></li>
				<li class="nav_line"></li>
				<li><a href="/gallery.do?action=research">數位人文研究計畫</a></li>
				<li class="nav_line"></li>
				<!-- <li><a href="/gallery.do?action=researchResource">數位人文研究資源</a></li>
				<li class="nav_line"></li> -->
				<li><a href="/gallery.do?action=converage">專題報導</a></li>
				<li class="nav_line"></li>
				<li><a href="/gallery.do?action=interperspective">國際視野</a></li>
				<li class="nav_line"></li>
				<li><a href="/index.do#tool">研究資源</a></li>
				<!-- <li class="nav_line"></li>
				<li><a href="/gallery.do?action=knowTaiwan">看見臺灣 </a></li> -->
			</ul>

		</nav>

		<!-- portable search -->
	        <div class="search_portable">
   <script>
  (function() {
    var cx = '002640562740318145717:es0pjra8g94';
    var gcse = document.createElement('script');
    gcse.type = 'text/javascript';
    gcse.async = true;
    gcse.src = (document.location.protocol == 'https:' ? 'https:' : 'http:') +
        '//cse.google.com/cse.js?cx=' + cx;
    var s = document.getElementsByTagName('script')[0];
    s.parentNode.insertBefore(gcse, s);
  })();
</script>
<gcse:search></gcse:search>
        </div>

	</div>

</div>
<!-- mobile-menu -->
	<div class="mobile-menu">
		<div class="hamburg">
			<span class="aaa"></span>
			<span class="bbb"></span>
			<span class="ccc"></span>
		</div>
	</div>	

	<div class="aside">
			<ul>
				<li><a href="/index.do">首頁</a></li>
				<li><a href="/gallery.do?action=hotnews">最新消息</a></li>
				<li><a href="/gallery.do?action=research">數位人文計畫介紹</a></li>
				<li><a href="/gallery.do?action=converage">專題報導</a></li>
				<li><a href="/gallery.do?action=interperspective">國際視野</a></li>
				<li><a href="/index.do#tool">研究資源</a></li>
			</ul>
	</div>


<div class="gallery_title">
<h2>${gallery_title_cht}</h2>	
</div>

<c:choose>
    <c:when test="${action == 'hotnews'}">
     
    </c:when>
    <c:when test="${action == 'researchResource'}">
       
    </c:when>
	  <c:when test="${action == 'relatedWeb'}">
       
    </c:when>
	<c:when test="${action == 'database'}">
       
    </c:when>
	<c:when test="${action == 'dataaddon'}">
       
    </c:when>

    <c:otherwise>
              <div class="gallery_plan">
	<div class="photo">
        <c:if test="${topBean.linkA == ''}">
            <a href="/detail.do?action=${action}&id=${topBean.id}">
                <img src="${topBean.imageApath}" height="188" width="250" alt="">
            </a>
        </c:if>
        <c:if test="${topBean.linkA != ''}">
            <a href="${topBean.linkA}" target="_blank">
                <img src="${topBean.imageApath}" height="188" width="250" alt="">
            </a>
        </c:if>

	</div>


	<div class="news">
		<h2>${topBean.title}</h2>
		<p>
			${topBean.content_short}
		</p>
	</div>

	<div class="clear"></div>

</div>
    </c:otherwise>
</c:choose>






	

<div class="gallery_title">

	
	<!-- item_group -->
	<c:forEach items="${galleryList}" var="gallery" varStatus="number">
		<c:if test="${(number.index + 1) % 2 == 1}">
			<div class="item_group">
				<div class="item">
					
					
					<c:if test="${gallery.linkA == ''}">
			            <a href="/detail.do?action=${action}&id=${gallery.id}">
							<h3 style="margin-left: 0;">${gallery.title}</h3>
						</a>
			        </c:if>
			        <c:if test="${gallery.linkA != ''}">
			            <a href="${gallery.linkA}" target="_blank">
			                <h3 style="margin-left: 0;">${gallery.title}</h3>
			            </a>
			        </c:if>
					
			<c:choose>
			    <c:when test="${action == 'hotnews'}">
					<h3 style="margin-left: 0;">${fn:substring(gallery.createDate, 0, 11)}</h3>
			    </c:when>
			    <c:otherwise>
			              
			    </c:otherwise>
			</c:choose>

					<c:if test="${gallery.linkA == ''}">
			            <a href="/detail.do?action=${action}&id=${gallery.id}">
			                <img src="${gallery.imageApath}" height="188" width="250" alt="">
			            </a>
			        </c:if>
			        <c:if test="${gallery.linkA != ''}">
			            <a href="${gallery.linkA}" target="_blank">
			                <img src="${gallery.imageApath}" height="188" width="250" alt="">
			            </a>
			        </c:if>
					<p>${gallery.description}</p>
					<div class="clear"></div>
				</div>
		</c:if>
		<c:if test="${(number.index + 1) % 2 == 0}">
				<div class="item">
					<c:if test="${gallery.linkA == ''}">
			            <a href="/detail.do?action=${action}&id=${gallery.id}">
							<h3 style="margin-left: 0;">${gallery.title}</h3>
						</a>
			        </c:if>
			        <c:if test="${gallery.linkA != ''}">
			            <a href="${gallery.linkA}" target="_blank">
			                <h3 style="margin-left: 0;">${gallery.title}</h3>
			            </a>
			        </c:if>
										
<c:choose>
    <c:when test="${action == 'hotnews'}">
		<h3 style="margin-left: 0;">${fn:substring(gallery.createDate, 0, 11)}</h3>
    </c:when>
    <c:otherwise>
              
    </c:otherwise>
</c:choose>
					<c:if test="${gallery.linkA == ''}">
			            <a href="/detail.do?action=${action}&id=${topBean.id}">
			                <img src="${gallery.imageApath}" height="188" width="250" alt="">
			            </a>
			        </c:if>
			        <c:if test="${gallery.linkA != ''}">
			            <a href="${gallery.linkA}" target="_blank">
			                <img src="${gallery.imageApath}" height="188" width="250" alt="">
			            </a>
			        </c:if>
					<p>${gallery.description}</p>
					<div class="clear"></div>
				</div>
			</div>
		</c:if>
		<c:if test="${(number.index + 1) == galleryTotal && (number.index + 1) % 2 == 1}">
			</div>
		</c:if>
	</c:forEach>
	
</div>


<footer>
<div class="footer_content">
臺灣大學數位人文研究中心 版權所有 © All Rights Reserved. <br>
  台北市大安區 106 羅斯福路四段一號 臺灣大學 TEL: 02-33669847
</div>
</footer>



</body>
</html>
