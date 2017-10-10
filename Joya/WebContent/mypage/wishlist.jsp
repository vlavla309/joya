<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->

<!-- Mirrored from demo.designshopify.com/html_jewelry/blog-3-col.html by HTTrack Website Copier/3.x [XR&CO'2014], Thu, 21 Sep 2017 08:52:22 GMT -->
<!-- Added by HTTrack -->
<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
<!-- /Added by HTTrack -->
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport"
  content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />
<link rel="canonical" href="http://demo.designshopify.com/" />
<meta name="description" content="" />
<title>Wish List</title>

<!-- css 적용 부분 시작 -->
<link href="../assets/stylesheets/font.css" rel='stylesheet'
  type='text/css'>

<link href="../assets/stylesheets/font-awesome.min.css" rel="stylesheet"
  type="text/css" media="all">
<link href="../assets/stylesheets/bootstrap.min.3x.css" rel="stylesheet"
  type="text/css" media="all">
<link href="../assets/stylesheets/cs.bootstrap.3x.css" rel="stylesheet"
  type="text/css" media="all">
<link href="../assets/stylesheets/cs.animate.css" rel="stylesheet"
  type="text/css" media="all">
<link href="../assets/stylesheets/cs.global.css" rel="stylesheet"
  type="text/css" media="all">
<link href="../assets/stylesheets/cs.style.css" rel="stylesheet"
  type="text/css" media="all">
<link href="../assets/stylesheets/cs.media.3x.css" rel="stylesheet"
  type="text/css" media="all">
<link href="../assets/stylesheets/wishlist.css" rel="stylesheet"
  type="text/css" media="all">

<script src="../assets/stylesheets/javascripts/jquery-1.9.1.min.js"
  type="text/javascript"></script>
<script src="../assets/javascripts/bootstrap.min.3x.js"
  type="text/javascript"></script>
<!-- css 적용 부분 종료 -->

<script type="text/javascript">
$(document).ready(function(){
    //최상단 체크박스 클릭
    $("#ji-totalchk").click(function(){
        //클릭되었으면
        if($("#ji-totalchk").prop("checked")){
            //input태그의 name이 chk인 태그들을 찾아서 checked옵션을 true로 정의
            $("input[name=ji-chk]").prop("checked",true);
            //클릭이 안되있으면
        }else{
            //input태그의 name이 chk인 태그들을 찾아서 checked옵션을 false로 정의
            $("input[name=ji-chk]").prop("checked",false);
        }
    })
    
})
</script>
</head>

<body itemscope="" itemtype="http://schema.org/WebPage" class="templateBlog notouch">
  <!-- Header 영역 시작 -->
  <jsp:include page="../include/header.jsp" />
  <!-- Header 영역 종료 -->

  <!-- 본문 영역 시작 -->
  <div id="content-wrapper-parent">
    <div id="content-wrapper">

      <!-- Content 영역 시작-->
      <div id="content" class="clearfix">

        <!-- smallHeader 영역 시작 -->
        <div id="breadcrumb" class="breadcrumb">
          <div itemprop="breadcrumb" class="container">
            <div class="row">
              <div class="col-md-24">
                <a href="index-2.html" class="homepage-link"
                  title="Back to the frontpage">My Page</a> <span>/</span>
                <span class="page-title">Wish List</span>
              </div>
            </div>
          </div>
        </div>
        <!-- smallHeader 영역 종료 -->

        <!-- 본문 영역 시작 -->
        <section class="content">
          <!-- 아이템 시작 -->
          <div class="container">
            <div class="row">

              <div id="page-header" class="col-md-24">
                <h1 id="page-title">Wish List</h1>
              </div>

              <div id="col-main"class="blog blog-page col-sm-24 col-md-24 blog-full-width blog-3-col ">  
                <c:choose>
                  <c:when test="${empty list}">
                    <h2 class="ji-wishlistEmpty" >위시리스트가 존재하지 않습니다</h2>
                  </c:when>
                  <c:otherwise>
                  
                    <div class="ji-totalD">
                    <input class="ji-totalselect"  id="ji-totalchk" type="checkbox"> 
                    <label  class="ji-totalselectL" for="ji-totalchk">전체 선택하기</label>
                   </div>
                  
                  <!--for  -->
                    
                    <div class="blog-content-wrapper ji-contentBox">
                    <c:forEach items="${list}" var="wishlist" varStatus="status">
                      <div class="blogs col-sm-8 col-md-8 clearfix" >
                        <article class="blogs-item">
                          <div class="row">
                            <div class="article-content col-md-24" >
                                <div class="article-content-inner"  >
                                  <div class="blogs-image">
                                    <ul class="list-inline">
                                      <li><a href="#">
                                          <div><img src="${wishlist.imgPath}${wishlist.imgName}"  alt="">
                                          </div>
                                      </a></li>
                                    </ul>
                                  </div>
                                  
                                  <form class="form-wishlistdelete" action="${pageContext.servletContext.contextPath}/mypage/wishlistdelete.joya" method="post">
                                  <ul class="ji-post list-inline">
                                    <li class="select"><input class="ji-selectC " id="ji-${wishlist.productId }"  type="checkbox" value="${wishlist.productId }" name="ji-chk"></li>

                                   <!--목록에서 삭제하는 form 시작 -->
                                    <label class="ji-contentL" for="ji-${wishlist.productId }"><li class="ji-productName">${wishlist.productName }</li></label>
                                       <input type="hidden" name="productId" value="${wishlist.productId }">
                                       <input type="hidden" name="email" value="${wishlist.email }">
                                       <input type="hidden" name="page" value="${params.page }">
                                       <li class="ji-post-action"><input class="wishlistDeleteBtn"  type="image" src="../assets/images/jiDelete.png" alt="Submit"></li>
                                    <!--목록에서 삭제하는 form 종료 -->
                                  </ul>
                                 </form>
                                  

                                </div>
                            </div>
                          </div>
                        </article>
                      </div>
                      </c:forEach>
                      </div>

                    <!-- end for  -->
                    
                  </c:otherwise>
                </c:choose>
              </div>
              
              <!-- 페이지 리스트 영역 시작 -->
              <div>
                <div class="col-md-6"">
                  <nav aria-label="Page navigation"">
                    <ul class="ji-pagination">
                      <c:if test="${pageBuilder.showPrevious }">
                        <li><a
                          href="${pageBuilder.getQueryString(pageBuilder.previousStartPage)}""
                          aria-label="Previous"> <span
                            aria-hidden="true">&laquo;</span>
                        </a></li>
                      </c:if>

                      <c:forEach var="i" begin="${pageBuilder.currentStartPage}" end="${pageBuilder.currentEndPage }">
                        <c:choose>
                          <c:when test="${i == params.page }">
                            <li class="active"><a>${i }</a></li>
                          </c:when>
                          <c:otherwise>
                            <li><a href="${pageBuilder.getQueryString(i)}"">${i }</a></li>
                          </c:otherwise>
                        </c:choose>
                      </c:forEach>

                      <c:if test="${pageBuilder.showNext }">
                        <li><a href="${pageBuilder.getQueryString(pageBuilder.nextStartPage)}"  aria-label="Next"> <span aria-hidden="true">&raquo;</span>
                        </a></li>
                      </c:if>
                    </ul>
                  </nav>
                </div>
              </div>
              <!-- 페이지 리스트 영역 시작 -->

              <!-- 주문하기 버튼 영역 시작 -->
              <c:choose>
                  <c:when test="${empty list}">
                  </c:when>
                  <c:otherwise>
                     <div>
                       <a href="wishlistTest.jsp?orderlist="${checked_val }><button id="ji-orderB" class="btn" type="button" name="orderlist">Add to Cart</button></a>
                     </div>
                  </c:otherwise>
                  </c:choose>
              <!-- 주문하기 버튼 영역 시작 -->
              <!-- End of layout -->
            </div>
          </div>
        </section>
        <!-- 본문 영역 종료 -->
      </div>
      <!-- Content 영역 종료-->
    </div>
  </div>

  <!-- footer 시작 -->
  <jsp:include page="../include/footer.jsp" />
  <!-- footer 종료 -->
</body>
