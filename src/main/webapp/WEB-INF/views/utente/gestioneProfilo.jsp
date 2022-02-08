<%@ page import="Model.Utente.Utente" %>
<!DOCTYPE html>
<html lang="it" xmlns="http://www.w3.org/1999/html">
<head>
    <jsp:include page="/WEB-INF/views/partials/head.jsp">
        <jsp:param name="title" value="Gestione Profilo"/>
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
    Utente utente = (Utente) request.getAttribute("utente");
%>

<header>
    <%@include file="/WEB-INF/views/partials/headerCustomer.jsp"%>
</header>

<div class="container mt-3">
    <h2>Dettaglio Profilo</h2>
    <br>
    <table class="table table-dark">
        <thead>
        <tr>
            <th>Nickname</th>
            <th>Nome</th>
            <th>Cognome</th>
            <th>Valutazioni effettuate</th>
            <th>Email</th>
            <th>Like totali</th>
            <th>Dislike totali</th>
            <th>Avatar</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td data-head="Nickname"><%=utente.getUtNickname()%></td>
            <td data-head="Nome"><%=utente.getNome()%></td>
            <td data-head="Cognome"><%=utente.getCognome()%></td>
            <td data-head="Avatar"><%=utente.getValEffettuate()%></td>
            <td data-head="Email"><%=utente.getEmail()%></td>
            <td data-head="Password"><%=utente.getLike()%></td>
            <td data-head="Videogiochi inserti"><%=utente.getDislike()%></td>
            <td data-head="Avatar"><%=utente.getAvatar()%></td>
        </tr>
        </tbody>
    </table>

    <form action="${pageContext.request.contextPath}/utenteProfile/" method="get">
        <button class="btn" style="background-color: turquoise" type="submit" id="modificaProfilo" name="gestioneUtente" value="modificaProfilo">Modifica Profilo</button>
        <button class="btn" style="background-color: turquoise" type="submit" id="eliminaProfilo" name="gestioneUtente" value="eliminaProfilo">Elimina Profilo</button>
    </form>
</div>


<footer>
    <%@include file="/WEB-INF/views/partials/footerCustomer.jsp"%>
</footer>

</body>
</html>
