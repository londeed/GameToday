<%@ page import="java.util.List" %>
<%@ page import="Model.Recensione.Recensione" %>
<%@ page import="Model.Videogioco.Videogioco" %>
<%@ page import="Model.Videogioco.VideogiocoDAO" %>
<%@ page import="java.util.regex.Pattern" %>
<!DOCTYPE html>
<html lang="it" xmlns="http://www.w3.org/1999/html">
<head>
    <jsp:include page="/WEB-INF/views/partials/head.jsp">
        <jsp:param name="title" value="Seleziona Recensione"/>
        <jsp:param name="style" value="bootstrap"/>
        <jsp:param name="script" value=""/>
    </jsp:include>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body style="background-color: #141414; color: white; font-family: AlumniSans-Italic">

<%
    List<Videogioco> videogicoList= (List<Videogioco>) request.getAttribute("lista");
    Autore autoreRec= (Autore) request.getAttribute("RecCommissionata");
%>

<header>
    <%@include file="/WEB-INF/views/partials/headerCustomer.jsp"%>
</header>

<%
    if(autoreRec.getRecCommissionate().equals("")){

%>

<div class="container mt-3">
    <h2>Lista Videogiochi da Recensire</h2>
    <br>
    <table class="table table-dark">
        <thead>
        <tr>
            <th>Titolo</th>
            <th>Immagine</th>
            <th>Pegi</th>
            <th>Casa Produttrice</th>
            <th>Piattaforma</th>
            <th>Data Pubblicazione</th>
            <th>Tipologia</th>
            <th>Seleziona</th>
        </tr>
        </thead>
        <tbody>
        <%
            for(Videogioco list : videogicoList){
        %>
        <tr>
            <td data-head="Titolo"><%=list.getTitolo()%></td>
            <%
            if (list.getTitolo().contains(":")) {
            String[] parts = list.getTitolo().split(Pattern.quote(":"));%>
            <td data-head="Immagine"><img src="./img/<%=parts[0]+parts[1]%>/<%=parts[0]+parts[1]%>-1.jpg" width="70px" height="50px"></td>
            <%}else{%>
                <td data-head="Immagine"><img src="./img/<%=list.getTitolo()%>/<%=list.getTitolo()%>-1.jpg" width="70px" height="50px"></td>
            <%}%>
            <td data-head="Testo"><%=list.getPegi()%></td>
            <td data-head="Data"><%=list.getCasaProduttrice()%></td>
            <td data-head="Titolo"><%=list.getPiattaforma()%></td>
            <td data-head="Testo"><%=list.getDataPubblicazione()%></td>
            <td data-head="Data"><%=list.getTipologia()%></td>
            <td data-head="Seleziona"><form action="${pageContext.request.contextPath}/RecensioneServlet" method="post"><button class="btn" style="background-color: turquoise" type="submit" id="seleziona" name="gestioneRecensioni" value="seleziona">Seleziona</button><input type="hidden" id="titolo" name="titolo" value="<%=list.getTitolo()%>"></form></td>
        </tr>
        <%}
        %>
        </tbody>
    </table>
</div>

<%}else{%>

<div class="container mt-3">
    <h2>Recensione Selezionata</h2>
    <br>
    <table class="table table-dark">
        <thead>
        <tr>
            <th>Titolo</th>
            <th>Immagine</th>
            <th>Seleziona</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td data-head="Titolo"><%=autoreRec.getRecCommissionate()%></td>
            <%
                if (autoreRec.getRecCommissionate().contains(":")) {
                    String[] parts = autoreRec.getRecCommissionate().split(Pattern.quote(":"));%>
            <td data-head="Immagine"><img src="./img/<%=parts[0]+parts[1]%>/<%=parts[0]+parts[1]%>-1.jpg" width="70px" height="50px"></td>
            <%}else{%>
            <td data-head="Immagine"><img src="./img/<%=autoreRec.getRecCommissionate()%>/<%=autoreRec.getRecCommissionate()%>-1.jpg" width="70px" height="50px"></td>
            <%}%>
            <td data-head="Seleziona"><form action="${pageContext.request.contextPath}/RecensioneServlet" method="post"><button class="btn" style="background-color: turquoise" type="submit" id="scrivi" name="gestioneRecensioni" value="scrivi">Scrivi</button><input type="hidden" id="titoloRec" name="titoloRec" value="<%=autoreRec.getRecCommissionate()%>"></form></td>
        </tr>
        </tbody>
    </table>
</div>

<%}%>

<footer>
    <%@include file="/WEB-INF/views/partials/footerCustomer.jsp"%>
</footer>

</body>
</html>
