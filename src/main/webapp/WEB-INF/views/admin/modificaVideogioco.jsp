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
        <jsp:param name="title" value="Modifica Videogioco"/>
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
    List<String> stringList = (List<String>) request.getAttribute("titoli");
%>

<header>
    <%@include file="/WEB-INF/views/admin/headerAdmin.jsp"%>
</header>

<div class="container mt-3">
    <br>
    <h2>Modifica le informazioni</h2>
    <br>
    <form action="${pageContext.request.contextPath}/adminGame/modifica" method="post">

        <div style="background-color: #141414; color:white">
            <!-- <h6>Scegli il titolo del videogioco da modificare:</h6> -->
            <select style="background-color: #141414; color:white" class="form-select form-select-lg" id="Titolo" name="Titolo">

                <%
                    int i=0;
                    for(String list : stringList){
                %>

                <option><%= stringList.get(i)%></option>

                <%i++;}%>
            </select>

        </div>

        <!--
        <div class="form-floating mb-3 mt-3">
            <input style="background-color: #141414; color:white" class="form-control" type="text" id="Titolo" name="Titolo" placeholder="Titolo">
            <label for="Titolo">Titolo</label>
        </div> -->
        <br>
        <div style="background-color: #141414; color:white">
            <select style="background-color: #141414; color:white" class="form-select form-select-lg" id="Pegi" name="Pegi" >
                <option>12</option>
                <option>16</option>
                <option>18</option>
            </select>

        </div>

        <!--
        <div class="form-floating mb-3 mt-3">
            <input style="background-color: #141414; color:white" class="form-control" type="number" id="Pegi" name="Pegi" placeholder="Pegi">
            <label for="Pegi">Pegi</label>
        </div>-->
        <div class="form-floating mb-3 mt-3">
            <input style="background-color: #141414; color:white" class="form-control" type="text" id="CasaProduttrice" name="CasaProduttrice" placeholder="Casa Produttrice">
            <label for="CasaProduttrice">Casa Produttrice</label>
        </div>

        <div style="background-color: #141414; color:white">
            <select style="background-color: #141414; color:white" class="form-select form-select-lg" id="Piattaforma" name="Piattaforma" >
                <option>PC</option>
                <option>PlayStation 4</option>
                <option>Xbox One</option>
            </select>

        </div>


        <!--
        <div class="form-floating mb-3 mt-3">
            <input style="background-color: #141414; color:white" class="form-control" type="text" id="Piattaforma" name="Piattaforma" placeholder="Piattaforma">
            <label for="Piattaforma">Piattaforma</label>
        </div>-->

        <div class="form-floating mb-3 mt-3">
            <input style="background-color: #141414; color:white" class="form-control" type="text" id="Tipologia" name="Tipologia" placeholder="Tipologia">
            <label for="Tipologia">Tipologia</label>
        </div>

        <button class="btn" style="background-color: turquoise">Modifica videogioco</button>

    </form>
</div>

<!-- <section class="field">
    <form action="${pageContext.request.contextPath}/adminGame/modifica" method="post">
        <label for="Titolo">
            <input type="text" name="Titolo" id="Titolo" placeholder="Titolo">
        </label>
        <label for="Pegi">
            <input type="number" name="Pegi" id="Pegi" placeholder="Pegi">
        </label>
        <label for="TotaleVoti">
            <input type="number" name="TotaleVoti" id="TotaleVoti" placeholder="Totale Voti">
        </label>
        <label for="CasaProduttrice">
            <input type="text" name="CasaProduttrice" id="CasaProduttrice" placeholder="Casa Produttrice">
        </label>
        <label for="MediaValutazioni">
            <input type="number" name="MediaValutazioni" id="MediaValutazioni" placeholder="Media Valutazioni">
        </label>
        <label for="Piattaforma">
            <input type="text" name="Piattaforma" id="Piattaforma" placeholder="Piattaforma">
        </label>
        <label for="DataPubblicazione">
            <input type="date" name="DataPubblicazione" id="DataPubblicazione" placeholder="Data Pubblicazione">
        </label>
        <label for="Tipologia">
            <input type="text" name="Tipologia" id="Tipologia" placeholder="Tipologia">
        </label>
        <button class="premi">Modifica</button>
    </form>
</section> -->


<footer>
    <%@include file="/WEB-INF/views/admin/footerAdmin.jsp"%>
</footer>
</body>
</html>
