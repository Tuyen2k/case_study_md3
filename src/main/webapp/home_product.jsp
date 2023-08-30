<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

  <title>Electro - HTML Ecommerce Template</title>

  <!-- Google font -->
  <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">

  <!-- Bootstrap -->
  <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css"/>

  <!-- Slick -->
  <link type="text/css" rel="stylesheet" href="css/slick.css"/>
  <link type="text/css" rel="stylesheet" href="css/slick-theme.css"/>

  <!-- nouislider -->
  <link type="text/css" rel="stylesheet" href="css/nouislider.min.css"/>

  <!-- Font Awesome Icon -->
  <link rel="stylesheet" href="css/font-awesome.min.css">

  <!-- Custom stlylesheet -->
  <link type="text/css" rel="stylesheet" href="css/style.css"/>

  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

</head>
<body>
<!-- HEADER -->
<header>
  <!-- TOP HEADER -->
  <div id="top-header">
    <div class="container">
      <ul class="header-links pull-left">
        <li><a href="#"><i class="fa fa-phone"></i> +021-95-51-84</a></li>
        <li><a href="#"><i class="fa fa-envelope-o"></i> email@email.com</a></li>
        <li><a href="#"><i class="fa fa-map-marker"></i> 1734 Stonecoal Road</a></li>
      </ul>
      <ul class="header-links pull-right">
        <li><a href="#"><i class="fa fa-dollar"></i> USD</a></li>
        <li><a href="#"><i class="fa fa-user-o"></i> My Account</a></li>
      </ul>
    </div>
  </div>
  <!-- /TOP HEADER -->

  <!-- MAIN HEADER -->
  <div id="header">
    <!-- container -->
    <div class="container">
      <!-- row -->
      <div class="row">
        <!-- LOGO -->
        <div class="col-md-3">
          <div class="header-logo">
            <a href="#" class="logo">
              <img src="./img/logo.png" alt="">
            </a>
          </div>
        </div>
        <!-- /LOGO -->

        <!-- SEARCH BAR -->
        <div class="col-md-6">
          <div class="header-search">
            <form>
              <select class="input-select">
                <option value="0">All Categories</option>
                <option value="1">Category 01</option>
                <option value="1">Category 02</option>
              </select>
              <input class="input" placeholder="Search here">
              <button class="search-btn">Search</button>
            </form>
          </div>
        </div>
        <!-- /SEARCH BAR -->

        <!-- ACCOUNT -->
        <div class="col-md-3 clearfix">
          <div class="header-ctn">
            <!-- Wishlist -->
            <div>
              <a href="#">
                <i class="fa fa-heart-o"></i>
                <span>Your Wishlist</span>
                <div class="qty">2</div>
              </a>
            </div>
            <!-- /Wishlist -->

            <!-- Cart -->
            <div class="dropdown">
              <a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">
                <i class="fa fa-shopping-cart"></i>
                <span>Your Cart</span>
                <div class="qty">3</div>
              </a>
              <div class="cart-dropdown">
                <div class="cart-list">
                  <div class="product-widget">
                    <div class="product-img">
                      <img src="./img/product01.png" alt="">
                    </div>
                    <div class="product-body">
                      <h3 class="product-name"><a href="#">product name goes here</a></h3>
                      <h4 class="product-price"><span class="qty">1x</span>$980.00</h4>
                    </div>
                    <button class="delete"><i class="fa fa-close"></i></button>
                  </div>

                  <div class="product-widget">
                    <div class="product-img">
                      <img src="./img/product02.png" alt="">
                    </div>
                    <div class="product-body">
                      <h3 class="product-name"><a href="#">product name goes here</a></h3>
                      <h4 class="product-price"><span class="qty">3x</span>$980.00</h4>
                    </div>
                    <button class="delete"><i class="fa fa-close"></i></button>
                  </div>
                </div>
                <div class="cart-summary">
                  <small>3 Item(s) selected</small>
                  <h5>SUBTOTAL: $2940.00</h5>
                </div>
                <div class="cart-btns">
                  <a href="#">View Cart</a>
                  <a href="#">Checkout  <i class="fa fa-arrow-circle-right"></i></a>
                </div>
              </div>
            </div>
            <!-- /Cart -->

            <!-- Menu Toogle -->
            <div class="menu-toggle">
              <a href="#">
                <i class="fa fa-bars"></i>
                <span>Menu</span>
              </a>
            </div>
            <!-- /Menu Toogle -->
          </div>
        </div>
        <!-- /ACCOUNT -->
      </div>
      <!-- row -->
    </div>
    <!-- container -->
  </div>
  <!-- /MAIN HEADER -->
</header>
<!-- /HEADER -->
<!-- NAVIGATION -->
<nav id="navigation">
  <!-- container -->
  <div class="container">
    <!-- responsive-nav -->
    <div id="responsive-nav">
      <!-- NAV -->
      <ul class="main-nav nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>
        <li><a href="#">Hot Deals</a></li>
        <li><a href="categories">Categories</a></li>
        <li><a href="#">Laptops</a></li>
        <li><a href="#">Smartphones</a></li>
        <li><a href="#">Cameras</a></li>
        <li><a href="#">Accessories</a></li>
      </ul>
      <!-- /NAV -->
    </div>
    <!-- /responsive-nav -->
  </div>
  <!-- /container -->
</nav>
<!-- /NAVIGATION -->

