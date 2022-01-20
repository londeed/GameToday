<%@ page import="Model.Recensione.Recensione" %>
<%@ page import="java.util.regex.Pattern" %>
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
<body style="background-color: #141414; color: white; font-family: AlumniSans-Italic">
    <%
    Recensione recensione = (Recensione) request.getAttribute("dettaglioRecensione");
%>

<header>
    <%@include file="../partials/headerCustomer.jsp"%>
</header>
    <h1><%=recensione.getTitolo()%></h1>
    <% if (recensione != null ){
            if (recensione.getTitolo().contains(":")) {
                String[] parts = recensione.getTitolo().split(Pattern.quote(":"));
    %>
    <img class="img-responsive" src="./img/<%=parts[0]+parts[1]%>/<%=parts[0]+parts[1]%>-1.jpg" alt="immagineDivertente">
    <%   }else{
    %>
    <img class="img-responsive" src="./img/<%=recensione.getTitolo()%>/<%=recensione.getTitolo()%>-1.jpg" alt="immagineDivertente">
    <%}%>
    <%}%>
    <footer>
        <%@include file="../partials/footerCustomer.jsp"%>
    </footer>
</body>
</html>