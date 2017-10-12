<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
      <div class="top row">
      <div class="col-md-6 phone-shopping">
        <span>PHONE SHOPING (01) 123 456 UJ</span>
      </div>
      <div class="col-md-18">
        <ul class="text-right">
        <li class="customer-links hidden-xs">
   
        <c:choose>
          <c:when test="${empty cookie.user}">
              <ul id="accounts" class="list-inline">
            <li class="my-account">
            	<c:if test="${empty cookie.user}">
            	  <a href="/user/login.joya">Order List</a>
            	 </c:if>
            </li>  
            <li class="login">    
              <span id="loginButton" class="dropdown-toggle" data-toggle="dropdown">
                <a href="login.html">Login</a>
                <i class="sub-dropdown1"></i>
                <i class="sub-dropdown"></i>
              </span>
              <div id="loginBox" class="dropdown-menu text-left">
              <form method="post" action="/user/loginaction.joya" id="customer_login" accept-charset="UTF-8"><input type="hidden" value="customer_login" name="form_type"><input type="hidden" name="utf8" value="✓">
                <div id="bodyBox">
                  <ul class="control-container customer-accounts list-unstyled">
                    <li>
                      <label id="cal">Customer Account Login</label>
                    </li>
                    <li class="clearfix">
                      <label for="customer_email_box" class="control-label">Email Address <span class="req">*</span></label>
                      <input type="email" value="" name="email" id="customer_email_box" class="form-control" required="required">
                      <input class="referer" type="hidden" name="referer" >
                    </li>            
                    <li class="clearfix">
                      <label for="customer_password_box" class="control-label">Password <span class="req">*</span></label>
                      <input type="password" value="" name="passwd" id="customer_password_box" class="form-control password" required="required">
                    </li>             
                    <li class="clearfix">
                      <button class="action btn btn-1" type="submit">Login</button>
                    </li>
                    <li class="clearfix">
                      <a class="action btn btn-1" href="/user/register.joya">Create an account</a>
                    </li>
                  </ul>
                </div>
              </form>
              </div>    
            </li>
            <li>/</li>   
            <li class="register">
              <a href="/user/register.joya" id="customer_register_link">Create an account</a>
            </li>  
          </ul>
          </c:when>
          <c:otherwise>
          <script type="text/javascript">
          	function fwemail() {
          		var form = document.createElement("form");
          		form.setAttribute("action", "/user/mypageaction.joya");
          		form.setAttribute("method", "post");
          		
          		var hidden = document.createElement("input");
          		hidden.setAttribute("type", "hidden");
          		hidden.setAttribute("name", "email");
          		hidden.setAttribute("value", "${email}");
          		
          		form.appendChild(hidden);
          		document.body.appendChild(form);
          		form.submit();
			}
          </script>
          <form action="/user/mypage_action.joya" method="post">
            <ul id="accounts" class="list-inline">
             <li>
               <c:choose>
               <c:when test="${empty user }">
                 <label id="welcomebro">${name}(${email})님 환영합니다.&nbsp;&nbsp;&nbsp;</label>
               </c:when>
               <c:otherwise>
                  <label id="welcomebro">${user.name}(${email})님 환영합니다.&nbsp;&nbsp;&nbsp;</label>               
               </c:otherwise> 
               </c:choose> 
             </li>
             <li class="my-account">
                <a href="javascript:fwemail();">마이페이지</a>
             </li> 
             <li class="my-account">
                <a href="/user/loginaction.joya">로그아웃</a>
             </li> 
            </ul>
            </form>
          </c:otherwise>
        </c:choose>
        
        </li>      
        <li id="widget-social">
          <ul class="list-inline">            
          <li><a target="_blank" href="#" class="btooltip swing" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="Facebook"><i class="fa fa-facebook"></i></a></li>
          <li><a target="_blank" href="#" class="btooltip swing" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="Twitter"><i class="fa fa-twitter"></i></a></li>                        
          <li><a target="_blank" href="#" class="btooltip swing" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="Pinterest"><i class="fa fa-pinterest"></i></a></li>           
          </ul>
        </li>        
        </ul>
      </div>
      </div>
    </div>