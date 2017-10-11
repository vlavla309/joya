<%@ page contentType="text/html; charset=utf-8"%>
    <div class="container">
      <div class="top-navigation">
        <ul class="list-inline">
          <li class="top-logo">
            <a id="site-title" href="/index.joya" title="Joya">          
            <img class="img-responsive" src="/assets/images/logo.png" alt="Joya Logo">          
            </a>
          </li>
          <li class="navigation">     
            <nav class="navbar">
              <div class="clearfix">
                <div class="navbar-header">
                  <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                  <span class="sr-only">Toggle main navigation</span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                  </button>
                </div>
                <div class="is-mobile visible-xs">
                  <ul class="list-inline">
                    <li class="is-mobile-menu">
                    <div class="btn-navbar" data-toggle="collapse" data-target=".navbar-collapse">
                      <span class="icon-bar-group">
                      <span class="icon-bar"></span>
                      <span class="icon-bar"></span>
                      <span class="icon-bar"></span>
                      </span>
                    </div>
                    </li>
                    <li class="is-mobile-login">
                    <div class="btn-group">
                      <div class="dropdown-toggle" data-toggle="dropdown">
                        <i class="fa fa-user"></i>
                      </div>
                      <ul class="customer dropdown-menu">
                        <li class="logout">
                        <a href="#">Login</a>
                        </li>
                        <li class="account last">
                        <a href="register.html">Register</a>
                        </li>
                      </ul>
                    </div>
                    </li>
                    <li class="is-mobile-wl">
                    <a href="#"><i class="fa fa-heart"></i></a>
                    </li>
                    <li class="is-mobile-cart">
                    <a href="#"><i class="fa fa-shopping-cart"></i></a>
                    </li>
                  </ul>
                </div>
                <div class="collapse navbar-collapse">
                  <ul class="nav navbar-nav hoverMenuWrapper">
                    <li class="nav-item active">
                    <a href="/index.joya">
                    <span>Home</span>
                    </a>
                    </li>
                    <li class="dropdown mega-menu">
                    <a href="/product/list.joya" class="dropdown-toggle dropdown-link" data-toggle="dropdown">
                    <span>Product</span>
                    <i class="fa fa-caret-down"></i>
                    <i class="sub-dropdown1 visible-sm visible-md visible-lg"></i>
                    <i class="sub-dropdown visible-sm visible-md visible-lg"></i>
                    </a>
                    <div class="megamenu-container megamenu-container-1 dropdown-menu banner-bottom mega-col-4" style="">
                      <ul class="sub-mega-menu">
                        <li>
                        <ul>
                          <li class="list-title"><a class="list-title" href="/product/list.joya?category=반지">반지</a></li>
                          <li class="list-unstyled li-sub-mega">
                          <a href="#">웨딩링</a>
                          </li>
                          <li class="list-unstyled li-sub-mega">
                          <a href="#">남성반지</a>
                          </li>
                          <li class="list-unstyled li-sub-mega">
                          <a href="#">여성반지</a>
                          </li>
                          <li class="list-unstyled li-sub-mega">
                          <a href="#">싱글링<span class="megamenu-label hot-label">Hot</span>
                          </a>
                          </li>
                          <li class="list-unstyled li-sub-mega">
                          <a href="#">커플링<span class="megamenu-label feature-label">Featured</span>
                          </a>
                          </li>
                        </ul>
                        </li>
                        <li>
                        <ul>
                          <li class="list-title"><a  class="list-title" href="/product/list.joya?category=목걸이">목걸이</a></li>
                          <li class="list-unstyled li-sub-mega">
                        </ul>
                        </li>
                        <li>
                        <ul>
                          <li class="list-title"><a  class="list-title" href="/product/list.joya?category=귀걸이">귀걸이</a></li>
                          <li class="list-unstyled li-sub-mega">
                          <a href="#">Dolorem Sed </a>
                          </li>
                          </li>
                        </ul>
                        </li>
                        <li>
                        <ul>
                          <li class="list-title"><a  class="list-title" href="/product/list.joya?category=팔찌">팔찌</a></li>
                          <li class="list-unstyled li-sub-mega">
                          <a href="#">Dolorem Sed <span class="megamenu-label new-label">New</span>
                          </a>
                          </li>
                          <li class="list-unstyled li-sub-mega">
                          <a href="#">Proident Nulla </a>
                          </li>
                          <li class="list-unstyled li-sub-mega">
                          <a href="product.html">Phasellus Leo </a>
                          </li>
                          <li class="list-unstyled li-sub-mega last">
                          <a href="product.html">Tristique Amet <span class="megamenu-label hot-label">Hot</span>
                          </a>
                          </li>
                        </ul>
                        </li>
                      </ul>
                    </div>
                    </li>
                    
                    <li class="nav-item dropdown">
                    <a href="blog-full.html" class="dropdown-toggle dropdown-link" data-toggle="dropdown">
                    <span>Board</span>
                    <i class="fa fa-caret-down"></i>
                    <i class="sub-dropdown1 visible-sm visible-md visible-lg"></i>
                    <i class="sub-dropdown visible-sm visible-md visible-lg"></i>
                    </a>
                    <ul class="dropdown-menu">
                      <li class=""><a tabindex="-1" href="/boards/qnalist.joya">Q&A</a></li>
                      <li class=""><a tabindex="-1" href="/boards/aslist.joya">A/S</a></li>
                      
                    </ul>
                    </li>
                    <li class="nav-item">
                    <a href="contact.html">
                    <span>Contact</span>
                    </a>
                    </li>
                  </ul>
                </div>
              </div>
            </nav>
          </li>     
          <li class="top-search hidden-xs">
            <div class="header-search">
              <a href="#">
              <span data-toggle="dropdown">
              <i class="fa fa-search"></i>
              <i class="sub-dropdown1"></i>
              <i class="sub-dropdown"></i>
              </span>
              </a>
              <form id="header-search" class="search-form dropdown-menu" action="${pageContext.servletContext.contextPath }/product/list.joya" method="get">
                <!-- <input type="hidden" name="type" value="product"> -->
                <input type="text" name="value" value="" accesskey="4" autocomplete="off" placeholder="상품명으로 검색..." required>
                <button type="submit" class="btn">Search</button>
              </form>
            </div>
          </li>         
          <li class="umbrella hidden-xs">
            <div id="umbrella" class="list-inline unmargin">
              <div class="cart-link">
                <a href="/cart.joya">
                  <i class="sub-dropdown1"></i>
                  <i class="sub-dropdown"></i>
                  <div class="num-items-in-cart">
                    <span class="icon">
                      Cart
                      <span class="number" id="cartSize"></span>
                    </span>
                  </div>
                </a>
              </div>
            </div>
          </li>          
          <li class="mobile-search visible-xs">
            <form id="mobile-search" class="search-form" action="http://demo.designshopify.com/html_jewelry/search.html" method="get">
              <input type="hidden" name="type" value="product">
              <input type="text" class="" name="q" value="" accesskey="4" autocomplete="off" placeholder="Search something...">
              <button type="submit" class="search-submit" title="search"><i class="fa fa-search"></i></button>
            </form>
          </li>     
        </ul>
      </div>