<%@ page import="Model.Recensione.Recensione" %>
<%@ page import="java.util.regex.Pattern" %>
<%@ page import="Model.Videogioco.Videogioco" %>
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
<body style="background-color: #141414; color: white; font-family: AlumniSans-Italic; text-align: center">
<%
    Videogioco videogioco = (Videogioco) request.getAttribute("dettaglioVideogioco");
%>

<header>
    <%@include file="../partials/headerCustomer.jsp"%>
</header>
<div class="row">
    <div class="col">
<% if (videogioco != null ){
    if (videogioco.getTitolo().contains(":")) {
        String[] parts = videogioco.getTitolo().split(Pattern.quote(":"));
%>
        <div class="card shadow-sm" style="padding-top: 50px">
<img class="img-responsive" src="./img/<%=parts[0]+parts[1]%>/<%=parts[0]+parts[1]%>-1.jpg"  alt="immagineDivertente">
        </div>
<%   }else{
%>
        <div class="card shadow-sm" style="padding-top: 50px">
<img class="img-responsive" src="./img/<%=videogioco.getTitolo()%>/<%=videogioco.getTitolo()%>-1.jpg"  alt="immagineDivertente">
        </div>
            <%}%>
<%}%>
    </div>
    <div class="col">
<ul>
    <h1><%=videogioco.getTitolo()%></h1>
    <p><%=videogioco.getCasaProduttrice()%></p>
    <p><%=videogioco.getPegi()%></p>
    <p><%=videogioco.getTipologia()%></p>
    <p><%=videogioco.getTotaleVoti()%></p>
    <p><%=videogioco.getPiattaforma()%></p>
    <p><%=videogioco.getDataPubblicazione()%></p>
</ul>
    </div>
</div>
<footer>
    <%@include file="../partials/footerCustomer.jsp"%>
</footer>
</body>
</html>
