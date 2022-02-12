<!DOCTYPE html>
<html lang="it" xmlns="http://www.w3.org/1999/html">
<head>
    <jsp:include page="/WEB-INF/views/partials/head.jsp">
        <jsp:param name="title" value="About Us"/>
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
<p style="text-align: center">Siamo una testata giornalistica di recensioni videoludiche, concentrata ad offrire recensioni quanto pi<span>&#249</span> oggettive e accurate possibili.</p>
<p style="text-align: center">Il nostro obiettivo <span>&#232</span> quello di fornirvi un'esperienza piacevole e appagante nella lettura e nel navigare il sito. </p>
<p style="text-align: center">Quindi divertitevi e iscrivetevi se ancora non lo avete fatto, per usufruire della massima esperienza possibile, e ricordatevi di prestare sempre il massimo rispetto verso gli altri membri della comunity nei commenti.</p>
<br>
<br>
<footer>
    <%@include file="/WEB-INF/views/partials/footerCustomer.jsp"%>
</footer>
</body>
</html>