<!-- sửa trên div này -->
<div class="container" style="width: 900px; height: 1000px; align-content: center;position: relative;z-index: 50">
  <div style="position: absolute; margin-top: 100px;">
    <c:if test="${flag == true}">
      <c:if test="${message != null&& not empty message }">
        <script>
          alert("${message}");
          ${flag = false};
        </script>
      </c:if>
    </c:if>
    <h1>Show List Product</h1>
    <a class="btn btn-primary" onclick="document.getElementById('form_create_product').style.display = 'block'">
      Create Product</a> <br>
    <form action="products" id="form_create_product" style="display: none" method="post">
      <label for="product_name">Product name</label>
      <input type="text" id="product_name" name="product_name" placeholder="product name">
      <button>Create</button>
    </form>
    <table class="table">
      <thead>
      <tr>
        <th>STT</th>
        <th>Name</th>
        <th colspan="2" style="width: 60%">Action</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach varStatus="index" items="${products}" var="product">
        <tr>
          <td>${index.count}</td>
          <td>${product.getName()}</td>
          <td>
            <button onclick="onUpdate(${product.getId_product()})"
                    class="btn btn-primary">Update
            </button>
          </td>
          <td class="input-text" id="cell-${product.getId_product()}" style="display: none">
            <form action="products?action=update&&id_product=${product.getId_product()}"
                  method="post">
              <input type="text" name="product_name" placeholder="product name update">
              <button>Save</button>
              <button type="reset">Reset</button>
              <button type="button" onclick="onClose(${product.getId_product()})">Close</button>
            </form>
          </td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
</div>
<!-- FOOTER -->
<footer id="footer">
  <!-- top footer -->
  <div class="section">
    <!-- container -->
    <div class="container">
      <!-- row -->
      <div class="row">
        <div class="col-md-3 col-xs-6">
          <div class="footer">
            <h3 class="footer-title">About Us</h3>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut.</p>
            <ul class="footer-links">
              <li><a href="#"><i class="fa fa-map-marker"></i>1734 Stonecoal Road</a></li>
              <li><a href="#"><i class="fa fa-phone"></i>+021-95-51-84</a></li>
              <li><a href="#"><i class="fa fa-envelope-o"></i>email@email.com</a></li>
            </ul>
          </div>
        </div>

        <div class="col-md-3 col-xs-6">
          <div class="footer">
            <h3 class="footer-title">Categories</h3>
            <ul class="footer-links">
              <li><a href="#">Hot deals</a></li>
              <li><a href="#">Laptops</a></li>
              <li><a href="#">Smartphones</a></li>
              <li><a href="#">Cameras</a></li>
              <li><a href="#">Accessories</a></li>
            </ul>
          </div>
        </div>

        <div class="clearfix visible-xs"></div>

        <div class="col-md-3 col-xs-6">
          <div class="footer">
            <h3 class="footer-title">Information</h3>
            <ul class="footer-links">
              <li><a href="#">About Us</a></li>
              <li><a href="#">Contact Us</a></li>
              <li><a href="#">Privacy Policy</a></li>
              <li><a href="#">Orders and Returns</a></li>
              <li><a href="#">Terms & Conditions</a></li>
            </ul>
          </div>
        </div>

        <div class="col-md-3 col-xs-6">
          <div class="footer">
            <h3 class="footer-title">Service</h3>
            <ul class="footer-links">
              <li><a href="#">My Account</a></li>
              <li><a href="#">View Cart</a></li>
              <li><a href="#">Wishlist</a></li>
              <li><a href="#">Track My Order</a></li>
              <li><a href="#">Help</a></li>
            </ul>
          </div>
        </div>
      </div>
      <!-- /row -->
    </div>
    <!-- /container -->
  </div>
  <!-- /top footer -->

  <!-- bottom footer -->
  <div id="bottom-footer" class="section">
    <div class="container">
      <!-- row -->
      <div class="row">
        <div class="col-md-12 text-center">
          <ul class="footer-payments">
            <li><a href="#"><i class="fa fa-cc-visa"></i></a></li>
            <li><a href="#"><i class="fa fa-credit-card"></i></a></li>
            <li><a href="#"><i class="fa fa-cc-paypal"></i></a></li>
            <li><a href="#"><i class="fa fa-cc-mastercard"></i></a></li>
            <li><a href="#"><i class="fa fa-cc-discover"></i></a></li>
            <li><a href="#"><i class="fa fa-cc-amex"></i></a></li>
          </ul>
          <span class="copyright">
								<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
								Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
							</span>
        </div>
      </div>
      <!-- /row -->
    </div>
    <!-- /container -->
  </div>
  <!-- /bottom footer -->
</footer>
<!-- /FOOTER -->

<!-- jQuery Plugins -->
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/slick.min.js"></script>
<script src="js/nouislider.min.js"></script>
<script src="js/jquery.zoom.min.js"></script>
<script src="js/main.js"></script>

</body>
</html>
<script>
  function onUpdate(index) {
    var inputs = document.getElementsByClassName("input-text");
    for (let i = 0; i < inputs.length; i++) {
      inputs[i].style.display = 'none';
    }
    var input = document.getElementById("cell-" + index);
    input.style.display = 'block';
  }

  function onClose(index) {
    var input = document.getElementById("cell-" + index);
    input.style.display = 'none';
  }
</script>
