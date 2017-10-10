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
	    $(function(){
	    	$("#same").change(function(){
	            $("#receiver").val($("#ordername").val())
	            $("#receivephone").val($("#orderphone").val())
	            alert($("#sample6_postcode").val())
	            $(".revpostcode").val($("#sample6_postcode").val())
	            $(".revaddress1").val($("#sample6_address").val())
	            $(".revaddress2").val($("#sample6_address2").val())
	        });          
	    });
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
								<span class="page-title">order</span>
							</div>
						</div>
					</div>
				</div>              
				<section class="content">
					<div class="container">
						<div class="row">
							<div id="page-header" class="col-md-24">
								<h1 id="page-title">주문하기</h1><span id="joinguide" class="req">*표는 필수 입력사항입니다.</span> 
							</div>
							<div id="col-main" class="col-md-24 register-page clearfix">
								<form method="post" action="/order/order_add_action.joya" accept-charset="UTF-8">
									<h4>주문자 정보</h4>
									<hr/><br/>
									<input value="create_customer" name="form_type" type="hidden"><input name="utf8" value="✓" type="hidden">
									<div id="register-form" class="row list-unstyled">
                                       <div class="half-ms-div">
  										<label class="control-label" for="sender">주문하시는 분<span class="req">*</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="emailmessage"></span></label>
  										<input name="ordername" id="ordername" class="form-control " type="text" required="required">
                                       </div>
                                       <div class="half-ms-div">
  										<label class="control-label" for="email">이메일<span class="req">*</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="emailmessage"></span></label>
  										<input name="email" id="email" class="form-control " type="text" pattern="^[a-zA-Z0-9]+@[a-zA-Z0-9]+(\.[a-zA-Z]+)+$" title="이메일을 올바르게 입력해 주세요." required="required">
                                       </div>
                                       <div class="half-ms-div"> 
  										<label class="control-label" for="phone">전화번호<span class="req">*</span></label>
  										<input name="orderphone" id="orderphone" class="form-control " type="text" pattern="^01\d{1}-\d{3,4}-\d{4}$" title="010-111(1)-1111 형태로 입력해 주세요" required="required">
                                       </div>
                                       <div class="half-ms-div"> 
  										<label class="control-label" for="phone">사용 가능한 포인트<span class="req">*</span></label>
  										<input type="number" name="quantity" min="1" max="${user.point}" value="${user.point}">
                                       </div>
                                       <div class="half-ms-div"> 
  										<label class="control-label" for="phone">결제 수단<span class="req" >*</span></label>
  										<select>
										  <option value="신용카드">신용카드</option>
										  <option value="무통장입금">무통장입금</option>
										  <option value="카카오페이">카카오페이</option>
										  <option value="휴대폰결제">휴대폰결제</option>
										</select>
                                       </div>
                                        <div class="ms_div">
                                        <label class="control-label" for="address">주소<span class="req">*</span></label>
                                        <input name="address1" type="text" id="sample6_postcode" class="postcode form-control" placeholder="우편번호" required="required">
                                        <input id="postalbtn" type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기">
                                        <input name="address2" type="text" id="sample6_address" class="address1 form-control" placeholder="주소" required="required">
                                        <input name="address3" type="text" id="sample6_address2" class="address2 form-control" placeholder="상세주소" >
                                        </div>
									</div>
									<h4>배송지 정보</h4>
									<hr/><br/>
									<input value="create_customer" name="form_type" type="hidden"><input name="utf8" value="✓" type="hidden">
									<div id="register-form" class="row list-unstyled">
									  <div class="ms_div">
                                      	<label class="control-label" for="delivery_select">배송지 선택<span class="req">*</span></label>
                                      	<input type="radio" name="delivery" value="new" checked> 새로운 배송지 &nbsp;&nbsp;
  									    <input type="radio" name="delivery" value="same" id="same" >주문자 정보와 동일<br><br>
                                      </div>
                                       <div class="half-ms-div">
  										<label class="control-label" for="sender">받는분 이름<span class="req">*</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="emailmessage"></span></label>
  										<input name="receiver" id="receiver" class="form-control " type="text">
                                       </div>
                                       <div class="half-ms-div"> 
  										<label class="control-label" for="phone">전화번호<span class="req">*</span></label>
  										<input name="receivephone" id="receivephone" class="form-control " type="text" pattern="^01\d{1}-\d{3,4}-\d{4}$" title="010-111(1)-1111 형태로 입력해 주세요" required="required">
                                       </div>
                                      <div class="ms_div">
	                                      <label class="control-label" for="address">주소<span class="req">*</span></label>
	                                      <input name="address1" type="text" id="sample6_postcode" class="postcode form-control revpostcode" placeholder="우편번호" required="required">
	                                      <input id="postalbtn" type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기">
	                                      <input name="address2" type="text" id="sample6_address" class="address1 form-control revaddress1" placeholder="주소" required="required">
	                                      <input name="address3" type="text" id="sample6_address2" class="address2 form-control revaddress2" placeholder="상세주소" required="required">
                                      </div>
                                      <div class="ms_div">
                                      	<label class="control-label" for="phone">배송메세지<span class="req">*</span></label>
                                      	<textarea  rows="5" cols="100"></textarea>
                                      </div>
                                        <a id="acc-close" class="btn" type="reset" href="/index.joya">취소</a>
                                        <button id="signupup" class="btn signup" type="submit" value="0">주문하기</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="joinmessage"></span>
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