<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <title>Cart</title>

    <!-- Google font -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">

    <!-- Bootstrap -->
    <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css"/>

    <!-- Slick -->
    <link type="text/css" rel="stylesheet" href="css/slick.css"/>
    <link type="text/css" rel="stylesheet" href="css/slick-theme.css"/>

    <!-- nouislider -->
    <link type="text/css" rel="stylesheet" href="css/nouislider.min.css"/>
    <link rel="stylesheet" type="text/css" href="\fonts\fontawesome-free-6.4.2-web/css/all.css">
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
<style>
    .fa-minus:before, .fa-subtract:before {
        content: "\f068";
    }

    *, :after, :before {
        box-sizing: border-box;
    }

    .fa-solid, .fas {
        font-family: "Font Awesome 6 Free";
        font-weight: 900;
    }

    .fa, .fa-brands, .fa-duotone, .fa-light, .fa-regular, .fa-solid, .fa-thin, .fab, .fad, .fal, .far, .fas, .fat {
        -moz-osx-font-smoothing: grayscale;
        -webkit-font-smoothing: antialiased;
        font-style: normal;
        font-variant: normal;
        line-height: 1;
        text-rendering: auto;
    }

    user agent stylesheet
    i {
        font-style: italic;
    }

    [type=button]:not(:disabled), [type=reset]:not(:disabled), [type=submit]:not(:disabled), button:not(:disabled) {
        cursor: pointer;
    }

    .btn-link, .btn-link:first-child:hover, .btn-link:focus-visible, .btn-link:hover, :not(.btn-check) + .btn-link:hover {
        text-decoration: none;
        box-shadow: var(--mdb-btn-box-shadow);
    }

    .btn-link {
        --mdb-btn-font-weight: 500;
        --mdb-btn-color: #3b71ca;
        --mdb-btn-hover-color: #386bc0;
        --mdb-btn-hover-bg: #f5f5f5;
        --mdb-btn-focus-color: #3566b6;
        --mdb-btn-active-color: #3260ac;
        --mdb-btn-disabled-color: #9e9e9e;
        --mdb-btn-box-shadow: none;
    }

    .btn {
        --mdb-btn-padding-top: 0.625rem;
        --mdb-btn-padding-bottom: 0.5rem;
        --mdb-btn-border-width: 0;
        --mdb-btn-border-color: none;
        --mdb-btn-border-radius: 0.25rem;
        --mdb-btn-box-shadow: 0 4px 9px -4px rgba(0, 0, 0, 0.35);
        --mdb-btn-hover-box-shadow: 0 8px 9px -4px rgba(0, 0, 0, 0.15), 0 4px 18px 0 rgba(0, 0, 0, 0.1);
        --mdb-btn-focus-box-shadow: 0 8px 9px -4px rgba(0, 0, 0, 0.15), 0 4px 18px 0 rgba(0, 0, 0, 0.1);
        --mdb-btn-active-box-shadow: 0 8px 9px -4px rgba(0, 0, 0, 0.15), 0 4px 18px 0 rgba(0, 0, 0, 0.1);
        padding-top: var(--mdb-btn-padding-top);
        padding-bottom: var(--mdb-btn-padding-bottom);
        text-transform: uppercase;
        vertical-align: bottom;
        border: 0;
        border-radius: var(--mdb-btn-border-radius);
        box-shadow: var(--mdb-btn-box-shadow);
    }

    .btn-link {
        --mdb-btn-font-weight: 400;
        --mdb-btn-bg: transparent;
        --mdb-btn-border-color: transparent;
        --mdb-btn-hover-border-color: transparent;
        --mdb-btn-active-color: #386bc0;
        --mdb-btn-active-border-color: transparent;
        --mdb-btn-disabled-border-color: transparent;
        --mdb-btn-focus-shadow-rgb: 88, 134, 210;
    }

    .btn {
        --mdb-btn-padding-x: 1.5rem;
        --mdb-btn-padding-y: 0.375rem;
        --mdb-btn-font-size: 0.75rem;
        --mdb-btn-font-weight: 500;
        --mdb-btn-line-height: 1.5;
        --mdb-btn-color: #4f4f4f;
        --mdb-btn-bg: transparent;
        --mdb-btn-border-width: 2px;
        --mdb-btn-border-color: transparent;
        --mdb-btn-hover-border-color: transparent;
        --mdb-btn-disabled-opacity: 0.65;
        --mdb-btn-focus-box-shadow: 0 0 0 0.25rem rgba(var(--mdb-btn-focus-shadow-rgb), 0.5);
        display: inline-block;
        padding: var(--mdb-btn-padding-y) var(--mdb-btn-padding-x);
        font-size: var(--mdb-btn-font-size);
        font-weight: var(--mdb-btn-font-weight);
        line-height: var(--mdb-btn-line-height);
        color: var(--mdb-btn-color);
        text-align: center;
        vertical-align: middle;
        cursor: pointer;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
        border: var(--mdb-btn-border-width) solid var(--mdb-btn-border-color);
        background-color: var(--mdb-btn-bg);
        transition: color .15s ease-in-out, background-color .15s ease-in-out, border-color .15s ease-in-out, box-shadow .15s ease-in-out;
    }

    button, select {
        text-transform: none;
    }

    button, input, optgroup, select, textarea {
        margin: 0;
        font-family: inherit;
        font-size: inherit;
        line-height: inherit;
    }

    user agent stylesheet
    button {
        text-rendering: auto;
        color: buttontext;
        letter-spacing: normal;
        word-spacing: normal;
        line-height: normal;
        text-transform: none;
        text-indent: 0px;
        text-shadow: none;
        text-align: center;
        cursor: default;
        writing-mode: horizontal-tb !important;
    }

    .row {
        --mdb-gutter-x: 1.5rem;
        --mdb-gutter-y: 0;
        display: flex;
        flex-wrap: wrap;
        margin-top: calc(var(--mdb-gutter-y) * -1);
        margin-right: calc(var(--mdb-gutter-x) * -0.5);
        margin-left: calc(var(--mdb-gutter-x) * -0.5);
    }

    .card-body {
        flex: 1 1 auto;
        padding: var(--mdb-card-spacer-y) var(--mdb-card-spacer-x);
    }

    .card {
        --mdb-card-spacer-y: 1.5rem;
        --mdb-card-spacer-x: 1.5rem;
        --mdb-card-title-spacer-y: 0.5rem;
        --mdb-card-border-width: 1px;
        --mdb-card-border-radius: 0.5rem;
        --mdb-card-box-shadow: 0 2px 15px -3px rgba(0, 0, 0, 0.07), 0 10px 20px -2px rgba(0, 0, 0, 0.04);
        --mdb-card-inner-border-radius: calc(0.5rem - 1px);
        --mdb-card-cap-padding-y: 0.75rem;
        --mdb-card-cap-padding-x: 1.5rem;
        --mdb-card-cap-bg: hsla(0, 0%, 100%, 0);
        --mdb-card-bg: #fff;
        --mdb-card-img-overlay-padding: 1.5rem;
        --mdb-card-group-margin: 0.75rem;
        position: relative;
        display: flex;
        flex-direction: column;
        min-width: 0;
        word-wrap: break-word;
        background-color: var(--mdb-card-bg);
        background-clip: border-box;
        border-radius: var(--mdb-card-border-radius);
        box-shadow: var(--mdb-card-box-shadow);
    }

    .container, .container-fluid, .container-lg, .container-md, .container-sm, .container-xl, .container-xxl {
        --mdb-gutter-x: 1.5rem;
        --mdb-gutter-y: 0;
        width: 100%;
        padding-right: calc(var(--mdb-gutter-x) * 0.5);
        padding-left: calc(var(--mdb-gutter-x) * 0.5);
        margin-right: auto;
        margin-left: auto;
    }

    body {
        margin: 0;
        font-family: var(--mdb-body-font-family);
        font-size: 20px;
        font-weight: var(--mdb-body-font-weight);
        -webkit-text-size-adjust: 100%;
        -webkit-tap-highlight-color: rgba(0, 0, 0, 0);
    }

    :root {
        --mdb-font-roboto: "Roboto", sans-serif;
        --mdb-bg-opacity: 1;
    }

    :root {
        --mdb-red: #f44336;
        --mdb-pink: #e91e63;
        --mdb-purple: #9c27b0;
        --mdb-indigo: #3f51b5;
        --mdb-blue: #2196f3;
        --mdb-cyan: #00bcd4;
        --mdb-teal: #009688;
        --mdb-green: #4caf50;
        --mdb-yellow: #ffeb3b;
        --mdb-orange: #ff9800;
        --mdb-white: #fff;
        --mdb-black: #000;
        --mdb-gray: #757575;
        --mdb-gray-dark: #4f4f4f;
        --mdb-gray-50: #fbfbfb;
        --mdb-gray-100: #f5f5f5;
        --mdb-gray-200: #eee;
        --mdb-gray-300: #e0e0e0;
        --mdb-gray-400: #bdbdbd;
        --mdb-gray-500: #9e9e9e;
        --mdb-gray-600: #757575;
        --mdb-gray-700: #616161;
        --mdb-gray-800: #4f4f4f;
        --mdb-gray-900: #262626;
        --mdb-primary: #3b71ca;
        --mdb-secondary: #9fa6b2;
        --mdb-success: #14a44d;
        --mdb-danger: #dc4c64;
        --mdb-warning: #e4a11b;
        --mdb-info: #54b4d3;
        --mdb-light: #fbfbfb;
        --mdb-dark: #332d2d;
        --mdb-primary-rgb: 59, 113, 202;
        --mdb-secondary-rgb: 159, 166, 178;
        --mdb-success-rgb: 20, 164, 77;
        --mdb-danger-rgb: 220, 76, 100;
        --mdb-warning-rgb: 228, 161, 27;
        --mdb-info-rgb: 84, 180, 211;
        --mdb-light-rgb: 251, 251, 251;
        --mdb-dark-rgb: 51, 45, 45;
        --mdb-white-rgb: 255, 255, 255;
        --mdb-black-rgb: 0, 0, 0;
        --mdb-body-color-rgb: 79, 79, 79;
        --mdb-body-bg-rgb: 255, 255, 255;
        --mdb-font-sans-serif: system-ui, -apple-system, "Segoe UI", Roboto, "Helvetica Neue", "Noto Sans", "Liberation Sans", Arial, sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol", "Noto Color Emoji";
        --mdb-font-monospace: SFMono-Regular, Menlo, Monaco, Consolas, "Liberation Mono", "Courier New", monospace;
        --mdb-gradient: linear-gradient(180deg, hsla(0, 0%, 100%, 0.15), hsla(0, 0%, 100%, 0));
        --mdb-body-font-family: var(--mdb-font-roboto);
        --mdb-body-font-size: 1rem;
        --mdb-body-font-weight: 400;
    }

    :host, :root {
        --fa-font-solid: normal 900 1em/1 "Font Awesome 6 Free";
    }

    :host, :root {
        --fa-font-regular: normal 400 1em/1 "Font Awesome 6 Free";
    }

    :host, :root {
        --fa-font-brands: normal 400 1em/1 "Font Awesome 6 Brands";
    }
