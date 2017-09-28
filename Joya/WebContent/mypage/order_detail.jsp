<%@ page contentType="text/html; charset=utf-8"%>
<!doctype html>
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"> <!--<![endif]-->

<!-- Mirrored from demo.designshopify.com/html_jewelry/account.html by HTTrack Website Copier/3.x [XR&CO'2014], Thu, 21 Sep 2017 08:51:03 GMT -->
<!-- Added by HTTrack --><meta http-equiv="content-type" content="text/html;charset=UTF-8" /><!-- /Added by HTTrack -->
<head>
  <meta charset="UTF-8">
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />
  <link rel="canonical" href="http://demo.designshopify.com/" />
  <meta name="description" content="" />
  <title>Order Detail View</title>
 
     <!-- css 적용 부분 시작 -->
    <link href="../assets/stylesheets/font.css" rel='stylesheet' type='text/css'>
  
	<link href="../assets/stylesheets/font-awesome.min.css" rel="stylesheet" type="text/css" media="all"> 	
	<link href="../assets/stylesheets/bootstrap.min.3x.css" rel="stylesheet" type="text/css" media="all">
	<link href="../assets/stylesheets/cs.bootstrap.3x.css" rel="stylesheet" type="text/css" media="all">
	<link href="../assets/stylesheets/cs.animate.css" rel="stylesheet" type="text/css" media="all">
	<link href="../assets/stylesheets/cs.global.css" rel="stylesheet" type="text/css" media="all">
	<link href="../assets/stylesheets/cs.style.css" rel="stylesheet" type="text/css" media="all">
	<link href="../assets/stylesheets/cs.media.3x.css" rel="stylesheet" type="text/css" media="all">
	<link href="../assets/stylesheets/orderList.css" rel="stylesheet" type="text/css" media="all">
  
	<script src="../assets/javascripts/jquery-1.9.1.min.js" type="text/javascript"></script>
	<script src="../assets/javascripts/bootstrap.min.3x.js" type="text/javascript"></script>
  <!-- css 적용 부분 종료 -->
  
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
                <span class="page-title">My Account</span>
              </div>
            </div>
          </div>
        </div>              
        <section class="content">
          <div class="container">
            <div class="row">
              <div id="page-header" class="col-md-24">
                <h1 id="page-title">My Account</h1> 
              </div>
              <!-- 사용자 정보 영역 시작 -->
              <div class="col-sm-6 col-md-6 sidebar">
                <div class="group_sidebar">
                  <div class="row sb-wrapper unpadding-top">
                    <h6 class="sb-title">Account Details</h6>
                    <span class="mini-line"></span>
                    <ul id="customer_detail" class="list-unstyled sb-content">
                      <li>
                      <address class="clearfix">
                      <div class="info">
                        <i class="fa fa-user"></i>
                        <span class="address-group">
                        <span class="author">Jin Alkaid</span>
                        <span class="email">jin@gmail.com</span>
                        </span>
                      </div>
                      <div class="address">
                        <span class="address-group">
                        <span class="address1">point : #######<span class="phone-number"></span></span>
                        <span class="address1">address : ~~~~~~<span class="phone-number"></span></span>
                        </span>
                      </div>
                      </address>
                      </li>
                      <li>
                      <button class="btn btn-1" id="view_address" onclick="window.location='address.html'">Manager Address (1)</button>
                      </li>
                    </ul>
                  </div>
                </div>
              </div>
              <!-- 사용자 정보 영역 종료 -->
              
              <!-- 주문 내역 조회 영역 시작 -->
              <div id="col-main" class="account-page col-sm-18 col-md-18 clearfix">
                <div id="customer_orders">
                  <h6 class="sb-title">선택한 주문 번호</h6>
                  <span class="mini-line"></span>
                  <div class="row wrap-table">
                    <table class="table-hover">
                    <!-- 테이블 헤더 시작 -->
                    <thead>
                    <tr>
                      <th class="order_number">
                        No.
                      </th>
                      <th class="date">
                        제품사진
                      </th>
                      <th class="payment_status">
                        제품명
                      </th>
                      <th class="fulfillment_status">
                        금액
                      </th>
                      <th class="total">
                      </th>
                    </tr>
                    </thead>
                    <!-- 테이블 헤더 종료 -->
                    
                    <!-- 테이블 바디 시작 -->
                    <tbody>
                    <tr class="odd ">
                      <td>
                        01
                      </td>
                      <td>
                        <span class="note"><input type="image" src="../assets/images/5_compact.jpg"></span>
                      </td>
                      <td>
                        <span class="status_authorized">빨리깨져 커플링</span>
                      </td>
                      <td>
                        <span class="status_unfulfilled">20000</span>
                      </td>
                      <td>
                        <a href="#"><span class="total"><input class="ji-reviewB" type="button" value="상품평"></span></a>
                      </td>
                    </tr>
                    <tr class="odd ">
                      <td>
                        02
                      </td>
                      <td>
                        <span class="note"><input type="image" src="../assets/images/5_compact.jpg"></span>
                      </td>
                      <td>
                        <span class="status_authorized">하하하 커플링</span>
                      </td>
                      <td>
                        <span class="status_unfulfilled">20000</span>
                      </td>
                      <td>
                        <a href="#"><span class="total"><input class="ji-reviewB" type="button" value="상품평"></span></a>
                      </td>
                    </tr>
                    </tbody>
                    <!-- 테이블 바디 종료 -->
                    
                    </table>
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