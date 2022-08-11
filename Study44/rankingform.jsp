<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="/js_css/jquery.innerfade.js"></script>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Black+And+White+Picture&family=Black+Han+Sans&family=Cute+Font&family=Do+Hyeon&family=Dokdo&family=East+Sea+Dokdo&family=Gaegu&family=Gamja+Flower&family=Gothic+A1&family=Gugi&family=Hi+Melody&family=Jua&family=Kirang+Haerang&family=Nanum+Brush+Script&family=Nanum+Gothic&family=Nanum+Gothic+Coding&family=Nanum+Myeongjo&family=Nanum+Pen+Script&family=Noto+Sans+KR&family=Noto+Serif+KR&family=Poor+Story&family=Single+Day&family=Song+Myung&family=Stylish&family=Sunflower:wght@300&family=Yeon+Sung&display=swap" rel="stylesheet">

<script>
$(function(){
	
	$("#ment").innerfade({
		animationtype:'fade'
		,speed: 3000
		, timeout: 4000
		,type:'sequence'  
	});
	
});
	
</script>
<script>
	$(function(){
		
		$("#picture").innerfade({
			animationtype:'fade'
			,speed: 3000
			, timeout: 4000
			,type:'sequence'   
		});
		
	});
</script>
<div class="container">
	<div id="header">
		<ul id="ment">
		<li><h1 class="h11">친구와 먹고 싶은 음식</h1></li>
		<li><h1 class="h11">회식 때 먹고 싶은 음식</h1></li>
		<li><h1 class="h11">비올 때 먹고 싶은 음식</h1></li>
		<li><h1 class="h11">더울 때 먹고 싶은 음식</h1></li>
		<li><h1 class="h11">추울 때 먹고 싶은 음식</h1></li>
		</ul>
	</div>
	
	<div id="nav">
		<ul id="picture">
		<li><img src="/img/dessert/cake.jpg"/>
		<img src="/img/dessert/crepe.jpg"/>
		<img src="/img/dessert/macaron.jpg"/>
		<img src="/img/dessert/pancake.jpg"/></li>
		
		<li><img src="/img/yasik/bossam.jpg"/>
		<img src="/img/hansik/samgyeopsal.jpg"/>
		<img src="/img/yasik/sashimi.jpg"/>
		<img src="/img/anju/sondaebokkeum.jpg"/></li>
		
		<li><img src="/img/jungsik/jjamppong.jpg"/>
		<img src="/img/bunsik/ramen.jpg"/>
		<img src="/img/bunsik/jjolmyeon.jpg"/>
		<img src="/img/ilsik/udon.jpg"/></li>
		
		<li><img src="/img/dessert/sherbet.jpg"/>
		<img src="/img/boyangsik/konggugsu.jpg"/>
		<img src="/img/dessert/icecream.jpg"/>
		<img src="/img/hansik/samgyetang.jpg"/></li>
		
		<li><img src="/img/bunsik/algamja.jpg"/>
		<img src="/img/boyangsik/chiotang.jpg"/>
		<img src="/img/jungsik/dumplings.jpg"/>
		<img src="/img/bunsik/hotteok.jpg"/></li>
		
		</ul>
	</div>
	
	<div id="section">
		<h1 class="h12" style="text-align:center;">MOME 랭킹</h1>
		<li>2222222</li>
		<li>22222222</li>
		<li>333333333</li>
	</div>
	
	<div id="aside">
		<h1 class="h12" style="text-align:center;">MOME 랭킹</h1>
		<li>2222222</li>
		<li>22222222</li>
		<li>333333333</li>
	</div>
	
</div>
