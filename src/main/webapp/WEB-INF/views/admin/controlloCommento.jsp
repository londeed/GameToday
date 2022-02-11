<%@ page import="java.util.List" %>
<%@ page import="Model.Commento.Commento" %>
<!DOCTYPE html>
<html lang="it" xmlns="http://www.w3.org/1999/html">
<head>
    <jsp:include page="/WEB-INF/views/partials/head.jsp">
        <jsp:param name="title" value="Controllo Commento"/>
        <jsp:param name="style" value=""/>
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
    List<Commento> commentoList = (List<Commento>) request.getAttribute("lista");
%>

<header>
     <%@include file="/WEB-INF/views/admin/headerAdmin.jsp"%>
</header>

<div class="container mt-3">
    <h2>Lista Recensioni</h2>
    <br>
    <table class="table table-dark">
        <thead>
        <tr>
            <th>CommentoCod</th>
            <th>Testo</th>
            <th>Elimina</th>
        </tr>
        </thead>
        <tbody>
        <%
            for(Commento list : commentoList){
        %>
        <tr>
            <td data-head="Titolo"><%=list.getComCodice()%></td>
            <td data-head="Testo"><%=list.getTesto()%></td>
            <td data-head="Elimina"><form action="${pageContext.request.contextPath}/adminGame/eliminaCom" method="post"><button class="btn" style="background-color: turquoise" type="submit" id="eliminaCom" name="gestioneRecensioni" value="eliminaCom">Elimina</button><input type="hidden" id="codiceElimina" name="codiceElimina" value="<%=list.getComCodice()%>"></form></td>
        </tr>
        <%}%>
        </tbody>
    </table>
</div>

<footer>
    <%@include file="/WEB-INF/views/partials/footerCustomer.jsp"%>
</footer>

</body>
</html>
