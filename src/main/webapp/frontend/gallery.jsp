<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />

	<title>${gallery_title_cht}</title>
	<meta property="og:title" content="${gallery_title_cht}"/>
	<meta property="og:image" content="images/logo.png"/>
	
	<link rel="stylesheet" href="/frontend/stylesheets/layout02.css">
	<link rel="stylesheet" href="/frontend/stylesheets/modify.css">
	<link rel="stylesheet" href="/frontend/stylesheets/flexslider.css">
	<link rel="stylesheet" href="/frontend/css/font-awesome.min.css">
	<link type="text/css" rel="stylesheet" href="/frontend/css/pagination/simplePagination.css"/>
	<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
  	<script type="text/javascript" src="/frontend/js/pagination/jquery.simplePagination.js"></script>
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
	
		$(window).scroll(function() {
	if($(window).scrollTop() < 50) {
       $('#bg_nav').removeClass('menuPostiotionFixed');
	   $('header').css('display','');
	}
	else{
		 $('#bg_nav').addClass('menuPostiotionFixed');
		 $('header').css('display','none');
	}
	
	});

		$(function() {
		    $('#pagination').pagination({
		        items: ${galleryTotal},
		        currentPage: ${page},
		        itemsOnPage: 6,
		        displayedPages: 5,
		        cssStyle: 'light-theme',
		        hrefTextPrefix:'?action=${action}&page='
		    });
		});
	</script>

<body>

<header>
	<div class="logo" id="logo">
		<a href="/index.do">
			<img src="/frontend/images/logo.png" height="60" width="300" alt="">
		</a>
	</div>	

	<div class="toplink">
		<ul>
			 <li><a href="#" onclick="javascript:alert('您好，若您對數位人文交流平台有任何建議或想法，歡迎您透過以下方式與我們聯繫!\n國立臺灣大學數位人文研究中心 \n市內電話/02-33669847\n電子信箱/dhintaiwan@gmail.com\n臉書粉專/https://www.facebook.com/dhtaiwan\n地址/106 台北市大安區羅斯福路四段一號');">關於我們</a></li>
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
	<div class="bg_nav" id="bg_nav">
		<!-- desktop menu -->
		<nav>
			<ul>
				<li><a href="/index.do">首頁</a></li>
				<li class="nav_line"></li>
				<li><a href="/gallery.do?action=hotnews" <c:if test="${action == 'hotnews'}"> style="background: #222"  </c:if>>最新消息</a></li>
				<li class="nav_line"></li>
				<li><a href="/gallery.do?action=research" <c:if test="${action == 'research'}"> style="background: #222"  </c:if>>數位人文研究計畫</a></li>
				<li class="nav_line"></li>
				<!-- <li><a href="/gallery.do?action=researchResource">數位人文研究資源</a></li>
				<li class="nav_line"></li> -->
				<li><a href="/gallery.do?action=converage" <c:if test="${action == 'converage'}"> style="background: #222"  </c:if>>專題報導</a></li>
				<li class="nav_line"></li>
				<li><a href="/gallery.do?action=interperspective" <c:if test="${action == 'interperspective'}"> style="background: #222"  </c:if>>國際視野</a></li>
				<li class="nav_line"></li>
				<li><a href="/index.do#tool"  <c:if test="${action == 'dataaddon' || action == 'database'|| action == 'researchResource' || action == 'relatedWeb'}"> style="background: #222"  </c:if>>研究資源</a></li>
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
	<c:if test="${action == 'dataaddon' || action == 'database'|| action == 'researchResource' || action == 'relatedWeb'}"> 
		<div class="bg_nav2" id="bg_nav2">
		<!-- desktop menu -->

		<nav >
			<div class="bg_nav3" id="bg_nav3">
			<ul>
				<li><a href="/gallery.do?action=dataaddon" <c:if test="${action == 'dataaddon'}"> style="background: #C0C0C0"  </c:if>>數位工具</a></li>
				<li class="nav_line2"></li>
				<li><a href="/gallery.do?action=database" <c:if test="${action == 'database'}"> style="background: #C0C0C0"  </c:if>>資料庫系統</a></li>
				<li class="nav_line2"></li>
				<li><a href="/gallery.do?action=researchResource" <c:if test="${action == 'researchResource'}"> style="background: #C0C0C0"  </c:if>>國外相關網站</a></li>
				<li class="nav_line2"></li>
				<!-- <li><a href="/gallery.do?action=researchResource">數位人文研究資源</a></li>
				<li class="nav_line"></li> -->
				<li><a href="/gallery.do?action=relatedWeb" <c:if test="${action == 'relatedWeb'}"> style="background: #C0C0C0"  </c:if>>國內相關網站</a></li>
				
			
			</ul>
			</div>

		</nav>
		<!-- portable search -->


	</div>
	
	 </c:if>
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
		        <c:if test="${topBean.linkA == ''}">
            <a href="/detail.do?action=${action}&id=${topBean.id}">
               <h2>${topBean.title}</h2>
            </a>
        </c:if>
        <c:if test="${topBean.linkA != ''}">
            <a href="${topBean.linkA}" target="_blank">
               <h2>${topBean.title}</h2>
            </a>
        </c:if>
		
		<p>
			${topBean.content_short}
		</p>
	</div>

	<div class="clear"></div>

</div>
    </c:otherwise>
</c:choose>






	

<div class="gallery_title">
	<div id="pagination" class="pagination light-theme simple-pagination"></div>
	
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
					<h4 style="margin-left: 0;">${fn:substring(gallery.createDate, 0, 11)}</h4>
							</BR>

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
		<h4 style="margin-left: 0;">${fn:substring(gallery.createDate, 0, 11)}</h4>
		</BR>
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

國立臺灣大學數位人文研究中心 版權所有 © All Rights Reserved. <br>
  台北市大安區 106 羅斯福路四段一號 國立臺灣大學 TEL: 02-33669847
</div>
</footer>



</body>
</html>
