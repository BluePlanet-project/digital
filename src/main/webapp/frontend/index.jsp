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
	<script src="/frontend/js/jquery.slides.min.js"></script>
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
  	$(document).ready(function(){
  	  	//mouse over function for menu bar
		/*$('.menuItem').each(function(){
			$(this).bind('mouseenter', function(){
				var id = $(this).attr('id');
				switchContent(id);
			});
		});*/
	});
  	
		function switchContent(id){
			var title = '';
			var subtitle = '';
			var description = '';
			var imagePath = '';

			$.ajax({
                url: "/frontend/AjaxItemGetter.jsp",
                data: "action=" + id,
                type:"POST",
                dataType:'text',

                success: function(msg){
                    var obj = $.parseJSON(msg);
                    //alert(obj[0].description);
                    $('div#first-section').html('');
                    for(var i = 0 ; i < obj.length ; i++){
                    	$('div#first-section').append('<div class="oop"><img src="' + obj[i].imgPathA + '"  alt=""><h3>' + obj[i].title + '</h3><p>' + obj[i].description + '</p><div class="clear"></div></div>');
                    }
                    if(obj.length < 3){
						for(var i = 0 ; i < 3 - obj.length ; i++){
							$('div#first-section').append('<div class="oop"><img src=""  alt=""><h3></h3><p></p><div class="clear"></div></div>');
						}
                    }
                    //$('div.title').html();
                },

                 error:function(xhr, ajaxOptions, thrownError){ 
                    //alert(xhr.status); 
                    //alert(thrownError); 
                 }
            });
		}

		
  	</script>
	

  
    <script>
    $(function() {
      $('#slides').slidesjs({
        
        play: {
          active: true,
          auto: true,
          interval: 4000,
          swap: true
        }
      });
    });

    
    $(window).load(function() {
    	$('.flexslider').flexslider({
    		animation: "slide"
    	});
    });
  </script>
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
           <li><a href="#">關於我們</a></li>
            <li><a href="mailto:dhintaiwan@gmail.com">我要投稿</a></li>
            <li><a href="mailto:dhintaiwan@gmail.com">聯絡我們</a></li>
 
            
        </ul>
    </div>
 
 
    <div class="topsocial">
 
 
        <a href="https://www.facebook.com/pages/%E6%95%B8%E4%BD%8D%E4%BA%BA%E6%96%87%E4%BA%A4%E6%B5%81%E5%B9%B3%E5%8F%B0Taiwan-Digital-Humanities-Forum/1566523080258285" target="_blank"><img src="/frontend/images/btn_fb.png" height="35" width="35" alt=""></a>
    </div>
<!--
	<div class="topsocial">
	<a href=""><img src="/frontend/images/btn_g.png" height="35" width="35" alt=""></a>
		<a href=""><img src="/frontend/images/btn_ttw.png" height="35" width="35" alt=""></a>
		<a href="https://www.facebook.com/pages/%E6%95%B8%E4%BD%8D%E4%BA%BA%E6%96%87%E4%BA%A4%E6%B5%81%E5%B9%B3%E5%8F%B0Taiwan-Digital-Humanities-Forum/1566523080258285" target="_blank"><img src="/frontend/images/btn_fb.png" height="35" width="35" alt=""></a>
</div>
-->
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


<div class="mainsection">
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
				<li><a href="#tool">研究資源</a></li>
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
		
		<!-- 
		<c:forEach items="${homebannerList}" var="homebanner" varStatus="number">
			<c:if test="${number.index + 1 == 1}">
			<div class="supertitle" id="supertitle_${number.index + 1}">
			</c:if>
			<c:if test="${number.index + 1 != 1}">
			<div class="supertitle" id="supertitle_${number.index + 1}" style="display:none;">
			</c:if>
				<h1>${homebanner.title}</h1>
				<p>${homebanner.description}</p>
			</div>
		</c:forEach>
		 -->

	</div>



	<!-- portable menu -->
<!-- 	<div class="nav_portable_burger"><label for="jijiji"><img src="images/menu_btn.png" height="50" width="50" alt=""></label></div>
	<input type="checkbox" id="jijiji" or="tab-a" name="vehicle" value=""> 
	<div class="nav_portable_menu">
			<ul>
				<li><a href="#">最新消息</a></li>
				<li><a href="#">數位人文計畫介紹</a></li>
				<li><a href="#">數位人文研究資源</a></li>
				<li><a href="#">專題報導</a></li>
				<li><a href="#">國際視野</a></li>
			</ul>
	</div>
	 -->

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
				<li><a href="#tool">研究資源</a></li>
			</ul>
	</div>
	
	

