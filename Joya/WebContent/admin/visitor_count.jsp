<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
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

    <!-- Morris Charts CSS -->
    <link href="${pageContext.servletContext.contextPath}/admin/vendor/morrisjs/morris.css" rel="stylesheet">

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
                    <h1 class="page-header">방문자 수</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
              
                <!-- /.col-lg-6 -->
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                           일일 방문자 수 
                           <input type="date" name="date" id="visitDate" value="${date}">
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div id="morris-line-chart"></div>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-6 -->
             
                
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="${pageContext.servletContext.contextPath}/admin/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.servletContext.contextPath}/admin/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="${pageContext.servletContext.contextPath}/admin/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="${pageContext.servletContext.contextPath}/admin/vendor/raphael/raphael.min.js"></script>
    <script src="${pageContext.servletContext.contextPath}/admin/vendor/morrisjs/morris.min.js"></script>
    <script src="${pageContext.servletContext.contextPath}/admin/data/morris-data.js"></script>
    <script src="${pageContext.servletContext.contextPath}/admin/dist/js/visitor_count.js"></script>

	<script type="text/javascript">
	
		$(function() {
			setData(${datas})
		});
	</script>

	<!-- Custom Theme JavaScript -->
	<script
		src="${pageContext.servletContext.contextPath}/admin/dist/js/sb-admin-2.js"></script>

</body>

</html>

