$(document).ready(function(){
    $(".subMenu").hide();

    $(".mainMenu").mouseover(function(){
        $(".subMenu").stop().slideDown(300);
    }).mouseout(function(){
        $(".subMenu").stop().slideUp(300);
    });
    $(".imgSlide > a:gt(0)").hide();

    setInterval(function(){
      $('.imgSlide a:first-child').fadeOut()
      .next('a').fadeIn()
      .end().appendTo('.imgSlide');
    }, 3000);
  

    $(function(){
        $('.tabMenu>li>a').click(function(){
            $(this).parent().addClass("active").siblings().removeClass("active");
        });
    });
    $('.notice li:first').click(function(){
        $('#modalWrap').addClass("active");
    });
    $('.btn').click(function(){
        $('#modalWrap').removeClass("active");
    });
});