</div>

<div class="slider-desktop" >
			<div class="flexslider" >
				<ul class="slides" style="height:650px">
					<c:forEach items="${homebannerList}" var="homebanner" varStatus="number">
						<li>
							<a href="${homebanner.linkA}"><img src="${homebanner.imageApath}" />
							<p class="flex-caption">
								<span style="font-size: 20px; line-height:40px;">${homebanner.title}</span><br />
								${homebanner.description}
								
								
							</p></a>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>


<div class="section1">
	<h2 id="index_title">${hotnews_title_cht}</h2>
	<div class="title" id="first-section">
		<c:forEach items="${hotnewsList}" var="hotnews" varStatus="number">
			<div class="oop">
				<c:if test="${hotnews.linkA == ''}">
		            <a href="/detail.do?action=hotnews&id=${hotnews.id}"><img src="${hotnews.imageApath}"  alt=""></a>
		        </c:if>
		        <c:if test="${hotnews.linkA != ''}">
		            <a href="${hotnews.linkA}" target="_blank">
		                <img src="${hotnews.imageApath}"  alt="">
		            </a>
		        </c:if>
				
			
				
				
				<a href="/detail.do?action=hotnews&id=${hotnews.id}"><h3>${hotnews.title}</h3></a>
				<a href="/detail.do?action=hotnews&id=${hotnews.id}"><h3>${fn:substring(hotnews.createDate, 0, 11)}</h3></a>
				
				
			
				
				
				<p>${hotnews.description}</p>
				<div class="clear"></div>
			</div>
		</c:forEach>
	</div>

	<div class="fb">
		<!--
		<div id="slides">
				
		      <img src="/frontend/img/example-slide-1.jpg" alt="Photo by: Missy S Link: http://www.flickr.com/photos/listenmissy/5087404401/">
		      <img src="/frontend/img/example-slide-2.jpg" alt="Photo by: Daniel Parks Link: http://www.flickr.com/photos/parksdh/5227623068/">
		      <img src="/frontend/img/example-slide-3.jpg" alt="Photo by: Mike Ranweiler Link: http://www.flickr.com/photos/27874907@N04/4833059991/">
		      <img src="/frontend/img/example-slide-4.jpg" alt="Photo by: Stuart SeegerLink: http://www.flickr.com/photos/stuseeger/97577796/">
		    </div>
		-->
		<div class="fb-page" data-href="https://www.facebook.com/pages/%E6%95%B8%E4%BD%8D%E4%BA%BA%E6%96%87%E4%BA%A4%E6%B5%81%E5%B9%B3%E5%8F%B0Taiwan-Digital-Humanities-Forum/1566523080258285" data-height="480" data-small-header="false" data-adapt-container-width="true" data-hide-cover="false" data-show-facepile="true" data-show-posts="true"><div class="fb-xfbml-parse-ignore"><blockquote cite="https://www.facebook.com/pages/%E6%95%B8%E4%BD%8D%E4%BA%BA%E6%96%87%E4%BA%A4%E6%B5%81%E5%B9%B3%E5%8F%B0Taiwan-Digital-Humanities-Forum/1566523080258285"><a href="https://www.facebook.com/pages/%E6%95%B8%E4%BD%8D%E4%BA%BA%E6%96%87%E4%BA%A4%E6%B5%81%E5%B9%B3%E5%8F%B0Taiwan-Digital-Humanities-Forum/1566523080258285">數位人文交流平台Taiwan Digital Humanities Forum</a></blockquote></div></div>
		<!--
		<div class="fb_1">
			<div class="fb-page" data-href="https://www.facebook.com/pages/%E6%95%B8%E4%BD%8D%E4%BA%BA%E6%96%87%E4%BA%A4%E6%B5%81%E5%B9%B3%E5%8F%B0Taiwan-Digital-Humanities-Forum/1566523080258285">科技部數位人文交流平台</a></blockquote></div></div>
		</div>
		-->
		<!-- Chris FB 寬度動態算 -->
		<!-- <div class="fb_2"><img src="images/faceookPAD.png"></div> -->

