<%@ page import="Model.Recensione.Recensione" %>
<%@ page import="java.util.regex.Pattern" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.Commento.Commento" %>
<!DOCTYPE html>
<html lang="it" xmlns="http://www.w3.org/1999/html">
<head>
    <jsp:include page="/WEB-INF/views/partials/head.jsp">
        <jsp:param name="title" value="HomePage"/>
        <jsp:param name="style" value="bootstrap"/>
        <jsp:param name="script" value="aggiungiCommento"/>
    </jsp:include>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body style="background-color: #141414; color: white; font-family: AlumniSans-Italic">
    <%
    Recensione recensione = (Recensione) request.getAttribute("dettaglioRecensione");
    List<Commento> commentoList = (List<Commento>) request.getAttribute("commenti");
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

    <div id="demo" style="width:50%; height: 400%" class="carousel slide mx-auto" data-bs-ride="carousel">

        <!-- Indicators/dots -->
        <div class="carousel-indicators">
            <button type="button" data-bs-target="#demo" data-bs-slide-to="0" class="active"></button>
            <button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
            <button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
        </div>

        <!-- The slideshow/carousel -->
        <div class="carousel-inner">
                <%if (recensione.getTitolo().contains(":")) {
                    String[] parts = recensione.getTitolo().split(Pattern.quote(":"));
                %>
            <div class="carousel-item active">
                <img src="./img/<%=parts[0]+parts[1]%>/<%=parts[0]+parts[1]%>-2.jpg" alt="Pic not found" class="d-block"  style="width:100%; height: 400%">
            </div>
            <div class="carousel-item">
                <img src="./img/<%=parts[0]+parts[1]%>/<%=parts[0]+parts[1]%>-3.jpg" alt="Pic not found" class="d-block"  style="width:100%; height: 400%">
            </div>
            <div class="carousel-item">
                <img src="./img/<%=parts[0]+parts[1]%>/<%=parts[0]+parts[1]%>-4.jpg" alt="Pic not found" class="d-block"  style="width:100%; height: 400%">
            </div>
           <%}else{
                    %>
            <div class="carousel-item active">
            <img src="./img/<%=recensione.getTitolo()%>/<%=recensione.getTitolo()%>-2.jpg" alt="Pic not found" class="d-block"  style="width:100%; height: 400%">
        </div>
        <div class="carousel-item">
            <img src="./img/<%=recensione.getTitolo()%>/<%=recensione.getTitolo()%>-3.jpg" alt="Pic not found" class="d-block"  style="width:100%; height: 400%">
        </div>
        <div class="carousel-item">
            <img src="./img/<%=recensione.getTitolo()%>/<%=recensione.getTitolo()%>-4.jpg" alt="Pic not found" class="d-block"  style="width:100%; height: 400%">
        </div>
           <%}%>
        </div>
        <!-- Left and right controls/icons -->
        <button class="carousel-control-prev" type="button" data-bs-target="#demo" data-bs-slide="prev">
            <span class="carousel-control-prev-icon"></span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#demo" data-bs-slide="next">
            <span class="carousel-control-next-icon"></span>
        </button>
    </div>
<div>
    <div class="container" style="padding: 30px 50px">
      <h3><br><br>Sezione commenti:</h3><br>
        <div class="mb-3" style= "width:50%" >
             <label for="textarea" class="form-label">Scrivi ciò che pensi:</label>
             <textarea class="form-control" id="textarea" rows="3" maxlength="1500"></textarea><br>
            <%String x = ""+recensione.getCodice()+",MarioBros,0,0";%>
             <button type="button" onclick="aggiungiCommento('<%=x%>'); appariNuovoCommento()" id="bottoneCommento">Inserisci il commento</button>
        <!--aggiungiCommento(' recensione.getCodice()');appariNuovoCommento('marioBros','0','0')-->
         </div>
    </div>
    <div class="container" style="padding: 30px 50px" id="commentoUtente"style="color: turquoise">
        <!--<h4 id="utnome"></h4>
        <input class="form-control" type="text" id="utCommento" aria-label="Disabled input example" disabled readonly>
        <div class="row row-cols-lg-auto g-3 align-items-center" style="float: right">
            <div class="col-12">
                <i class="far fa-thumbs-up"></i><p id="utLike"></p>
            </div>
            <div class="col-12">
                <i class="far fa-thumbs-down"></i><p id="utDislike"></p>
            </div>
        </div>-->
    </div>
    <%for(Commento commento: commentoList) {%>
    <div class="container" style="padding: 30px 50px">
        <h4></h4>
        <input class="form-control" type="text" value="<%=commento.getTesto()%>" aria-label="Disabled input example" disabled readonly>
        <div class="row row-cols-lg-auto g-3 align-items-center" style="float: right;padding-top: 10px">
            <div class="col-12">
                <%String like = "true"+","+commento.getComCodice()+","+commento.getLike();%>
                <button id="button<%=commento.getComCodice()%>" onclick="CommentoEsistente(<%=like%>)">
                    <i class="far fa-thumbs-up" id="i<%=commento.getComCodice()%>"><p id="p<%=commento.getComCodice()%>"><%=commento.getLike()%></p></i>
                </button>
            </div>
            <div class="col-12">
                <%String dislike = "false"+","+commento.getComCodice()+","+commento.getDislike();%>
                <button id="button2<%=commento.getComCodice()%>" onclick="CommentoEsistente(<%=dislike%>)">
                    <i class="far fa-thumbs-down" id="i2<%=commento.getComCodice()%>"><p id="p2<%=commento.getComCodice()%>"><%=commento.getDislike()%></p></i>
                </button>
            </div>
        </div>
    </div>

    <%}%>
    <button id="buttongg" onclick="CommentoEsistente('ok')"></button>
</div>
    <footer>
        <%@include file="../partials/footerCustomer.jsp"%>
    </footer>
</body>
</html>

