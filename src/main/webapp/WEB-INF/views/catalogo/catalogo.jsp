<%@ page import="Model.Videogioco.Videogioco" %>
<%@ page import="java.util.List" %>
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
        List<Videogioco> videogioco = (List<Videogioco>) request.getAttribute("lista");
    %>

<header>
    <%@include file="../partials/headerCustomer.jsp"%>
</header>
    <div class="album py-5 bg-light">
        <div class="container mb-0">
            <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
                <% for(Videogioco generale: videogioco){
                    if (generale != null ){
                        if (generale.getTitolo().contains(":")) {
                            String[] parts = generale.getTitolo().split(Pattern.quote(":"));
                %>
                <div class="col">
                    <div class="card shadow-sm">
                        <img src="./img/<%=parts[0]+parts[1]%>/<%=parts[0]+parts[1]%>-1.jpg" class="bd-placeholder-img card-img-top" width="100%" height="225"  role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title>
                        <rect width="100%" height="100%" fill="#55595c"></rect>
                        <text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text>
                        </img>
                        <div class="card-body">
                            <p class="card-text"><%=generale.getTitolo()%></p>
                            <div class="d-flex justify-content-between align-items-center">
                                <div class="btn-group">
                                    <form action="${pageContext.request.contextPath}/VideogiocoServlet" method="get">
                                        <button type="button" class="btn btn-sm btn-outline-secondary" id="dettaglioRecensione" name="dettaglioRecensione" value="<%=generale.getTitolo()%>">Info</button>
                                    </form>
                                    <form action="${pageContext.request.contextPath}/RecensioneServlet" method="get">
                                        <button type="button" class="btn btn-sm btn-outline-secondary" id="dettaglioRecensione" name="dettaglioRecensione" value="<%=generale.getTitolo()%>">Recensione</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <%   }else{
                %>
                <div class="col">
                    <div class="card shadow-sm">
                        <img src="./img/<%=generale.getTitolo()%>/<%=generale.getTitolo()%>-1.jpg" class="bd-placeholder-img card-img-top" width="100%" height="225"  role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title>
                        <rect width="100%" height="100%" fill="#55595c"></rect>
                        <text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text>
                        </img>
                        <div class="card-body">
                            <p class="card-text"><%=generale.getTitolo()%></p>
                            <div class="d-flex justify-content-between align-items-center">
                                <div class="btn-group">
                                    <form action="${pageContext.request.contextPath}/VideogiocoServlet" method="get">
                                        <button type="button" class="btn btn-sm btn-outline-secondary">Info</button>
                                        <input type="hidden" id="dettaglioRecensione" name="dettaglioRecensione" value="<%=generale.getTitolo()%>">
                                    </form>
                                    <form action="${pageContext.request.contextPath}/RecensioneServlet" method="get">
                                        <button type="button" class="btn btn-sm btn-outline-secondary">Recensione</button>
                                        <input type="hidden" id="dettaglioRecensione" name="dettaglioRecensione" value="<%=generale.getTitolo()%>">
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <%}%>
                <%}%>
                <%}%>
            </div>
        </div>
    </div>
<footer>
    <%@include file="../partials/footerCustomer.jsp"%>
</footer>
</body>
</html>
