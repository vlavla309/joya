<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />
<link rel="canonical" href="http://demo.designshopify.com/" />
<meta name="description" content="" />
<title>Product Full Width</title>

<link href="../assets/stylesheets/font.css" rel='stylesheet'
	type='text/css'>
<link href="../assets/stylesheets/font-awesome.min.css" rel="stylesheet"
	type="text/css" media="all">
<link href="../assets/stylesheets/jquery.camera.css" rel="stylesheet"
	type="text/css" media="all">
<link href="../assets/stylesheets/jquery.fancybox-buttons.css"
	rel="stylesheet" type="text/css" media="all">
<link href="../assets/stylesheets/cs.animate.css" rel="stylesheet"
	type="text/css" media="all">
<link href="../assets/stylesheets/application.css" rel="stylesheet"
	type="text/css" media="all">
<link href="../assets/stylesheets/swatch.css" rel="stylesheet"
	type="text/css" media="all">
<link href="../assets/stylesheets/jquery.owl.carousel.css"
	rel="stylesheet" type="text/css" media="all">
<link href="../assets/stylesheets/jquery.bxslider.css" rel="stylesheet"
	type="text/css" media="all">
<link href="../assets/stylesheets/bootstrap.min.3x.css" rel="stylesheet"
	type="text/css" media="all">
<link href="../assets/stylesheets/cs.bootstrap.3x.css" rel="stylesheet"
	type="text/css" media="all">
<link href="../assets/stylesheets/cs.global.css" rel="stylesheet"
	type="text/css" media="all">
<link href="../assets/stylesheets/cs.style.css" rel="stylesheet"
	type="text/css" media="all">
<link href="../assets/stylesheets/cs.media.3x.css" rel="stylesheet"
	type="text/css" media="all">
<link href="../assets/stylesheets/spr.css" rel="stylesheet"
	type="text/css" media="all">
<link href="../assets/stylesheets/addthis.css" rel="stylesheet"
	type="text/css" media="all">
<script src="../assets/javascripts/jquery-1.9.1.min.js"
	type="text/javascript"></script>
<script src="../assets/javascripts/jquery.imagesloaded.min.js"
	type="text/javascript"></script>
<script src="../assets/javascripts/bootstrap.min.3x.js"
	type="text/javascript"></script>
<script src="../assets/javascripts/jquery.easing.1.3.js"
	type="text/javascript"></script>
<script src="../assets/javascripts/jquery.camera.min.js"
	type="text/javascript"></script>
<script src="../assets/javascripts/jquery.mobile.customized.min.js"
	type="text/javascript"></script>
<script src="../assets/javascripts/cookies.js" type="text/javascript"></script>
<script src="../assets/javascripts/modernizr.js" type="text/javascript"></script>
<script src="../assets/javascripts/application.js"
	type="text/javascript"></script>
<script src="../assets/javascripts/jquery.owl.carousel.min.js"
	type="text/javascript"></script>
<script src="../assets/javascripts/jquery.bxslider.js"
	type="text/javascript"></script>
<script src="../assets/javascripts/skrollr.min.js"
	type="text/javascript"></script>
<script src="../assets/javascripts/jquery.fancybox-buttons.js"
	type="text/javascript"></script>
<script src="../assets/javascripts/jquery.zoom.js"
	type="text/javascript"></script>
<script src="../assets/javascripts/cs.script.js" type="text/javascript"></script>

<script src="../assets/javascripts/cart_function.js"
	type="text/javascript"></script>
<script src="/assets/javascripts/referer.js" type="text/javascript"></script>

<script>
	$(function() {
		$(".add-to-cart").click(function() {
			var productId = $(this).val();
			var amount = $("#quantity").val();
			addCartItem(productId, amount);
		});
	})
</script>
</head>

