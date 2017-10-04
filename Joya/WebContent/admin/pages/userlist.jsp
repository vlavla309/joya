<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>관리자페이자</title>

<!-- Bootstrap Core CSS -->
<link
	href="${pageContext.servletContext.contextPath}/admin/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link
	href="${pageContext.servletContext.contextPath}/admin/vendor/metisMenu/metisMenu.min.css"
	rel="stylesheet">

<!-- DataTables CSS -->
<link
	href="${pageContext.servletContext.contextPath}/admin/vendor/datatables-plugins/dataTables.bootstrap.css"
	rel="stylesheet">

<!-- DataTables Responsive CSS -->
<link
	href="${pageContext.servletContext.contextPath}/admin/vendor/datatables-responsive/dataTables.responsive.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link
	href="${pageContext.servletContext.contextPath}/admin/dist/css/sb-admin-2.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="${pageContext.servletContext.contextPath}/admin/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<div id="wrapper">

		<!-- Navigation -->
		<jsp:include page="${pageContext.servletContext.contextPath}/admin/pages/include/nav.jsp"></jsp:include>

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">회원정보</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">회원 목록</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<table width="100%"
								class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								<thead>
									<tr>
										<th>번호</th>
										<th>아이디</th>
										<th>이름</th>
										<th>전화번호</th>
										<th>회원구분</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${users}" var="user" varStatus="status">
										<tr class="odd gradeX">
											<td>${(pageBuilder.totalRowCount-((params.page-1)*(params.pageSize)))-status.index}</td>
											<td><a class="userInfoBtn" value="${user.email }">${user.email }</a></td>
											<td>${user.name }</td>
											<td class="center">${user.phone }</td>
											<c:if test="${user.type==0}">
												<td class="center">일반회원</td>
											</c:if>
											<c:if test="${user.type==1}">
												<td class="center">관리자</td>
											</c:if>
										</tr>
									</c:forEach>

								</tbody>
							</table>
							<!-- /.table-responsive -->

						</div>
						<!-- /.panel-body -->


						<!--  pagination start-->
						<div class="row">
							<div class="col-sm-6">
								<div class="dataTables_info" id="dataTables-example_info"
									role="status" aria-live="polite">Showing 1 to 2 of 2
									entries</div>
							</div>
							<div class="col-sm-6">
								<div class="dataTables_paginate paging_simple_numbers"
									id="dataTables-example_paginate">
									<ul class="pagination">

										<c:if test="${pageBuilder.isShowPrevious()}">
											<li class="paginate_button previous"
												aria-controls="dataTables-example" tabindex="0"
												id="dataTables-example_previous"><a
												href="${pageBuilder.getQueryString(pageBuilder.getPreviousStartPage())}">Previous</a></li>
										</c:if>
										<c:if test="${!pageBuilder.isShowPrevious()}">
											<<li class="paginate_button previous disabled"
												aria-controls="dataTables-example" tabindex="0"
												id="dataTables-example_previous"><a href="#">Previous</a></li>
										</c:if>

										<c:forEach begin="${pageBuilder.currentStartPage}"
											end="${pageBuilder.currentEndPage}" varStatus="status">
											<c:if test="${params.page==status.index}">
												<li class="paginate_button active"
													aria-controls="dataTables-example" tabindex="0"><a
													href="#">${status.index}</a></li>
											</c:if>
											<c:if test="${params.page!=status.index}">
												<li><a
													href="${pageBuilder.getQueryString(status.index)}">${status.index}</a></li>
											</c:if>
										</c:forEach>

										<c:if test="${pageBuilder.isShowNext()}">
											<li class="paginate_button next"
												aria-controls="dataTables-example" tabindex="0"
												id="dataTables-example_next"><a
												href="${pageBuilder.getQueryString(pageBuilder.nextStartPage)}">Next</a></li>
										</c:if>
										<c:if test="${!pageBuilder.isShowNext()}">
											<li class="paginate_button next disabled"
												aria-controls="dataTables-example" tabindex="0"
												id="dataTables-example_next"><a href="#">Next</a></li>
										</c:if>

									</ul>
								</div>
							</div>
						</div>
						<!-- pagination end -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->

		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!--  #modal start -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header alert alert-danger">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">회원상세정보</h4>
				</div>
				<div class="modal-body" id="userInfoDiv">
					<label class="success-message">여기에 회원 상세 정보를 보여주면 된다</label>
					<p></p>
				</div>
				<div class="modal-footer">
					<button class="btn btn-default" data-dismiss="modal">닫기</button>
				</div>
			</div>
		</div>
	</div>
	<!--  #modal end -->

	<!-- jQuery -->
	<script
		src="${pageContext.servletContext.contextPath}/admin/vendor/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script
		src="${pageContext.servletContext.contextPath}/admin/vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script
		src="${pageContext.servletContext.contextPath}/admin/vendor/metisMenu/metisMenu.min.js"></script>

	<!-- DataTables JavaScript -->
	<script
		src="${pageContext.servletContext.contextPath}/admin/vendor/datatables/js/jquery.dataTables.min.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/admin/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/admin/vendor/datatables-responsive/dataTables.responsive.js"></script>

	<!-- Custom Theme JavaScript -->
	<script	src="${pageContext.servletContext.contextPath}/admin/dist/js/sb-admin-2.js"></script>
	<script	src="${pageContext.servletContext.contextPath}/admin/dist/js/userlist.js"></script>
	
	<!-- Page-Level Demo Scripts - Tables - Use for reference
	<script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
            responsive: true
        });
    });
    </script>-->

</body>

</html>
