<!DOCTYPE html>
<html lang="it" xmlns="http://www.w3.org/1999/html">
<head>
    <jsp:include page="/WEB-INF/views/partials/head.jsp">
        <jsp:param name="title" value="Features"/>
        <jsp:param name="style" value="bootstrap"/>
        <jsp:param name="script" value=""/>
    </jsp:include>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body style="background-color: #141414; color: white; font-family: AlumniSans-Italic">
<header>
    <%@include file="/WEB-INF/views/partials/headerCustomer.jsp"%>
</header>
<br>
<br>
<p style="text-align: center">Sul nostro sito potrai trovare:</p>
<p style="text-align: center">Gli ultimi videogiochi per pc,xbox e playstation con annesse recensioni</p>
<p style="text-align: center">Sotto ogni recensione uno spazio dedicato ai commenti</p>
<p style="text-align: center">La possibilit<span>&#224</span> di valutare i titoli e visualizzare la valutazione complessiva dello stesso grazie ai voti della nostra comunity</p>
<p style="text-align: center">Recensioni di qualit<span>&#224</span> scritte dai migliori giornalisti del settore</p>
<p style="text-align: center">Una grande comunity appassionata di videogiochi</p>
<br>
<br>
<footer>
    <%@include file="/WEB-INF/views/partials/footerCustomer.jsp"%>
</footer>
</body>
</html>