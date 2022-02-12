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
        <jsp:param name="title" value="Inserisci Videogioco"/>
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

<header>
    <%@include file="/WEB-INF/views/admin/headerAdmin.jsp"%>
</header>

<div class="container mt-3">
    <br>
    <h2>Inserisci le credenziali del nuovo videogioco</h2>
    <br>
    <form action="${pageContext.request.contextPath}/adminGame/create" enctype=multipart/form-data method="post">
        <div class="form-floating mb-3 mt-3">
            <input style="background-color: #141414; color:white" class="form-control" type="text" id="Titolo" name="Titolo" placeholder="Titolo">
            <label for="Titolo">Titolo</label>
        </div>


        <div style="background-color: #141414; color:white">
            <select style="background-color: #141414; color:white" class="form-select form-select-lg" id="Pegi" name="Pegi" >
                <option>12</option>
                <option>16</option>
                <option>18</option>
            </select>

        </div>

        <div class="form-floating mb-3 mt-3">
            <input style="background-color: #141414; color:white" class="form-control" type="text" id="CasaProduttrice" name="CasaProduttrice" placeholder="CasaProduttrice">
            <label for="CasaProduttrice">Casa Produttrice</label>
        </div>



        <div style="background-color: #141414; color:white">
            <select style="background-color: #141414; color:white" class="form-select form-select-lg" id="Piattaforma" name="Piattaforma" >
                <option>PC</option>
                <option>PlayStation 4</option>
                <option>Xbox One</option>
            </select>

        </div>

        <div class="form-floating mb-3 mt-3">
            <input style="background-color: #141414; color:white" class="form-control" type="text" id="Tipologia" name="Tipologia" placeholder="Tipologia">
            <label for="Tipologia">Tipologia</label>
        </div>

        <div class="form-floating mb-3 mt-3">
            <input style="background-color: #141414; color:white" class="form-control" type="date" name="DataPubblicazione" id="DataPubblicazione" placeholder="DataPubblicazione">
            <label for="DataPubblicazione">Data Pubblicazione</label>
        </div>

        <h5>Inserisci un immagine di copertina</h5>
        <div>
            <input style="background-color: #141414; color:white" class="form-control" type="file" id="Img" name="Img" placeholder="Immagine">
        </div>
        <br>
        <button class="btn" style="background-color: turquoise">Inserisci</button>

    </form>
</div>

<footer>
    <%@include file="/WEB-INF/views/admin/footerAdmin.jsp"%>
</footer>
</body>
</html>
