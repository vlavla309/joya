<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />
  <link rel="canonical" href="http://demo.designshopify.com/" />
  <meta name="description" content="" />
  <title>Register</title>
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
	<link href="../assets/stylesheets/cart.css" rel="stylesheet"  type="text/css" media="all">
	
	<script src="/assets/javascripts/jquery-1.9.1.min.js" type="text/javascript"></script>
	<script src="/assets/javascripts/bootstrap.min.3x.js" type="text/javascript"></script>
    <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	<script src="/assets/javascripts/postcode.js" type="text/javascript"></script>
	<script src="/assets/javascripts/cart.js" type="text/javascript"></script>
	<script src="/assets/javascripts/cookies.js" type="text/javascript"></script>
	<script src="/assets/javascripts/referer.js" type="text/javascript"></script>
	<script src="/assets/javascripts/cart_function.js" type="text/javascript"></script>
    
    <script type="text/javascript">
	    
    	$(function(){
	    	
	    	//로그인한 사용자 정보 읽어들임.
	    	$("#sample6_postcode").val("${user.address}".split("###")[0])
	    	$("#sample6_address").val("${user.address}".split("###")[1])
	    	$("#sample6_address2").val("${user.address}".split("###")[2])
	    	
	    	//주문자 정보와 동일함 라디오 버튼을 누르면, 배송지 정보가 자동으로 채워짐
	    	$("#same").change(function(){
	            $("#receiver").val($("#ordername").val())
	            $("#receivephone").val($("#orderphone").val())
	            $(".revpostcode").val($("#sample6_postcode").val())
	            $(".revaddress1").val($("#sample6_address").val())
	            $(".revaddress2").val($("#sample6_address2").val())
	        });   
	    	
	    	// 새로운 배송지를 눌렀을때 모든 input val이 비워져야함
	    	$("#new").change(function(){
	            $("#receiver").val("")
	            $("#receivephone").val("")
	            $(".revpostcode").val("")
	            $(".revaddress1").val("")
	            $(".revaddress2").val("")
	        });  
	    	//new
	    	
	    	// 포인트 사용하기 버튼을 누르기전에, total price를 따로 hidden으로 저장을 해놓는다.
	    	$("#before_use_point_price").val($("#subtotalPrice").text());
	    	
	    	//사용가능한 포인트에  전체 포인트를 넣는다.
	    	$("#totalpoint").val($("#restpoint").text())
	    	
	    	// 포인트 사용버튼을 누르면 실행되는 이벤트
	    	$("#usepoint").click(function(){
	    		var point_result=Number($("#restpoint").text())-Number($("#point").val())
	    		
	    		//사용한 포인트 누적해서 저장하기
	    		$("#used_point").val(Number($("#used_point").val())+Number($("#point").val()))
	    		
	    		if(point_result >= 0){
	    			$("#restpoint").text(point_result)
	    			$("#rest_point").val(point_result)
	    			$("#point").attr("max", point_result)
	    			var price=Number($("#subtotalPrice").text())-Number($("#point").val());
		    		$("#subtotalPrice").text(price);
		    		$("#totalPrice").val(price)
		    		$("#point").val("")
	    		}else{
	    			$("#point_info").text("사용 가능한 포인트를 초과하였습니다.")
	    			$("#point").val("")
	    		}
	    		
	    	})
	    	
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
							
							<h4>주문항목</h4>
							<hr/><br/>
							<input value="create_customer" name="form_type" type="hidden"><input name="utf8" value="✓" type="hidden">
							<div id="register-form" class="row list-unstyled">
								
								<table class="cart-items haft-border">
									<colgroup>
										<col class="checkout-image">
										<col class="checkout-info">
										<col class="checkout-price">
										<col class="checkout-quantity">
										<col class="checkout-totals">
									</colgroup>
									<thead>
										<tr class="top-labels">
	                                        <th>
	                                          &nbsp;
	                                        </th>
											<th>
												Items
											</th>
											<th>
												Price
											</th>
											<th>
												Qty
											</th>
											<th>
												SubTotal
											</th>
											
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${cart}" var="cartItem" varStatus="status">
													<tr class="item donec-condime-fermentum" id="productId_${cartItem.key }">
			                                            <!-- 체크박스 -->
			                                            <td>&nbsp;</td>
			                                            <!-- 제품 설명(사진, 이미지) start -->
											<td class="title text-left">
												<ul class="list-inline">
													<li class="image">
													<a href="${pageContext.servletContext.contextPath}/product/view.joya?productid=${cartItem.key}&type=view">
													<img src="/shopimg/${images[cartItem.key].imageName }" alt="${products[cartItem.key].productName}" class="cartImg">
													</a>
													</li>
													<li class="link">
													<a href="${pageContext.servletContext.contextPath}/product/view.joya?productid=${cartItem.key}&type=view">
													<span class="title-5">${products[cartItem.key].productName }</span>
													</a>
													</li>
												</ul>
											</td>
			                                            
			                                            <!-- 제품 가격 -->
											<td class="title-1">
												&#8361; <span class="cartItemPrice" name=${cartItem.key}>${products[cartItem.key].price }</span>
											</td>
			                                            
			                                            <!-- 제품 수량 -->
											<td>
												<input type="number" class="form-control input-1 replace productAmount" min="1" maxlength="5" size="5" id="updates_3947646083" name="${cartItem.key }" value="${cartItem.value }" readonly="readonly">
											</td>
			                                            
			                                            <!-- 제품 수량에 대한 가격 -->
											<td class="total title-1">
												&#8361;  <span class="subPrice" name="${cartItem.key}">${products[cartItem.key].price*cartItem.value }</span>
											</td>
										</tr>
										</c:forEach>	
									</tbody>
									<tfoot>
										<tr class="bottom-summary">
                                            <td>
                                              <h1>TOTAL : </h1>
                                            </td>
											<td>
												&nbsp;
											</td>
											<td>
												
											</td>
											<td id="subtotalCart" class="subtotal title-1">
												<span>&#8361;</span><span id="subtotalPrice"></span>
											</td>
											<td>
												&nbsp;
											</td>
										</tr>
									</tfoot>
								</table>
							</div>
							 
							<div id="col-main" class="col-md-24 register-page clearfix">
								<form method="post" action="/order/orderaction.joya" accept-charset="UTF-8">
									<input type="hidden" id="totalPrice" name = "totalPrice">
									<input type="hidden" id = "before_use_point_price" value = "" name = "before_use_point_price">
									<h4>주문자 정보</h4>
									<hr/><br/>
									<input value="create_customer" name="form_type" type="hidden"><input name="utf8" value="✓" type="hidden">
									<div id="register-form" class="row list-unstyled">
                                       <div class="half-ms-div">
  										<label class="control-label" for="sender">주문하시는 분<span class="req">*</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="emailmessage"></span></label>
  										<input name="ordername" id="ordername" class="form-control " type="text" required="required" value="${user.name}">
                                       </div>
                                       <div class="half-ms-div">
  										<label class="control-label" for="email">이메일<span class="req">*</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="emailmessage"></span></label>
  										<input name="email" id="email" class="form-control " type="text" value="${user.email}" pattern="^[a-zA-Z0-9]+@[a-zA-Z0-9]+(\.[a-zA-Z]+)+$" title="이메일을 올바르게 입력해 주세요." required="required">
                                       </div>
                                       <div class="half-ms-div"> 
  										<label class="control-label" for="phone">전화번호<span class="req">*</span></label>
  										<input name="orderphone" id="orderphone" class="form-control " value="${user.phone}" type="text" pattern="^01\d{1}-\d{3,4}-\d{4}$" title="010-111(1)-1111 형태로 입력해 주세요" required="required">
                                       </div>
                                       <div class="half-ms-div">
                                       		<input type ="hidden" id = "totalpoint"  >
                                       		<input type ="hidden" name = "used_point" id = "used_point"  value="0">
	  										<input type ="hidden" id = "rest_point">
	  										<label class="control-label" for="phone">사용 가능한 포인트 : <span id="restpoint">${user.point}</span> point</label>
											<c:choose>
											    <c:when test="${empty user.email}">
											    	<input type="number" name="quantity" disabled="disabled">
											    </c:when>
											    <c:otherwise>
											    	<input type="number" id="point" name="quantity" min="0" max="${user.point}">
											    	<a id="usepoint" class="btn">적용</a> <span id = "point_info" class="req"></span>
											    </c:otherwise>
											</c:choose>
                                       </div>
                                       <div class="half-ms-div"> 
  										<label class="control-label" for="payment">결제 수단<span class="req" >*</span></label>
  										<select name = "payment">
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
                                      	<input type="radio" name="delivery" value="new" id="new" checked> 새로운 배송지 &nbsp;&nbsp;
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
	                                      <input name="receiveaddress1" type="text" id="sample7_postcode" class="postcode form-control revpostcode" placeholder="우편번호" required="required">
	                                      <input id="postalbtn" type="button" onclick="sample7_execDaumPostcode()" value="우편번호 찾기">
	                                      <input name="receiveaddress2" type="text" id="sample7_address" class="address1 form-control revaddress1" placeholder="주소" required="required">
	                                      <input name="receiveaddress3" type="text" id="sample7_address2" class="address2 form-control revaddress2" placeholder="상세주소" required="required">
                                      </div>
                                      <div class="ms_div">
                                      	<label class="control-label" for="phone">배송메세지<span class="req">*</span></label>
                                      	<textarea  rows="5" cols="100" name= "deliverymsg"></textarea>
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