<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="it" xmlns="http://www.w3.org/1999/html">
<head>
    <style>
        .bg-1 {
            background-color: #1abc9c; /* Green */
            color: #ffffff;
        }

        div > .errorename {
            border: solid red;
            background-color: red;
            color: #141414;
        }

    </style>
    <jsp:include page="/WEB-INF/views/partials/head.jsp">
        <jsp:param name="title" value="Registrazione"/>
        <jsp:param name="style" value=""/>
        <jsp:param name="script" value="controlloRegistrazione"/>
    </jsp:include>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body style="background-color: #141414; color: white; font-family: AlumniSans-Italic">

<header>
    <%@include file="/WEB-INF/views/partials/headerCustomer.jsp"%>
</header>

<div class="container mt-3">
    <br>
    <h2>Inserisci i dati</h2>
    <br>
    <form action="${pageContext.request.contextPath}/utenteProfile/registrazione" onsubmit="event.preventDefault();validateForm(this)" method="post">
        <div class="form-floating mb-3 mt-3">
            <input style="background-color: #141414; color:white" class="form-control" type="text" id="UtNickname" name="UtNickname" placeholder="Nickname">
            <label for="UtNickname">Nickname</label>


            <div id="nickname" class="errorename" style="display: none;">Valore nickname troppo corto</div><br id="nbr" style="display: none;">
            <div id="nicknamelungo" class="errorename" style="display: none;">Valore nickname troppo lungo</div><br id="nbrlungo" style="display: none;">
            <div id="nicknamesbagliato" class="errorename" style="display: none;">Valore nickname non corretto</div><br id="nbrsbagliato" style="display: none;">

        </div>

        <div class="form-floating mb-3 mt-3">
            <input style="background-color: #141414; color:white" class="form-control" type="text" id="UtNome" name="UtNome" placeholder="Nome">
            <label for="UtNome">Nome</label>

            <div id="nome" class="errorename" style="display: none;">Nome troppo corto</div><br id="br" style="display: none;">
            <div id="nomelungo" class="errorename" style="display: none;">Nome troppo lungo</div><br id="brlungo" style="display: none;">
            <div id="nomesbagliato" class="errorename" style="display: none;">Valore nome non corretto</div><br id="brsbagliato" style="display: none;">
        </div>

        <div class="form-floating mb-3 mt-3">
            <input style="background-color: #141414; color:white" class="form-control" type="text" id="UtCognome" name="UtCognome" placeholder="Cognome">
            <label for="UtCognome">Cognome</label>

            <div id="cognome" class="errorename" style="display: none;">Valore cognome troppo corto</div><br id="cbr" style="display: none;">
            <div id="cognomelungo" class="errorename" style="display: none;">Valore cognome troppo lungo</div><br id="cbrlungo" style="display: none;">
            <div id="cognomesbagliato" class="errorename" style="display: none;">Valore cognome non corretto</div><br id="cbrsbagliato" style="display: none;">

        </div>

        <div class="form-floating mb-3 mt-3">
            <input style="background-color: #141414; color:white" class="form-control" type="number" id="UtAvatar" name="UtAvatar" placeholder="Avatar">
            <label for="UtAvatar">Avatar</label>

            <div id="avatarsbagliato" class="errorename" style="display: none;">Valore avatar non scelto</div><br id="abrsbagliato" style="display: none;">

        </div>

        <div class="form-floating mb-3 mt-3">
            <input style="background-color: #141414; color:white" class="form-control" type="text" id="UtEmail" name="UtEmail" placeholder="Email">
            <label for="UtEmail">Email</label>

            <div id="email" class="errorename" style="display: none;">Valore email troppo corto</div><br id="ebr" style="display: none;">
            <div id="emailsbagliato" class="errorename" style="display: none;">Valore email non corretto</div><br id="ebrsbagliato" style="display: none;">


        </div>

        <div class="form-floating mb-3 mt-3">
            <input style="background-color: #141414; color:white" class="form-control" type="text" id="UtPW" name="UtPW" placeholder="Password">
            <label for="UtPW">Password</label>

            <div id="pw" class="errorename" style="display: none;">Valore password troppo corto</div><br id="pbr" style="display: none;">
            <div id="pwlungo" class="errorename" style="display: none;">Valore password troppo lungo</div><br id="pbrlungo" style="display: none;">
            <div id="pwsbagliato" class="errorename" style="display: none;">Valore password non corretto</div><br id="pbrsbagliato" style="display: none;">

        </div>

        <button class="btn" style="background-color: turquoise">Registrati</button>

    </form>
</div>

<footer>
    <%@include file="/WEB-INF/views/partials/footerCustomer.jsp"%>
</footer>
</body>
</html>