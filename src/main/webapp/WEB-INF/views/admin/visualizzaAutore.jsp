<%@ page import="Model.Amministratore.Amministratore" %>
<%@ page import="Model.Autore.AutoreDAO" %>
<%@ page import="Model.Autore.Autore" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="it" xmlns="http://www.w3.org/1999/html">
<head>
    <jsp:include page="/WEB-INF/views/partials/head.jsp">
        <jsp:param name="title" value="Visualizza Autore"/>
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
    List<Autore> autori=(List<Autore>) request.getAttribute("autori");
%>

<header>
    <%@include file="/WEB-INF/views/admin/headerAdmin.jsp"%>
</header>


<div class="container mt-3">
    <h2>Dettaglio Autori</h2>
    <br>
<table class="table table-dark">
    <thead>
    <tr>
        <th>Nickname</th>
        <th>Nome</th>
        <th>Cognome</th>
        <th>Avatar</th>
        <th>Rec. Effettuate</th>
        <th>Rec. Commissionate</th>
        <th>Email</th>
        <th>Scadenza</th>
        <th>Password</th>
        <th>N. Like</th>
        <th>N. Dislike</th>
    </tr>
    </thead>
    <tbody>
    <%
        int i=0;
        for(Autore list : autori){
    %>
    <tr>
        <td data-head="Nickname"><%=list.getAuNickname()%></td>
        <td data-head="Nome"><%=list.getNome()%></td>
        <td data-head="Cognome"><%=list.getCognome()%></td>
        <td data-head="Avatar"><%=list.getAvatar()%></td>
        <td data-head="Recensioni Effettuate"><%=list.getRecEffettuate()%></td>
        <td data-head="Recensioni Commissionate"><%=list.getRecCommissionate()%></td>
        <td data-head="Email"><%=list.getEmail()%></td>
        <td data-head="Scadenza"><%=list.getScadenza()%></td>
        <td data-head="Password"><%=list.getPassword()%></td>
        <td data-head="Numero di Like"><%=list.getLike()%></td>
        <td data-head="Numero di Dislike"><%=list.getDislike()%></td>
    </tr>
    <%i++;}%>
    </tbody>
</table>
</div>

<footer>
    <%@include file="/WEB-INF/views/admin/footerAdmin.jsp"%>
</footer>
</body>
</html>