<!-- 		<div class="fb_3"><img src="images/faceookPAD.png"></div>
 -->			
		<!-- <div class="container">
		    <div id="slides">
				
		      <img src="img/example-slide-1.jpg" alt="Photo by: Missy S Link: http://www.flickr.com/photos/listenmissy/5087404401/">
		      <img src="img/example-slide-2.jpg" alt="Photo by: Daniel Parks Link: http://www.flickr.com/photos/parksdh/5227623068/">
		      <img src="img/example-slide-3.jpg" alt="Photo by: Mike Ranweiler Link: http://www.flickr.com/photos/27874907@N04/4833059991/">
		      <img src="img/example-slide-4.jpg" alt="Photo by: Stuart SeegerLink: http://www.flickr.com/photos/stuseeger/97577796/">
		    </div>
  		</div>
			 -->
		</div>


</div>


<div class="bg_green">
	<div class="section3">
		<a href="/gallery.do?action=research"><h2>數位人文研究計畫<br>
			Research Planning
		</h2></a>

	<c:forEach items="${researchList}" var="research" varStatus="number">
		<c:if test="${(number.index + 1) % 2 == 1}">
			<div class="section_group">
		</c:if>
				<div class="database">
					<div class="dataimg">
						<a href="/gallery.do?action=research"><img src="${research.imageApath}" height="200" width="288" alt=""></a>
					</div>
					<a href="/gallery.do?action=research"><h6>${research.title}</h6></a>
					<h5>${research.author}</h5>
					<p>${research.description}</p>
				</div>
		<c:if test="${(number.index + 1) % 2 == 0}">
			</div>
		</c:if>
	</c:forEach>
	</div>
</div>



<div class="section2">
		<div class="globleview">
			<a href="/gallery.do?action=converage"><h2>國際視野<br>
			International Perspective</h2>	</a>
			<c:forEach items="${interperspectiveList}" var="inter" varStatus="number" begin="0" end="1">
				<div class="globle_a">
					<a href="/detail.do?action=interperspective&id=${inter.id}"><img src="${inter.imageApath}" height="100" width="200" alt=""></a>
					<a href="/detail.do?action=interperspective&id=${inter.id}"><h3>${inter.title}</h3></a>
					<p>${inter.description}</p>
				</div>
			</c:forEach>
		</div>

		<div class="researchplan">
			<a href="/gallery.do?action=converage"><h2>專題報導<br>
			Theme Report</h2></a>
			<c:forEach items="${converageList}" var="con" varStatus="number" begin="0" end="1">
				<div class="globle_a">
					<a href="/detail.do?action=converage&id=${con.id}"><img src="${con.imageApath}" height="100" width="200" alt=""></a>
					<a href="/detail.do?action=converage&id=${con.id}"><h3>${con.title}</h3></a>
					<p>${con.description}</p>
				</div>
			</c:forEach>
		</div>
</div>



<div class="bg_blue" >
			<div class="section4">
				<h2>研究資源<br>
					Research Source
					</h2>
			<div class="section_group">
				<div class="database">
					<div class="dataimg">
						<a href="/gallery.do?action=dataaddon"><img src="/upload/items/1430719482119.jpg" alt=""></a>
					</div>
					<a href="/gallery.do?action=dataaddon"><h6>數位工具</h6></a>
					<p>提供文獻分析、地圖繪製等數位工具免費使用。</p>
				</div>
				<div class="database">
					<div class="dataimg">
						<a href="/gallery.do?action=database"><img src="/upload/items/1430719467705.jpg" alt=""></a>
					</div>
					<a href="/gallery.do?action=database"><h6>資料庫系統</h6></a>
					<p>提供與數位人文相關之資料庫系統供參考。</p>
				</div>
			</div>	

			<div class="section_group">
				<div class="database">
					<div class="dataimg">
						<a href="/gallery.do?action=researchResource"><img src="/upload/items/1430722085219.jpg" alt=""></a>
					</div>
					<a href="/gallery.do?action=researchResource"><h6>國外相關網站</h6></a>
					<p>提供與數位人文相關的網站資源供參考。</p>
				</div>

				<div class="database">
					<div class="dataimg">
						<a href="/gallery.do?action=relatedWeb"><img src="/upload/items/1430722157790.jpg" alt=""></a>
					</div>
					<a href="/gallery.do?action=relatedWeb"><h6>國內相關網站</h6></a>
					<p>提供有關國內研究單位、國外研究單位、相關期刊等資源供參考。</p>
				</div>
			</div>
		</div>
</div>







<footer >
	
<div class="footer_content"id="tool">
臺灣大學數位人文研究中心 版權所有 © All Rights Reserved. <br>
  台北市大安區 106 羅斯福路四段一號 臺灣大學 TEL: 02-33669847
</div>

</footer>



</body>
</html>