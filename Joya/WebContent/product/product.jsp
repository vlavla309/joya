<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />
  <link rel="canonical" href="http://demo.designshopify.com/" />
  <meta name="description" content="" />
  <title>Product Full Width</title>
  
    	<link href="../assets/stylesheets/font.css" rel='stylesheet' type='text/css'>
	<link href="../assets/stylesheets/font-awesome.min.css" rel="stylesheet" type="text/css" media="all"> 
	<link href="../assets/stylesheets/jquery.camera.css" rel="stylesheet" type="text/css" media="all">
	<link href="../assets/stylesheets/jquery.fancybox-buttons.css" rel="stylesheet" type="text/css" media="all">
	<link href="../assets/stylesheets/cs.animate.css" rel="stylesheet" type="text/css" media="all">
	<link href="../assets/stylesheets/application.css" rel="stylesheet" type="text/css" media="all">
	<link href="../assets/stylesheets/swatch.css" rel="stylesheet" type="text/css" media="all">
	<link href="../assets/stylesheets/jquery.owl.carousel.css" rel="stylesheet" type="text/css" media="all">
	<link href="../assets/stylesheets/jquery.bxslider.css" rel="stylesheet" type="text/css" media="all">
	<link href="../assets/stylesheets/bootstrap.min.3x.css" rel="stylesheet" type="text/css" media="all">
	<link href="../assets/stylesheets/cs.bootstrap.3x.css" rel="stylesheet" type="text/css" media="all">
	<link href="../assets/stylesheets/cs.global.css" rel="stylesheet" type="text/css" media="all">
	<link href="../assets/stylesheets/cs.style.css" rel="stylesheet" type="text/css" media="all">
	<link href="../assets/stylesheets/cs.media.3x.css" rel="stylesheet" type="text/css" media="all">
	<link href="../assets/stylesheets/spr.css" rel="stylesheet" type="text/css" media="all">
	<link href="../assets/stylesheets/addthis.css" rel="stylesheet" type="text/css" media="all">
	<script src="../assets/javascripts/jquery-1.9.1.min.js" type="text/javascript"></script>
	<script src="../assets/javascripts/jquery.imagesloaded.min.js" type="text/javascript"></script>
	<script src="../assets/javascripts/bootstrap.min.3x.js" type="text/javascript"></script>
	<script src="../assets/javascripts/jquery.easing.1.3.js" type="text/javascript"></script>
	<script src="../assets/javascripts/jquery.camera.min.js" type="text/javascript"></script>
	<script src="../assets/javascripts/jquery.mobile.customized.min.js" type="text/javascript"></script>
	<script src="../assets/javascripts/cookies.js" type="text/javascript"></script>
	<script src="../assets/javascripts/modernizr.js" type="text/javascript"></script>  
	<script src="../assets/javascripts/application.js" type="text/javascript"></script>
	<script src="../assets/javascripts/jquery.owl.carousel.min.js" type="text/javascript"></script>
	<script src="../assets/javascripts/jquery.bxslider.js" type="text/javascript"></script>
	<script src="../assets/javascripts/skrollr.min.js" type="text/javascript"></script>
	<script src="../assets/javascripts/jquery.fancybox-buttons.js" type="text/javascript"></script>
	<script src="../assets/javascripts/jquery.zoom.js" type="text/javascript"></script>	
	<script src="../assets/javascripts/cs.script.js" type="text/javascript"></script>
</head>

