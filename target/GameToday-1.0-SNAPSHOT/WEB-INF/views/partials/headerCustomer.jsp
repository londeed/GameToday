<%@ page import="java.util.Objects" %>
<%@ page import="Model.Autore.Autore" %>
<%@ page import="Model.Utente.Utente" %>
<%
    Autore autore = (Autore) request.getSession(false).getAttribute("userAu");
    Utente utente = (Utente) request.getSession(false).getAttribute("userUt");
%>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <div class="container-fluid">
        <form action="${pageContext.request.contextPath}/General" method="get">
            <button class="btn navbar-brand" id="home" name="home" value="home">Logo</button>
        </form>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="mynavbar">
            <ul class="navbar-nav me-auto">
                <li class="nav-item dropdown dropdown-hover" id="piattaforma">
                    <a class="nav-link dropdown-toggle" href="javascript:void(0)" data-bs-toggle="dropdown">Piattaforma</a>
                    <ul class="dropdown-menu">
                        <form action="${pageContext.request.contextPath}/Catalogo" method="get">
                            <li><button class="dropdown-item" id="PC" name="piattaforma" value="PC">PC</button></li>
                            <li><button class="dropdown-item" id="Playstation" name="piattaforma" value="Playstation 4">Playstation</button></li>
                            <li><button class="dropdown-item" id="Xbox" name="piattaforma" value="Xbox One">Xbox</button></li>
                        </form>
                    </ul>
                </li>
                <li class="nav-item">
                    <form action="${pageContext.request.contextPath}/VideogiocoServlet" method="get">
                        <button class="nav-link" style="background-color: transparent;border: 0px" id="videogioco" name="videogioco" value="videogioco">Videogiochi</button>
                    </form>
                </li>
                <li class="nav-item">
                    <form action="${pageContext.request.contextPath}/RecensioneServlet" method="get">
                         <button class="nav-link" style="background-color: transparent;border: 0px" id="recensione" name="recensione" value="recensione">Recensioni</button>
                    </form>
                </li>
            </ul>
            <%
                if(!Objects.isNull(utente)) {
            %>
            <div class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false" style="color: turquoise">
                    <img src="${pageContext.request.contextPath}/img/Avatar/avatar<%=utente.getAvatar()%>.png" alt="Logo" width="32" height="32" class="rounded-circle">
                    <!-- <i class="fas fa-user-circle" style="font-size:26px; color: turquoise"></i>-->
                </a>
                <ul class="dropdown-menu">
                    <form action="${pageContext.request.contextPath}/utenteProfile/" method="get">
                        <li><button class="dropdown-item" id="gestioneProfiloUtente" name="gestioneUtente" value="gestioneProfiloUtente">Gestione Profilo</button></li>
                        <li><button class="dropdown-item" id="logoutUtente" name="gestioneUtente" value="logoutUtente">Logout</button></li>
                    </form>
                </ul>
            </div>
            <%
                }
                if(!Objects.isNull(autore)){
            %>
            <div class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false" style="color: turquoise">
                    <img src="${pageContext.request.contextPath}/img/Avatar/avatar<%=autore.getAvatar()%>.png" alt="Logo" width="32" height="32" class="rounded-circle">
                </a>
                <ul class="dropdown-menu">
                    <form action="${pageContext.request.contextPath}/autoreProfile/" method="get">
                        <li><button class="dropdown-item" id="gestioneProfiloAutore" name="gestioneAutore" value="gestioneProfiloAutore">Gestione Profilo</button></li>
                        <li><button class="dropdown-item" id="logoutAutore" name="gestioneAutore" value="logoutAutore">Logout</button></li>
                    </form>
                </ul>
            </div>
                    <%
                        }
                        if(Objects.isNull(utente) && Objects.isNull(autore)){
                    %>
            <div class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false" style="color: turquoise">
                    <i class="fas fa-user-circle" style="font-size:26px; color: turquoise"></i>
                </a>
                <ul class="dropdown-menu">
                    <form action="${pageContext.request.contextPath}/UserServlet/toLogin" method="get">
                        <li><button class="dropdown-item" id="Login" name="Login" value="Login">Login</button></li>
                    </form>
                </ul>
            </div>
            <%
                }
            %>
            <form class="d-flex" action="${pageContext.request.contextPath}/ResearchServlet" method="get">
                <input class="form-control me-2" type="text" placeholder="Search" id="result" name="result">
                <button class="btn" style="background-color: turquoise" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
