<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"> <!--<![endif]-->

<!-- Mirrored from demo.designshopify.com/html_jewelry/cart.html by HTTrack Website Copier/3.x [XR&CO'2014], Thu, 21 Sep 2017 08:52:22 GMT -->
<!-- Added by HTTrack --><meta http-equiv="content-type" content="text/html;charset=UTF-8" /><!-- /Added by HTTrack -->
<head>
  <meta charset="UTF-8">
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />
  <link rel="canonical" href="http://demo.designshopify.com/" />
  <meta name="description" content="" />
  <title>Cart - Joya</title>
  <!-- favicon -->
  	<link rel="shortcut icon" href="/assets/images/favicon.ico">
  
  
  <!-- css 적용 부분 시작 -->
    <link href="assets/stylesheets/font.css" rel='stylesheet' type='text/css'>
  
	<link href="assets/stylesheets/font-awesome.min.css" rel="stylesheet" type="text/css" media="all"> 	
	<link href="assets/stylesheets/bootstrap.min.3x.css" rel="stylesheet" type="text/css" media="all">
	<link href="assets/stylesheets/cs.bootstrap.3x.css" rel="stylesheet" type="text/css" media="all">
	<link href="assets/stylesheets/cs.animate.css" rel="stylesheet" type="text/css" media="all">
	<link href="assets/stylesheets/cs.global.css" rel="stylesheet" type="text/css" media="all">
	<link href="assets/stylesheets/cs.style.css" rel="stylesheet" type="text/css" media="all">
	<link href="assets/stylesheets/cs.media.3x.css" rel="stylesheet" type="text/css" media="all">
    <link href="assets/stylesheets/jjh-style.css" rel="stylesheet"  type="text/css" media="all">
	<link href="assets/stylesheets/cart.css" rel="stylesheet"  type="text/css" media="all">
	
	
	<script src="assets/javascripts/jquery-1.9.1.min.js" type="text/javascript"></script>
	<script src="assets/javascripts/bootstrap.min.3x.js" type="text/javascript"></script>
	<script src="assets/javascripts/cookies.js" type="text/javascript"></script>
	<script src="assets/javascripts/cart.js" type="text/javascript"></script>
	<script src="assets/javascripts/cart_function.js" type="text/javascript"></script>
	<script src="/assets/javascripts/referer.js" type="text/javascript"></script>
	
	
	
  
  <!-- css 적용 부분 종료 -->
</head>

<body itemscope="" itemtype="http://schema.org/WebPage" class="templateCart notouch">
  
	<!-- Header 영역 시작 -->
    <jsp:include page="include/header.jsp" />
    <!-- Header 영역 종료 -->
  
    <!-- 본문 영역 시작 -->
	<div id="content-wrapper-parent">
		<div id="content-wrapper">  
			
			<div id="content" class="clearfix">      
      
                <!-- smallHeader 영역 시작 -->          
				<div id="breadcrumb" class="breadcrumb">
					<div itemprop="breadcrumb" class="container">
						<div class="row">
							<div class="col-md-24">
								<a href="index-2.html" class="homepage-link" title="Back to the frontpage">Home</a>
								<span>/</span>
								<span class="page-title">Your Shopping Cart</span>
							</div>
						</div>
					</div>
				</div>        
                <!-- smallHeader 영역 종료 -->
                
				<section class="content">
					<div class="container">
						<div class="row">
							<div id="page-header" class="col-md-24">
								<h1 id="page-title">Shopping Cart</h1>
							</div>
              
							<div id="col-main" class="col-md-24 cart-page content">
									<div class="row table-cart">
										<div class="wrap-table">
                    
                                            <!-- 장바구니 테이블 start -->
										<table class="cart-items haft-border">
											<colgroup>
											<col class="checkout-image">
											<col class="checkout-info">
											<col class="checkout-price">
											<col class="checkout-quantity">
											<col class="checkout-totals">
											</colgroup>
                                         
											<thead>
											<tr class="top-labels">
                                               <th>
                                                    &nbsp;
                                                </th>
												<th>
													Items
												</th>
												<th>
													Price
												</th>
												<th>
													Qty
												</th>
												<th>
													SubTotal
												</th>
												<th>
													&nbsp;
												</th>
												
											</tr>
											</thead>
                      
											<tbody>
											<c:forEach items="${cart}" var="cartItem" varStatus="status">
														<tr class="item donec-condime-fermentum" id="productId_${cartItem.key }">
                                                <!-- 체크박스 -->
                                                <td>&nbsp;</td>
                                                <!-- 제품 설명(사진, 이미지) start -->
												<td class="title text-left">
													<ul class="list-inline">
														<li class="image">
														<a href="${pageContext.servletContext.contextPath}/product/view.joya?productid=${cartItem.key}&type=view">
														<img src="/shopimg/${images[cartItem.key].imageName }" alt="${products[cartItem.key].productName}" class="cartImg">
														</a>
														</li>
														<li class="link">
														<a href="${pageContext.servletContext.contextPath}/product/view.joya?productid=${cartItem.key}&type=view">
														<span class="title-5">${products[cartItem.key].productName }</span>
														</a>
														</li>
													</ul>
												</td>
                                                
                                                <!-- 제품 가격 -->
												<td class="title-1">
													&#8361; <span class="cartItemPrice" name=${cartItem.key}>${products[cartItem.key].price }</span>
												</td>
                                                
                                                <!-- 제품 수량 -->
												<td>
													<input type="number" class="form-control input-1 replace productAmount" maxlength="5" size="5" min = "1" id="updates_3947646083" name="${cartItem.key }" value="${cartItem.value }">
												</td>
                                                
                                                <!-- 제품 수량에 대한 가격 -->
												<td class="total title-1">
													&#8361;  <span class="subPrice" name="${cartItem.key}">${products[cartItem.key].price*cartItem.value }</span>
												</td>
                        
                                                <!-- 제거 -->
												<td class="action">
                                                    <input class="ji-cart-deleteBtn" type="image" src="assets/images/jiDelete.png" value= ${cartItem.key}>
												</td>
                        
											</tr>
											</c:forEach>	
											</tbody>
                                            
                                            <!-- 선택한 상품들의 총 금액 출력 영역 start -->
											<tfoot>
											<tr class="bottom-summary">
                                                <td>
                                                  &nbsp;
                                                </td>
												<td>
													&nbsp;
												</td>
												<td>
													&nbsp;
												</td>
												<td class="update-quantities">
													<button type="button" id="update-cart" class="btn btn-2" name="update" >Update Qty</button>
												</td>
												<td id="subtotalCart" class="subtotal title-1">
													<span>&#8361;</span><span id="subtotalPrice"></span>
												</td>
												<td>
													&nbsp;
												</td>
											</tr>
											</tfoot>
                                            <!-- 선택한 상품들의 총 금액 출력 영역 end -->
                                            
									   </table>
                                       <!-- 장바구니 테이블 end -->
                                            
										</div>
									</div>
									<div class="clearfix">
										<div id="checkout-proceed" class="last1 text-right">
											<button class="btn" type="submit" id="checkout" name="checkout">Checkout</button>
										</div>
									</div>
								
							</div>
						</div>
					</div>
				</section>        
			</div>
		</div>
	</div>
     <!-- 본문 영역 종료 -->
      
	<!-- footer 시작 -->
    <jsp:include page="include/footer.jsp" />
    <!-- footer 종료 -->
  </body>