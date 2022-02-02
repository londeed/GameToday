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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body style="background-color: #141414; color: white; font-family: AlumniSans-Italic">
<%
    Amministratore amministratore = (Amministratore) request.getAttribute("amministratore");
%>

<header>
    <%@include file="/WEB-INF/views/admin/headerAdmin.jsp"%>
</header>

<!-- <section class="field" style="padding: 70px">
    <h2>Inserisci le informazioni del nuovo autore:</h2>
    <br>
    <form action="${pageContext.request.contextPath}/adminOp/create" method="post">

        <div class="form-floating mb-3 mt-3">
            <input style="background-color: #141414" class="form-control" type="text" id="AuNickname" name="AuNicknameext" placeholder="Nickname va qui">
            <label for="AuNickname">Nickname</label>
        </div>
        <br>

        <div class="form-floating mb-3 mt-3">
            <input style="background-color: #141414" class="form-control" type="text" id="AuNome" name="AuNome" placeholder="Nome">
            <label for="AuNome">Nome</label>
        </div>
        <br>

        <div class="form-floating mb-3 mt-3">
            <input style="background-color: #141414" class="form-control" type="text" id="AuCognome" name="AuCognome" placeholder="Cognome>
            <label for="AuCognome">Cognome</label>
        </div>
        <br>

        <div class="form-floating mb-3 mt-3">
            <input style="background-color: #141414" class="form-control" type="number" id="AuAvatar" name="AuAvatar" placeholder="Avatar>
            <label for="AuAvatar">Avatar</label>
        </div>
        <br>

        <div class="form-floating mb-3 mt-3">
            <input style="background-color: #141414" class="form-control" type="text" id="AuEmail" name="AuEmail" placeholder="Email>
            <label for="AuEmail">Email</label>
        </div>
        <br>

        <div class="form-floating mb-3 mt-3">
            <input style="background-color: #141414" class="form-control" type="text" id="AuPW" name="AuPW" placeholder="Password>
            <label for="AuPW ">Password</label>
        </div>
        <br>

        <div class="form-floating mb-3 mt-3">
            <input style="background-color: #141414" class="form-control" type="text" id="RecCommissionate" name="RecCommissionate" placeholder="Recensioni Commissionate">
            <label for="RecCommissionate">Recensioni Commissionate</label>
        </div>
        <br>

        <div class="form-floating mb-3 mt-3">
            <input style="background-color: #141414" class="form-control" type="date" name="Scadenza" id="Scadenza" placeholder="Scadenza">
            <label for="Scadenza">Scadenza</label>
        </div>
        <br>

        <button class="btn" style="background-color: turquoise">Inserisci</button>
    </form>
</section> -->

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
        <button class="premi">Inserisci</button>
    </form>
</section>


<footer>
    <%@include file="/WEB-INF/views/admin/footerAdmin.jsp"%>
</footer>
</body>
</html>
