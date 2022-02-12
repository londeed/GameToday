<%@ page import="Model.Videogioco.Videogioco" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.Recensione.Recensione" %>
<%@ page import="java.util.regex.Pattern" %>
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
    <style>
        .bottone {
            width: 100%;
            height: 500px;
            background-color: #FF0000;
            background-repeat: no-repeat;
            background-position: center center;
        }
    </style>
</head>

<body id="main" style="background-color: #141414; color: white; font-family: AlumniSans-Italic">

<%
    List<Videogioco> videogiocoList = (List<Videogioco>) request.getAttribute("listaVideogiochi");
    Recensione recensioneCommentata = (Recensione) request.getAttribute("recensioneCommentata");
    Recensione recensioneUltima = (Recensione) request.getAttribute("recensioneUltima");
    Recensione recensionePrima = (Recensione) request.getAttribute("recensionePrima");
%>

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
    <%int i = 0;
        for (Videogioco videogioco : videogiocoList ) {
            if (videogioco.getTitolo().contains(":")) {
                String[] parts = videogioco.getTitolo().split(Pattern.quote(":"));
                    if(i==0){%>
            <div class="carousel-item active">
                <%}else{%>
                <div class="carousel-item">
                    <%}%>
                    <form action="${pageContext.request.contextPath}/VideogiocoServlet" method="post">
                        <button class="bottone" style="background-image: url('./img/<%=parts[0]+parts[1]%>/<%=parts[0]+parts[1]%>-1.jpg');"><input type="hidden" id="dettaglioVideogioco1" name="dettaglioVideogioco" value="<%=videogioco.getTitolo()%>"></button>
                    </form>
                    <!--<img src="./img/<%=parts[0]+parts[1]%>/<%=parts[0]+parts[1]%>-1.jpg" alt="Immagine non trovata" class="d-block" style="height: 500px; width:100%">-->
            <div class="carousel-caption">
                <h3><%=videogioco.getTitolo()%></h3>
                <p>Casa produttrice : <%=videogioco.getCasaProduttrice()%></p>
            </div>
        </div>
    <%}else{
            if(i==0){%>
            <div class="carousel-item active">
                <%}else{%>
                <div class="carousel-item">
                        <%}%>
                    <form action="${pageContext.request.contextPath}/VideogiocoServlet" method="post">
                         <button class="bottone" style="background-image: url('./img/<%=videogioco.getTitolo()%>/<%=videogioco.getTitolo()%>-1.jpg');"><input type="hidden" id="dettaglioVideogioco2" name="dettaglioVideogioco" value="<%=videogioco.getTitolo()%>"></button>
                    </form>
            <!--<img src="./img/<%=videogioco.getTitolo()%>/<%=videogioco.getTitolo()%>-1.jpg" alt="Immagine non trovata" class="d-block" style="height: 500px; width:100%">-->
            <div class="carousel-caption">
                <h3><%=videogioco.getTitolo()%></h3>
                <p>Casa produttrice : <%=videogioco.getCasaProduttrice()%></p>
            </div>
        </div>
    <%}%>
<%i++;}%>
    <!-- Left and right controls/icons -->
    <button class="carousel-control-prev" type="button" data-bs-target="#demo" data-bs-slide="prev">
        <span class="carousel-control-prev-icon"></span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#demo" data-bs-slide="next">
        <span class="carousel-control-next-icon"></span>
    </button>
    </div>
</div>
<br>
<br>
<div class="row" style="width: 100%;">
    <div class="col-sm-4" style="text-align: center">
        <h3>Recensione pi<span>&#250</span> commentata</h3>
        <%if (recensioneCommentata.getTitolo().contains(":")) {
        String[] parts = recensioneCommentata.getTitolo().split(Pattern.quote(":"));%>
        <div class="container mt-3">
            <img src="./img/<%=parts[0]+parts[1]%>/<%=parts[0]+parts[1]%>-1.jpg" class="img-fluid card" alt="Recensione più commentata">
            <br>
            <div><form action="${pageContext.request.contextPath}/RecensioneServlet" method="get"><button class="btn btn-link" style="border: 0px" id="recCommentata1" name="dettaglioRecensione" value="<%=recensioneCommentata.getTitolo()%>">Vai alla recensione</button></form></div>
        </div>
        <%}else{%>
        <div class="container mt-3">
            <img src="./img/<%=recensioneCommentata.getTitolo()%>/<%=recensioneCommentata.getTitolo()%>-1.jpg" class="img-fluid card" alt="Recensione più commentata">
            <br>
            <div><form action="${pageContext.request.contextPath}/RecensioneServlet" method="get"><button class="btn btn-link" style="border: 0px" id="recCommentata2" name="dettaglioRecensione" value="<%=recensioneCommentata.getTitolo()%>">Vai alla recensione</button></form></div>
        </div>
        <%}%>
    </div>
    <div class="col-sm-4" style="text-align: center">
        <h3>Ultima recensione</h3>
        <%if (recensioneUltima.getTitolo().contains(":")) {
            String[] parts = recensioneUltima.getTitolo().split(Pattern.quote(":"));%>
        <div class="container mt-3">
            <img src="./img/<%=parts[0]+parts[1]%>/<%=parts[0]+parts[1]%>-1.jpg" class="img-fluid card" alt="Ultima recensione">
            <br>
            <div><form action="${pageContext.request.contextPath}/RecensioneServlet" method="get"><button class="btn btn-link" style="border: 0px" id="ultRecensione1" name="dettaglioRecensione" value="<%=recensioneUltima.getTitolo()%>">Vai alla recensione</button></form></div>
        </div>
        <%}else{%>
        <div class="container mt-3">
            <img src="./img/<%=recensioneUltima.getTitolo()%>/<%=recensioneUltima.getTitolo()%>-1.jpg" class="img-fluid card" alt="Ultima recensione">
            <br>
            <div><form action="${pageContext.request.contextPath}/RecensioneServlet" method="get"><button class="btn btn-link" style="border: 0px" id="ultRecensione2" name="dettaglioRecensione" value="<%=recensioneUltima.getTitolo()%>">Vai alla recensione</button></form></div>
        </div>
        <%}%>
    </div>
    <div class="col-sm-4" style="text-align: center">
        <h3>Prima recensione del sito</h3>
        <%if (recensionePrima.getTitolo().contains(":")) {
            String[] parts = recensionePrima.getTitolo().split(Pattern.quote(":"));%>
        <div class="container mt-3">
            <img src="./img/<%=parts[0]+parts[1]%>/<%=parts[0]+parts[1]%>-1.jpg" class="img-fluid card" alt="Prima recensione">
            <br>
            <div><form action="${pageContext.request.contextPath}/RecensioneServlet" method="get"><button class="btn btn-link" style="border: 0px" id="primaRec1" name="dettaglioRecensione" value="<%=recensionePrima.getTitolo()%>">Vai alla recensione</button></form></div>
        </div>
        <%}else{%>
        <div class="container mt-3">
            <img src="./img/<%=recensionePrima.getTitolo()%>/<%=recensionePrima.getTitolo()%>-1.jpg" class="img-fluid card" alt="Prima Recensione">
            <br>
            <div><form action="${pageContext.request.contextPath}/RecensioneServlet" method="get"><button class="btn btn-link" style="border: 0px" id="primaRec2" name="dettaglioRecensione" value="<%=recensionePrima.getTitolo()%>">Vai alla recensione</button></form></div>
        </div>
        <%}%>
    </div>
</div>

<footer>
    <%@include file="WEB-INF/views/partials/footerCustomer.jsp"%>
</footer>
</body>
</html>