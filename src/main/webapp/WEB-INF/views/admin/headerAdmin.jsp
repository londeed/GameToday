<%
    HttpSession sessionHeader = request.getSession(false);
    Amministratore amministratoreHeader = new Amministratore();
    amministratoreHeader = (Amministratore) request.getSession().getAttribute("amministratore");
    String avatarTmpHeader= String.valueOf(amministratoreHeader.getAvatar());
    String avatarHeader= "avatar"+avatarTmpHeader+".png";
%>

<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="HomePage.jsp" >Logo</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="mynavbar">
            <ul class="navbar-nav me-auto">
                <li class="nav-item dropdown dropdown-hover" id="gestioneAutori">
                    <a class="nav-link dropdown-toggle" href="javascript:void(0)" data-bs-toggle="dropdown" >Gestione Autori</a>
                    <ul class="dropdown-menu">
                        <form action="${pageContext.request.contextPath}/adminOp/" method="get">
                            <li><button class="dropdown-item" id="inserisciAutore" name="gestioneAutori" value="inserisciAutore">Inserisci Autore</button></li>
                            <li><button class="dropdown-item" id="eliminaAutore" name="gestioneAutori" value="eliminaAutore">Elimina Autore</button></li>
                            <li><button class="dropdown-item" id="visualizzaAutore" name="gestioneAutori" value="visualizzaAutore">Visualizza Autori</button></li>
                        </form>
                    </ul>
                </li>
                <li class="nav-item dropdown dropdown-hover" id="gestioneVideogiochi">
                    <a class="nav-link dropdown-toggle" href="javascript:void(0)" data-bs-toggle="dropdown" >Gestione Videogiochi</a>
                    <ul class="dropdown-menu">
                        <form action="${pageContext.request.contextPath}/adminGame/" method="get">
                            <li><button class="dropdown-item" id="inserisci" name="gestioneVideogiochi" value="inserisci">Inserisci Videogioco</button></li>
                            <li><button class="dropdown-item" id="modifica" name="gestioneVideogiochi" value="modifica">Modifica Videogioco</button></li>
                            <li><button class="dropdown-item" id="elimina" name="gestioneVideogiochi" value="elimina">Elimina Videogioco</button></li>
                        </form>
                    </ul>
                </li>
                <li class="nav-item dropdown dropdown-hover" id="gestioneControllo">
                    <a class="nav-link dropdown-toggle" href="javascript:void(0)" data-bs-toggle="dropdown" >Controllo</a>
                    <ul class="dropdown-menu">
                        <form action="${pageContext.request.contextPath}/adminGame/" method="get">
                            <li><button class="dropdown-item" id="controlloRecensione" name="gestioneVideogiochi" value="controlloRecensione">Controlla Recensione</button></li>
                            <li><button class="dropdown-item" id="controlloCommento" name="gestioneVideogiochi" value="controlloCommento">Controlla Commento</button></li>
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
            <div class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false" style="color: turquoise">
                    <img src="${pageContext.request.contextPath}/img/Avatar/<%=avatarHeader%>" alt="Logo" width="32" height="32" class="rounded-circle">
                </a>
                <ul class="dropdown-menu">
                    <form action="${pageContext.request.contextPath}/adminProfile/" method="get">
                        <li><button class="dropdown-item" id="gestioneProfilo" name="gestioneAmministratore" value="gestioneProfilo">Gestione Profilo</button></li>
                        <li><button class="dropdown-item" id="logout" name="gestioneAmministratore" value="logout">Logout</button></li>
                    </form>
                </ul>
            </div>
            <form class="d-flex" action="${pageContext.request.contextPath}/ResearchServlet" method="get">
                <input class="form-control me-2" type="text" placeholder="Search" id="result" name="result">
                <button class="btn" style="background-color: turquoise" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>

