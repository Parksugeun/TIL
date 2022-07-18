JQuery문은 가장 마지막에 실행된다.

$를 사용해줘야함 문장앞에


		
		//상태선택자
		
		// : text -> 속성값이 text인 객체를 선택한다.
		$(':text').css("background",'green');
		// :checked -> 속성이 checked가 설정되어 있으면 선택한다.
		$(':checked').css('width','40px').css('height','40px').prop('checked',false);
		// :selected -> 속성이 selected가 설정되어 있으면 선택한다.
		$(':selected').css('background','orange').prop('selected',false);
		
		//컨텐츠 선택자
			// contains() : 특정한 문자가 포함되어 있으면 선택한다.
			$("p:contains('탁빔')").css('background-color','pink');
			// has() : 특정태그가 포함되는 경우 선택한다.
			$("p:has('b')").css('color','green');
			// not() : 특정선택자 제외한 나머지를 선택한다.
			$("p:not(':first')").css('font-weight','bold');
			// closest() : 조상선택자
			$('b').closest('div').css('border','4px solid red');
			// filter()
			$('p').filter('.c1').css('color','orange');
			
			// contents() : 특정태그의 하위 내용이 다른 태그에 포함된 경우 하위태그를 선택한다.
			$('p').contents().css('background-color','blue');
			
			// selectedIndex : 선택된 option의 index를 구한다.
			// document.getElementById('username').value="";
			$('#username').val($('#site').prop('selectedIndex'));
			
			if($('#tel').val()==""){// document.getElementById("tel").value
				alert('전화번호를 입력하세요...');
			}
		});

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
