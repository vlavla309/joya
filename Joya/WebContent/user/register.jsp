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
    
    <script type="text/javascript">
    
    $(document).ready(function() {
		$("#email").keyup(function() {
			var useremail = $(this).val();
			$.ajax({
				url: "/user/email_action.joya",
				data: {"email" : useremail},
				success: function(data) {
					if ($("#email").val().length == 0) {
						$("#emailmessage").html("");
					} else if (data.trim() != "true") {
						$("#emailmessage").css("color", "blue");
						$("#emailmessage").html("사용 가능한 아이디 입니다.");
						$("#signupup").attr("value", "1");
						setTimeout(function() {
							$("#emailmessage").html("");	
						}, 10000)
					} else {
						$("#emailmessage").css("color", "red");
						$("#emailmessage").html("이미 존재하는 아이디 입니다.");
						$("#signupup").attr("value", "0");
						setTimeout(function() {
							$("#emailmessage").html("");	
						}, 10000)
					}
				}
			});
		});
		
	});
    
	function checkinfo() {
		
		var pw1 = $("#password").val();
		var pw2 = $("#password2").val();
		
		if ($("#signupup").attr("value") == "0") {
			$("#joinmessage").html("중복되지 않는 아이디(이메일)를 입력해 주세요.");
			return false; 
		}
		
		if (pw1 != pw2) {
			$("#pwmessage").css("color", "red");
			$("#pwmessage").html("비밀번호가 일치하지 않습니다.");
			setTimeout(function() {
				$("#pwmessage").html("");	
			}, 10000)
			return false;
		} else {
			$("#pwmessage").html("");
		}
		
		return true;
		
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
								<span class="page-title">Register</span>
							</div>
						</div>
					</div>
				</div>              
				<section class="content">
					<div class="container">
						<div class="row">
							<div id="page-header" class="col-md-24">
								<h1 id="page-title">회원 가입</h1><span id="joinguide" class="req">*표는 필수 입력사항입니다.</span> 
							</div>
							<div id="col-main" class="col-md-24 register-page clearfix">
								<form method="post" action="/user/register_action.joya" id="create_customer" accept-charset="UTF-8" onsubmit="return checkinfo();">
									<input value="create_customer" name="form_type" type="hidden"><input name="utf8" value="✓" type="hidden">
									<div id="register-form" class="row list-unstyled">
                                      <div class="half-ms-div">
  										<label class="control-label" for="email">아이디<span class="req">*</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="emailmessage"></span></label>
  										<input name="email" id="email" class="form-control " type="text" pattern="^[a-zA-Z0-9]+@[a-zA-Z0-9]+(\.[a-zA-Z]+)+$" title="이메일을 올바르게 입력해 주세요." required="required">
                                       </div>
                                       <div class="half-ms-div">
                                        <label class="control-label" for="name">이름<span class="req">*</span></label>
                                        <input value="" name="name" id="name" class="form-control password" type="text" pattern="^[a-zA-Z]{3,30}|[가-힣]{2,10}" title="영문 3~30자, 한글 2~10자 이내로 입력해 주세요." required="required" >
                                       </div>
                                       <div class="half-ms-div">
  										<label class="control-label" for="password">비밀번호<span class="req">*</span></label>
                                        <input name="passwd" id="password" class="form-control password" type="password" pattern="^[a-zA-Z0-9]{4,20}$" title="영문/숫자 4~20 자리로 입력해 주세요." required="required">
                                       </div>
                                       <div class="half-ms-div">
                                        <label id="repasswd" class="control-label" for="password">비밀번호 확인<span class="req">*</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="pwmessage"></span></label>
                                        <input name="passwd2" id="password2" class="form-control password" type="password" pattern="^[a-zA-Z0-9]{4,20}$" title="영문/숫자 4~20 자리로 동일하게 입력해 주세요." required="required">
                                       </div>
                                       <div class="half-ms-div"> 
  										<label class="control-label" for="phone">전화번호<span class="req">*</span></label>
  										<input name="phone" id="phone" class="form-control " type="text" pattern="^01\d{1}-\d{3,4}-\d{4}$" title="010-111(1)-1111 형태로 입력해 주세요" required="required">
                                       </div>
                                       <div class="half-ms-div">
                                        <label class="control-label" for="birthdate">생년월일</label>
                                        <input value="" name="birthdate" id="birthdate" class="form-control password" type="text" pattern="^\d{8}$" title="19940101의 형태로 입력해 주세요.">
                                        </div>
                                        <div class="ms_div">
                                        <label class="control-label" for="address">주소<span class="req">*</span></label>
                                        <input name="address1" type="text" id="sample6_postcode" class="postcode form-control" placeholder="우편번호" required="required">
                                        <input id="postalbtn" type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기">
                                        <input name="address2" type="text" id="sample6_address" class="address1 form-control" placeholder="주소" required="required">
                                        <input name="address3" type="text" id="sample6_address2" class="address2 form-control" placeholder="상세주소" >
                                        </div>
                                        <a id="acc-close" class="btn" type="reset" href="/index.joya">취소</a>
                                        <button id="signupup" class="btn signup" type="submit" value="0">가입</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="joinmessage"></span>
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