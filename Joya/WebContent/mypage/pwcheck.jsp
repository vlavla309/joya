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
  <title>Modification</title>
  <!-- favicon -->
  	<link rel="shortcut icon" href="/assets/images/favicon.ico">
  
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
    
    
    <script>
        $(document).ready(function () {
        	/* DB에 있는 비밀번호와 일치 확인 이벤트 처리 */
        	$("#password").keyup(function() {
    			var useremail = $("#email").val();
    			var userpasswd = $(this).val(); 
    			$.ajax({
    				url: "/user/passwdaction.joya",
    				data: {"email" : useremail, "passwd" : userpasswd},
    				success: function(data) {
    					if ($("#password").val().length == 0) {
    						$("#pwmessage1").html("");
    					} else if (data.trim() == "true") {
    						$("#pwmessage1").css("color", "blue");
    						$("#pwmessage1").html("가입 시 입력된 비밀번호와 일치합니다.");
    						$("#done").attr("value", "1");
    						setTimeout(function() {
    							$("#pwmessage1").html("");	
    						}, 10000)
    					} else {
    						$("#pwmessage1").css("color", "red");
    						$("#pwmessage1").html("가입 시 입력하신 비밀번호와 다릅니다.");
    						$("#done").attr("value", "0");
    						setTimeout(function() {
    							$("#pwmessage1").html("");	
    						}, 10000)
    					}
    				}
    			});
    		});
        });
        
        /* 입력한 비밀번호 일치 확인 */
        function checkpw() {
    		
    		var pw1 = $("#password").val();
    		var pw2 = $("#password2").val();
    		
    		if ($("#done").attr("value") == "0") {
    			$("#pwmessage1").html("가입 시 입력된 비밀번호와 다릅니다.");
    			return false; 
    		}
    		
    		if (pw1 != pw2) {
    			$("#pwmessage2").css("color", "red");
    			$("#pwmessage2").html("비밀번호가 일치하지 않습니다.");
    			setTimeout(function() {
    				$("#pwmessage2").html("");	
    			}, 10000)
    			return false;
    		} else {
    			$("#pwmessage2").html("");
    		}
    		
    		return true;
    		
    	};
    	
    	/* 취소 버튼 클릭 시 페이지 이동 메소드 */
    	function goBack() {
			var form = document.createElement("form");
			form.setAttribute("action", "/user/mypageaction.joya");
			form.setAttribute("method", "post");
			
			var email = document.createElement("input");
			email.setAttribute("type", "hidden");
			email.setAttribute("name", "email");
			email.setAttribute("value", "${user.email }");
			
			form.appendChild(email);
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
								<span class="page-title">Modification</span>
							</div>
						</div>
					</div>
				</div>              
				<section class="content">
					<div class="container">
						<div class="row">
							<div id="page-header" class="col-md-24">
								<h1 id="page-title">비밀번호 확인</h1> 
							</div>
							<div id="col-main" class="col-md-24 register-page clearfix">
                            <!-- 비밀번호 체크 폼 -->
								<form method="post" action="/user/bridgeaction.joya" id="create_customer" accept-charset="UTF-8" onsubmit="return checkpw();">
									<input value="create_customer" name="form_type" type="hidden"><input name="utf8" value="✓" type="hidden">
									<div id="register-form" class="row list-unstyled">
                                      <div class="half-ms-div">
                                        <input value="${user.email }" name="email" id="email" class="form-control " type="hidden" readonly="readonly">
  										<label class="control-label" for="password">비밀번호<span class="req">*</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="pwmessage1"></span></label>
                                        <input value="" name="passwd" id="password" class="form-control password" type="password" pattern="^[a-zA-Z0-9]{4,20}$" title="영문/숫자 4~20 자리로 입력해 주세요." required="required">
                                       </div>
                                       <div class="half-ms-div">
                                        <label class="control-label" for="password">비밀번호 확인<span class="req">*</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="pwmessage2"></span></label>
                                        <input value="" name="passwd2" id="password2" class="form-control password" type="password" pattern="^[a-zA-Z0-9]{4,20}$" title="영문/숫자 4~20 자리로 동일하게 입력해 주세요." required="required">
                                        </div>
                                        <div class="full-ms-div">
                                        <button id="acc-cancel" class="btn" type="button" onclick="location.href='javascript:goBack();'">취소</button>
                                        <button id="done" class="btn" type="submit" value="0" >확인</button>
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

    <!-- Footer -->
    <jsp:include page="../include/footer.jsp"/>
    <!-- Footer End -->
</body>