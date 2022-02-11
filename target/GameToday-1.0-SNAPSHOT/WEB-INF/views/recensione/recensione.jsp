<%@ page import="Model.Recensione.Recensione" %>
<%@ page import="java.util.regex.Pattern" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.Commento.Commento" %>
<%@ page import="Model.Autore.Autore" %>
<%@ page import="Model.Utente.Utente" %>
<%@ page import="Model.InterazioneAu.InterazioneAu" %>
<%@ page import="Model.InterazioneUt.InterazioneUt" %>
<%@ page import="java.util.Objects" %>
<%@ page import="org.json.JSONObject" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="it" xmlns="http://www.w3.org/1999/html">
<head>
    <jsp:include page="/WEB-INF/views/partials/head.jsp">
        <jsp:param name="title" value="HomePage"/>
        <jsp:param name="style" value="bootstrap"/>
        <jsp:param name="script" value="aggiungiCommento"/>
    </jsp:include>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

    <style>

        /* The Modal (background) */
        .modal {
            display: none; /* Hidden by default */
            position: fixed; /* Stay in place */
            z-index: 1; /* Sit on top */
            padding-top: 100px; /* Location of the box */
            left: 0;
            top: 0;
            width: 100%; /* Full width */
            height: 100%; /* Full height */
            overflow: auto; /* Enable scroll if needed */
            background-color: rgb(0,0,0); /* Fallback color */
            background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
        }

        /* Modal Content */
        .modal-content {
            background-color: #fefefe;
            margin: auto;
            padding: 20px;
            border: 1px solid #888;
            width: 80%;
        }

        /* The Close Button */
        .close {
            color: #aaaaaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
        }

        .close:hover,
        .close:focus {
            color: #000;
            text-decoration: none;
            cursor: pointer;
        }
    </style>







</head>
<body style="background-color: #141414; color: white; font-family: AlumniSans-Italic">
    <%
    Recensione recensione = (Recensione) request.getAttribute("dettaglioRecensione");
    List<Commento> commentoList = (List<Commento>) request.getAttribute("commenti");
    List<Autore> autoreList = (List<Autore>) request.getAttribute("autoreList");
    List<Utente> utenteList = (List<Utente>) request.getAttribute("utenteList");
    List<InterazioneAu> interazioneAuList = (List<InterazioneAu>) request.getAttribute("interazioneAutore");
    List<InterazioneUt> interazioneUtList = (List<InterazioneUt>) request.getAttribute("interazioneUtente");
    Autore autoreLogin = (Autore) request.getSession(false).getAttribute("userAu");
    Utente utenteLogin = (Utente) request.getSession(false).getAttribute("userUt");
    %>

<header>
    <%@include file="../partials/headerCustomer.jsp"%>
</header>
    <h1 style="text-align: center; padding: 10px"><%=recensione.getTitolo()%></h1>
    <% if (recensione != null ){
            if (recensione.getTitolo().contains(":")) {
                String[] parts = recensione.getTitolo().split(Pattern.quote(":"));
    %>
    <div class="card shadow-sm mx-auto" style="width: 50%; height: 35%">
    <img class="img-responsive" src="./img/<%=parts[0]+parts[1]%>/<%=parts[0]+parts[1]%>-1.jpg" alt="immagineDivertente">
    </div>
            <%   }else{
    %>
    <div class="card shadow-sm mx-auto" style="width: 50%; height: 35%" >
    <img class="img-responsive" src="./img/<%=recensione.getTitolo()%>/<%=recensione.getTitolo()%>-1.jpg" alt="immagineDivertente">
    </div>
    <%}%>
    <%}%>
    <div class="container" style="padding: 30px 50px">
        <p style="text-align: center"><%=recensione.getTesto()%></p>
        <blockquote class="blockquote-footer">
            <p><%=recensione.getAuNickname()%></p>
        </blockquote>
    </div>

    <div id="demo" style="width:50%; height: 400%" class="carousel slide mx-auto" data-bs-ride="carousel">

        <!-- Indicators/dots -->
        <div class="carousel-indicators">
            <button type="button" data-bs-target="#demo" data-bs-slide-to="0" class="active"></button>
            <button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
            <button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
        </div>

        <!-- The slideshow/carousel -->
        <div class="carousel-inner">
                <%if (recensione.getTitolo().contains(":")) {
                    String[] parts = recensione.getTitolo().split(Pattern.quote(":"));
                %>
            <div class="carousel-item active">
                <img src="./img/<%=parts[0]+parts[1]%>/<%=parts[0]+parts[1]%>-2.jpg" alt="Pic not found" class="d-block"  style="width:100%; height: 400%">
            </div>
            <div class="carousel-item">
                <img src="./img/<%=parts[0]+parts[1]%>/<%=parts[0]+parts[1]%>-3.jpg" alt="Pic not found" class="d-block"  style="width:100%; height: 400%">
            </div>
            <div class="carousel-item">
                <img src="./img/<%=parts[0]+parts[1]%>/<%=parts[0]+parts[1]%>-4.jpg" alt="Pic not found" class="d-block"  style="width:100%; height: 400%">
            </div>
           <%}else{
                    %>
            <div class="carousel-item active">
            <img src="./img/<%=recensione.getTitolo()%>/<%=recensione.getTitolo()%>-2.jpg" alt="Pic not found" class="d-block"  style="width:100%; height: 400%">
        </div>
        <div class="carousel-item">
            <img src="./img/<%=recensione.getTitolo()%>/<%=recensione.getTitolo()%>-3.jpg" alt="Pic not found" class="d-block"  style="width:100%; height: 400%">
        </div>
        <div class="carousel-item">
            <img src="./img/<%=recensione.getTitolo()%>/<%=recensione.getTitolo()%>-4.jpg" alt="Pic not found" class="d-block"  style="width:100%; height: 400%">
        </div>
           <%}%>
        </div>
        <!-- Left and right controls/icons -->
        <button class="carousel-control-prev" type="button" data-bs-target="#demo" data-bs-slide="prev">
            <span class="carousel-control-prev-icon"></span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#demo" data-bs-slide="next">
            <span class="carousel-control-next-icon"></span>
        </button>
    </div>
