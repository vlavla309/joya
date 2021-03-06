<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
  <meta charset="UTF-8">
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />
  <link rel="canonical" href="http://demo.designshopify.com/" />
  <meta name="description" content="" />
  <title>Joya - World Jewelry</title>
  	<!-- favicon -->
  	<link rel="shortcut icon" href="/assets/images/favicon.ico">
  
    <link href="assets/stylesheets/font.css" rel='stylesheet' type='text/css'>
  
	<link href="assets/stylesheets/font-awesome.min.css" rel="stylesheet" type="text/css" media="all"> 
	<link href="assets/stylesheets/jquery.camera.css" rel="stylesheet" type="text/css" media="all">
	<link href="assets/stylesheets/jquery.fancybox-buttons.css" rel="stylesheet" type="text/css" media="all">
	<link href="assets/stylesheets/cs.animate.css" rel="stylesheet" type="text/css" media="all">
	<link href="assets/stylesheets/application.css" rel="stylesheet" type="text/css" media="all">
	<link href="assets/stylesheets/swatch.css" rel="stylesheet" type="text/css" media="all">
	<link href="assets/stylesheets/jquery.owl.carousel.css" rel="stylesheet" type="text/css" media="all">
	<link href="assets/stylesheets/jquery.bxslider.css" rel="stylesheet" type="text/css" media="all">
	<link href="assets/stylesheets/bootstrap.min.3x.css" rel="stylesheet" type="text/css" media="all">
	<link href="assets/stylesheets/cs.bootstrap.3x.css" rel="stylesheet" type="text/css" media="all">
	<link href="assets/stylesheets/cs.global.css" rel="stylesheet" type="text/css" media="all">
	<link href="assets/stylesheets/cs.style.css" rel="stylesheet" type="text/css" media="all">
	<link href="assets/stylesheets/cs.media.3x.css" rel="stylesheet" type="text/css" media="all">
	<link href="assets/stylesheets/button_mypage.css" rel="stylesheet" type="text/css" media="all">
	
	<script src="assets/javascripts/jquery-1.9.1.min.js" type="text/javascript"></script>
	<script src="assets/javascripts/jquery.imagesloaded.min.js" type="text/javascript"></script>
	<script src="assets/javascripts/bootstrap.min.3x.js" type="text/javascript"></script>
	<script src="assets/javascripts/jquery.easing.1.3.js" type="text/javascript"></script>
	<script src="assets/javascripts/jquery.camera.min.js" type="text/javascript"></script>	
	<script src="assets/javascripts/cookies.js" type="text/javascript"></script>
	<script src="assets/javascripts/modernizr.js" type="text/javascript"></script>  
	<script src="assets/javascripts/application.js" type="text/javascript"></script>
	<script src="assets/javascripts/jquery.owl.carousel.min.js" type="text/javascript"></script>
	<script src="assets/javascripts/jquery.bxslider.js" type="text/javascript"></script>
	<script src="assets/javascripts/skrollr.min.js" type="text/javascript"></script>
	<script src="assets/javascripts/jquery.fancybox-buttons.js" type="text/javascript"></script>
	<script src="assets/javascripts/jquery.zoom.js" type="text/javascript"></script>	
	<script src="assets/javascripts/cs.script.js" type="text/javascript"></script>
		<script src="assets/javascripts/cookies.js" type="text/javascript"></script>
	<script src="assets/javascripts/referer.js" type="text/javascript"></script>
	<script src="/assets/javascripts/cart_function.js" type="text/javascript"></script>
    
</head>

