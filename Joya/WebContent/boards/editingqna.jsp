<%@page import="java.net.URLDecoder"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en" class="no-js">
<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
<head>

<%-- CSS 적용 부분 시작 --%> 
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport"
  content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />
<link rel="canonical" href="http://demo.designshopify.com/" />
<meta name="description" content="" />
<title>Q&A - Writing</title>
<!-- favicon -->
  	<link rel="shortcut icon" href="/assets/images/favicon.ico">
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
<%@ include file="../assets/stylesheets/mi_board_write.css"%>
<script src="../assets/javascripts/jquery-1.9.1.min.js"
  type="text/javascript"></script>
<script src="../assets/javascripts/bootstrap.min.3x.js"
  type="text/javascript"></script>
  
  <script src="/assets/javascripts/cookies.js" type="text/javascript"></script>
	<script src="/assets/javascripts/referer.js" type="text/javascript"></script>
	<script src="/assets/javascripts/cart_function.js" type="text/javascript"></script>
<%-- CSS 적용 부분 종료 --%>   

<%--비밀글 라디오 버튼 이벤트 --%>  
<script>
  $(function() {
    $("input[type='radio']").click(function(){
          var radioValue = $("input[name='articleType']:checked").val();
          if(radioValue == "secret"){
            $("input[name='title']").attr("value","비밀글입니다.");
          }
          
      });
  })
</script>
</head>
<%-- HEAD 영역 종료 --%>

<%-- BODY 영역 시작 --%>
<body itemscope="" itemtype="http://schema.org/WebPage"
  class="templatePage notouch">
  
 <!-- Header 영역 시작 -->
  <jsp:include page="../include/header.jsp" />
 <!-- hearder 영역 종료 -->

 <!-- Main 영역 시작 -->
  <div id="content-wrapper-parent">
    <div id="content-wrapper">
      <!-- Content -->
      <div id="content" class="clearfix">
        <div id="breadcrumb" class="breadcrumb">
          <div itemprop="breadcrumb" class="container">
            <div class="row">
              <div class="col-md-24">
                <a href="http://demo.designshopify.com/"
                  class="homepage-link" title="Back to the frontpage">Home</a>
                <span>/</span> <span class="page-title">Q&A - Edit</span>
              </div>
            </div>
          </div>
        </div>
        <section class="content">
          <div class="container">
            <div class="row">
              <div id="page-header">
                <h1 id="page-title">Q&A</h1>
              </div>
            </div>
          </div>

          <div id="col-main" class="contact-page clearfix">
            <div class="group-contact clearfix">
              <div class="container">
                <div class="row">

                  <form action="${pageContext.servletContext.contextPath}/boards/updatearticle.joya?boardid=2"
                    method="post">
                    <div class="left-block col-md-12">
                      <input type="hidden" value="contact"
                        name="form_type"><input type="hidden"
                        name="utf8" value="â">
                        
                        <div class="typediv">
                        <input type="radio" name="articleType" value="secret" > 비밀글 &nbsp;
                      </div>
                      <br>

                      <div class="midivision2">
                        <label class="control-label" for="name">제목<span
                          class="req">*</span></label>
                      </div>
                      <input type="text" id="name" value="${article.title}"
                        class="form-control" name="title"> 
                        
                        <input type="hidden" value="${email}" name="email">
                        <input type="hidden" name="articleId" value="${param.articleid}">
                        <input type="hidden" name="boardid" value="2">
 
                      <c:choose>
                        <c:when test="${not empty email}">
                          <div>
                            <div class="midivision left-block col-md-12">
                              <label class="control-label" for="email">이름
                                <span class="req">*</span>
                              </label> <input type="text" id="email"
                                value="${name}"
                                class="form-control email" name="writer"
                                readonly="readonly">
                            </div>
                        </c:when>
                        <c:otherwise>
                          <div>
                            <div class="midivision left-block col-md-12">
                              <label class="control-label" for="email">이름
                                <span class="req">*</span>
                              </label> <input type="text" id="email" value=""
                                class="form-control email" name="writer">
                            </div>
                        </c:otherwise>
                      </c:choose>

                      <div class="midivision1 col-md-12">
                        <label class="control-label" for="name">비밀번호<span
                          class="req">*</span></label> <input type="text"
                          id="name" value="" class="form-control"
                          name="passwd" pattern="[0-9]{4}" required
                          placeholder="비밀번호(숫자0~9까지 4자리)">
                      </div>
                    </div>

                    <div class="midivision3 col-md-24">
                      <label class="control-label" for="message">문의사항
                        <span class="req">*</span>
                      </label>
                      <textarea id="message" rows="5"
                        class="form-control" name="contents">${article.contents}</textarea>
                      <br>
                      <div class="midivision6">
                        <input class="btn" type="submit" value="수정하기">
                        <button class="btn"><a href="${pageContext.servletContext.contextPath}/boards/qnalist.joya">글목록</a></button>
                      </div>
                    </div>
                  </form>
                </div>
                <div class="right-block contact-content col-md-12">
                  <div class="border_mi">
                    <h6 class="sb-title">
                      <i class="fa fa-home"></i> Contact Information
                    </h6>
                    <ul class="right-content">
                      <li class="title">
                        <h6>Office Address</h6>
                      </li>
                      <li class="address">
                        <p>서울특별시 가산동 12345 신한이노플랙스 1차 KOSTA</p>
                      </li>
                      <br>
                      <li>010-1111-0000</li>
                      <br>
                      <br>
                      <li class="email"><i class="fa fa-envelope"></i> support@designshopify.com</li>
                    </ul>
                    <ul class="right-content">
                      <li class="title">
                        <h6>Follow Us on</h6>
                      </li>
                      <li class="facebook"><a href="#"><span
                          class="fa-stack fa-lg btooltip" title=""
                          data-original-title="Facebook"><i
                            class="fa fa-circle fa-stack-2x"></i><i
                            class="fa fa-facebook fa-inverse fa-stack-1x"></i></span></a></li>
                      <li class="twitter"><a href="#"><span
                          class="fa-stack fa-lg btooltip" title=""
                          data-original-title="Twitter"><i
                            class="fa fa-circle fa-stack-2x"></i><i
                            class="fa fa-twitter fa-inverse fa-stack-1x"></i></span></a></li>
                      <li class="google-plus"><a href="#"><span
                          class="fa-stack fa-lg btooltip" title=""
                          data-original-title="Google plus"><i
                            class="fa fa-circle fa-stack-2x"></i><i
                            class="fa fa-google-plus fa-inverse fa-stack-1x"></i></span></a></li>
                      <li class="pinterest"><a href="#"><span
                          class="fa-stack fa-lg btooltip" title=""
                          data-original-title="Pinterest"><i
                            class="fa fa-circle fa-stack-2x"></i><i
                            class="fa fa-pinterest fa-inverse fa-stack-1x"></i></span></a></li>
                    </ul>
                  </div>
                </div>
              </div>
            </div>
         </div>
      </div>
     </section>
    </div>
  </div>
 </div>
 <!-- Main 영역 종료 -->

  <!-- footer 영역 시작 -->
  <jsp:include page="../include/footer.jsp" />
  <!-- footer 영역 종료 -->
</body>
<!-- BODY 영역 종료 -->