<div>
    <div class="container" style="padding: 30px 50px">
      <h3><br><br>Sezione commenti:</h3><br>
        <div class="mb-3" style= "width:50%" >
             <label for="textarea" class="form-label">Scrivi ciò che pensi:</label>
             <textarea class="form-control" id="textarea" rows="3" minlength="300" maxlength="1500"></textarea><br>
            <%String x = "";
                System.out.println("prima");
            if(!Objects.isNull(utenteLogin)) {
                x = "" + recensione.getCodice() + "," + utenteLogin.getUtNickname() + ",0,0,true,utente,"+utenteLogin.getAvatar();
                System.out.println("utente");
            }
            if(!Objects.isNull(autoreLogin)){
                x = "" + recensione.getCodice() + "," + autoreLogin.getAuNickname() + ",0,0,true,autore,"+autoreLogin.getAvatar();
                System.out.println("autore");
            }
            if(Objects.isNull(utenteLogin) && Objects.isNull(autoreLogin)){
                System.out.println("nessuno");
                x = "n,n,0,0,false,niente,0";
            }%>
             <button type="button" onclick="aggiungiCommento('<%=x%>')" id="bottoneCommento">Inserisci il commento</button>
         </div>
    </div>
    <div class="container" style="padding: 30px 50px" id="commentoUtente"style="color: turquoise">
    </div>
    <div id="myModal" class="modal">
        <!-- Modal content -->
        <div class="modal-content">
            <span class="close">&times;</span>
            <textarea id="modificatore" style="resize: none"></textarea>
            <button class="btn" id="salvaModifica" type="button">Salva modifica</button>
        </div>

    </div>
    <%for(Commento commento: commentoList) {
        if(interazioneUtList != null && utenteList != null){
            for(InterazioneUt interazioneUt: interazioneUtList){
                if(interazioneUt.getUtNickname()!=null){
                    if(interazioneUt.getComCodice().equals(commento.getComCodice())){
                        for(Utente utenteRecensione: utenteList){
                            if(utenteRecensione.getUtNickname().equals(interazioneUt.getUtNickname())){
                                %>
                            <div class="container" style="padding: 30px 50px">
        <h4><img src="./img/Avatar/avatar<%=utenteRecensione.getAvatar()%>.png" alt="Pic not found" class="d-block"  style="width:5%; height: 5%"> <%=utenteRecensione.getUtNickname()%></h4>
    <textarea class="form-control" type="text" id="textarea<%=commento.getComCodice()%>" aria-label="Disabled input example" style="resize: none" disabled readonly><%=commento.getTesto()%></textarea>
    <div class="row row-cols-lg-auto g-3 align-items-center" style="float: right;padding-top: 10px">
        <%if(!Objects.isNull(utenteLogin)){
            if(utenteLogin.getUtNickname().equals(utenteRecensione.getUtNickname())){
                String eliminazione = ""+commento.getComCodice()+","+utenteRecensione.getUtNickname();%>
        <div class="container" style="float: left">
            <button id="ModificaBottone<%=commento.getComCodice()%>" type='button'>Modifica</button>
                <script>
                    $("#ModificaBottone<%=commento.getComCodice()%>").bind("click", function(){
                        modifica("<%=commento.getComCodice()%>")
                    })
                </script>
        </div>
        <div class="container" style="float: left">
            <button id="eliminaBottone<%=commento.getComCodice()%>" type='button'>Elimina</button>
            <script>
                document.getElementById("eliminaBottone<%=commento.getComCodice()%>").addEventListener("click",function (){
                    var codiceCom = "<%=eliminazione%>";
                    const array = codiceCom.split(",")
                    var codiceCommento = array[0];
                    var nick = array[1];
                    var code = {codiceCommento: codiceCommento , nickname: nick};
                    $.ajax({
                        type: "get",
                        url: "http://localhost:8080/GameToday_war/CommentoServlet/eliminaCaricati",
                        contentType: "JSON", // NOT dataType!
                        data:{ code: JSON.stringify(code)},
                        success: function(response) {
                            alert("Eliminazione riuscita");
                        },
                        error: function(response) {
                            alert('Errore in fase di eliminazione');
                        }
                    });
                })
            </script>
        </div>
        <%}
        }%>
        <div class="col-12">
            <%String like = "true"+","+commento.getComCodice()+","+commento.getLike();%>
            <button id="button<%=commento.getComCodice()%>" >
                <i class="far fa-thumbs-up" id="i<%=commento.getComCodice()%>"><p id="p<%=commento.getComCodice()%>"><%=commento.getLike()%></p></i>
            </button>
            <script>document.getElementById("button<%=commento.getComCodice()%>").addEventListener("click",function (){
                var stringa ="<%=like%>";
                const array = stringa.split(",")
                var v = array[0];
                var c = array[1];
                var i = array[2];
                var interazione = {interazione: v , cCod: c , cInterazione: i};
                $.ajax({
                    type: "get",
                    url: "http://localhost:8080/GameToday_war/CommentoServlet/aggiungiInterazioneEsistente",
                    contentType: "JSON", // NOT dataType!
                    data:{ interazione: JSON.stringify(interazione)},
                    success: function(response) {
                        alert("Like o dislike correttamente aggiunto!");
                    },
                    error: function(response) {
                        alert('Like o dislike non aggiunto!');
                    }
                });
            })</script>
        </div>
        <div class="col-12">
            <%String dislike = "false"+","+commento.getComCodice()+","+commento.getDislike();%>
            <button id="button2<%=commento.getComCodice()%>">
                <i class="far fa-thumbs-down" id="i2<%=commento.getComCodice()%>"><p id="p2<%=commento.getComCodice()%>"><%=commento.getDislike()%></p></i>
            </button>
        </div>
        <script>document.getElementById("button2<%=commento.getComCodice()%>").addEventListener("click",function (){
            var stringa ="<%=dislike%>";
            const array = stringa.split(",")
            var v = array[0];
            var c = array[1];
            var i = array[2];
            var interazione = {interazione: v , cCod: c , cInterazione: i};
            $.ajax({
                type: "get",
                url: "http://localhost:8080/GameToday_war/CommentoServlet/aggiungiInterazioneEsistente",
                contentType: "JSON", // NOT dataType!
                data:{ interazione: JSON.stringify(interazione)},
                success: function(response) {
                    alert("Like o dislike correttamente aggiunto!");
                },
                error: function(response) {
                    alert('Like o dislike non aggiunto!');
                }
            });
        })</script>
    </div>
</div>
                     <% break;
                            }
                    }
               break;
                    }
            }
                     }
        }
        if(interazioneAuList != null && autoreList != null){
             for(InterazioneAu interazioneAu: interazioneAuList){
                 if(interazioneAu.getAuNickname()!=null){
                     if(interazioneAu.getComCodice().equals(commento.getComCodice())){
                         for(Autore autoreRecensione: autoreList){
                             if(autoreRecensione.getAuNickname().equals(interazioneAu.getAuNickname())){
                                 %>
    <div id="div<%=commento.getComCodice()%>" class="container" style="padding: 30px 50px">
        <h4 id="h4<%=commento.getComCodice()%>"><img src="./img/Avatar/avatar<%=autoreRecensione.getAvatar()%>.png" alt="Pic not found" class="d-block"  style="width:5%; height: 5%"> <%=autoreRecensione.getAuNickname()%></h4>
            <div id="ajax2<%=commento.getComCodice()%>" style="border:solid turquoise;border-radius: 10px;padding: 2%"><%=commento.getTesto()%></div>
        <div class="row row-cols-lg-auto g-3 align-items-center" style="float: right;padding-top: 10px">
            <%if(!Objects.isNull(autoreLogin)){
                if(autoreLogin.getAuNickname().equals(autoreRecensione.getAuNickname())){
                String eliminazione = ""+commento.getComCodice()+","+autoreRecensione.getAuNickname();%>
            <div class="container" style="float: left">
                <button id="ModificaBottone2<%=commento.getComCodice()%>" type='button'>Modifica</button>
                <script defer>
                        $("#ModificaBottone2<%=commento.getComCodice()%>").bind("click", function(){
                        modifica("<%=commento.getComCodice()%>")
                    })
                </script>
            </div>
            <div class="container" style="float: left">
                <button id="eliminaBottone2<%=commento.getComCodice()%>" type='button'>Elimina</button>
                <script defer>
                    document.getElementById("eliminaBottone2<%=commento.getComCodice()%>").addEventListener("click",function (){
                        var codiceCom = "<%=eliminazione%>";
                        const array = codiceCom.split(",")
                        var codiceCommento = array[0];
                        var nick = array[1];
                        var code = {codiceCommento: codiceCommento , nickname: nick};
                        $.ajax({
                            type: "get",
                            url: "http://localhost:8080/GameToday_war/CommentoServlet/eliminaCaricati",
                            contentType: "JSON", // NOT dataType!
                            data:{ code: JSON.stringify(code)},
                            success: function(response) {
                            alert("Eliminazione riuscita");
                            },
                            error: function(response) {
                            alert('Errore in fase di eliminazione');
                            }
                        });
                    })
                </script>
            </div>
            <%}
            }%>
            <div class="col-12">
                <%String like = "true"+","+commento.getComCodice()+","+commento.getLike();%>
                <button id="button<%=commento.getComCodice()%>" >
                    <i class="far fa-thumbs-up" id="i<%=commento.getComCodice()%>"><p id="p<%=commento.getComCodice()%>"><%=commento.getLike()%></p></i>
                </button>
                <script defer>document.getElementById("button<%=commento.getComCodice()%>").addEventListener("click",function (){
                    var stringa ="<%=like%>";
                    const array = stringa.split(",")
                    var v = array[0];
                    var c = array[1];
                    var i = array[2];
                    var interazione = {interazione: v , cCod: c , cInterazione: i};
                    $.ajax({
                        type: "get",
                        url: "http://localhost:8080/GameToday_war/CommentoServlet/aggiungiInterazioneEsistente",
                        contentType: "JSON", // NOT dataType!
                        data:{ interazione: JSON.stringify(interazione)},
                        success: function(response) {
                            alert("Like o dislike correttamente aggiunto!");
                        },
                        error: function(response) {
                            alert('Like o dislike non aggiunto!');
                        }
                    });
                })</script>
            </div>
            <div class="col-12">
                <%String dislike = "false"+","+commento.getComCodice()+","+commento.getDislike();%>
                <button id="button2<%=commento.getComCodice()%>">
                    <i class="far fa-thumbs-down" id="i2<%=commento.getComCodice()%>"><p id="p2<%=commento.getComCodice()%>"><%=commento.getDislike()%></p></i>
                </button>
            </div>
            <script defer>document.getElementById("button2<%=commento.getComCodice()%>").addEventListener("click",function (){
                var stringa ="<%=dislike%>";
                const array = stringa.split(",")
                var v = array[0];
                var c = array[1];
                var i = array[2];
                var interazione = {interazione: v , cCod: c , cInterazione: i};
                $.ajax({
                    type: "get",
                    url: "http://localhost:8080/GameToday_war/CommentoServlet/aggiungiInterazioneEsistente",
                    contentType: "JSON", // NOT dataType!
                    data:{ interazione: JSON.stringify(interazione)},
                    success: function(response) {
                        alert("Like o dislike correttamente aggiunto!");
                    },
                    error: function(response) {
                        alert('Like o dislike non aggiunto!');
                    }
                });
            })</script>
        </div>
    </div>
    <%break;
         }
    }
        break;
                     }
    }
    }
    }
    }%>
</div>
    <footer>
        <%@include file="../partials/footerCustomer.jsp"%>
    </footer>
</body>
</html>

