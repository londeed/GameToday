<%@ page import="Model.Autore.Autore" %>
<%@ page import="Model.Utente.Utente" %>
<%@ page import="java.util.Objects" %>
<!DOCTYPE html>
<html lang="it" xmlns="http://www.w3.org/1999/html">
<head>
    <jsp:include page="/WEB-INF/views/partials/head.jsp">
        <jsp:param name="title" value="HomePage"/>
        <jsp:param name="style" value=""/>
        <jsp:param name="script" value="login"/>
    </jsp:include>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

    <!--per far funzionare il popup-->
    <link rel="apple-touch-icon" href="/docs/5.1/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
    <link rel="icon" href="/docs/5.1/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
    <link rel="icon" href="/docs/5.1/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
    <link rel="manifest" href="/docs/5.1/assets/img/favicons/manifest.json">
    <link rel="mask-icon" href="/docs/5.1/assets/img/favicons/safari-pinned-tab.svg" color="#7952b3">
    <link rel="icon" href="/docs/5.1/assets/img/favicons/favicon.ico">
    <meta name="theme-color" content="#7952b3">
    <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/modals/">
    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>
    <link href="modals.css" rel="stylesheet">


</head>

<body id="main" style="background-color: #141414; color: white; font-family: AlumniSans-Italic">

<header>
    <%@include file="WEB-INF/views/partials/headerCustomer.jsp"%>
</header>

<div id="demo" class="carousel slide" data-bs-ride="carousel">

    <!-- Indicators/dots -->
    <div class="carousel-indicators">
        <button type="button" data-bs-target="#demo" data-bs-slide-to="0" class="active"></button>
        <button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
        <button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
    </div>

    <!-- The slideshow/carousel -->
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="img/download1.jpg" alt="Los Angeles" class="d-block" style="height: 200px; width:100%">
            <div class="carousel-caption">
                <h3>Los Angeles</h3>
                <p>We had such a great time in LA!</p>
            </div>
        </div>
        <div class="carousel-item">
            <img src="img/download.jpg" alt="Chicago" class="d-block" style="height: 200px; width:100%">
            <div class="carousel-caption">
                <h3>Chicago</h3>
                <p>Thank you, Chicago!</p>
            </div>
        </div>
        <div class="carousel-item">
            <img src="img/download3.jpg" alt="New York" class="d-block" style="height: 200px; width:100%">
            <div class="carousel-caption">
                <h3>New York</h3>
                <p>We love the Big Apple!</p>
            </div>
        </div>
    </div>

    <!-- Left and right controls/icons -->
    <button class="carousel-control-prev" type="button" data-bs-target="#demo" data-bs-slide="prev">
        <span class="carousel-control-prev-icon"></span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#demo" data-bs-slide="next">
        <span class="carousel-control-next-icon"></span>
    </button>
</div>
<br>
<!--div id="appareLogin" style="display: none">-->
<div class="container"  id="appareLogin" style="display: none;position: fixed;z-index: 1;margin: 0px;border:0px;padding-left: 10%;padding-right:10%;max-height: 410px">
    <div className="modal modal-signin position-static d-block bg-secondary py-5" style="background-color: turquoise;width: 100%;height: 100%;max-height: 410px" tabIndex="1" role="dialog" id="modalSignin">
        <div className="modal-dialog" role="document">
            <div className="modal-content rounded-5 shadow">
                <div className="modal-header p-5 pb-4 border-bottom-0">
                    <!-- <h5 class="modal-title">Modal title</h5> -->
                    <h2 className="fw-bold mb-0" style="text-align: center">Sign up for free</h2>
                    <button type="button" className="btn-close" data-bs-dismiss="modal" aria-label="Close"><symbol id="check2-circle" viewBox="0 0 16 16">
                        <path d="M2.5 8a5.5 5.5 0 0 1 8.25-4.764.5.5 0 0 0 .5-.866A6.5 6.5 0 1 0 14.5 8a.5.5 0 0 0-1 0 5.5 5.5 0 1 1-11 0z"></path>
                        <path d="M15.354 3.354a.5.5 0 0 0-.708-.708L8 9.293 5.354 6.646a.5.5 0 1 0-.708.708l3 3a.5.5 0 0 0 .708 0l7-7z"></path>
                    </symbol></button>
                </div>

                <div className="modal-body p-5 pt-0">
                    <!--<form action="${pageContext.request.contextPath}/UserServlet/login" method="post" onsubmit="event.preventDefault(); validateForm(this)">-->
                        <div className="form-floating mb-3">
                            <input type="email" className="form-control rounded-4" style="width: 60%" id="email" name="email" placeholder="name@example.com">
                            <label for="email">Email address</label>
                        </div>
                        <div className="form-floating mb-3">
                            <input type="password" className="form-control rounded-4" style="width: 60%" id="password" name="password" placeholder="Password">
                            <label for="password">Password</label>
                        </div>
                        <button className="w-100 mb-2 btn btn-lg rounded-4 btn-primary" type="button" onclick="event.preventDefault(); validateForm()">Login</button>
                        <small className="text-muted">By clicking Sign up, you agree to the terms of use.</small>
                        <hr className="my-4">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<!--</div>-->
<br>
<div class="row" style="width: 100%;">
    <div class="col-sm-4" style="text-align: center">
        <h3>RECENSIONE PIU' COMMENTATA</h3>
        <div class="container mt-3">
            <img src="img/download1.jpg" class="img-fluid" alt="">
            <p>OKI</p>
        </div>
    </div>
    <div class="col-sm-4" style="text-align: center">
        <h3>RECENSIONE PIU' COMMENTATA</h3>
        <div class="container mt-3">
            <img src="img/download.jpg" class="img-fluid" alt="">
            <p>OKI</p>
        </div>
    </div>
    <div class="col-sm-4" style="text-align: center">
        <h3>RECENSIONE PIU' COMMENTATA</h3>
        <div class="container mt-3">
            <img src="img/download3.jpg" class="img-fluid" alt="">
            <p>OKI</p>
        </div>
    </div>
</div>

<footer>
    <%@include file="WEB-INF/views/partials/footerCustomer.jsp"%>
</footer>
</body>
</html>