<body class="templateIndex notouch">
  
	<!-- Header -->
  <jsp:include page="include/header.jsp"/>
    <!-- Header End -->
  
    <div id="content-wrapper-parent">
        <div id="content-wrapper">  
			<!-- Main Slideshow -->
			<div class="home-slider-wrapper clearfix">
				<div class="camera_wrap" id="home-slider">
					<div data-src="assets/images/slide-image-1.jpg">
						<div class="camera_caption camera_title_1 fadeIn">
						  <a  style="color:#010101;">Live the moment</a>
						</div>
						<div class="camera_caption camera_caption_1 fadeIn" style="color: rgb(1, 1, 1);">
							Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
						</div>
						<div class="camera_caption camera_image-caption_1 moveFromLeft">
							<img src="assets/images/slide-image-caption-1.png" alt="image_caption">
						</div>
						<div class="camera_cta_1">
							<a href="${pageContext.servletContext.contextPath }/product/list.joya" class="btn">See Collection</a>
						</div>
					</div>
					<div data-src="assets/images/slide-image-2.jpg">
						<div class="camera_caption camera_title_2 moveFromLeft">
						  <a href="collection.html" style="color:#666666;">Love’s embrace</a>
						</div>
						<div class="camera_caption camera_image-caption_2 moveFromLeft" style="visibility: hidden;">
							<img src="assets/images/slide-image-caption-2.png" alt="image_caption">
						</div>
					</div>
					<div data-src="assets/images/slide-image-3.jpg">
						<div class="camera_caption camera_image-caption_3 moveFromLeft">
							<img src="assets/images/slide-image-caption-3.png" alt="image_caption">
						</div>
					</div>
				</div>
			</div> 
			<!-- Content -->
			<div id="content" class="clearfix">                       
				<section class="content">  
					<div id="col-main" class="clearfix">
						<div class="home-popular-collections">
							<div class="container">
								<div class="group_home_collections row">
									<div class="col-md-24">
										<div class="home_collections">
											<h6 class="general-title">Popular Collections</h6>
											<div class="home_collections_wrapper">												
												<div id="home_collections">
																<div class="home_collections_item">
																	<div class="home_collections_item_inner">
																		<div class="collection-details">
																			<a href="${pageContext.servletContext.contextPath }/product/list.joya?category=팔찌" title="Browse our Bracelets">
																				<img src="assets/images/3_large.png" alt="Bracelets">
																			</a>
																		</div>
																		<div class="hover-overlay">
																			<span class="col-name"><a href="${pageContext.servletContext.contextPath }/product/list.joya?category=팔찌">팔찌</a></span>
																			<div class="collection-action">
																				<a href="${pageContext.servletContext.contextPath }/product/list.joya?category=팔찌">See the Collection</a>
																			</div>
																		</div>
																	</div>
																</div>
																<div class="home_collections_item">
																	<div class="home_collections_item_inner">
																		<div class="collection-details">
																			<a href="${pageContext.servletContext.contextPath }/product/list.joya?category=귀걸이" title="Browse our Earrings">
																			<img src="assets/images/2_large.png" alt="Earrings">
																			</a>
																		</div>
																		<div class="hover-overlay">
																			<span class="col-name"><a href="${pageContext.servletContext.contextPath }/product/list.joya?category=귀걸이">귀걸이</a></span>
																			<div class="collection-action">
																				<a href="${pageContext.servletContext.contextPath }/product/list.joya?category=귀걸이">See the Collection</a>
																			</div>
																		</div>
																	</div>
																</div>
																<div class="home_collections_item">
																	<div class="home_collections_item_inner">
																		<div class="collection-details">
																			<a href="${pageContext.servletContext.contextPath }/product/list.joya?category=목걸이" title="Browse our Necklaces">
																			<img src="assets/images/1_79ec3305-7c83-4daa-804c-fac19b2d1b7b_large.png" alt="Necklaces">
																			</a>
																		</div>
																		<div class="hover-overlay">
																			<span class="col-name"><a href="${pageContext.servletContext.contextPath }/product/list.joya?category=목걸이">목걸이</a></span>
																			<div class="collection-action">
																				<a href="${pageContext.servletContext.contextPath }/product/list.joya?category=목걸이">See the Collection</a>
																			</div>
																		</div>
																	</div>
																</div>
																<div class="home_collections_item">
																	<div class="home_collections_item_inner">
																		<div class="collection-details">
																			<a href="${pageContext.servletContext.contextPath }/product/list.joya?category=반지" title="Browse our Rings">
																			<img src="assets/images/4_large.png" alt="Rings">
																			</a>
																		</div>
																		<div class="hover-overlay">
																			<span class="col-name"><a href="${pageContext.servletContext.contextPath }/product/list.joya?category=반지">반지</a></span>
																			<div class="collection-action">
																				<a href="${pageContext.servletContext.contextPath }/product/list.joya?category=반지">See the Collection</a>
																			</div>
																		</div>
																	</div>
																</div>
																<div class="home_collections_item">
																	<div class="home_collections_item_inner">
																		<div class="collection-details">
																			<a href="${pageContext.servletContext.contextPath }/product/list.joya?category=시계" title="Browse our Bracelets">
																				<img src="assets/images/3_large.png" alt="Bracelets">
																			</a>
																		</div>
																		<div class="hover-overlay">
																			<span class="col-name"><a href="${pageContext.servletContext.contextPath }/product/list.joya?category=시계">시계</a></span>
																			<div class="collection-action">
																				<a href="collection.html">See the Collection</a>
																			</div>
																		</div>
																	</div>
																</div>
													</div>													
												</div>
											</div>
										</div>
										<script>
										  $(document).ready(function() {
											$('.collection-details').hover(
											  function() {
												$(this).parent().addClass("collection-hovered");
											  },
											  function() {
											  $(this).parent().removeClass("collection-hovered");
											  });
										  });
										</script>
									</div>
								</div>
						</div>
						<div class="home-newproduct">
							<div class="container">
								<div class="group_home_products row">
									<div class="col-md-24">
										<div class="home_products">
											<h6 class="general-title">New Products</h6>
											<div class="home_products_wrapper">
												<div id="home_products">
												
												<!-- 여기서부터 상품 항목 -->
												<c:forEach items="${productlist}" var="product" varStatus="status">
													<div class="element no_full_width col-md-8 col-sm-8 not-animated" data-animate="fadeInUp" data-delay="0">
														<ul class="row-container list-unstyled clearfix">
															<li class="row-left">
															<a href="${pageContext.servletContext.contextPath }/product/view.joya?productid=${product.productId}&type=view" class="container_item">
															<img src="${imgs[product.productId] }" class="img-responsive" alt="${product.productName }">
															</a>
															
															</li>
															<li class="row-right parent-fly animMix">
															<div class="product-content-left">
																<a class="title-5" href="${pageContext.servletContext.contextPath }/product/view.joya?productid=${product.productId}&type=view">${product.productName }</a>
																<span class="spr-badge" id="spr_badge_12932382113" data-rating="0.0">
																<span class="spr-starrating spr-badge-starrating"><i class="spr-icon spr-icon-star-empty" style=""></i><i class="spr-icon spr-icon-star-empty" style=""></i><i class="spr-icon spr-icon-star-empty" style=""></i><i class="spr-icon spr-icon-star-empty" style=""></i><i class="spr-icon spr-icon-star-empty" style=""></i></span>
																<span class="spr-badge-caption">
																No reviews </span>
																</span>
															</div>
															<div class="product-content-right">
																<div class="product-price">
																	<span class="price">&#8361; ${product.price }</span>
																</div>
															</div>
															
															
															</li>
														</ul>
													</div>    
												</c:forEach>	
													<!-- 여기가 상품항목 끝 -->            
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="home-banner-wrapper">
							<div class="container">
								<div id="home-banner" class="text-center clearfix">
									<img class="pulse img-banner-caption" src="assets/images/home_banner_image_text.png" alt="">
									<div class="home-banner-caption">
										<p>
											Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.<br>
											 Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
										</p>
									</div>
									<div class="home-banner-action">
										<a href="${pageContext.servletContext.contextPath }/product/list.joya">Shop Now</a>
									</div>
								</div>
							</div>
						</div>
						
					</div>
				</section>        
			</div>
		</div>
	</div>
	
	<!-- Footer -->
    <jsp:include page="include/footer.jsp"/>
    <!-- Footer End -->
	
	<div class="newsletter-popup" style="display: none;">
		<form action="http://codespot.us5.list-manage.com/subscribe/post?u=ed73bc2d2f8ae97778246702e&amp;id=c63b4d644d" method="post" name="mc-embedded-subscribe-form" target="_blank">
			<h4>-50% Deal</h4>
			<p class="tagline">
				subscribe for newsletter and get the item for 50% off
			</p>
			<div class="group_input">
				<input class="form-control" type="email" name="EMAIL" placeholder="YOUR EMAIL">
				<button class="btn" type="submit"><i class="fa fa-paper-plane"></i></button>
			</div>
		</form>
		<div id="popup-hide">
			<input type="checkbox" id="mc-popup-hide" value="1" checked="checked"><label for="mc-popup-hide">Never show this message again</label>
		</div>
	</div>
	
	<script src="assets/javascripts/cs.global.js" type="text/javascript"></script>
 
	<div id="quick-shop-modal" class="modal in" role="dialog" aria-hidden="false" tabindex="-1" data-width="800">
		<div class="modal-backdrop in" style="height: 742px;">
		</div>
		<div class="modal-dialog rotateInDownLeft animated">
			<div class="modal-content">
				<div class="modal-header">
					<i class="close fa fa-times btooltip" data-toggle="tooltip" data-placement="top" title="" data-dismiss="modal" aria-hidden="true" data-original-title="Close"></i>
				</div>
				<div class="modal-body">
					<div class="quick-shop-modal-bg" style="display: none;">
					</div>
					<div class="row">
						<div class="col-md-12 product-image">
							<div id="quick-shop-image" class="product-image-wrapper">
								<a class="main-image"><img class="img-zoom img-responsive image-fly" src="assets/images/1_grande.jpg" data-zoom-image="./assets/images/1.jpg" alt=""/></a>
								<div id="gallery_main_qs" class="product-image-thumb">
									<a class="image-thumb active" href="assets/1images/.html" data-image="./assets/images/1_grande.jpg" data-zoom-image="assets/images/1.html"><img src="assets/images/1_compact.jpg" alt=""/></a>
									<a class="image-thumb" href="assets/images/2.html" data-image="./assets/images/2_grande.jpg" data-zoom-image="assets/images/2.html"><img src="assets/images/2_compact.jpg" alt=""/></a>
									<a class="image-thumb" href="assets/images/3.html" data-image="./assets/images/3_grande.jpg" data-zoom-image="assets/images/3.html"><img src="assets/images/3_compact.jpg" alt=""/></a>
									<a class="image-thumb" href="assets/images/4.html" data-image="./assets/images/4_grande.jpg" data-zoom-image="assets/images/4.html"><img src="assets/images/4_compact.jpg" alt=""/></a>
									<a class="image-thumb" href="assets/images/5.html" data-image="./assets/images/5_grande.jpg" data-zoom-image="assets/images/5.html"><img src="assets/images/5_compact.jpg" alt=""/></a>
									<a class="image-thumb" href="assets/images/6.html" data-image="./assets/images/6_grande.jpg" data-zoom-image="assets/images/6.html"><img src="assets/images/6_compact.jpg" alt=""/></a>
								</div>	
							</div>
						</div>
						<div class="col-md-12 product-information">
							<h1 id="quick-shop-title"><span> <a href="http://demo.designshopify.com/products/curabitur-cursus-dignis">Curabitur cursus dignis</a></span></h1>
							<div id="quick-shop-infomation" class="description">
								<div id="quick-shop-description" class="text-left">
									<p>
										Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis amet voluptas assumenda est, omnis dolor repellendus quis nostrum.
									</p>
									<p>
										Temporibus autem quibusdam et aut officiis debitis aut rerum dolorem necessitatibus saepe eveniet ut et neque porro quisquam est, qui dolorem ipsum quia dolor s...
									</p>
								</div>
							</div>
							<div id="quick-shop-container">
								<div id="quick-shop-relative" class="relative text-left">
									<ul class="list-unstyled">
										<li class="control-group vendor">
										<span class="control-label">Vendor :</span><a href="http://demo.designshopify.com/collections/vendors?q=Vendor+1"> Vendor 1</a>
										</li>
										<li class="control-group type">
										<span class="control-label">Type :</span><a href="http://demo.designshopify.com/collections/types?q=Sweaters+Wear"> Sweaters Wear</a>
										</li>
									</ul>
								</div>
								<form action="#" method="post" class="variants" id="quick-shop-product-actions" enctype="multipart/form-data">
									<div id="quick-shop-price-container" class="detail-price">
										<span class="price_sale">$259.00</span><span class="dash">/</span><del class="price_compare">$300.00</del>
									</div>
									<div class="quantity-wrapper clearfix">
										<label class="wrapper-title">Quantity</label>
										<div class="wrapper">
											<input type="text" id="qs-quantity" size="5" class="item-quantity" name="quantity" value="1">
											<span class="qty-group">
											<span class="qty-wrapper">
											<span class="qty-up" title="Increase" data-src="#qs-quantity">
											<i class="fa fa-plus"></i>
											</span>
											<span class="qty-down" title="Decrease" data-src="#qs-quantity">
											<i class="fa fa-minus"></i>
											</span>
											</span>
											</span>
										</div>
									</div>
									<div id="quick-shop-variants-container" class="variants-wrapper">
										<div class="selector-wrapper">
											<label for="#quick-shop-variants-1293238211-option-0">Color</label>
											<div class="wrapper">
												<select class="single-option-selector" data-option="option1" id="#quick-shop-variants-1293238211-option-0" style="z-index: 1000; position: absolute; opacity: 0; font-size: 15px;">
													<option value="black">black</option>
													<option value="red">red</option>
													<option value="blue">blue</option>
													<option value="purple">purple</option>
													<option value="green">green</option>
													<option value="white">white</option>
												</select>
												<button type="button" class="custom-style-select-box" style="display: block; overflow: hidden;"><span class="custom-style-select-box-inner" style="width: 264px; display: inline-block;">black</span></button><i class="fa fa-caret-down"></i>
											</div>
										</div>
										<div class="selector-wrapper">
											<label for="#quick-shop-variants-1293238211-option-1">Size</label>
											<div class="wrapper">
												<select class="single-option-selector" data-option="option2" id="#quick-shop-variants-1293238211-option-1" style="z-index: 1000; position: absolute; opacity: 0; font-size: 15px;">
													<option value="small">small</option>
													<option value="medium">medium</option>
													<option value="large">large</option>
												</select>
												<button type="button" class="custom-style-select-box" style="display: block; overflow: hidden;"><span class="custom-style-select-box-inner" style="width: 264px; display: inline-block;">small</span></button><i class="fa fa-caret-down"></i>
											</div>
										</div>
									</div>
									<div class="others-bottom">
										<input id="quick-shop-add" class="btn small add-to-cart" type="submit" name="add" value="Add to Cart" style="opacity: 1;">
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	

	
</body>