<body style="height: 2671px;" itemscope=""
	itemtype="http://schema.org/WebPage" class="templateProduct notouch">

	<!-- Header -->
	<jsp:include page="../include/header.jsp" />
	<!-- end of Header -->

	<div id="content-wrapper-parent">
		<div id="content-wrapper">
			<!-- Content -->
			<div id="content" class="clearfix">
				<div id="breadcrumb" class="breadcrumb">
					<div itemprop="breadcrumb" class="container">
						<div class="row">
							<div class="col-md-24">
								<a href="index-2.html" class="homepage-link"
									title="Back to the frontpage">Home</a> <span>/</span> <a
									href="collection.html" title="">Bracelets</a> <span>/</span> <span
									class="page-title">${product.productName}</span>
							</div>
						</div>
					</div>
				</div>
				<section class="content">
					<div class="container">
						<div class="row">
							<div id="col-main" class="product-page col-xs-24 col-sm-24 ">
								<div itemscope="" itemtype="http://schema.org/Product">
									<meta itemprop="url"
										content="/products/donec-condime-fermentum">
									<div id="product" class="content clearfix">
										<h1 id="page-title" class="text-center">
											<span itemprop="name">${product.productName}</span>
										</h1>

										<div id="product-image" class="product-image row ">
											<div id="detail-left-column"
												class="hidden-xs left-coloum col-sm-6 col-sm-6 fadeInRight not-animated"
												data-animate="fadeInRight">
												<div id="gallery_main"
													class="product-image-thumb thumbs full_width ">
													<ul class="slide-product-image">
														<c:forEach items="${imglist}" var="img" varStatus="status">
															<c:choose>
																<c:when test="${status.first}">
																	<li class="image"><a
																		href="${img.path}${img.imageName}"
																		class="cloud-zoom-gallery active"> <img
																			src="${img.path}${img.imageName}" alt="slide1">
																	</a></li>
																</c:when>
																<c:otherwise>
																	<li class="image"><a
																		href="${img.path}${img.imageName}"
																		class="cloud-zoom-gallery"> <img
																			src="${img.path}${img.imageName}" alt="slide2">
																	</a></li>
																</c:otherwise>
															</c:choose>
														</c:forEach>
													</ul>
												</div>
											</div>
											<!--  누르면 보여져야하는 이미지... main image -->
											<div
												class="image featured col-smd-12 col-sm-12 fadeInUp not-animated"
												data-animate="fadeInUp">
												<c:forEach items="${imglist}" var="img" varStatus="status">
													<c:if test="${status.first}">
														<img src="${img.path}${img.imageName}" alt="main image1">
													</c:if>
												</c:forEach>
											</div>
											<!-- slide-product-image과 갯수가 비슷해야함 main mobile -->
											<div id="gallery_main_mobile"
												class="visible-xs product-image-thumb thumbs mobile_full_width ">
												<ul style="opacity: 0; display: block;"
													class="slide-product-image owl-carousel owl-theme">
													<c:forEach items="${imglist}" var="img" varStatus="status">
														<c:choose>
															<c:when test="${status.first}">
																<li class="image"><a
																	href="${img.path}${img.imageName}"
																	class="cloud-zoom-gallery active"> <img
																		src="${img.path}${img.imageName}" alt="slide1">
																</a></li>
															</c:when>
															<c:otherwise>
																<li class="image"><a
																	href="${img.path}${img.imageName}"
																	class="cloud-zoom-gallery"> <img
																		src="${img.path}${img.imageName}" alt="slide2">
																</a></li>
															</c:otherwise>
														</c:choose>
													</c:forEach>
												</ul>
											</div>

											<div id="detail-right-column"
												class="right-coloum col-sm-6 fadeInLeft not-animated"
												data-animate="fadeInLeft">
												<div class="addthis_sharing_toolbox" data-url="#"
													data-title="Donec aliquam ante non | Jewelry - HTML Template">
													<div id="atstbx"
														class="at-share-tbx-element addthis_32x32_style addthis-smartlayers addthis-animated at4-show">
														<a class="at-share-btn at-svc-facebook"><span
															class="at4-icon aticon-facebook" title="Facebook"></span></a><a
															class="at-share-btn at-svc-twitter"><span
															class="at4-icon aticon-twitter" title="Twitter"></span></a><a
															class="at-share-btn at-svc-email"><span
															class="at4-icon aticon-email" title="Email"></span></a><a
															class="at-share-btn at-svc-print"><span
															class="at4-icon aticon-print" title="Print"></span></a><a
															class="at-share-btn at-svc-compact"><span
															class="at4-icon aticon-compact" title="More"></span></a>
													</div>
												</div>
											</div>
										</div>
										<div id="product-information"
											class="product-information row text-center ">
											<div id="product-header" class="clearfix">
												<div id="product-info-left">
													<div class="description">
														<span>Product Descriptions</span>
														<p>${product.productDesc}</p>
													</div>
													<div class="relative">
														<ul class="list-unstyled">
															<li class="tags"><span>Tags :</span> <a href="#">
																	above-200<span>,</span>
															</a> <a href="#"> black<span>,</span>
															</a> <a href="#"> l<span>,</span>
															</a> <a href="#"> sale-off </a></li>
														</ul>
													</div>
												</div>
												<div id="product-info-right">
													<div itemprop="offers" itemscope=""
														itemtype="http://schema.org/Offer"
														class="col-sm-24 group-variants">
														<meta itemprop="priceCurrency" content="USD">
														<link itemprop="availability"
															href="http://schema.org/InStock">
														<form
															action="http://demo.designshopify.com/html_jewelry/cart.html"
															method="post" class="variants" id="product-actions">
															<div id="product-actions-1293235843"
																class="options clearfix">
																<style scoped>
																	label[for="product-select-option-0"] {
																		display: none;
																	}
																	
																	#product-select-option-0 {
																		display: none;
																	}
																	
																	#product-select-option-0+.custom-style-select-box {
																		display: none !important;
																	}
																</style>
																<div class="quantity-wrapper clearfix">
																	<label class="wrapper-title">Quantity</label>
																	<div class="wrapper">
																		<input id="quantity" name="quantity" value="1"
																			maxlength="5" size="5" class="item-quantity"
																			type="text"> <span class="qty-group">
																			<span class="qty-wrapper"> <span
																				data-original-title="Increase"
																				class="qty-up btooltip" data-toggle="tooltip"
																				data-placement="top" title="" data-src="#quantity">
																					<i class="fa fa-caret-right"></i>
																			</span> <span data-original-title="Decrease"
																				class="qty-down btooltip" data-toggle="tooltip"
																				data-placement="top" title="" data-src="#quantity">
																					<i class="fa fa-caret-left"></i>
																			</span>
																		</span>
																		</span>
																	</div>
																</div>
																<div id="purchase-1293235843">
																	<div class="detail-price" itemprop="price">
																		<span class="price">${product.price}</span>
																	</div>
																</div>
																<div class="others-bottom clearfix">
																	<button id="add-to-cart" class="btn btn-1 add-to-cart"
																		data-parent=".product-information"
																		value="${product.productId}" type="button" name="add">Add
																		to Cart</button>
																</div>
															</div>
														</form>
														<div class="wls">
															<c:choose>
																<c:when test="${empty loginuser || loginuser eq null }">
																	<a class="wish-list" href="/user/login.joya" title="wish list"><i class="fa fa-heart-o"></i><span class="list-mode">Add to Wishlist</span></a>
																</c:when>
																<c:otherwise>
																	<c:choose>
																		<c:when test="${empty wishlist || loginuser eq null}">
																			<a class="wish-list"
																			href="${pageContext.servletContext.contextPath}/mypage/wishlistcreate.joya?productId=${product.productId}"><i
																			class="fa fa-heart-o"></i>Add to Wishlist</a> 
																		</c:when>
																		<c:otherwise>
																			<a class="wish-list" href="${pageContext.servletContext.contextPath}/mypage/wishlistdelete.joya?productId=${product.productId}" title="wish list"><i class="fa fa-heart"></i><span class="list-mode">delete to Wishlist</span></a>
																		</c:otherwise>
																	</c:choose>
																</c:otherwise>
															</c:choose>
															<span>|</span> 
															<a href="mailto:info@yourdomain.com"><i	class="fa fa-envelope"></i> SEND EMAIL</a>
														</div>
													</div>
													<ul id="tabs_detail"
														class="tabs-panel-detail hidden-xs hidden-sm">
														<li class="first">
															<h5>
																<a href="#pop-one" class="fancybox">Measurements
																	&amp; Specs</a>
															</h5>
														</li>
														<li>
															<h5>
																<a href="#pop-two" class="fancybox">Shipping &amp;
																	Returns</a>
															</h5>
														</li>
														<li>
															<h5>
																<a href="#pop-three" class="fancybox">Size Charts</a>
															</h5>
														</li>
													</ul>
													<div id="pop-one" style="display: none;">
														<img src="assets/images/mspecs_image.jpg" alt="">
													</div>
													<div id="pop-two" style="display: none;">
														<h5>Returns Policy</h5>
														<p>You may return most new, unopened items within 30
															days of delivery for a full refund. We'll also pay the
															return shipping costs if the return is a result of our
															error (you received an incorrect or defective item,
															etc.).You should expect to receive your refund within
															four weeks of giving your package to the return shipper,
															however, in many cases you will receive a refund more
															quickly. This time period includes the transit time for
															us to receive your return from the shipper (5 to 10
															business days), the time it takes us to process your
															return once we receive it (3 to 5 business days), and the
															time it takes your bank to process our refund request (5
															to 10 business days).If you need to return an item,
															simply login to your account, view the order using the
															'Complete Orders' link under the My Account menu and
															click the Return Item(s) button. We'll notify you via
															e-mail of your refund once we've received and processed
															the returned item.</p>
														<br>
														<h5>Shipping</h5>
														<p>We can ship to virtually any address in the world.
															Note that there are restrictions on some products, and
															some products cannot be shipped to international
															destinations.When you place an order, we will estimate
															shipping and delivery dates for you based on the
															availability of your items and the shipping options you
															choose. Depending on the shipping provider you choose,
															shipping date estimates may appear on the shipping quotes
															page.Please also note that the shipping rates for many
															items we sell are weight-based. The weight of any such
															item can be found on its detail page. To reflect the
															policies of the shipping companies we use, all weights
															will be rounded up to the next full pound.</p>
													</div>
													<div id="pop-three" style="display: none;">
														<img src="assets/images/size_chart_image.jpg" alt="">
													</div>
												</div>
											</div>
										</div>
										<div id="shopify-product-reviews" data-id="1293236931">
											<style scoped="">
												.spr-container {
													padding: 24px;
													border-color: #ECECEC;
												}
												
												.spr-review, .spr-form {
													border-color: #ECECEC;
												}
												
												.reviewimg{
													width: 150px;
												}
											</style>
											<div class="spr-container">
												<div class="spr-header">
													<h2 class="spr-header-title">Customer Reviews</h2> 	
														<span class="spr-summary-actions"> <a href="#"
															class="spr-summary-actions-newreview"
															onclick="SPR.toggleForm(1293236931);return false">Write
																a review</a>
														</span>
												</div>
											</div>
											<c:forEach items="${reviewlist}" var="review" varStatus="status">
												<div class="spr-container">
													<div class="spr-header">		
														<!-- ${pageContext.servletContext.contextPath } -->
														<div class="row">
															<div class="col col-lg-4" >
																<img class = "reviewimg" src="${review.filePath}"/>
															</div>
															<div class="col col-lg-12">
																<div class="spr-summary" itemscope=""
																	itemtype="http://data-vocabulary.org/Review-aggregate">
																	<meta itemprop="itemreviewed"
																		content="Donec aliquam ante non">
																	<meta itemprop="votes" content="1">
																	${review.contents}
																</div>
															</div>
															<div class="col col-lg-8" >
																<span class="spr-summary-caption"> <span
																	class="spr-summary-actions-togglereviews"><small><strong>${review.writer}</strong></small>
																</span> 
																</span>
																<span class="spr-review-header-byline">
																		<small><strong>${review.regdate}</strong></small>
																</span>
															</div>
														</div>
													</div>
												</div>
											</c:forEach>
												<!-- <div class="spr-content">
													<div class="spr-form" id="form_1293236931"
														style="display: none">
															<h3 class="spr-form-title">Write a review</h3>
													</div>
													
													<div class="spr-header">
													
														
														<div class="spr-header">
															<h2 class="spr-header-title">리뷰 title</h2>
															<div class="spr-summary" itemscope="" itemtype="http://data-vocabulary.org/Review-aggregate">
															
															</div>
														</div>
														<div class="spr-review" id="spr-review-906174">
															<div class="spr-review-header">
																<h3 class="spr-review-header-title">리뷰 title</h3>
																<span class="spr-review-header-byline"><strong>사용자 id</strong>
																	on <strong>리뷰 등록일</strong></span>
															</div>
															<div class="spr-review-content">
																<p class="spr-review-content-body">리뷰내용</p>
															</div>
															<div class="spr-review-footer">
																<a href="#" class="spr-review-reportreview"
																	onclick="SPR.reportReview(906174);return false"
																	id="report_906174"
																	data-msg="This review has been reported">Report as
																	Inappropriate</a>
															</div>
														</div>
													</div>
												</div> -->
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- footer -->
					<jsp:include page="../include/footer.jsp" />
					<!-- end of footer -->
</body>