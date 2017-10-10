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
        	
        	$("#cancel_modify").click(function() {
        		goBack();
			});
            //start of the document ready function
            //delcaring global variable to hold primary key value.
            var pryEmpId;
            $('#acc-close').click(function () {
                pryEmpId = $(this).attr('id');
                $('#myModal').modal('show');
            });

            //function to reset bootstrap modal popups
            $("#myModal").on("hidden.bs.modal", function () {
                $(".modal-header").removeClass(' ').addClass('alert-danger');
                $('.delete-confirm').css('display', 'inline-block');
                $('.success-message').html('').html('정말 탈퇴하시겠습니까?');
            });

            //end of the docuement ready function
        });
        
        function checkpw() {
    		
    		var pw1 = $("#password").val();
    		var pw2 = $("#password2").val();
    		
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
    		
    	}
        
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
								<h1 id="page-title">회원 정보 수정</h1> 
							</div>
							<div id="col-main" class="col-md-24 register-page clearfix">
								<form method="post" action="/user/modifyaction.joya" id="create_customer" accept-charset="UTF-8" onsubmit="return checkpw();">
									<input value="create_customer" name="form_type" type="hidden"><input name="utf8" value="✓" type="hidden">
									<div id="register-form" class="row list-unstyled">
                                      <div class="half-ms-div">
  										<label class="control-label" for="last_name">아이디<span class="req">*</span></label>
  										<input value="${user.email }" name="email" id="email" class="form-control " type="text" readonly="readonly">
  										<label class="control-label" for="password">비밀번호<span class="req">*</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="pwmessage1"></span></label>
                                        <input value="" name="passwd" id="password" class="form-control password" type="password" pattern="^[a-zA-Z0-9]{4,20}$" title="영문/숫자 4~20 자리로 입력해 주세요." required="required">
  										<label class="control-label" for="email">전화번호<span class="req">*</span></label>
  										<input value="${user.phone }" name="phone" id="phone" class="form-control " type="text" pattern="^01\d{1}-\d{3,4}-\d{4}$" title="010-111(1)-1111 형태로 입력해 주세요" required="required">
                                       </div>
                                       <div class="half-ms-div">
                                        <label class="control-label" for="password">이름<span class="req">*</span></label>
                                        <input value="${user.name }" name="name" id="password" class="form-control password" type="text" pattern="^[a-zA-Z]{3,30}|[가-힣]{2,10}" title="영문 3~30자, 한글 2~10자 이내로 입력해 주세요." required="required">
                                        <label class="control-label" for="password">비밀번호 확인<span class="req">*</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="pwmessage2"></span></label>
                                        <input value="" name="passwd2" id="password2" class="form-control password" type="password" pattern="^[a-zA-Z0-9]{4,20}$" title="영문/숫자 4~20 자리로 동일하게 입력해 주세요." required="required">
                                        <label class="control-label" for="password">생년월일<span class="req">*</span></label>
                                        <input value="${user.birthdate }" name="birthdate" id="password" class="form-control password" type="text" pattern="^\d{8}$" title="19940101의 형태로 입력해 주세요.">
                                        </div>
                                        <div class="ms_div">
                                        <label class="control-label" for="password">주소<span class="req">*</span></label>
                                        <input value="${address1 }" name="address1" type="text" id="sample6_postcode" class="postcode form-control" placeholder="우편번호" required="required">
                                        <input id="postalbtn" type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기">
                                        <input value="${address2 }" name="address2" type="text" id="sample6_address" class="address1 form-control" placeholder="주소" required="required">
                                        <input value="${address3 }" name="address3" id="sample6_address2" class="address2 form-control" placeholder="상세주소" required="required">
                                        </div>
                                        <button id="cancel_modify" class="btn" type="button">취소</button>
                                        <button id="acc-close" class="btn" type="button">회원 탈퇴</button>
                                        <button id="complete" class="btn" type="submit">수정 완료</button>
									</div>
								</form>
                                <form action="/user/closeaction.joya" method="post">                  
                                    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                                      <div class="modal-dialog" role="document">
                                        <div class="modal-content">
                                         <div class="modal-header alert alert-danger">
                                           <input value="${user.email }" name="email" type="hidden">
                                           <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                           <span aria-hidden="true">&times;</span>
                                           </button>
                                           <h4 class="modal-title" id="myModalLabel">회원 탈퇴 확인</h4>
                                         </div>
                                         <div class="modal-body">
                                           <label class="success-message">정말 탈퇴하시겠습니까?</label>
                                         </div>
                                         <div class="modal-footer">
                                           <button class="btn btn-success delete-confirm" type="submit">탈퇴</button>
                                           <button class="btn btn-default" data-dismiss="modal">취소</button>
                                         </div>
                                       </div>
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