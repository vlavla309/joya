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

<%
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
%>

<%
  email = "joa@joa";
  name = "관리자";

  request.setAttribute("email", email);
  request.setAttribute("name", name);
%>


</head>

<body itemscope="" itemtype="http://schema.org/WebPage"
  class="templateCustomersRegister notouch">

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
                <span class="page-title">Q&A</span>
              </div>
            </div>
          </div>
        </div>
        <section class="content">
          <div class="container">
            <div class="row">
              <div id="page-header" class="col-md-24">
                <h1 id="page-title">Q&A</h1>
              </div>
              
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
                  <%--
                  	String con = article.getContent().replace("\r\n", "<br>");
                  --%>
                  <td colspan="6" >${article.contents }</td>
                </tr>
                </table>

                <div id="ji-writeD">
                  <c:if test="${name eq '관리자'}">
                   <button type="button" class="btn">
                    <a href="${pageContext.servletContext.contextPath}/boards/">답글쓰기</a>
                   </button>
                  </c:if>
                   <button type="button" class="btn">
                    <a href="${pageContext.servletContext.contextPath}/boards/">수정</a>
                  </button>
                  <button type="button" class="btn">
                    <a href="${pageContext.servletContext.contextPath}/boards/">삭제</a>
                  </button>
                  <button type="button" class="btn">
                    <a href="${pageContext.servletContext.contextPath}/boards/">글목록</a>
                  </button>
                </div>

              </div>
            </div>
          </div>


  <!-- footer 시작 -->
  <jsp:include page="../include/footer.jsp" />
  <!-- footer 종료 -->
</body>