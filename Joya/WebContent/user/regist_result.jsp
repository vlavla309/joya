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
  <title>Register Page</title>
  
  <!-- css 적용 영역 시작 -->
    <link href="../assets/stylesheets/font.css" rel='stylesheet' type='text/css'>
  
   <link href="../assets/stylesheets/font-awesome.min.css" rel="stylesheet" type="text/css" media="all">    
   <link href="../assets/stylesheets/bootstrap.min.3x.css" rel="stylesheet" type="text/css" media="all">
   <link href="../assets/stylesheets/cs.bootstrap.3x.css" rel="stylesheet" type="text/css" media="all">
   <link href="../assets/stylesheets/cs.animate.css" rel="stylesheet" type="text/css" media="all">
   <link href="../assets/stylesheets/cs.global.css" rel="stylesheet" type="text/css" media="all">
   <link href="../assets/stylesheets/cs.style.css" rel="stylesheet" type="text/css" media="all">
   <link href="../assets/stylesheets/cs.media.3x.css" rel="stylesheet" type="text/css" media="all">
   <link href="../assets/stylesheets/registResult.css" rel="stylesheet" type="text/css" media="all">
   
   <script src="../assets/javascripts/jquery-1.9.1.min.js" type="text/javascript"></script>
   <script src="../assets/javascripts/bootstrap.min.3x.js" type="text/javascript"></script>
    <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
   <script src="../assets/javascripts/postcode.js" type="text/javascript"></script>
    
    <style type="text/css">
      .thanks-bg {
        float: left;
        position: relative;
        left: 22%;
        margin-top: 30px;
      }
    </style>
    <!-- css 적용 영역 종료 -->
</head>

<body itemscope="" itemtype="http://schema.org/WebPage" class="templateCustomersRegister notouch">
  
   <!-- Header 영역 시작 -->
   <jsp:include page="../include/header.jsp" />
    <!-- hearder 영역 종료 -->
  
   <div id="content-wrapper-parent">
      <div id="content-wrapper">  
         <!-- Content -->
         <div id="content" class="clearfix">   
           
                <!-- smallHeader 영역 시작 -->
            <div id="breadcrumb" class="breadcrumb">
               <div itemprop="breadcrumb" class="container">
                  <div class="row">
                     <div class="col-md-24">
                        <a href="index-2.html" class="homepage-link" title="Back to the frontpage">Home</a>
                        <span>/</span>
                        <span class="page-title">Regist</span>
                     </div>
                  </div>
               </div>
            </div>       
               <!-- smallHeader 영역 종료 -->       
               
                <!-- 본문 영역 시작 -->
            <section class="content">
               <div class="container">
                  <div class="row">
                     <div id="col-main" class="col-md-24 register-page clearfix">
                         <div class="thanks-bg">
                                   <div class="thanks-img wow fadeIn"><img src="../assets/images/thanks.png" alt="" title="" class="img-responsive"></div>
                                   <div class="thanks-text" >
                                    <h2 id="ji-h2" class="wow fadeIn"><strong>회원가입이 완료되었습니다</strong></h2>
                                    <div id="ji-userInfo">
                                       <span class="wow fadeIn"><strong class="kind">이메일</strong>${user.email }</span><br>
                                       <span class="wow fadeIn"><strong class="kind">이름</strong>${user.name }</span><br>
                                       <span class="wow fadeIn"><strong class="kind">전화번호</strong>${user.phone }</span><br>
                                       <span class="wow fadeIn"><strong class="kind">주소</strong>${address1 } ${address2 } ${address3 }</span><br>
                                       <span class="wow fadeIn"><strong class="kind">생년월일</strong>${user.birthdate }</span><br>
                                     </div>
                                   <div id="ji-buttons"><a href="#"  id="ji-gohomeB" class="wow fadeInLeft">Go Home</a>&nbsp;&nbsp; <a href="#" id="ji-gologinB"class="wow fadeInRight">Login</a> </div>
                                   </div>
                                 </div>
                     </div>   
                  </div>
               </div>
            </section>     
                 <!-- 본문 영역 종료 -->   
         </div>
      </div>
   </div>

  
<!-- footer 시작 -->
<jsp:include page="../include/footer.jsp" />
<!-- footer 종료 -->
</body>