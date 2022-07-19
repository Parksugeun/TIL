# JQuery object문

## object handler



<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style>
	.c1{border:2px solid red; width:200px; height:200px;}
	.c2{border:2px solid blue; width:200px; height:200px;}
	.c3{border:2px solid green; width:200px; height:200px;}
	.c4{border:2px solid orange; width:200px; height:200px;}
</style>
<script>
	$(()=>{
		// html() : 특정객체에 html태그를 추가한다. => innerHTML
		var tag = "<a href=''>다음</a>을 클릭하시면 페이지가 이동합니다.";
		$('#result').html(tag);

		console.log( $('#result').html() );
		
		// text() : 특정객체에 문자를 추가한다.
		var tag2 = "<div>text()속성 연습중</div>"
		$("#result").text(tag2);
		
		console.log( $('a').text());
		
		$('h2').children('a').attr('href','https://www.nate.com');
		//속성지우기
		$('a').removeAttr('href');
		$('h1').removeAttr('id');
		
		//클래스 handler
		// style시트의 클래스 조작하는 방법이다.
		// addClass() : 클래스추가
		$('#list>img').addClass('c1');
		$('#list>img').addClass('c2');
		
		// removeClass() : 클래스 삭제
		$("#list>img").removeClass('c2');
		
		// 짝수번째 : c3, 홀수번째 : c4
		$("#list>img:even").addClass('c3');
		$('#list>img:odd').addClass('c4');
		
		// toggleClass() : 클래스 있으면 지우고 없으면 추가 
		$('#list>img').toggleClass('c3');
		
		// hasClass() : 클래스가 존재하는지 유무 확인 (true, false)
		var h = $("#list>img:first").hasClass('c1');
		console.log(h)
		$('h1').html(h+"");
		
		// val() : 폼의 value를 구하거나 셋팅한다.
		// html(), text(), attr(), prop()
		
	});
</script>
</head>
<body>

<div></div>
<h1 id="obj1">객체 조작 1</h1>
<h2><a href="">객체 조작 2</a></h2>
<div id="result"></div>
<div id="list">
	<img src="../img/01.jfif"/>
	<img src="../img/02.jfif"/>
	<img src="../img/03.jfif"/>
	<img src="../img/04.jfif"/>
</div>
</body>



## object



<style>
	ul,li{margin:0; padding:0;}
	img{width:100px; height:100px;}
	li{list-style-type:none; float:left; border:1px solid red; margin:4px; padding:4px;}
</style>
<script>
	$(()=>{
		// before() : 선택자 이전에 객체를 추가
		$("#i").before("<li><img src='../img/04.jfif'/></li>");
		// insertBefore() : 선택자 이전에 객체를 추가
		// 내용           선택자
		$("<li><img src='../img/02.jfif'/></li>").insertBefore("#i");
		//after() : 선택자 다음에 객체를 추가
		$("#i").after("<li><img src='../img/01.jfif'/></li>");
		//insertAfter() : 선택자 다음에 객체를 추가
		$("<li id='copy'><img src='../img/02.jpg'/></li>").insertAfter("#i");
		// append() : 선택자의 내용중에 제일 마지막에
		$('ul').append("<li><img src='../img/son.jfif'/></li>");
		// appendTo() : 제일마지막에  내용, 선택자
		$("<li><img src='../img/04.jpg'/></li>").appendTo('ul');

		// html()  $('ul').html("<li><img src='../img/02.jpg'/></li>")
		// prepend(), prependTo() : 선택한 요소내에 제일 처음에 추가
		$("ul").prepend("<li><img src='../img/jeju_map.jpg'/></li>");
		$("<li><img src='../img/05.jpg'/></li>").prependTo('ul');
		
		//clone() : 요소 복사하기 -> 사용은 한번만 할 수 있다.
		var element = $("#copy").clone();
		element.attr("id",'copy2');
		$('ul').prepend(element);
		
		// empty() : 선택자의 내용을 지우기
		$("#copy").empty();
		
		// remove() : 선택자와 내용을 지우기
		$("li:first").remove();
		
		//replaceAll(), replaceWith() : 선택자를 다른 객체로 치환
		//$("<h1>replaceAll</h1>").replaceAll("#copy");
		//$("#i").replaceWith("<h1>ReplaceWith</h1>");
		setInterval('imgMove()', 1000);
	});
	
	function imgMove(){
		$("li:first").appendTo("ul")
	}
</script>
</head>
<body>
<ul>
	<li id="i"><img src="../img/03.jfif"/></li>
</ul>
</body>

## object 2

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style>
	div{border:3px solid orange; margin:5px;}
</style>
<script>
	$(function(){
		//객체 감싸기
		// wrap() : 선택자를 특정태그로 각각 감싼다.
		$(".c1").wrap("<h1/>");// .c1 = 클래스 c1

		// wrapAll() : 선택자를 한번에 감싼다.
		$(".c2").wrapAll("<div/>")
		
		// wrapInner() : 선택자의 안쪽을 특정태그로 묶는다.
		$(".c2").wrapInner("<b/>");
		
		// unwrap() : 선택자의 부모를 지운다.
		$('.c2').unwrap();
		
		// each() : 여러개의 객체를 순차적으로 적용(반복처리) 
		//				idx=0,1,2,3,4,5,6  obj= li,li,li,li...
		$("#list>li").each(function(idx, obj){
			$(obj).html("<li>each() 함수를 이용한 반복실행...("+idx+")</li>");
		});
		
		//map() : 배열을 이용한 반복실행
		var arr=['달리기','걷기','마라톤','싸이클','스키','등산'];
		var tag = "<select>";
		
		//배열명.map(function(data, index){});
		arr.map(function(data, idx){
			tag += "<option>"+data+"("+idx+")</option>";
		});
		
		tag +="</select>";
		//$("body").prepend(tag);
		$("h1:fisrt").before(tag);
	});
</script>
</head>
<body>
<div class="c1">객체조작 메소드 1</div>
<div class="c1">객체조작 메소드 2</div>
<div class="c2">객체조작 메소드 3</div>
<div class="c2">객체조작 메소드 4</div>

<ul id="list">
	<li>객체 조작 메소드 AAAA</li>
	<li>객체 조작 메소드 BBBB</li>
	<li>객체 조작 메소드 CCCC</li>
	<li>객체 조작 메소드 DDDD</li>
	<li>객체 조작 메소드 EEEE</li>
	<li>객체 조작 메소드 FFFF</li>
	<li>객체 조작 메소드 GGGG</li>
</ul>
</body>