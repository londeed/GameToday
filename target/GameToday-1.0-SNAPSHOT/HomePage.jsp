<!DOCTYPE html>
<html lang="it" xmlns="http://www.w3.org/1999/html">
<head>
    <jsp:include page="/WEB-INF/views/partials/head.jsp">
        <jsp:param name="title" value="HomePage"/>
        <jsp:param name="style" value="bootstrap"/>
        <jsp:param name="script" value=""/>
    </jsp:include>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body style="background-color: #141414; color: white; font-family: AlumniSans-Italic">

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
            <img src="./img/download1.jpg" alt="Los Angeles" class="d-block" style="height: 200px; width:100%">
            <div class="carousel-caption">
                <h3>Los Angeles</h3>
                <p>We had such a great time in LA!</p>
            </div>
        </div>
        <div class="carousel-item">
            <img src="./img/download.jpg" alt="Chicago" class="d-block" style="height: 200px; width:100%">
            <div class="carousel-caption">
                <h3>Chicago</h3>
                <p>Thank you, Chicago!</p>
            </div>
        </div>
        <div class="carousel-item">
            <img src="./img/download3.jpg" alt="New York" class="d-block" style="height: 200px; width:100%">
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
<br>
<div class="row" style="width: 100%;">
    <div class="col-sm-4" style="text-align: center">
        <h3>RECENSIONE PIU' COMMENTATA</h3>
        <div class="container mt-3">
            <img src="./img/download1.jpg" class="img-fluid" alt="">
            <p>OKI</p>
        </div>
    </div>
    <div class="col-sm-4" style="text-align: center">
        <h3>RECENSIONE PIU' COMMENTATA</h3>
        <div class="container mt-3">
            <img src="./img/download.jpg" class="img-fluid" alt="">
            <p>OKI</p>
        </div>
    </div>
    <div class="col-sm-4" style="text-align: center">
        <h3>RECENSIONE PIU' COMMENTATA</h3>
        <div class="container mt-3">
            <img src="./img/download3.jpg" class="img-fluid" alt="">
            <p>OKI</p>
        </div>
    </div>
</div>

<footer>
    <%@include file="WEB-INF/views/partials/footerCustomer.jsp"%>
</footer>
</body>
</html>