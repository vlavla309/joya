<%@ page contentType="text/html; charset=utf-8"%>
<header id="top" class="clearfix">
  
    <!--top 영역 시작-->
        <jsp:include page="../include/top.jsp" />
    <!--top 영역 종료-->
    
    <div class="line"></div>
    
    <!-- Navigation -->
        <jsp:include page="../include/navigation.jsp" />
    <!--End Navigation-->
    
      <script>
        function addaffix(scr){
        if($(window).innerWidth() >= 1024){
          if(scr > $('#top').innerHeight()){
          if(!$('#top').hasClass('affix')){
            $('#top').addClass('affix').addClass('animated');
          }
          }
          else{
          if($('#top').hasClass('affix')){
            $('#top').prev().remove();
            $('#top').removeClass('affix').removeClass('animated');
          }
          }
        }
        else $('#top').removeClass('affix');
        }
        $(window).scroll(function() {
        var scrollTop = $(this).scrollTop();
        addaffix(scrollTop);
        });
        $( window ).resize(function() {
        var scrollTop = $(this).scrollTop();
        addaffix(scrollTop);
        });
      </script>
    </div>
    </header>