<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="HomePage.jsp" >Logo</a>
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
            <div class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false" style="color: turquoise">
                    <!--<img src="./img/download.jpg" alt="Logo" width="32" height="32" class="rounded-circle">-->
                    <i class="fas fa-user-circle" style="font-size:26px; color: turquoise"></i>
                </a>
                <ul class="dropdown-menu">
                    <li><button class="dropdown-item" id="Login" name="Login" value="Login" onclick="login()">Login</button></li>
                    <li><a class="dropdown-item" href="#">Another link</a></li>
                    <li><a class="dropdown-item" href="#">A third link</a></li>
                </ul>
            </div>
            <form class="d-flex" action="${pageContext.request.contextPath}/ResearchServlet" method="get">
                <input class="form-control me-2" type="text" placeholder="Search" id="result" name="result">
                <button class="btn" style="background-color: turquoise" type="submit">Search</button>
            </form>
            <!---   <a class="navbar-brand" href="#">
              //     <img src="img_avatar1.png" alt="Logo" style="width:40px;" class="rounded-pill">
               </a>
                <a href="#" class="d-block link-dark text-decoration-none dropdown-toggle" id="dropdownUser2" data-bs-toggle="dropdown" aria-expanded="false">
           <img src="https://github.com/mdo.png" alt="mdo" width="32" height="32" class="rounded-circle">
         </a>--->
        </div>
    </div>
</nav>