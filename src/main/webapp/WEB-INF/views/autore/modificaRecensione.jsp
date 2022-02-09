<%@ page import="java.util.List" %>
<%@ page import="Model.Recensione.Recensione" %>
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
    Recensione recensione= (Recensione) request.getAttribute("recensione");
%>

<header>
    <%@include file="/WEB-INF/views/partials/headerCustomer.jsp"%>
</header>

<div class="container mt-3">
    <h2>Recensione <%=recensione.getTitolo()%></h2>
    <br>
    <form action="${pageContext.request.contextPath}/RecensioneServlet" method="post">
        <textarea id="testoModificato" name="testoModificato"><%=recensione.getTesto()%></textarea>
        <button class="btn" style="background-color: turquoise" type="submit" id="salvaModifiche" name="gestioneRecensioni" value="salvaModifiche">Salva</button><input type="hidden" id="codiceModifica" name="codiceModifica" value="<%=recensione.getCodice()%>">
    </form>
</div>

<footer>
    <%@include file="/WEB-INF/views/partials/footerCustomer.jsp"%>
</footer>

</body>
</html>
