<%@ page import="Model.Recensione.Recensione" %>
<%@ page import="java.util.regex.Pattern" %>
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
    <%
    Recensione recensione = (Recensione) request.getAttribute("dettaglioRecensione");
%>

<header>
    <%@include file="../partials/headerCustomer.jsp"%>
</header>
    <h1 style="text-align: center; padding: 10px"><%=recensione.getTitolo()%></h1>
    <% if (recensione != null ){
            if (recensione.getTitolo().contains(":")) {
                String[] parts = recensione.getTitolo().split(Pattern.quote(":"));
    %>
    <div class="card shadow-sm mx-auto" style="width: 50%; height: 35%">
    <img class="img-responsive" src="./img/<%=parts[0]+parts[1]%>/<%=parts[0]+parts[1]%>-1.jpg" alt="immagineDivertente">
    </div>
            <%   }else{
    %>
    <div class="card shadow-sm mx-auto" style="width: 50%; height: 35%" >
    <img class="img-responsive" src="./img/<%=recensione.getTitolo()%>/<%=recensione.getTitolo()%>-1.jpg" alt="immagineDivertente">
    </div>
    <%}%>
    <%}%>
    <div class="container" style="padding: 30px 50px">
        <p style="text-align: center"><%=recensione.getTesto()%></p>
        <blockquote class="blockquote-footer">
            <p><%=recensione.getAuNickname()%></p>
        </blockquote>
    </div>
    <!--<div class="container mx-auto" style="padding: 30px 50px">
        <div id="carouselExampleIndicators" class="carousel slide mx-auto" data-bs-ride="carousel">
            <div class="carousel-indicators">
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
            </div>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="./img/download1.jpg" class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                    <img src="./img/download.jpg" class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                    <img src="./img/download3.jpg" class="d-block w-100" alt="...">
                </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>
    </div>-->

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
            </div>
            <div class="carousel-item">
                <img src="./img/download.jpg" alt="Chicago" class="d-block" style="height: 200px; width:100%">
            </div>
            <div class="carousel-item">
                <img src="./img/download3.jpg" alt="New York" class="d-block" style="height: 200px; width:100%">
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

    <footer>
        <%@include file="../partials/footerCustomer.jsp"%>
    </footer>
</body>
</html>