<%@ page contentType="text/html; charset=utf-8"%>
<!doctype html>
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"> <!--<![endif]-->

<!-- Mirrored from demo.designshopify.com/html_jewelry/register.html by HTTrack Website Copier/3.x [XR&CO'2014], Thu, 21 Sep 2017 08:51:04 GMT -->
<!-- Added by HTTrack --><meta http-equiv="content-type" content="text/html;charset=UTF-8" /><!-- /Added by HTTrack -->
<head>
  <meta charset="UTF-8">
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />
  <link rel="canonical" href="http://demo.designshopify.com/" />
  <meta name="description" content="" />
  <title>Register</title>
  
    <link href="../assets/stylesheets/font.css" rel='stylesheet' type='text/css'>
  
	<link href="../assets/stylesheets/font-awesome.min.css" rel="stylesheet" type="text/css" media="all"> 	
	<link href="../assets/stylesheets/bootstrap.min.3x.css" rel="stylesheet" type="text/css" media="all">
	<link href="../assets/stylesheets/cs.bootstrap.3x.css" rel="stylesheet" type="text/css" media="all">
	<link href="../assets/stylesheets/cs.animate.css" rel="stylesheet" type="text/css" media="all">
	<link href="../assets/stylesheets/cs.global.css" rel="stylesheet" type="text/css" media="all">
	<link href="../assets/stylesheets/cs.style.css" rel="stylesheet" type="text/css" media="all">
	<link href="../assets/stylesheets/cs.media.3x.css" rel="stylesheet" type="text/css" media="all">
	<link href="../assets/stylesheets/acc_close.css" rel="stylesheet" type="text/css" media="all">
	<link href="../assets/stylesheets/cms_div.css" rel="stylesheet" type="text/css" media="all">
	
	<script src="../assets/javascripts/jquery-1.9.1.min.js" type="text/javascript"></script>
	<script src="../assets/javascripts/bootstrap.min.3x.js" type="text/javascript"></script>
    <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	<script src="../assets/javascripts/postcode.js" type="text/javascript"></script>
    
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
								<a href="index-2.html" class="homepage-link" title="Back to the frontpage">Home</a>
								<span>/</span>
								<span class="page-title">Register</span>
							</div>
						</div>
					</div>
				</div>              
				<section class="content">
					<div class="container">
						<div class="row">
							<div id="page-header" class="col-md-24">
								<h1 id="page-title">회원 가입</h1> 
							</div>
							<div id="col-main" class="col-md-24 register-page clearfix">
								<form method="post" action="/user/register_action.joya" id="create_customer" accept-charset="UTF-8">
									<input value="create_customer" name="form_type" type="hidden"><input name="utf8" value="✓" type="hidden">
									<div id="register-form" class="row list-unstyled">
                                      <div class="half-ms-div">
  										<label class="control-label" for="last_name">아이디<span class="req">*</span></label>
  										<input name="email" id="last_name" class="form-control " type="text">
                                       </div>
                                       <div class="half-ms-div">
                                        <label class="control-label" for="password">이름<span class="req">*</span></label>
                                        <input value="" name="name" id="password" class="form-control password" type="text">
                                       </div>
                                       <div class="half-ms-div">
  										<label class="control-label" for="password">비밀번호<span class="req">*</span></label>
                                        <input value="" name="passwd" id="password" class="form-control password" type="password">
                                       </div>
                                       <div class="half-ms-div">
                                        <label class="control-label" for="password">비밀번호 확인<span class="req">*</span></label>
                                        <input value="" name="passwd2" id="password" class="form-control password" type="password">
                                       </div>
                                       <div class="half-ms-div"> 
  										<label class="control-label" for="email">전화번호<span class="req">*</span></label>
  										<input name="phone" id="email" class="form-control " type="text">
                                       </div>
                                       <div class="half-ms-div">
                                        <label class="control-label" for="password">생년월일<span class="req">*</span></label>
                                        <input value="" name="birthdate" id="password" class="form-control password" type="text">
                                        </div>
                                        <div class="ms_div">
                                        <label class="control-label" for="password">주소<span class="req">*</span></label>
                                        <input name="address1" type="text" id="sample6_postcode" class="postcode form-control" placeholder="우편번호">
                                        <input id="postalbtn" type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기">
                                        <input name="address2" type="text" id="sample6_address" class="address1 form-control" placeholder="주소">
                                        <input name="address3" type="text" id="sample6_address2" class="address2 form-control" placeholder="상세주소">
                                        </div>
                                        <button id="acc-close" class="btn" type="reset">취소</button>
                                        <button class="btn" type="submit">가입</button>
									</div>
								</form>
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