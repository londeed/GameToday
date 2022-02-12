<%@ page import="Model.Amministratore.Amministratore" %>
<%@ page import="Model.Autore.AutoreDAO" %>
<%@ page import="Model.Autore.Autore" %>
<%@ page import="java.util.List" %>
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
    Amministratore amministratore = (Amministratore) request.getAttribute("amministratore");
%>

<header>
    <%@include file="/WEB-INF/views/admin/headerAdmin.jsp"%>
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
        <th>Avatar</th>
        <th>Email</th>
        <th>Password</th>
        <th>Videogiochi inseriti</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td data-head="Nickname"><%=amministratore.getAmNickname()%></td>
        <td data-head="Nome"><%=amministratore.getNome()%></td>
        <td data-head="Cognome"><%=amministratore.getCognome()%></td>
        <td data-head="Avatar"><%=amministratore.getAvatar()%></td>
        <td data-head="Email"><%=amministratore.getEmail()%></td>
        <td data-head="Password"><%=amministratore.getPassword()%></td>
        <td data-head="Videogiochi inserti"><%=amministratore.getVideogiochiInseriti()%></td>
    </tr>
    </tbody>
</table>

<form action="${pageContext.request.contextPath}/adminProfile/" method="get">
    <button class="btn" style="background-color: turquoise" type="submit" id="modificaProfilo" name="gestioneAmministratore" value="modificaProfilo">Modifica Profilo</button>
    <button class="btn" style="background-color: turquoise" type="submit" id="eliminaProfilo" name="gestioneAmministratore" value="eliminaProfilo">Elimina Profilo</button>
</form>

<footer>
    <%@include file="/WEB-INF/views/admin/footerAdmin.jsp"%>
</footer>
</body>
</html>