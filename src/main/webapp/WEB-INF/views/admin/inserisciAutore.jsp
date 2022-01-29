<%@ page import="Model.Amministratore.Amministratore" %>
<!DOCTYPE html>
<html lang="it" xmlns="http://www.w3.org/1999/html">
<head>
    <style>
        .bg-1 {
            background-color: #1abc9c; /* Green */
            color: #ffffff;
        }
    </style>
    <jsp:include page="/WEB-INF/views/partials/head.jsp">
        <jsp:param name="title" value="inserisciAutore"/>
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
    Amministratore amministratore = (Amministratore) request.getAttribute("amministratore");
%>

<header>
    <%@include file="/WEB-INF/views/admin/headerAdmin.jsp"%>
</header>

<section class="field">
    <form action="${pageContext.request.contextPath}/adminOp/create" method="post">
        <label for="AuNickname">
            <input type="text" name="AuNickname" id="AuNickname" placeholder="Nickname">
        </label>
        <label for="AuNome">
            <input type="text" name="AuNome" id="AuNome" placeholder="Nome">
        </label>
        <label for="AuCognome">
            <input type="text" name="AuCognome" id="AuCognome" placeholder="Cognome">
        </label>
        <label for="AuAvatar">
            <input type="number" name="AuAvatar" id="AuAvatar" placeholder="Avatar">
        </label>
        <label for="REffettuate">
            <input type="number" name="REffettuate" id="REffettuate" placeholder="Recensioni effettuate">
        </label>
        <label for="RCommissionate">
            <input type="text" name="RCommissionate" id="RCommissionate" placeholder="Recensioni commissionate">
        </label>
        <label for="AuEmail">
            <input type="text" name="AuEmail" id="AuEmail" placeholder="Email">
        </label>
        <label for="Scadenza">
            <input type="date" name="Scadenza" id="Scadenza" placeholder="Scadenza">
        </label>
        <label for="AuPW">
            <input type="text" name="AuPW" id="AuPW" placeholder="Password">
        </label>
        <label for="AuLike">
            <input type="number" name="AuLike" id="AuLike" placeholder="Numero like">
        </label>
        <label for="AuDislike">
            <input type="number" name="AuDislike" id="AuDislike" placeholder="Numero dislike">
        </label>
        <button class="premi">Inserisci</button>
    </form>
</section>


<footer>
    <%@include file="/WEB-INF/views/admin/footerAdmin.jsp"%>
</footer>
</body>
</html>
