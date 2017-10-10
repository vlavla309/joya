<%@page import="java.net.URLDecoder"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<title>Q&A - Replying</title>
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


</head>

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
                <span>/</span> <span class="page-title">Q&A -
                  Replying</span>
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
                  <form action="${pageContext.servletContext.contextPath}/boards/replyarticle.joya"
                    method="post">
                    <div class="left-block col-md-24" id="replydiv">
                      <input type="hidden" value="contact"
                        name="form_type"><input type="hidden"
                        name="utf8" value="â">

                      <div class="midivision2">
                        <label class="control-label" for="name">제목<span
                          class="req">*</span></label>
                      </div>
                      <input type="text" id="name" value="[RE]"
                        class="form-control" name="title"> <input
                        type="hidden" value="${email}" name="email">
                        <input type="hidden" name="articleid" value="${param.articleid}">
                        <input type="hidden" name="boardid" value="${param.boardid}">
                      <div>
                        <div class="midivision left-block col-md-12">
                          <label class="control-label" for="email">이름
                            <span class="req">*</span>
                          </label> <input type="text" id="email" value="${name}"
                            class="form-control email" name="writer"
                            readonly="readonly">
                        </div>
                        <div class="midivision1 col-md-12">
                          <label class="control-label" for="name">비밀번호<span
                            class="req">*</span></label> <input type="text"
                            id="name" value="" class="form-control"
                            name="passwd" pattern="[0-9]{4}" required
                            placeholder="비밀번호(숫자0~9까지 4자리)">
                        </div>
                      </div>

                      <div class="midivision3 col-md-24">
                        <label class="control-label" for="message">답변내용
                          <span class="req">*</span>
                        </label>
                        <textarea id="message" rows="5"
                          class="form-control" name="contents"></textarea>
                        <br>
                        <div class="midivision6">
                         <button class="btn">올리기</button>
                        </div>
                        <ul>
                          <li>&nbsp;</li>
                          <li>&nbsp;</li>
                          <li>&nbsp;</li>
                          <li>&nbsp;</li>
                          <li>&nbsp;</li>
                        </ul>
                      </div>
                    </div>
                    </form>
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