<body style="height: 2671px;" itemscope="" itemtype="http://schema.org/WebPage" class="templateProduct notouch">
  
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
								<a href="index-2.html" class="homepage-link" title="Back to the frontpage">Home</a>
								<span>/</span>
								<a href="collection.html" title="">Bracelets</a>
								<span>/</span>
								<span class="page-title">${product.productName}</span>
							</div>
						</div>
					</div>
				</div>         
				<section class="content">
					<div class="container">
						<div class="row">              
							<div id="col-main" class="product-page col-xs-24 col-sm-24 ">
								<div itemscope="" itemtype="http://schema.org/Product">
									<meta itemprop="url" content="/products/donec-condime-fermentum">
									<div id="product" class="content clearfix">      
										<h1 id="page-title" class="text-center">
											<span itemprop="name">${product.productName}</span>
										</h1>
										
										<div id="product-image" class="product-image row ">     
											<div id="detail-left-column" class="hidden-xs left-coloum col-sm-6 col-sm-6 fadeInRight not-animated" data-animate="fadeInRight">
												<div id="gallery_main" class="product-image-thumb thumbs full_width ">
													<ul class="slide-product-image">		
														<c:forEach items="${imglist}" var="img" varStatus="status">									
															<c:choose>
																<c:when test="${status.first}">
																	<li class="image">
																		<a href="${img.path}${img.imageName}" class="cloud-zoom-gallery active">
																			<img src="${img.path}${img.imageName}" alt="slide1">
																		</a>
																	</li>
																</c:when>
																<c:otherwise>
																	<li class="image">
																		<a href="${img.path}${img.imageName}" class="cloud-zoom-gallery">
																			<img src="${img.path}${img.imageName}" alt="slide2">
																		</a>
																	</li>
																</c:otherwise>
															</c:choose>
														</c:forEach>
													</ul>
												</div>
											</div>      
											<!--  누르면 보여져야하는 이미지... main image -->
											<div class="image featured col-smd-12 col-sm-12 fadeInUp not-animated" data-animate="fadeInUp"> 
												<c:forEach items="${imglist}" var="img" varStatus="status">
													<c:if test="${status.first}">
														<img src="${img.path}${img.imageName}" alt="main image1">
													</c:if>
												</c:forEach>
											</div>
											<!-- slide-product-image과 갯수가 비슷해야함 main mobile -->
											<div id="gallery_main_mobile" class="visible-xs product-image-thumb thumbs mobile_full_width ">
												<ul style="opacity: 0; display: block;" class="slide-product-image owl-carousel owl-theme">
													<c:forEach items="${imglist}" var="img" varStatus="status">									
														<c:choose>
															<c:when test="${status.first}">
																<li class="image">
																	<a href="${img.path}${img.imageName}" class="cloud-zoom-gallery active">
																		<img src="${img.path}${img.imageName}" alt="slide1">
																	</a>
																</li>
															</c:when>
															<c:otherwise>
																<li class="image">
																	<a href="${img.path}${img.imageName}" class="cloud-zoom-gallery">
																		<img src="${img.path}${img.imageName}" alt="slide2">
																	</a>
																</li>
															</c:otherwise>
														</c:choose>
													</c:forEach>
												</ul>
											</div>
										
											<div id="detail-right-column" class="right-coloum col-sm-6 fadeInLeft not-animated" data-animate="fadeInLeft">
												<div class="addthis_sharing_toolbox" data-url="#" data-title="Donec aliquam ante non | Jewelry - HTML Template">
													<div id="atstbx" class="at-share-tbx-element addthis_32x32_style addthis-smartlayers addthis-animated at4-show">
														<a class="at-share-btn at-svc-facebook"><span class="at4-icon aticon-facebook" title="Facebook"></span></a><a class="at-share-btn at-svc-twitter"><span class="at4-icon aticon-twitter" title="Twitter"></span></a><a class="at-share-btn at-svc-email"><span class="at4-icon aticon-email" title="Email"></span></a><a class="at-share-btn at-svc-print"><span class="at4-icon aticon-print" title="Print"></span></a><a class="at-share-btn at-svc-compact"><span class="at4-icon aticon-compact" title="More"></span></a>
													</div>
												</div>
											</div>      
										</div>
										<div id="product-information" class="product-information row text-center ">        
											<div id="product-header" class="clearfix">
												<div id="product-info-left">
													<div class="description">
														<span>Product Descriptions</span>
														<p>
															${product.productDesc}
														</p>
													</div>
													<div class="relative">
														<ul class="list-unstyled">
															<li class="tags">
															<span>Tags :</span>
															<a href="#">
															above-200<span>,</span>
															</a>
															<a href="#">
															black<span>,</span>
															</a>
															<a href="#">
															l<span>,</span>
															</a>
															<a href="#">
															sale-off </a>
															</li>
														</ul>
													</div>
												</div>          
												<div id="product-info-right">     
													<div itemprop="offers" itemscope="" itemtype="http://schema.org/Offer" class="col-sm-24 group-variants">
														<meta itemprop="priceCurrency" content="USD">              
														<link itemprop="availability" href="http://schema.org/InStock">
														<form action="http://demo.designshopify.com/html_jewelry/cart.html" method="post" class="variants" id="product-actions">
															<div id="product-actions-1293235843" class="options clearfix">
																<style scoped>
																  label[for="product-select-option-0"] { display: none; }
																  #product-select-option-0 { display: none; }
																  #product-select-option-0 + .custom-style-select-box { display: none !important; }
																</style>																
																<div class="quantity-wrapper clearfix">
																	<label class="wrapper-title">Quantity</label>
																	<div class="wrapper">
																		<input id="quantity" name="quantity" value="1" maxlength="5" size="5" class="item-quantity" type="text">
																		<span class="qty-group">
																		<span class="qty-wrapper">
																		<span data-original-title="Increase" class="qty-up btooltip" data-toggle="tooltip" data-placement="top" title="" data-src="#quantity">
																		<i class="fa fa-caret-right"></i>
																		</span>
																		<span data-original-title="Decrease" class="qty-down btooltip" data-toggle="tooltip" data-placement="top" title="" data-src="#quantity">
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
																	<button id="add-to-cart" class="btn btn-1 add-to-cart" data-parent=".product-information" type="submit" name="add">Add to Cart</button>
																</div>
															</div>
														</form>
														<div class="wls">
															<a class="wish-list" href="${pageContext.servletContext.contextPath}/mypage/wishlistcreate.joya?productId=${product.productId}"><i class="fa fa-heart"></i> Wish list
															</a>
															<span>|</span>
															<a href="mailto:info@yourdomain.com"><i class="fa fa-envelope"></i> SEND EMAIL</a>
														</div>                                          
													</div>                        
													<ul id="tabs_detail" class="tabs-panel-detail hidden-xs hidden-sm">
														<li class="first">
															<h5><a href="#pop-one" class="fancybox">Measurements &amp; Specs</a></h5>
														</li>
														<li>
															<h5><a href="#pop-two" class="fancybox">Shipping &amp; Returns</a></h5>
														</li>
														<li>
															<h5><a href="#pop-three" class="fancybox">Size Charts</a></h5>
														</li>
													</ul>             
													<div id="pop-one" style="display: none;">
														<img src="assets/images/mspecs_image.jpg" alt="">
													</div>
													<div id="pop-two" style="display: none;">
														<h5>Returns Policy</h5>
														<p>
															You may return most new, unopened items within 30 days of delivery for a full refund. We'll also pay the return shipping costs if the return is a result of our error (you received an incorrect or defective item, etc.).You should expect to receive your refund within four weeks of giving your package to the return shipper, however, in many cases you will receive a refund more quickly. This time period includes the transit time for us to receive your return from the shipper (5 to 10 business days), the time it takes us to process your return once we receive it (3 to 5 business days), and the time it takes your bank to process our refund request (5 to 10 business days).If you need to return an item, simply login to your account, view the order using the 'Complete Orders' link under the My Account menu and click the Return Item(s) button. We'll notify you via e-mail of your refund once we've received and processed the returned item.
														</p>
														<br>
														<h5>Shipping</h5>
														<p>
															We can ship to virtually any address in the world. Note that there are restrictions on some products, and some products cannot be shipped to international destinations.When you place an order, we will estimate shipping and delivery dates for you based on the availability of your items and the shipping options you choose. Depending on the shipping provider you choose, shipping date estimates may appear on the shipping quotes page.Please also note that the shipping rates for many items we sell are weight-based. The weight of any such item can be found on its detail page. To reflect the policies of the shipping companies we use, all weights will be rounded up to the next full pound.
														</p>
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
													</style>
													<div class="spr-container">
														<div class="spr-header">
															<h2 class="spr-header-title">Customer Reviews</h2>
															<div class="spr-summary" itemscope="" itemtype="http://data-vocabulary.org/Review-aggregate">
																<meta itemprop="itemreviewed" content="Donec aliquam ante non">
																<meta itemprop="votes" content="1">
																<span itemprop="rating" itemscope="" itemtype="http://data-vocabulary.org/Rating" class="spr-starrating spr-summary-starrating">
																<meta itemprop="average" content="4.0">
																<meta itemprop="best" content="5">
																<meta itemprop="worst" content="1">
																<i class="spr-icon spr-icon-star" style=""></i><i class="spr-icon spr-icon-star" style=""></i><i class="spr-icon spr-icon-star" style=""></i><i class="spr-icon spr-icon-star" style=""></i><i class="spr-icon spr-icon-star-empty" style=""></i>
																</span>
																<span class="spr-summary-caption">
																<span class="spr-summary-actions-togglereviews">Based on 1 review</span>
																</span>
																<span class="spr-summary-actions">
																<a href="#" class="spr-summary-actions-newreview" onclick="SPR.toggleForm(1293236931);return false">Write a review</a>
																</span>
															</div>
														</div>
														<div class="spr-content">
															<div class="spr-form" id="form_1293236931" style="display: none">
																<form method="post" action="#" id="new-review-form_1293236931" class="new-review-form">
																	<input type="hidden" name="review[rating]"><input type="hidden" name="product_id" value="1293236931">
																	<h3 class="spr-form-title">Write a review</h3>
																	<fieldset class="spr-form-contact">
																		<div class="spr-form-contact-name">
																			<label class="spr-form-label" for="review_author_1293236931">Name</label>
																			<input class="spr-form-input spr-form-input-text " id="review_author_1293236931" type="text" name="review[author]" value="" placeholder="Enter your name">
																		</div>
																		<div class="spr-form-contact-email">
																			<label class="spr-form-label" for="review_email_1293236931">Email</label>
																			<input class="spr-form-input spr-form-input-email " id="review_email_1293236931" type="email" name="review[email]" value="" placeholder="john.smith@example.com">
																		</div>
																	</fieldset>
																	<fieldset class="spr-form-review">
																		<div class="spr-form-review-rating">
																			<label class="spr-form-label">Rating</label>
																			<div class="spr-form-input spr-starrating ">
																				<a href="#" onclick="SPR.setRating(this);return false;" class="spr-icon spr-icon-star spr-icon-star-empty" data-value="1">&nbsp;</a>
																				<a href="#" onclick="SPR.setRating(this);return false;" class="spr-icon spr-icon-star spr-icon-star-empty" data-value="2">&nbsp;</a>
																				<a href="#" onclick="SPR.setRating(this);return false;" class="spr-icon spr-icon-star spr-icon-star-empty" data-value="3">&nbsp;</a>
																				<a href="#" onclick="SPR.setRating(this);return false;" class="spr-icon spr-icon-star spr-icon-star-empty" data-value="4">&nbsp;</a>
																				<a href="#" onclick="SPR.setRating(this);return false;" class="spr-icon spr-icon-star spr-icon-star-empty" data-value="5">&nbsp;</a>
																			</div>
																		</div>
																		<div class="spr-form-review-title">
																			<label class="spr-form-label" for="review_title_1293236931">Review Title</label>
																			<input class="spr-form-input spr-form-input-text " id="review_title_1293236931" type="text" name="review[title]" value="" placeholder="Give your review a title">
																		</div>
																		<div class="spr-form-review-body">
																			<label class="spr-form-label" for="review_body_1293236931">Body of Review <span class="spr-form-review-body-charactersremaining">(1500)</span></label>
																			<div class="spr-form-input">
																				<textarea class="spr-form-input spr-form-input-textarea " id="review_body_1293236931" data-product-id="1293236931" name="review[body]" rows="10" placeholder="Write your comments here"></textarea>																				
																			</div>
																		</div>
																	</fieldset>
																	<fieldset class="spr-form-actions">
																		<input type="submit" class="spr-button spr-button-primary button button-primary btn btn-primary" value="Submit Review">
																	</fieldset>
																</form>
															</div>
															<div class="spr-reviews" id="reviews_1293236931">
																<div class="spr-review" id="spr-review-906174">
																	<div class="spr-review-header">
																		<span class="spr-starratings spr-review-header-starratings"><i class="spr-icon spr-icon-star" style=""></i><i class="spr-icon spr-icon-star" style=""></i><i class="spr-icon spr-icon-star" style=""></i><i class="spr-icon spr-icon-star" style=""></i><i class="spr-icon spr-icon-star-empty" style=""></i></span>
																		<h3 class="spr-review-header-title">test</h3>
																		<span class="spr-review-header-byline"><strong>test</strong> on <strong>Aug 10, 2015</strong></span>
																	</div>
																	<div class="spr-review-content">
																		<p class="spr-review-content-body">
																			test
																		</p>
																	</div>
																	<div class="spr-review-footer">
																		<a href="#" class="spr-review-reportreview" onclick="SPR.reportReview(906174);return false" id="report_906174" data-msg="This review has been reported">Report as Inappropriate</a>
																	</div>
																</div>
															</div>
														</div>
													</div>
										</div>				
									</div>
								</div>         
								<!-- Related Products -->
								<section class="rel-container clearfix">  
									<h6 class="general-title text-left">You may also like the related products</h6>
									<div id="prod-related-wrapper">
										<div class="prod-related clearfix">
											<div class="element no_full_width not-animated" data-animate="bounceIn" data-delay="0">
												<ul class="row-container list-unstyled clearfix">
													<li class="row-left">
													<a href="product.html" class="container_item">
													<img src="assets/images/1_grande.jpg" class="img-responsive" alt="Curabitur cursus dignis">
													<span class="sale_banner">
													<span class="sale_text">Sale</span>
													</span>
													</a>
													<div class="hbw">
														<span class="hoverBorderWrapper"></span>
													</div>
													</li>
													<li class="row-right parent-fly animMix">
													<div class="product-content-left">
														<a class="title-5" href="product.html">Curabitur cursus dignis</a>
														<span class="spr-badge" id="spr_badge_1293238211" data-rating="0.0">
														<span class="spr-starrating spr-badge-starrating"><i class="spr-icon spr-icon-star-empty" style=""></i><i class="spr-icon spr-icon-star-empty" style=""></i><i class="spr-icon spr-icon-star-empty" style=""></i><i class="spr-icon spr-icon-star-empty" style=""></i><i class="spr-icon spr-icon-star-empty" style=""></i></span>
														<span class="spr-badge-caption">
														No reviews </span>
														</span>
													</div>
													<div class="product-content-right">
														<div class="product-price">
															<span class="price_sale">$259.00</span>
															<del class="price_compare"> $300.00</del>
														</div>
													</div>
													<div class="list-mode-description">
														 Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis amet voluptas assumenda est, omnis dolor repellendus quis nostrum. Temporibus autem quibusdam et aut officiis debitis aut rerum dolorem necessitatibus saepe eveniet ut et neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed...
													</div>
													<div class="hover-appear">
														<form action="#" method="post">
															<div class="effect-ajax-cart">
																<input name="quantity" value="1" type="hidden">
																<button class="select-option" type="button" onclick="window.location.href='product.html'"><i class="fa fa-th-list" title="Select Options"></i><span class="list-mode">Select Option</span></button>
															</div>
														</form>
														<div class="product-ajax-qs hidden-xs hidden-sm">
															<div data-handle="curabitur-cursus-dignis" data-target="#quick-shop-modal" class="quick_shop" data-toggle="modal">
																<i class="fa fa-eye" title="Quick view"></i><span class="list-mode">Quick View</span>																	
															</div>
														</div>
														<a class="wish-list" href="account.html" title="wish list"><i class="fa fa-heart"></i><span class="list-mode">Add to Wishlist</span></a>
													</div>
													</li>
												</ul>
											</div>
											<div class="element no_full_width bounceIn not-animated" data-animate="bounceIn" data-delay="200">
												<ul class="row-container list-unstyled clearfix">
													<li class="row-left">
													<a href="product.html" class="container_item">
													<img src="assets/images/2_119a31f2-2054-4483-93a3-841310e6bdfb_grande.jpg" class="img-responsive" alt="Curabitur cursus dignis">
													</a>
													<div class="hbw">
														<span class="hoverBorderWrapper"></span>
													</div>
													</li>
													<li class="row-right parent-fly animMix">
													<div class="product-content-left">
														<a class="title-5" href="product.html">Curabitur cursus dignis</a>
														<span class="spr-badge" id="spr_badge_1293239619" data-rating="0.0">
														<span class="spr-starrating spr-badge-starrating"><i class="spr-icon spr-icon-star-empty" style=""></i><i class="spr-icon spr-icon-star-empty" style=""></i><i class="spr-icon spr-icon-star-empty" style=""></i><i class="spr-icon spr-icon-star-empty" style=""></i><i class="spr-icon spr-icon-star-empty" style=""></i></span>
														<span class="spr-badge-caption">
														No reviews </span>
														</span>
													</div>
													<div class="product-content-right">
														<div class="product-price">
															<span class="price">
															$200.00 </span>
														</div>
													</div>
													<div class="list-mode-description">
														 Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis amet voluptas assumenda est, omnis dolor repellendus quis nostrum. Temporibus autem quibusdam et aut officiis debitis aut rerum dolorem necessitatibus saepe eveniet ut et neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed...
													</div>
													<div class="hover-appear">
														<form action="#" method="post">
															<div class="hide clearfix">
																<select name="id">
																	<option selected="selected" value="5141875779">Default Title</option>
																</select>
															</div>
															<div class="effect-ajax-cart">
																<input name="quantity" value="1" type="hidden">
																<button class="add-to-cart" type="submit" name="add"><i class="fa fa-shopping-cart"></i><span class="list-mode">Add to Cart</span></button>
															</div>
														</form>
														<div class="product-ajax-qs hidden-xs hidden-sm">
															<div data-handle="curabitur-cursus-dignis" data-target="#quick-shop-modal" class="quick_shop" data-toggle="modal">
																<i class="fa fa-eye" title="Quick view"></i><span class="list-mode">Quick View</span>																	
															</div>
														</div>
														<a class="wish-list" href="account.html" title="wish list"><i class="fa fa-heart"></i><span class="list-mode">Add to Wishlist</span></a>
													</div>
													</li>
												</ul>
											</div>											  
											<div class="element no_full_width bounceIn not-animated" data-animate="bounceIn" data-delay="400">
												<ul class="row-container list-unstyled clearfix">
													<li class="row-left">
													<a href="product.html" class="container_item">
													<img src="assets/images/6_03a522d6-f36a-4f59-a815-bbade4d87a6e_grande.jpg" class="img-responsive" alt="Donec aliquam ante non">
													<span class="sale_banner">
													<span class="sale_text">Sale</span>
													</span>
													</a>
													<div class="hbw">
														<span class="hoverBorderWrapper"></span>
													</div>
													</li>
													<li class="row-right parent-fly animMix">
													<div class="product-content-left">
														<a class="title-5" href="product.html">Donec aliquam ante non</a>
														<span class="spr-badge" id="spr_badge_1293236931" data-rating="4.0">
														<span class="spr-starrating spr-badge-starrating"><i class="spr-icon spr-icon-star" style=""></i><i class="spr-icon spr-icon-star" style=""></i><i class="spr-icon spr-icon-star" style=""></i><i class="spr-icon spr-icon-star" style=""></i><i class="spr-icon spr-icon-star-empty" style=""></i></span>
														<span class="spr-badge-caption">
														1 review </span>
														</span>
													</div>
													<div class="product-content-right">
														<div class="product-price">
															<span class="price_sale">$250.00</span>
															<del class="price_compare"> $300.00</del>
														</div>
													</div>
													<div class="list-mode-description">
														 Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis amet voluptas assumenda est, omnis dolor repellendus quis nostrum. Temporibus autem quibusdam et aut officiis debitis aut rerum dolorem necessitatibus saepe eveniet ut et neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed...
													</div>
													<div class="hover-appear">
														<form action="#" method="post">
															<div class="effect-ajax-cart">
																<input name="quantity" value="1" type="hidden">
																<button class="select-option" type="button" onclick="window.location.href='product.html'"><i class="fa fa-th-list" title="Select Options"></i><span class="list-mode">Select Option</span></button>
															</div>
														</form>
														<div class="product-ajax-qs hidden-xs hidden-sm">
															<div data-handle="curabitur-cursus-dignis" data-target="#quick-shop-modal" class="quick_shop" data-toggle="modal">
																<i class="fa fa-eye" title="Quick view"></i><span class="list-mode">Quick View</span>																	
															</div>
														</div>
														<a class="wish-list" href="account.html" title="wish list"><i class="fa fa-heart"></i><span class="list-mode">Add to Wishlist</span></a>
													</div>
													</li>
												</ul>
											</div>	  
											<div class="element no_full_width bounceIn not-animated" data-animate="bounceIn" data-delay="600">
												<ul class="row-container list-unstyled clearfix">
													<li class="row-left">
													<a href="product.html" class="container_item">
													<img src="assets/images/4_0fe2529b-f7ae-4ed5-a8ff-4fae623757f9_grande.jpg" class="img-responsive" alt="Donec condime fermentum">
													</a>
													<div class="hbw">
														<span class="hoverBorderWrapper"></span>
													</div>
													</li>
													<li class="row-right parent-fly animMix">
													<div class="product-content-left">
														<a class="title-5" href="product.html">Donec condime fermentum</a>
														<span class="spr-badge" id="spr_badge_1293235843" data-rating="0.0">
														<span class="spr-starrating spr-badge-starrating"><i class="spr-icon spr-icon-star-empty" style=""></i><i class="spr-icon spr-icon-star-empty" style=""></i><i class="spr-icon spr-icon-star-empty" style=""></i><i class="spr-icon spr-icon-star-empty" style=""></i><i class="spr-icon spr-icon-star-empty" style=""></i></span>
														<span class="spr-badge-caption">
														No reviews </span>
														</span>
													</div>
													<div class="product-content-right">
														<div class="product-price">
															<span class="price">
															$200.00 </span>
														</div>
													</div>
													<div class="list-mode-description">
														 Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis amet voluptas assumenda est, omnis dolor repellendus quis nostrum. Temporibus autem quibusdam et aut officiis debitis aut rerum dolorem necessitatibus saepe eveniet ut et neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed...
													</div>
													<div class="hover-appear">
														<form action="#" method="post">
															<div class="effect-ajax-cart">
																<input name="quantity" value="1" type="hidden">
																<button class="select-option" type="button" onclick="window.location.href='product.html'"><i class="fa fa-th-list" title="Select Options"></i><span class="list-mode">Select Option</span></button>
															</div>
														</form>
														<div class="product-ajax-qs hidden-xs hidden-sm">
															<div data-handle="curabitur-cursus-dignis" data-target="#quick-shop-modal" class="quick_shop" data-toggle="modal">
																<i class="fa fa-eye" title="Quick view"></i><span class="list-mode">Quick View</span>																	
															</div>
														</div>
														<a class="wish-list" href="account.html" title="wish list"><i class="fa fa-heart"></i><span class="list-mode">Add to Wishlist</span></a>
													</div>
													</li>
												</ul>
											</div>	  
											<div class="element no_full_width bounceIn not-animated" data-animate="bounceIn" data-delay="800">
												<ul class="row-container list-unstyled clearfix">
													<li class="row-left">
													<a href="product.html" class="container_item">
													<img src="assets/images/10_16854be2-a731-4970-984e-7f6e483d2405_grande.jpg" class="img-responsive" alt="Maximus quam posuere">
													<span class="sale_banner">
													<span class="sale_text">Sale</span>
													</span>
													</a>
													<div class="hbw">
														<span class="hoverBorderWrapper"></span>
													</div>
													</li>
													<li class="row-right parent-fly animMix">
													<div class="product-content-left">
														<a class="title-5" href="product.html">Maximus quam posuere</a>
														<span class="spr-badge" id="spr_badge_1293227907" data-rating="3.0">
														<span class="spr-starrating spr-badge-starrating"><i class="spr-icon spr-icon-star" style=""></i><i class="spr-icon spr-icon-star" style=""></i><i class="spr-icon spr-icon-star" style=""></i><i class="spr-icon spr-icon-star-empty" style=""></i><i class="spr-icon spr-icon-star-empty" style=""></i></span>
														<span class="spr-badge-caption">
														1 review </span>
														</span>
													</div>
													<div class="product-content-right">
														<div class="product-price">
															<span class="price_sale">$200.00</span>
															<del class="price_compare"> $300.00</del>
														</div>
													</div>
													<div class="list-mode-description">
														 Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis amet voluptas assumenda est, omnis dolor repellendus quis nostrum. Temporibus autem quibusdam et aut officiis debitis aut rerum dolorem necessitatibus saepe eveniet ut et neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed...
													</div>
													<div class="hover-appear">
														<form action="#" method="post">
															<div class="effect-ajax-cart">
																<input name="quantity" value="1" type="hidden">
																<button class="select-option" type="button" onclick="window.location.href='product.html'"><i class="fa fa-th-list" title="Select Options"></i><span class="list-mode">Select Option</span></button>
															</div>
														</form>
														<div class="product-ajax-qs hidden-xs hidden-sm">
															<div data-handle="curabitur-cursus-dignis" data-target="#quick-shop-modal" class="quick_shop" data-toggle="modal">
																<i class="fa fa-eye" title="Quick view"></i><span class="list-mode">Quick View</span>																	
															</div>
														</div>
														<a class="wish-list" href="account.html" title="wish list"><i class="fa fa-heart"></i><span class="list-mode">Add to Wishlist</span></a>
													</div>
													</li>
												</ul>
											</div>	  
											<div class="element no_full_width not-animated" data-animate="bounceIn" data-delay="1000">
												<ul class="row-container list-unstyled clearfix">
													<li class="row-left">
													<a href="product.html" class="container_item">
													<img src="assets/images/11_68ab6d0f-109c-429b-a903-4cbf60257806_grande.jpg" class="img-responsive" alt="Product full width">
													<span class="sale_banner">
													<span class="sale_text">Sale</span>
													</span>
													</a>
													<div class="hbw">
														<span class="hoverBorderWrapper"></span>
													</div>
													</li>
													<li class="row-right parent-fly animMix">
													<div class="product-content-left">
														<a class="title-5" href="product.html">Product full width</a>
														<span class="spr-badge" id="spr_badge_1293240771" data-rating="0.0">
														<span class="spr-starrating spr-badge-starrating"><i class="spr-icon spr-icon-star-empty" style=""></i><i class="spr-icon spr-icon-star-empty" style=""></i><i class="spr-icon spr-icon-star-empty" style=""></i><i class="spr-icon spr-icon-star-empty" style=""></i><i class="spr-icon spr-icon-star-empty" style=""></i></span>
														<span class="spr-badge-caption">
														No reviews </span>
														</span>
													</div>
													<div class="product-content-right">
														<div class="product-price">
															<span class="price_sale">$200.00</span>
															<del class="price_compare"> $300.00</del>
														</div>
													</div>
													<div class="list-mode-description">
														 Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis amet voluptas assumenda est, omnis dolor repellendus quis nostrum. Temporibus autem quibusdam et aut officiis debitis aut rerum dolorem necessitatibus saepe eveniet ut et neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed...
													</div>
													<div class="hover-appear">
														<form action="#" method="post">
															<div class="effect-ajax-cart">
																<input name="quantity" value="1" type="hidden">
																<button class="select-option" type="button" onclick="window.location.href='product.html'"><i class="fa fa-th-list" title="Select Options"></i><span class="list-mode">Select Option</span></button>
															</div>
														</form>
														<div class="product-ajax-qs hidden-xs hidden-sm">
															<div data-handle="curabitur-cursus-dignis" data-target="#quick-shop-modal" class="quick_shop" data-toggle="modal">
																<i class="fa fa-eye" title="Quick view"></i><span class="list-mode">Quick View</span>																	
															</div>
														</div>
														<a class="wish-list" href="account.html" title="wish list"><i class="fa fa-heart"></i><span class="list-mode">Add to Wishlist</span></a>
													</div>
													</li>
												</ul>
											</div>
										</div>	
									</div>										
								</section>
							</div>
						</div>
					</div>
				</section>	
			</div>
	    </div>
	</div>  	
	<!-- footer -->
		<jsp:include page="../include/footer.jsp" />
	<!-- end of footer -->
</body>