<%@ page contentType="text/html; charset=utf-8"%>
<div class="container">
      <div class="top row">
      <div class="col-md-6 phone-shopping">
        <span>PHONE SHOPING (01) 123 456 UJ</span>
      </div>
      <div class="col-md-18">
        <ul class="text-right">
        <li class="customer-links hidden-xs">
          <ul id="accounts" class="list-inline">
            <li class="my-account">
              <a href="account.html">My Account</a>
            </li>  
            <li class="login">    
              <span id="loginButton" class="dropdown-toggle" data-toggle="dropdown">
                <a href="login.html">Login</a>
                <i class="sub-dropdown1"></i>
                <i class="sub-dropdown"></i>
              </span>
              <!-- Customer Account Login -->
              <div id="loginBox" class="dropdown-menu text-left">
              <form method="post" action="#" id="customer_login" accept-charset="UTF-8"><input type="hidden" value="customer_login" name="form_type"><input type="hidden" name="utf8" value="✓">
                <div id="bodyBox">
                  <ul class="control-container customer-accounts list-unstyled">
                    <li class="clearfix">
                      <label for="customer_email_box" class="control-label">Email Address <span class="req">*</span></label>
                      <input type="email" value="" name="customer[email]" id="customer_email_box" class="form-control">
                    </li>            
                    <li class="clearfix">
                      <label for="customer_password_box" class="control-label">Password <span class="req">*</span></label>
                      <input type="password" value="" name="customer[password]" id="customer_password_box" class="form-control password">
                    </li>             
                    <li class="clearfix">
                      <a class="action btn btn-1" href="login.html">Login</a>
                    </li>
                    <li class="clearfix">
                      <a class="action btn btn-1" href="register.html">Create an account</a>
                    </li>
                  </ul>
                </div>
              </form>
              </div>    
            </li>
            <li>/</li>   
            <li class="register">
              <a href="register.html" id="customer_register_link">Create an account</a>
            </li> 
          </ul>
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