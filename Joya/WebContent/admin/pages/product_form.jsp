<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Bootstrap Admin Theme</title>

    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.servletContext.contextPath}/admin/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="${pageContext.servletContext.contextPath}/admin/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${pageContext.servletContext.contextPath}/admin/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${pageContext.servletContext.contextPath}/admin/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

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
                    <h1 class="page-header">상품등록</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            상품 등록
                        </div>
                        <div class="panel-body">
                            <div class="row">
                             <form role="form" name="productForm" action="/admin/product_add_action.joya" method="post" enctype="multipart/form-data">
                                <div class="col-lg-6">
                                   		<h1>상품 정보</h1>
                                        <div class="form-group">
                                            <label>상품이름</label>
                                            <input type='text' class="form-control" maxlength="30" name="productName">
                                            <p class="help-block">최대 30글자</p>
                                        </div>
                                         <div class="form-group">
                                            <label>제조사</label>
                                            <input type='text'  class="form-control" maxlength="30" name="maker">
                                            <p class="help-block">최대 30글자</p>
                                        </div>
                                         <div class="form-group">
                                            <label>가격</label>
                                            <input type="number" class="form-control" name="price">
                                            <p class="help-block">(단위:원)</p>
                                        </div>
                                        <div class="form-group">
                                            <label>재고량</label>
                                            <input type="number" class="form-control" name="amount">
                                            <p class="help-block">(단위:개)</p>
                                        </div>
                                        <div class="form-group">
                                            <label>카테고리</label>
                                            <select class="form-control"  name="categoryName">
                                             <c:forEach items="${categories}" var="category" varStatus="status">
												<option>${category.categoryName}</option>
											 </c:forEach>
                                              
                                            </select>
                                        </div>
                                         <div class="form-group">
                                            <label>상품 설명</label>
                                            <textarea class="form-control" rows="6"  name="productDesc"></textarea>
                                        </div>
                                </div>
                                <!-- /.col-lg-6 (nested) -->
                                <div class="col-lg-6" >
										<h1>상품 사진</h1>
										<input type="button" value="추가" onClick="addFile(this.form)" border=0 style='cursor:hand'>
										<input type="button" value="제거" onClick="deleteFile(this.form)" border=0 style='cursor:hand'>
										<div class="form-group" id="imageForm">
                                            <label>사진 등록 (대표 사진)</label>
                                            <input type="file" name="filename1" value="5">
                                             <p class="help-block">필수 사항입니다.</p>
                                        </div>
                                     
                                        <button type="submit" class="btn btn-default">Submit Button</button>
                                        <button type="reset" class="btn btn-default">Reset Button</button>
                                 
                                </div>
                                <!-- /.col-lg-6 (nested) -->
                                   </form>
                            </div>
                            <!-- /.row (nested) -->
                        </div>
                        <!-- /.panel-body -->
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

    <!-- jQuery -->
    <script src="${pageContext.servletContext.contextPath}/admin/vendor/jquery/jquery-3.2.0.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.servletContext.contextPath}/admin/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="${pageContext.servletContext.contextPath}/admin/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="${pageContext.servletContext.contextPath}/admin/dist/js/sb-admin-2.js"></script>
    <script src="${pageContext.servletContext.contextPath}/admin/dist/js/productform.js"></script>

</body>

</html>
