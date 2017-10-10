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
  <title>My Page</title>
  
    <link href="../assets/stylesheets/font.css" rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
  
	<link href="../assets/stylesheets/font-awesome.min.css" rel="stylesheet" type="text/css" media="all"> 	
	<link href="../assets/stylesheets/bootstrap.min.3x.css" rel="stylesheet" type="text/css" media="all">
	<link href="../assets/stylesheets/cs.bootstrap.3x.css" rel="stylesheet" type="text/css" media="all">
	<link href="../assets/stylesheets/cs.animate.css" rel="stylesheet" type="text/css" media="all">
	<link href="../assets/stylesheets/cs.global.css" rel="stylesheet" type="text/css" media="all">
	<link href="../assets/stylesheets/cs.style.css" rel="stylesheet" type="text/css" media="all">
	<link href="../assets/stylesheets/cs.media.3x.css" rel="stylesheet" type="text/css" media="all">
    <%@ include file="../assets/stylesheets/mimimi.css" %>
	
	<script src="../assets/javascripts/jquery-1.9.1.min.js" type="text/javascript"></script>
	<script src="../assets/javascripts/bootstrap.min.3x.js" type="text/javascript"></script>
    <script src="../assets/javascripts/referer.js" type="text/javascript"></script>
  
     <script type="text/javascript">
            function go2modify(where) {
              var form = document.createElement("form");
              form.setAttribute("action", "/user/mypageaction.joya");
              form.setAttribute("method", "post");
              
              var email = document.createElement("input");
              email.setAttribute("type", "hidden");
              email.setAttribute("name", "email");
              email.setAttribute("value", "${email}");
              
              var referer = document.createElement("input");
              referer.setAttribute("type", "hidden");
              referer.setAttribute("name", "referer");
              referer.setAttribute("value", where);
              
              form.appendChild(email);
              form.appendChild(referer);
              document.body.appendChild(form);
              form.submit();
      }
    </script> 
    
</head>

<body itemscope="" itemtype="http://schema.org/WebPage" class="templateCustomersRegister notouch">
  
	<!-- Header -->
  <jsp:include page="../include/header.jsp"/>
    <!-- Header End -->
  
	<div id="content-wrapper-parent">
		<div id="content-wrapper">  
			<!-- Content -->
			<div id="content" class="clearfix">        
				<div id="breadcrumb" class="breadcrumb">
					<div itemprop="breadcrumb" class="container">
						<div class="row">
							<div class="col-md-24">
								<a href="/index.joya" class="homepage-link" title="Back to the frontpage">Home</a>
								<span>/</span>
								<span class="page-title">My Page</span>
							</div>
						</div>
					</div>
				</div>              
				<section class="content">
					<div class="container">
						<div class="row">
							<div id="page-header" class="col-md-24">
								<h1 id="page-title">My Page</h1> 
							</div>
							<div class="col-sm-6 col-md-6 sidebar">
								<div class="group_sidebar">
									<div class="row sb-wrapper unpadding-top">
										<span class="mini-line"></span>
										<ul id="customer_detail" class="list-unstyled sb-content">
											<li>
											<address class="clearfix">
											<div class="info">
												<i class="fa fa-user"></i>
												<span class="address-group">
												<span class="author">${user.name }</span>
												<span class="email">${user.email }</span>
												</span>
											</div>
											<div class="address">
												<span class="address-group">
												<span class="address1">Point : ${user.point } <span class="phone-number"></span></span>
                                                <span class="address1">Address : ${address1 } ${address2 } ${address3 } <span class="phone-number"></span></span>
												</span>
											</div>
											</address>
											</li>
                                            <li>
                                            
                                            </li>
										</ul>
									</div>
								</div>
							</div>
							<div id="col-main" class="account-page col-sm-18 col-md-18 clearfix">
									<a href="javascript:go2modify('1');">
                                     <div class="orderselect_mimi">
                                      <div class="minimi">
                                      <h1>Order List</h1>
                                      <image src="../assets/images/orderlist_mi.png" align="center" class="mi_order">
                                      </div>
                                    </div>
                                     </a>
                                     <a href="javascript:go2modify('2');">
                                    <div class="orderselect_mimi1">
                                      <div class="minimi">
                                      <h1>User Information</h1>
                                      <image src="../assets/images/userinfo_mi.png" align="center" class="mi_user">
                                      </div>
                                    </div>
                                    </a>
                                    <a href="javascript:go2modify('3');">
                                    <div class="orderselect_mimi2">
                                      <div class="minimi">
                                      <h1>Wish List</h1>
                                      <image src="../assets/images/wishwish.png" align="center" class="mi_wish"></image>
                                      </div>
                                    </div>
                                    </a>
							</div>
						</div>
					</div>
				</section>        
			</div>
		</div>
	</div>
    
	<!-- Footer -->
    <jsp:include page="../include/footer.jsp"/>
    <!-- Footer End -->
    
</body>