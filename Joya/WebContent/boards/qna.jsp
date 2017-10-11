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
<!-- favicon -->
  	<link rel="shortcut icon" href="/assets/images/favicon.ico">

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

<%-- 비밀글 modal 이벤트 액션 --%>
<script>
	$(function() {
		$(".secrettitle").on("click", function(event) {
			var articleId = $(event.target).attr("name");
			var id = $(".yes").attr("name", articleId);
		});

		$(".yes").on("click",function() {
			var id = $(".yes").attr("name");
			console.log("articleId " + id);
			var secretPw = $(".secretpasswd").val();
			var password = $(".pw").val();
			console.log("모달창비번 " + secretPw);
			console.log("원래비번 " + password);

			if (secretPw == password) {
				location.href = "${pageContext.servletContext.contextPath}/boards/readingarticle.joya?articleid="+ id + "&boardid=2";

			} else {
				$(".errorpasswd").text("비밀번호가 일치하지 않습니다.");
				$(".secretpasswd").val("");
			}
		});
	})
</script>
</head>
<%-- HEAD 영역 종료 --%>

<%-- 비밀글일때 비밀번호 확인 modal --%>
<div class="modal" id="checkModal">
  <div class="modal-dialog modal-sm">
    <div class="modal-content" id="secretm">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">
          <span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
        </button>
        <span class="modal-title">비밀글을 읽으시려면 비밀번호를 입력해주세요.</span>
      </div>
      <div class="modal-footer" id="secretf">
        <div class="mimodal">
          <input type="password" class="secretpasswd" name="" maxlength="4">
          <button type="button" class="yes" id="yesbtn" value="">확인</button>
        </div>
        <span class="errorpasswd" value=""></span>
      </div>
    </div>
  </div>
</div>

<%-- BODY 영역 시작 --%>
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

              <div id="ji-tableD">
                <table class="table-hover">
                  <thead>
                    <tr>
                      <th class="ji-size">No.</th>
                      <th class="ji_title">Title</th>
                      <th class="ji-writerS">Writer</th>
                      <th class="ji-size">Date</th>
                      <th class="ji-size">Hit</th>
                    </tr>
                  </thead>
                  <tbody>

                    <c:choose>
                      <c:when test="${empty list }">
                        <tr class="odd">
                          <td></td>
                          <td>검색된 글이 존재하지 않습니다.</td>
                          <td></td>
                          <td></td>
                          <td></td>
                        </tr>
                      </c:when>
                      <c:otherwise>
                        <c:forEach items="${list }" var="article"
                          varStatus="status">
                          <tr class="odd" value="">
                            <td>${(pb.totalRowCount - ((params.page - 1) * params.pageSize)) - status.index}</td>

                            <c:choose>
                              <%-- 삭제된 글일 경우 --%>
                              <c:when test="${article.contents eq '삭제' }">
                                <td class="titletd">
                                  <c:if test="${article.writer eq '관리자'}">
                                    <img src="../assets/images/replying.png"> &nbsp;
                                  </c:if> 
                                 <a class="titlebtn">${article.title}</a></td>
                                <td colspan='3'></td>
                              </c:when>
                              <c:otherwise>
                                <%-- 관리자인 경우 --%>
                                <td class="titletd">
                                  <c:if test="${article.writer eq '관리자'}">
                                   <img src="../assets/images/replying.png"> &nbsp;
                                   </c:if>
                                 <c:choose>
                                  <%-- 비밀글인 경우 --%>
                                   <c:when test="${article.title eq '비밀글입니다.' }">
                                     <img src="../assets/images/secret_lock.png"> &nbsp;
                                       <c:choose>
                                        <c:when test="${name eq '관리자' }">
                                          <a class="titlebtn" href="${pageContext.servletContext.contextPath}/boards/readingarticle.joya?articleid=${article.articleId}&boardid=2">${article.title}</a>
                                        </c:when>
                                        <c:otherwise>
                                          <a class="secrettitle" data-toggle="modal" data-target="#checkModal" name="${article.articleId }">${article.title}</a>
                                        </c:otherwise>
                                       </c:choose>
                                    </c:when>
                                   <c:otherwise>
                                   <%-- 일반게시글인 경우 --%>
                                     <a class="titlebtn" href="${pageContext.servletContext.contextPath}/boards/readingarticle.joya?articleid=${article.articleId}&boardid=2">${article.title}</a>
                                   </c:otherwise>
                                 </c:choose>
                                 </td>
                                <td class="writertd">${article.writer}</td>
                                <td>${article.regdate}</td>
                                <td>${article.hitcount}</td>
                                <input type="hidden" class="pw" name="passwd" value="${article.passwd }">
                              </c:otherwise>
                            </c:choose>
                          </tr>
                        </c:forEach>
                      </c:otherwise>
                    </c:choose>
                  </tbody>
                </table>
                
                <div id="ji-writeD">
                  <button type="button" class="btn">
                    <a href="${pageContext.servletContext.contextPath}/boards/writingqna.joya">글쓰기</a>
                  </button>
                  </form>
                </div>
              </div>
            </div>
          </div>

          <div class="row">
            <ul class="pagination">
              <c:if test="${pb.isShowFirst()}">
                <li><a href="${pb.getQueryString(1)}">처음으로</a></li>
              </c:if>

              <c:if test="${pb.isShowPrevious()}">
                <li class="prev">
                  <a href="${pb.getQueryString(pb.previousStartPage)}">이전목록</a></li>
              </c:if>

              <c:forEach var="i" varStatus="status" begin="${pb.currentStartPage}" end="${pb.currentEndPage}">
                <c:choose>
                  <c:when test="${params.page==i}">
                    <li class="active"><a>${i}</a></li>
                  </c:when>
                  <c:otherwise>
                    <li><a href="${pb.getQueryString(i)}">${i}</a></li>
                  </c:otherwise>
                </c:choose>
              </c:forEach>

              <c:if test="${pb.isShowNext()}">
                <li class="next">
                <a href="${pb.getQueryString(pb.nextStartPage) }">다음목록</a></li>
              </c:if>

              <c:if test="${pb.isShowLast()}">
                <li>
                <a href="${pb.getQueryString(pb.totalPageCount) }">끝으로</a></li>
              </c:if>
            </ul>

            <%-- 검색 --%>
            <div class="jiji_div">
              <form name="search" class="form-inline" role="form"
                method="get"
                action="${pageContext.servletContext.contextPath}/boards/qnalist.joya">
                <div class="form-group">
                  <select class="form-control" id="type" name="type">
                    <option value="title">제목</option>
                    <option value="contents">내용</option>
                    <option value="writer">작성자</option>
                  </select> <input type="text" class="form-control" id="value"
                    name="value" required>
                </div>
                <button type="submit" class="btn btn-default">검색</button>
              </form>
            </div>
          </div>
        </section>
      </div>
    </div>
  </div>

  <!-- footer 시작 -->
  <jsp:include page="../include/footer.jsp" />
  <!-- footer 종료 -->
</body>
<!-- BODY 영역 종료 -->