<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>${itemBean.title}</title>
	<meta property="og:title" content="${itemBean.title}"/>
	<meta property="og:image" content="http://140.112.145.91/${itemBean.imageApath}"/>
	<meta name="description" content="${itemBean.subtitle}">
	<link rel="stylesheet" href="/frontend/stylesheets/layout02.css">
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
}(document, 'script', 'facebook-jssdk'));

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

</script>

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



<div class="detail_gellary">
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
				<li><a href="/index.do#tool">研究資源</a></li>
				<!-- <li class="nav_line"></li>
				<li><a href="/gallery.do?action=knowTaiwan">看見臺灣 </a></li> -->
			</ul>
		</nav>

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






<div class="detail">
	<div class="detail_l">
		<h2>${itemBean.title}</h2>
		<h3>${itemBean.subtitle}</h3>

	<!--
		<p>
		${itemBean.description} 
		</p>
	-->
		<h3></h3>
		<p>
		${itemBean.content_long}
		</p>


		<div class="line_a"></div>

		<c:if test="${itemBean.fileApath != ''}">
			<a href="${itemBean.fileApath}" class="download" target="_blank">
				<img src="/frontend/images/arrow-download-icon.png" alt="">資料下載
				<!-- title & description -->
				${itemBean.fileTitle1}/${itemBean.fileDesc1}
			</a>
		</c:if>
		<c:if test="${itemBean.fileBpath != ''}">
			<a href="${itemBean.fileApath}" class="download" target="_blank">
				<img src="/frontend/images/arrow-download-icon.png" alt="">資料下載
				<!-- title & description -->
				${itemBean.fileTitle2}/${itemBean.fileDesc2}
			</a>
		</c:if>
		<c:if test="${itemBean.fileCpath != ''}">
			<a href="${itemBean.fileApath}" class="download" target="_blank">
				<img src="/frontend/images/arrow-download-icon.png" alt="">資料下載
				<!-- title & description -->
				${itemBean.fileTitle3}/${itemBean.fileDesc3}
			</a>
		</c:if>



<script type='text/javascript' src='//dsms0mj1bbhn4.cloudfront.net/assets/pub/shareaholic.js' data-shr-siteid='46e002a9a52bc68dbf59ab986236da1c' data-cfasync='false' async='async'></script>


<div class='shareaholic-canvas' data-app='share_buttons' data-app-id='20750187'></div>

<div id="disqus_thread"></div>
<script type="text/javascript">
    /* * * CONFIGURATION VARIABLES * * */
    var disqus_shortname = 'digitalhumanities';
    
    /* * * DON'T EDIT BELOW THIS LINE * * */
    (function() {
        var dsq = document.createElement('script'); dsq.type = 'text/javascript'; dsq.async = true;
        dsq.src = '//' + disqus_shortname + '.disqus.com/embed.js';
        (document.getElementsByTagName('head')[0] || document.getElementsByTagName('body')[0]).appendChild(dsq);
    })();
</script>
<noscript>Please enable JavaScript to view the <a href="https://disqus.com/?ref_noscript" rel="nofollow">comments powered by Disqus.</a></noscript>


	<!--<div id="fb-root"></div>
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/zh_TW/sdk.js#xfbml=1&version=v2.4&appId=219221718187183";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>
-->


<!--
<div class="fb-share-button" data-href="/detail.do?action=${action}&id=${itemBean.id}" data-layout="button_count" style="float:right;right:5%"></div>

		<div class="clear"></div>
		<div class="FB_section">
			<div class="fb-comments" data-href="http://140.112.145.91/detail.do?action=${action}&amp;id=${itemBean.id}" data-width="700" data-numposts="5" data-colorscheme="light"></div>
		</div>
-->
	</div>
	
	<div class="detail_r">
		<c:forEach items="${itemListRight}" var="item" varStatus="number">
			<div class="r_box">
				<c:if test="${item.linkA == ''}">
		            <a href="/detail.do?action=${action}&id=${item.id}"><img src="${item.imageApath}" alt=""></a>
		        </c:if>
		        <c:if test="${item.linkA != ''}">
		            <a href="${item.linkA}" target="_blank">
		                <img src="${item.imageApath}" alt="">
		            </a>
		        </c:if>
			
				

				<a href="/detail.do?action=${action}&id=${item.id}"><h6>${item.title}</h6></a>

				<!-- <p>${item.description}</p> -->
			</div>
		</c:forEach>
		
		<div class="FB_box">
			<div class="fb-page" data-href="https://www.facebook.com/pages/%E6%95%B8%E4%BD%8D%E4%BA%BA%E6%96%87%E4%BA%A4%E6%B5%81%E5%B9%B3%E5%8F%B0Taiwan-Digital-Humanities-Forum/1566523080258285" data-height="00" data-small-header="false" data-adapt-container-width="true" data-hide-cover="false" data-show-facepile="true" data-show-posts="true"><div class="fb-xfbml-parse-ignore"><blockquote cite="https://www.facebook.com/pages/%E6%95%B8%E4%BD%8D%E4%BA%BA%E6%96%87%E4%BA%A4%E6%B5%81%E5%B9%B3%E5%8F%B0Taiwan-Digital-Humanities-Forum/1566523080258285"><a href="https://www.facebook.com/pages/%E6%95%B8%E4%BD%8D%E4%BA%BA%E6%96%87%E4%BA%A4%E6%B5%81%E5%B9%B3%E5%8F%B0Taiwan-Digital-Humanities-Forum/1566523080258285">數位人文交流平台Taiwan Digital Humanities Forum</a></blockquote></div></div>
		</div>	
		
		
	</div>
</div>
	








<footer>
<div class="footer_content">

國立臺灣大學數位人文研究中心 版權所有 © All Rights Reserved. <br>
  台北市大安區 106 羅斯福路四段一號 國立臺灣大學 TEL: 02-33669847
</div>
</footer>


<script type="text/javascript">
    /* * * CONFIGURATION VARIABLES * * */
    var disqus_shortname = 'digitalhumanities';
    
    /* * * DON'T EDIT BELOW THIS LINE * * */
    (function () {
        var s = document.createElement('script'); s.async = true;
        s.type = 'text/javascript';
        s.src = '//' + disqus_shortname + '.disqus.com/count.js';
        (document.getElementsByTagName('HEAD')[0] || document.getElementsByTagName('BODY')[0]).appendChild(s);
    }());
</script>

</body>
</html>