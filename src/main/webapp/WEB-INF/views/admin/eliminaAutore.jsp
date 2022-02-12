<%@ page import="Model.Amministratore.Amministratore" %>
<%@ page import="java.util.List" %>
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
        <jsp:param name="title" value="Elimina Autore"/>
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
    List<String> stringList = (List<String>) request.getAttribute("nickname");
%>

<header>
    <%@include file="/WEB-INF/views/admin/headerAdmin.jsp"%>
</header>

<div class="container mt-3">
    <br>
    <h2>Inserisci il nickname dell'autore da eliminare</h2>
    <br>
    <form action="${pageContext.request.contextPath}/adminOp/elimina" method="post">

        <div style="background-color: #141414; color:white">

            <select style="background-color: #141414; color:white" class="form-select form-select-lg" id="AuNickname" name="AuNickname">

                <%
                    int i=0;
                    for(String list : stringList){
                %>

                <option><%= stringList.get(i)%></option>

                <%i++;}%>
            </select>

        </div>

        <br>
        <button class="btn" style="background-color: turquoise">Elimina autore</button>

    </form>
</div>


<footer>
    <%@include file="/WEB-INF/views/admin/footerAdmin.jsp"%>
</footer>
</body>
</html>