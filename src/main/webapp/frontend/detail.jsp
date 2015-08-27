<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>科技部數位人文交流平台</title>
	<link rel="stylesheet" href="/frontend/stylesheets/layout.css">
<!-- 	<link rel="stylesheet" href="stylesheets/gallery.css">
	<link rel="stylesheet" href="stylesheets/detail.css"> -->
        <script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>

  	<script src="/frontend/js/js.js"></script>

</head>
<body>
<div id="fb-root"></div>
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/zh_TW/sdk.js#xfbml=1&version=v2.3&appId=196260620424788";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>

<header>
	<div class="logo">
		<a href="/index.do">
			<img src="/frontend/images/logo.png" height="60" width="300" alt="">
		</a>
	</div>	

	<div class="toplink">
		<ul>
			<li><a href="#">加入會員</a></li>
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
		    var cx = '005551680650451778246:j_ubmsw77im';
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



<div class="detail_gellary">
	<div class="bg_nav">
		<!-- desktop menu -->
		<nav>
			<ul>
				<li><a href="/index.do">首頁</a></li>
				<li class="nav_line"></li>
				<li><a href="/gallery.do?action=hotnews">最新消息</a></li>
				<li class="nav_line"></li>
				<li><a href="/gallery.do?action=research">數位人文計畫介紹</a></li>
				<li class="nav_line"></li>
				<!-- <li><a href="/gallery.do?action=researchResource">數位人文研究資源</a></li>
				<li class="nav_line"></li> -->
				<li><a href="/gallery.do?action=converage">專題報導</a></li>
				<li class="nav_line"></li>
				<li><a href="/gallery.do?action=interperspective">國際視野</a></li>
				<!-- <li class="nav_line"></li>
				<li><a href="/gallery.do?action=knowTaiwan">看見臺灣 </a></li> -->
			</ul>
		</nav>

		<!-- portable search -->
		<div class="search_portable">
			<input type="text">
			<a href="">æå°</a>
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
			</ul>
	</div>






<div class="detail">
	<div class="detail_l">
		<h2>${itemBean.title}</h2>
		<h3>${itemBean.subtitle}</h3>

	
		<p>
		${itemBean.description}
		</p>
		<h3></h3>
		<p>
		${itemBean.content_long}
		</p>


		<div class="line_a"></div>

		<c:if test="${itemBean.fileApath != ''}">
			<a href="${itemBean.fileApath}" class="download" target="_blank"><img src="/frontend/images/arrow-download-icon.png" alt="">資料下載</a>
		</c:if>
		<c:if test="${itemBean.fileBpath != ''}">
			<a href="${itemBean.fileApath}" class="download" target="_blank"><img src="/frontend/images/arrow-download-icon.png" alt="">資料下載</a>
		</c:if>
		<c:if test="${itemBean.fileCpath != ''}">
			<a href="${itemBean.fileApath}" class="download" target="_blank"><img src="/frontend/images/arrow-download-icon.png" alt="">資料下載</a>
		</c:if>

		<div class="clear"></div>


	</div>
	
	<div class="detail_r">
		<c:forEach items="${itemListRight}" var="item" varStatus="number">
			<div class="r_box">
				<a href="/detail.do?action=${action}&id=${item.id}"><img src="${item.imageApath}" alt=""></a>
				<h6>${item.title}</h6>
				<!-- <p>${item.description}</p> -->
			</div>
		</c:forEach>
		
		<div class="FB_box">
			<div class="fb-page" data-href="https://www.facebook.com/pages/%E6%95%B8%E4%BD%8D%E4%BA%BA%E6%96%87%E4%BA%A4%E6%B5%81%E5%B9%B3%E5%8F%B0Taiwan-Digital-Humanities-Forum/1566523080258285">科技部數位人文交流平台</a></blockquote></div></div>
		</div>	
	</div>
</div>
	


<div class="FB_section">
	<div class="fb-comments" data-href="http://140.112.145.91/detail.do?action=${action}&amp;id=${itemBean.id}" data-width="1000" data-numposts="5" data-colorscheme="light"></div>
</div>


<div class="bg_blue">
			<div class="section4">
				<h2>研究資源<br>
					Research Source
					</h2>
			<div class="section_group">
				<div class="database">
					<div class="dataimg">
						<a href="/gallery.do?action=researchResource"><img src="/upload/items/1430722085219.jpg" alt=""></a>
					</div>
					<h6>研究資源</h6>
					<p>提供與數位人文相關的網站資源供參考。</p>
				</div>
				<div class="database">
					<div class="dataimg">
						<a href="/gallery.do?action=database"><img src="/upload/items/1430719467705.jpg" alt=""></a>
					</div>
					<h6>資料庫系統</h6>
					<p>提供與數位人文相關之資料庫系統供參考。</p>
				</div>
			</div>	

			<div class="section_group">
				<div class="database">
					<div class="dataimg">
						<a href="/gallery.do?action=dataaddon"><img src="/upload/items/1430719482119.jpg" alt=""></a>
					</div>
					<h6>數位工具</h6>
					<p>提供文獻分析、地圖繪製等數位工具免費使用。</p>
				</div>
				<div class="database">
					<div class="dataimg">
						<a href="/gallery.do?action=relatedWeb"><img src="/upload/items/1430722157790.jpg" alt=""></a>
					</div>
					<h6>相關網站</h6>
					<p>提供有關國內研究單位、國外研究單位、相關期刊等資源供參考。</p>
				</div>
			</div>
		</div>
</div>


<footer>
<div class="footer_content">
臺灣大學數位人文研究中心 版權所有 © All Rights Reserved. <br>
  台北市大安區 106 羅斯福路四段一號 臺灣大學 TEL: 02-33669847
</div>
</footer>




</body>
</html>