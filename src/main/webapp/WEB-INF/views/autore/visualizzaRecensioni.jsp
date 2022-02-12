<%@ page import="java.util.List" %>
<%@ page import="Model.Recensione.Recensione" %>
<!DOCTYPE html>
<html lang="it" xmlns="http://www.w3.org/1999/html">
<head>
    <jsp:include page="/WEB-INF/views/partials/head.jsp">
        <jsp:param name="title" value="Visualizza recensione"/>
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
    List<Recensione> recensioneList= (List<Recensione>) request.getAttribute("listaRecensioni");
%>

<header>
    <%@include file="/WEB-INF/views/partials/headerCustomer.jsp"%>
</header>

<div class="container mt-3">
    <h2>Lista Recensioni</h2>
    <br>
    <table class="table table-dark">
        <thead>
        <tr>
            <th>Titolo</th>
            <th>Testo</th>
            <th>Data Recensione</th>
            <th>Modifica</th>
            <th>Elimina</th>
        </tr>
        </thead>
        <tbody>
        <%
            for(Recensione list : recensioneList){
        %>
        <tr>
            <td data-head="Titolo"><%=list.getTitolo()%></td>
            <td data-head="Testo"><%=list.getTesto()%></td>
            <td data-head="Data"><%=list.getData()%></td>
            <td data-head="Modifica"><form action="${pageContext.request.contextPath}/RecensioneServlet" method="post"><button class="btn" style="background-color: turquoise" type="submit" id="modifica" name="gestioneRecensioni" value="modifica">Modifica</button><input type="hidden" id="codiceModifica" name="codiceModifica" value="<%=list.getCodice()%>"></form></td>
            <td data-head="Elimina"><form action="${pageContext.request.contextPath}/RecensioneServlet" method="post"><button class="btn" style="background-color: turquoise" type="submit" id="elimina" name="gestioneRecensioni" value="elimina">Elimina</button><input type="hidden" id="codiceElimina" name="codiceElimina" value="<%=list.getCodice()%>"></form></td>
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
