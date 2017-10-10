<%@page import="java.net.URLDecoder"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en" class="no-js">
<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport"
  content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />
<link rel="canonical" href="http://demo.designshopify.com/" />
<meta name="description" content="" />
<title>Q&A</title>

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
<link href="../assets/stylesheets/jjh-style.css" rel="stylesheet"
  type="text/css" media="all">

<script src="../assets/javascripts/jquery-1.9.1.min.js"
  type="text/javascript"></script>
<script src="../assets/javascripts/bootstrap.min.3x.js"
  type="text/javascript"></script>
  
 
<!-- css 적용 부분 종료 -->

<%--
	String user = null;
	String email = null;
	String name = null;

	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equalsIgnoreCase("user")) {
				user = URLDecoder.decode(cookie.getValue(), "utf-8");
				String[] tokens = user.split("###");
				email = tokens[0];
				name = tokens[1];
			}
		}
	}
--%>


<script type="text/javascript">
	$(function(){
		$(".yes").on("click", function(event){
			$.ajax({
				url : "${pageContext.servletContext.contextPath}/boards/deletearticle.joya?article_id=${article.articleId}",
				success : function(data){
					location.href="${pageContext.servletContext.contextPath}/boards/aslist.joya";
				}
			});
		});
		
	})
</script>



</head>

<body itemscope="" itemtype="http://schema.org/WebPage"
  class="templateCustomersRegister notouch">
  
    <%-- 회원삭제 modal --%>
  <div class="modal" id="deleteModal">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title">삭제하시겠습니까?</h4>
      </div>
      <div class="modal-footer">
        <button type="button" class="yes" data-dismiss="modal" name="">삭제</button>
        <button type="reset" class="no" data-dismiss="modal" name="">취소</button>
      </div>
    </div>
  </div>
 </div>
 
     <%-- 이미지 modal --%>
 <div class="modal" id="imageModal" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content" id="imagem">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button> 
        <h4 class="modal-title">Image</h4>
      </div>
      <div class="modal-body" id="imagebody">
       <span><image class="imginmodal" src="${article.filePath }"></span>
      </div>
      <div class="modal-footer">
         <button type="button" class="btn btn-default" data-dismiss="modal">Close</button> 
      </div>
    </div>
  </div>
</div>

  <!-- Header 영역 시작 -->
  <jsp:include page="../include/header.jsp" />
  <!-- hearder 영역 종료 -->

  <div id="content-wrapper-parent">
    <div id="content-wrapper">
      <!-- Content -->
      <div id="content" class="clearfix">
        <div id="breadcrumb" class="breadcrumb">
          <div itemprop="breadcrumb" class="container">
            <div class="row">
              <div class="col-md-24">
                <a href="index-2.html" class="homepage-link"
                  title="Back to the frontpage">Home</a> <span>/</span>
                <span class="page-title">A/S</span>
              </div>
            </div>
          </div>
        </div>
        <section class="content">
          <div class="container">
            <div class="row">
              <div id="page-header" class="col-md-24">
                <h1 id="page-title">A/S</h1>
              </div>
              <form action="${pageContext.servletContext.contextPath}/boards/updateaction.joya?articleid=${article.articleId}&boardid=4"
                    method="post">
              <div id="ji-tableM">
                <table>
                <tr>
                  <td><strong>제목</strong></td>
                  <td colspan="5" class="textleft">${article.title }</td>

                </tr>
                <tr>
                  <td><strong>작성자</strong></td>
                  <td class="textleft">${article.writer }</td>
                  <td><strong>작성일</strong></td>
                  <td class="textleft">${article.regdate }</td>
                  <td><strong>조회수</strong></td>
                  <td class="textleft">${article.hitcount }</td>
                </tr>
                <tr>
                  <td><strong>첨부파일</strong></td>
                  <td colspan="5" class="textleft"><a style="cursor: pointer;" data-toggle="modal" data-target="#imageModal"><img class="fileimage" src="${article.filePath }"></a></td>
                </tr>

                <tr>
                  <%--
                    <td colspan="6" >${article.contents.replace('\\r\\n','<br>')}</td>
                  --%>
                  <td colspan="6" >${article.contents }</td>
                </tr>
                </table>

                <div id="ji-writeD">
                
                <c:choose>
                  <c:when test="${name eq '관리자'}">
                   <button type="button" class="btn">
                    <a href="${pageContext.servletContext.contextPath}/boards/replyingqna.jsp?articleid=${article.articleId}&boardid=4">답글쓰기</a>
                    </button>
                    <input class="btn" type="submit" value="수정" >
                     <button type="button" class="btn">
                     <!--<a href="${pageContext.servletContext.contextPath}/boards/deletearticle.joya?article_id=${article.articleId}">삭제</a>-->  
                     <a class="deletebtn" data-toggle="modal" data-target="#deleteModal">삭제</a> 
                     </button>
                      <button type="button" class="btn">
                      <a class="deletebtn" href="${pageContext.servletContext.contextPath}/boards/aslist.joya">글목록</a>
                      </button>
                      </div>
                    </c:when>
                  
                    <c:when test="${name eq article.writer}">
                      <input class="btn" type="submit" value="수정" >
                      <button type="button" class="btn">
                      <!--<a href="${pageContext.servletContext.contextPath}/boards/deletearticle.joya?article_id=${article.articleId}">삭제</a> --> 
                      <a class="deletebtn" data-toggle="modal" data-target="#deleteModal">삭제</a> 
                      </button>
                      <button type="button" class="btn">
                      <a class="deletebtn" href="${pageContext.servletContext.contextPath}/boards/aslist.joya">글목록</a>
                      </button>
                      </div>
                    </c:when>
                    <c:otherwise>
                     <button type="button" class="btn">
                     <a class="deletebtn" href="${pageContext.servletContext.contextPath}/boards/aslist.joya">글목록</a>
                     </button>
                     </div>
                    </c:otherwise>
                  </c:choose>

              </div>
              </form>
            </div>
          </div>


  <!-- footer 시작 -->
  <jsp:include page="../include/footer.jsp" />
  <!-- footer 종료 -->
</body>