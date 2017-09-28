<%@ page contentType="text/html; charset=utf-8"%>
<!doctype html>
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"> <!--<![endif]-->

<!-- Mirrored from demo.designshopify.com/html_jewelry/login.html by HTTrack Website Copier/3.x [XR&CO'2014], Thu, 21 Sep 2017 08:51:04 GMT -->
<!-- Added by HTTrack --><meta http-equiv="content-type" content="text/html;charset=UTF-8" /><!-- /Added by HTTrack -->
<head>
  <meta charset="UTF-8">
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />
  <link rel="canonical" href="http://demo.designshopify.com/" />
  <meta name="description" content="" />
  <title>Login Page</title>
  
    <link href="assets/stylesheets/font.css" rel='stylesheet' type='text/css'>
   
	<link href="assets/stylesheets/font-awesome.min.css" rel="stylesheet" type="text/css" media="all"> 	
	<link href="assets/stylesheets/bootstrap.min.3x.css" rel="stylesheet" type="text/css" media="all">
	<link href="assets/stylesheets/cs.bootstrap.3x.css" rel="stylesheet" type="text/css" media="all">
	<link href="assets/stylesheets/cs.animate.css" rel="stylesheet" type="text/css" media="all">
	<link href="assets/stylesheets/cs.global.css" rel="stylesheet" type="text/css" media="all">
	<link href="assets/stylesheets/cs.style.css" rel="stylesheet" type="text/css" media="all">
	<link href="assets/stylesheets/cs.media.3x.css" rel="stylesheet" type="text/css" media="all">
	
	<script src="assets/javascripts/jquery-1.9.1.min.js" type="text/javascript"></script>
	<script src="assets/javascripts/bootstrap.min.3x.js" type="text/javascript"></script>
  
  <style type="text/css">
  .alert-danger {
    width: 87%; 
  }
  </style>
</head>

<body itemscope="" itemtype="http://schema.org/WebPage" class="templateCustomersRegister notouch">
  
	<!-- Header -->
  <jsp:include page="include/header.jsp"/>
    <!-- Header End -->
  
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
								<span class="page-title">Login</span>
							</div>
						</div>
					</div>
				</div>              
				<section class="content">
					<div class="container">
						<div class="row">
							<div id="page-header" class="col-md-24">
								<h1 id="page-title">Login</h1> 
							</div>
							<div id="col-main" class="col-md-24 register-page clearfix">
								<div class="row checkout-form">
									<div class="col-md-12 row-left">
										<!-- Customer Account Login -->
										<div id="customer-login">
											<div class="checkout-title">
												<span class="general-title">회원 로그인</span> 
											</div>
											<form method="post" action="http://demo.designshopify.com/html_jewelry/login.html" id="customer_login" accept-charset="UTF-8">
												<input type="hidden" value="customer_login" name="form_type"><input type="hidden" name="utf8" value="✓">
												<div class="col-md-21 login-alert">
													<div class="alert alert-danger">
														<button type="button" class="close btooltip" data-toggle="tooltip" data-placement="top" title="" data-dismiss="alert" data-original-title="Close">x</button>
														<div class="errors">
															<ul>
																<li>존재하지 않음</li>
															</ul>
														</div>
													</div>
												</div>
												<ul id="login-form" class="list-unstyled">
													<li class="clearfix"></li>
													<li id="login_email" class="col-md-21">
													<label class="control-label" for="customer_email">아이디(이메일) <span class="req">*</span></label>
													<input type="email" value="" name="customer[email]" id="customer_email" class="form-control">
													</li>
													<li class="clearfix"></li>
													<li id="login_password" class="col-md-21">
													<label class="control-label" for="customer_password">비밀번호 <span class="req">*</span></label>
													<input type="password" value="" name="customer[password]" id="customer_password" class="form-control password">
													</li>
													<li class="col-md-21 unpadding-top">
													<ul class="login-wrapper list-unstyled">
														<li>
														<button class="btn" type="submit">로그인</button>
                                                        <button class="btn" type="submit">회원 가입</button>
														</li>
                                                        <li>
                                                        <a class="action" href="javascript:;" onclick="showRecoverPasswordForm()">아이디/비밀번호 찾기</a>
                                                        &nbsp;&nbsp;&nbsp; or &nbsp;&nbsp;&nbsp; <a class="return" href="index-2.html">홈으로</a>
                                                        </li>
													</ul>
													</li>
												</ul>
											</form>
										</div>
                    
										<!-- Password Recovery -->
										<div id="recover-password" style="display: none;">
											<div class="checkout-title">
												<span class="general-title">Reset Password</span>
												<span class="line"></span>
											</div>
											<p class="note">
												We will send you an email to reset your password.
											</p>
											<form method="post" action="http://demo.designshopify.com/account/recover" accept-charset="UTF-8">
												<input type="hidden" value="recover_customer_password" name="form_type"><input type="hidden" name="utf8" value="✓">
												<ul id="recover-form" class="list-unstyled clearfix">
													<li class="clearfix"></li>
													<li id="recover_email" class="col-md-21">
													<label class="control-label">Email Address <span class="req">*</span></label>
													<input type="email" value="" name="email" id="recover-email" class="form-control">
													</li>
													<li class="col-md-21 unpadding-top">
													<ul class="login-wrapper list-unstyled">
														<li>
														<a class="action" href="javascript:;" onclick="hideRecoverPasswordForm()">Return to login?</a>
														or <a class="return" href="index-2.html">Return to store</a>
														</li>
														<li>
														<button class="btn btn-1" type="submit">Submit</button>
														</li>
													</ul>
													</li>
												</ul>
											</form>
										</div>
									</div>
                    <div class="col-md-12 row-right">
                    <!-- Customer Account Login -->
                    <div id="customer-login">
                      <div class="checkout-title">
                        <span class="general-title">비회원</span>
                      </div>
                      <form method="post" action="http://demo.designshopify.com/html_jewelry/login.html" id="customer_login" accept-charset="UTF-8">
                        <input type="hidden" value="customer_login" name="form_type"><input type="hidden" name="utf8" value="✓">
                        <div class="col-md-21 login-alert">
                          <div class="alert alert-danger">
                            <button type="button" class="close btooltip" data-toggle="tooltip" data-placement="top" title="" data-dismiss="alert" data-original-title="Close">x</button>
                            <div class="errors">
                              <ul>
                                <li>Invalid login credentials.</li>
                              </ul>
                            </div>
                          </div>
                        </div>
                        <ul id="login-form" class="list-unstyled">
                          <li class="clearfix"></li>
                          <li id="login_email" class="col-md-21">
                          <label class="control-label" for="customer_email">주문번호<span class="req">*</span></label>
                          <input type="email" value="" name="customer[email]" id="customer_email" class="form-control">
                          </li>
                          <li class="col-md-21 unpadding-top">
                          <ul class="login-wrapper list-unstyled">
                            <li>
                            <button class="btn" type="submit">주문내역 조회하기</button>
                            </li> 
                          </ul>
                          </li>
                        </ul>
                      </form>
                    </div>
                    
                    <!-- Password Recovery -->
                    <div id="recover-password" style="display: none;">
                      <div class="checkout-title">
                        <span class="general-title">Reset Password</span>
                        <span class="line"></span>
                      </div>
                      <p class="note">
                        We will send you an email to reset your password.
                      </p>
                      <form method="post" action="http://demo.designshopify.com/account/recover" accept-charset="UTF-8">
                        <input type="hidden" value="recover_customer_password" name="form_type"><input type="hidden" name="utf8" value="✓">
                        <ul id="recover-form" class="list-unstyled clearfix">
                          <li class="clearfix"></li>
                          <li id="recover_email" class="col-md-21">
                          <label class="control-label">Email Address <span class="req">*</span></label>
                          <input type="email" value="" name="email" id="recover-email" class="form-control">
                          </li>
                          <li class="col-md-21 unpadding-top">
                          <ul class="login-wrapper list-unstyled">
                            <li>
                            <a class="action" href="javascript:;" onclick="hideRecoverPasswordForm()">Return to login?</a>
                            or <a class="return" href="index-2.html">Return to store</a>
                            </li>
                            <li>
                            <button class="btn btn-1" type="submit">Submit</button>
                            </li>
                          </ul>
                          </li>
                        </ul>
                      </form>
                    </div>
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
</body>