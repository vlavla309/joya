<%@ page contentType="text/html; charset=utf-8"%>
<!doctype html>
<html lang="en" class="no-js">
<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
<head>
  <meta charset="UTF-8">
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />
  <link rel="canonical" href="http://demo.designshopify.com/" />
  <meta name="description" content="" />
  <title>Order List</title>
 
     <!-- css 적용 부분 시작 -->
    <link href="../assets/stylesheets/font.css" rel='stylesheet' type='text/css'>
	<link href="../assets/stylesheets/font-awesome.min.css" rel="stylesheet" type="text/css" media="all"> 	
	<link href="../assets/stylesheets/bootstrap.min.3x.css" rel="stylesheet" type="text/css" media="all">
	<link href="../assets/stylesheets/cs.bootstrap.3x.css" rel="stylesheet" type="text/css" media="all">
	<link href="../assets/stylesheets/cs.animate.css" rel="stylesheet" type="text/css" media="all">
	<link href="../assets/stylesheets/cs.global.css" rel="stylesheet" type="text/css" media="all">
	<link href="../assets/stylesheets/cs.style.css" rel="stylesheet" type="text/css" media="all">
	<link href="../assets/stylesheets/cs.media.3x.css" rel="stylesheet" type="text/css" media="all">
	<link href="../assets/stylesheets/orders.css" rel="stylesheet" type="text/css" media="all">
  	<link href="../assets/stylesheets/jasny-bootstrap.min.css" rel="stylesheet" type="text/css" media="all">
  
	<script src="../assets/javascripts/jquery-1.9.1.min.js" type="text/javascript"></script>
	<script src="../assets/javascripts/bootstrap.min.3x.js" type="text/javascript"></script>
	<script src="../assets/javascripts/jasny-bootstrap.min.js" type="text/javascript"></script>
  <!-- css 적용 부분 종료 -->
    </style>
    
    <script type="text/javascript">
    $(function() {
    	$("#m_reviewtxt").focus();
    })
    
    </script>
    
    
</head>

<body itemscope="" itemtype="http://schema.org/WebPage" class="templateCustomersRegister notouch">
  
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
                <a href="index-2.html" class="homepage-link" title="Back to the frontpage">Home</a>
                <span>/</span>
                <span class="page-title">Review</span>
              </div>
            </div>
          </div>
        </div>              
        <section class="content">
        <br>
          <div class="container">
            <div class="row">
              <!-- 주문 내역 조회 영역 시작 -->
              <div id="col-main" class="account-page col-sm-18 col-md-18 clearfix">
                <div id="customer_orders">
                  <h6 class="sb-title">Review</h6>
                  <span class="mini-line"></span>
                  <div class="row wrap-table">
                  <form action="${pageContext.servletContext.contextPath}/boards/writearticle.joya?board_id=3"
                    method="post" enctype="multipart/form-data">
                    <table class="table-hover">
                    <!-- 테이블 헤더 시작 -->
                    <input type="hidden" name="title" value="상품평">
                    <input type="hidden" name="email" value="${email}">
                    <input type="hidden" name="writer" value="${name}">
                    <input type="hidden" name="passwd" value="상품평비번">
                    <input type="hidden" name="productid" value="${productid}">
                    <input type="hidden" name="orderid" value="${orderid}">
                    <thead>
	                    <tr>
	                      <th class="order_number" id="mi_review_1">
	                        	Image file
	                      </th>
	                      <th class="payment_status" colspan="4" id="mi_review_2">
	                        Please Write Your Comment
	                      </th>
	                    </tr>
                    </thead>
                    <!-- 테이블 헤더 종료 -->
                    
                    <!-- 테이블 바디 시작 -->
                    <tbody>
                    <tr class="odd ">
                      <td id="">
                      	<div class="fileinput fileinput-new" data-provides="fileinput">
					      <div class="fileinput-preview thumbnail" data-trigger="fileinput" style="width: 200px; height: 150px;">
					      </div>
					      <div>
					        <span class="btn btn-default btn-file"><span class="fileinput-new">Select image</span><span class="fileinput-exists">Change</span>
					        <input type="file" name="filepath" value="5"></span>
					        <a href="#" class="btn btn-default fileinput-exists" data-dismiss="fileinput">Remove</a>
					      </div>
					  	</div>
                      </td>
                      <td colspan="4">
                        <textarea rows="10" cols="60" name="contents" id="m_reviewtxt"></textarea>
                      </td>
                    </tr>
                    </tbody>
                    <!-- 테이블 바디 종료 -->
                    </table> 
                    <br>
                    <div id="reviewsubmit_m">
                    <center><input class="btn" type="submit" id="reviewbtn" value="Write"></center>
                    </div>
                    </form>
                  </div>
                </div>
              </div>  
              <!-- 주문 내역 조회 영역 종료 -->
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