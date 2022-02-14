<!DOCTYPE html>
<html lang="it" xmlns="http://www.w3.org/1999/html">
<head>
    <jsp:include page="/WEB-INF/views/partials/head.jsp">
        <jsp:param name="title" value="Scrivi recensione"/>
        <jsp:param name="style" value=""/>
        <jsp:param name="script" value="inserisciRecensione"/>
    </jsp:include>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

    <style>
        form > .errorename {
            border: solid red;
            background-color: red;
            color: #141414;
        }
    </style>

</head>
<body style="background-color: #141414; color: white; font-family: AlumniSans-Italic">

<%
    String titolo= (String) request.getAttribute("titolo");
%>

<header>
    <%@include file="/WEB-INF/views/partials/headerCustomer.jsp"%>
</header>

<div class="container mt-3">
    <h2>Recensisci <%=titolo%></h2>
    <h5>La recensione dovr<span>&#224</span> rispettare le seguenti linee guida:</h5>
    <h5>1) La recensione dovr<span>&#224</span> essere imparziale tralasciando le opinione soggettive e concentrandosi sulla valutazione oggettiva del prodotto</h5>
    <h5>2) La recensione dovr<span>&#224</span> rispettare gli utenti e gli svilupppatori</h5>
    <h5>3) La recensione non dovr<span>&#224</span> contenere espressioni volgari</h5>
    <h6><b>Gli amministratori elimineranno le recensioni che non rispettano le linee guida</b></h6>
    <br>
    <form action="${pageContext.request.contextPath}/RecensioneServlet" method="post" onsubmit="event.preventDefault();validateForm(this)" enctype=multipart/form-data>
        <h5>Inserisci la prima immagine di gameplay</h5>
        <br>
        <div>
            <input style="background-color: #141414; color:white" class="form-control" type="file" id="Imgone" name="Img" placeholder="Immagine">
        </div>
        <br>
        <h5>Inserisci la seconda immagine di gameplay</h5>
        <br>
        <div>
            <input style="background-color: #141414; color:white" class="form-control" type="file" id="Imgtwo" name="Img" placeholder="Immagine">
        </div>
        <br>
        <h5>Inserisci la terza immagine di gameplay</h5>
        <br>
        <div>
            <input style="background-color: #141414; color:white" class="form-control" type="file" id="Imgthree" name="Img" placeholder="Immagine">
        </div>
        <br>
        <textarea id="testoInserito" name="testoInserito" rows="5" style="resize: none;width: 100%;height: 40%" minlength="500" maxlength="3000"></textarea>
        <br>

        <div id="inserito" class="errorename" style="display: none;">Valore testo nullo</div><br id="tbr" style="display: none;">

        <button class="btn" style="background-color: turquoise" type="submit" id="inserisciRec" name="gestioneRecensioni" value="inserisciRec">Inserisci</button><input type="hidden" id="codiceRec" name="codiceRec" value="<%=titolo%>">
    </form>
</div>

<footer>
    <%@include file="/WEB-INF/views/partials/footerCustomer.jsp"%>
</footer>

</body>
</html>
