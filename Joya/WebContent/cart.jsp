<%@ page contentType="text/html; charset=utf-8"%>
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
  <title>Account Page</title>
  
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
	
	<script src="assets/javascripts/jquery-1.9.1.min.js" type="text/javascript"></script>
	<script src="assets/javascripts/bootstrap.min.3x.js" type="text/javascript"></script>
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
								<form action="http://demo.designshopify.com/cart" method="post" id="cartform" class="clearfix">
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
											<tr class="item donec-condime-fermentum">
                                                <!-- 제품 선택 -->
                                                <td>
                                                  <input class="ji-productSelect"  id=""  type="checkbox"  value="" name="">
                                                </td>
                                                
                                                <!-- 제품 설명(사진, 이미지) start -->
												<td class="title text-left">
													<ul class="list-inline">
														<li class="image">
														<a href="product.html">
														<img src="assets/images/4_0fe2529b-f7ae-4ed5-a8ff-4fae623757f9_small.jpg" alt="Donec condime fermentum">
														</a>
														</li>
														<li class="link">
														<a href="product.html">
														<span class="title-5">Donec condime fermentum</span>
														</a>
														<br>
														<span class="variant_title">black / small</span>
														<br>
														</li>
													</ul>
												</td>
                                                
                                                <!-- 제품 가격 -->
												<td class="title-1">
													$200.00
												</td>
                                                
                                                <!-- 제품 수량 -->
												<td>
													<input class="form-control input-1 replace" maxlength="5" size="5" id="updates_3947646083" name="updates[]" value="1">
												</td>
                                                
                                                <!-- 제품 수량에 대한 가격 -->
												<td class="total title-1">
													$200.00
												</td>
                        
                                                <!-- 제거 -->
												<td class="action">
													<!-- <button type="button" ><i class="fa fa-times"></i>Remove</button> -->
                                                     <button type="button"><input class="ji-cart-deleteBtn" type="image" src="assets/images/jiDelete.png"" ></button>
												</td>
                        
											</tr>
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
													<button type="submit" id="update-cart" class="btn btn-2" name="update">Update Qty</button>
												</td>
												<td class="subtotal title-1">
													$1,600.00
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
								</form>
								
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