</style>
<body>
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
                        <a href="products" class="logo">
                            <img src="./img/logo.png" alt="">
                        </a>
                    </div>
                </div>
                <!-- /LOGO -->

                <!-- SEARCH BAR -->
                <div class="col-md-6">
                    <div class="header-search">
                        <form>
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
                                    <a href="#">Checkout <i class="fa fa-arrow-circle-right"></i></a>
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
<section style="background-color: #eee;">
    <div class="container py-5">
        <div class="row d-flex justify-content-center align-items-center ">
            <div class="col-10">

                <div class="d-flex justify-content-between align-items-center mb-4">
                    <h3 class="fw-normal mb-0 text-black">Shopping Cart</h3>
<%--                    <div>--%>
<%--                        <p class="mb-0"><span class="text-muted">Sort by:</span> <a href="#!" class="text-body">Price<i--%>
<%--                                class="fas fa-angle-down mt-1">--%>
<%--                        </i></a></p>--%>
<%--                    </div>--%>
                    <div class="dropdown">
                        <a data-toggle="dropdown" aria-expanded="true">
                            <p class="mb-0"><span class="text-muted">Sort by: Price</span>
                                <i class="fas fa-angle-down mt-1"></i></p>
                        </a>
                        <div class="cart-dropdown">
                            <ul>
                                <li><a href="carts?action=sort_in&&id_user=${userLogin.getId_account()}">Increment</a></li>
                                <li><a href="carts?action=sort_de&&id_user=${userLogin.getId_account()}">Decrement</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <c:forEach var="cartDetail" items="${cartDetails}">
                    <div class="card rounded-3 mb-4">
                        <div class="card-body p-4">
                            <div class="row d-flex justify-content-between align-items-center">
                                <div class="col-md-2 col-lg-2 col-xl-2">
                                    <img src="${cartDetail.getProduct().getImage()}"
                                            class="img-fluid rounded-3" alt="image">
                                </div>
                                <div class="col-md-3 col-lg-3 col-xl-3">
                                    <p class="lead fw-normal mb-2">${cartDetail.getProduct().getName()}</p>
                                </div>
                                <div class="col-md-2 col-lg-2 col-xl-2 d-flex" style="width: 12%">
                                    <button class="btn btn-link px-2"
                                            onclick="this.parentNode.querySelector('input[type=number]').stepDown();
                                                    updateQuantity(${cartDetail.getId_cartDetail()},${userLogin.getId_account()})">
                                        <i class="fas fa-minus">
                                        </i>
                                    </button>

                                    <input id="quantity-${cartDetail.getId_cartDetail()}" min="0" name="quantity" value="${cartDetail.getQuantity()}"
                                           onchange="updateQuantity(${cartDetail.getId_cartDetail()},${userLogin.getId_account()})" type="number"
                                           class="form-control form-control-sm" style="width: 50px"/>
                                    <button class="btn btn-link px-2"
                                            onclick="this.parentNode.querySelector('input[type=number]').stepUp();
                                            updateQuantity(${cartDetail.getId_cartDetail()},${userLogin.getId_account()})">
                                        <i class="fas fa-plus">
                                        </i>
                                    </button>
                                </div>
                                <div class="col-md-2 col-lg-2 col-xl-2 " style="width: 12%">
                                    <h5 class="mb-0"><fmt:formatNumber value="${cartDetail.getPrice()}" pattern="#,##0"/></h5>
                                </div>
                                <div class="col-md-2 col-lg-2 col-xl-2 " style="width: 12%">
                                    <h5 class="mb-0"><fmt:formatNumber value="${cartDetail.getTotal_product()}" pattern="#,##0"/></h5>
                                </div>
                                <div class="col-md-1 col-lg-1 col-xl-1 text-end" style="width: 10%" onclick="deleteProduct(${cartDetail.getId_cartDetail()},${userLogin.getId_account()})">
                                    <a class="text-danger"><i class="fas fa-trash fa-lg">
                                    </i></a>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>

                <div class="card">
                    <div class="card-body">
                        <div class="d-flex justify-content-between px-x">
                            <p class="fw-bold mb-3">Discount:</p>
                            <p class="fw-bold mb-3"><fmt:formatNumber value="${discount}" pattern="#,##0"/></p>
                        </div>
                    </div>
                </div>

                <div class="card">
                    <div class="card-body">
                        <div class="d-flex justify-content-between p-2 mb-2"
                             style="background-color: #e1f5fe; font-size: 20px;">
                            <p class="fw-bold mb-3">Total:</p>
                            <p class="fw-bold mb-3"><fmt:formatNumber value="${total}" pattern="#,##0"/></p>
                        </div>
                    </div>
                </div>

                <div class="card">
                    <div class="card-body">
                        <button type="button" class="btn btn-warning btn-block btn-lg"
                                style="width: 100%;font-size: 22px;">Proceed to Pay
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
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
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt
                            ut.</p>
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
								Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i
                            class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com"
                                                                                target="_blank">Colorlib</a>
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
</body>
</html>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/slick.min.js"></script>
<script src="js/nouislider.min.js"></script>
<script src="js/jquery.zoom.min.js"></script>
<script src="js/main.js"></script>
<script>
    function deleteProduct(id_cart, id_account) {
        let flag = confirm("Are you sure?")
        if (flag === true) {
            window.location.href = "carts?action=delete_product_in_cart&id_cartDetail=" + id_cart+"&&id_user="+id_account;
        }
    }
    function updateQuantity(id_cart, id_account) {
        console.log(id_cart)
        var quantity = document.getElementById("quantity-"+id_cart).value;
        window.location.href = "carts?action=update_product_in_cart&id_cartDetail=" +
            id_cart+"&&quantity=" + quantity +"&&id_user="+id_account;
    }
</script>