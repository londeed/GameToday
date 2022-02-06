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
             <textarea class="form-control" id="textarea" rows="3" maxlength="1500"></textarea><br>
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
    <%for(Commento commento: commentoList) {
        if(interazioneUtList != null && utenteList != null){
            for(InterazioneUt interazioneUt: interazioneUtList){
                if(interazioneUt.getUtNickname()!=null){
                    if(interazioneUt.getComCodice().equals(commento.getComCodice())){
                        for(Utente utente: utenteList){
                            if(utente.getUtNickname().equals(interazioneUt.getUtNickname())){
                                %>
                            <div class="container" style="padding: 30px 50px">
        <h4><img src="./img/Avatar/avatar<%=utente.getAvatar()%>.png" alt="Pic not found" class="d-block"  style="width:5%; height: 5%"> <%=utente.getUtNickname()%></h4>
    <textarea class="form-control" type="text" id="textarea<%=commento.getComCodice()%>" aria-label="Disabled input example" style="resize: none" disabled readonly><%=commento.getTesto()%></textarea>
    <div class="row row-cols-lg-auto g-3 align-items-center" style="float: right;padding-top: 10px">
        <%if(!Objects.isNull(utenteLogin)){
            if(utenteLogin.getUtNickname().equals(utente.getUtNickname())){
                String eliminazione = ""+commento.getComCodice()+","+utente.getUtNickname();%>
        <div class="container" style="float: left">
            <button id="ModificaBottone<%=commento.getComCodice()%>" type='button'>Modifica</button>
            <script>
                var el = document.getElementById("textarea<%=commento.getComCodice()%>");
                if(el) {
                   // document.getElementById("ModificaBottone<%=commento.getComCodice()%>").addEventListener("click", function () {
                        $("#textarea<%=commento.getComCodice()%>").addEventListener("click",function () {
                        //document.getElementById("textarea<%=commento.getComCodice()%>").disabled = false;
                        //document.getElementById("textarea<%=commento.getComCodice()%>").readonly = false;
                        document.getElementById("textarea<%=commento.getComCodice()%>").removeAttribute("disabled");
                        document.getElementById("textarea<%=commento.getComCodice()%>").removeAttribute("readonly");
                        document.getElementById("ModificaBottone<%=commento.getComCodice()%>").innerHTML = "Conferma Modifiche";
                        document.getElementById("ModificaBottone<%=commento.getComCodice()%>").setAttribute("id", "ConfermaModifica<%=commento.getComCodice()%>")
                    })
                }
                var el2 = document.getElementById("ConfermaModifica<%=commento.getComCodice()%>");
                if(el2) {
                    //document.getElementById("ConfermaModifica<%=commento.getComCodice()%>").addEventListener("click",function (){
                        $("#textarea<%=commento.getComCodice()%>").addEventListener("click",function () {
                            //document.getElementById("textarea<%=commento.getComCodice()%>").disabled = true;
                            //document.getElementById("textarea<%=commento.getComCodice()%>").readonly = true;
                            document.getElementById("textarea<%=commento.getComCodice()%>").setAttribute("disabled", "disabled");
                            document.getElementById("textarea<%=commento.getComCodice()%>").setAttribute("readonly", "readonly");
                            $("#textarea<%=commento.getComCodice()%>").addEventListener("click", function () {
                                document.getElementById("ConfermaModifica<%=commento.getComCodice()%>").innerHTML = "Modifica";
                                document.getElementById("ConfermaModifica<%=commento.getComCodice()%>").setAttribute("id", "ModificaBottone<%=commento.getComCodice()%>")
                            })
                        })
                }
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
                         for(Autore autore: autoreList){
                             if(autore.getAuNickname().equals(interazioneAu.getAuNickname())){
                                 %>
<script>sessionStorage.setItem('testo',"ok");</script>
    <div id="div<%=commento.getComCodice()%>" class="container" style="padding: 30px 50px">
        <h4 id="h4<%=commento.getComCodice()%>"><img src="./img/Avatar/avatar<%=autore.getAvatar()%>.png" alt="Pic not found" class="d-block"  style="width:5%; height: 5%"> <%=autore.getAuNickname()%></h4>
        <div>
            <div id="ajax<%=commento.getComCodice()%>" style="display: none">
                <textarea class="form-control" type="text" id="#textarea2<%=commento.getComCodice()%>" name="#textarea2<%=commento.getComCodice()%>" aria-label="Disabled input example" style="resize: none" ></textarea>
            </div>
            <div id="ajax2<%=commento.getComCodice()%>">
                <textarea class="form-control" type="text" id="#textarea<%=commento.getComCodice()%>" name="#textarea<%=commento.getComCodice()%>" aria-label="Disabled input example" style="resize: none" disabled="disabled" readonly="readonly"><%=commento.getTesto()%></textarea>
            </div>
        </div>
        <div class="row row-cols-lg-auto g-3 align-items-center" style="float: right;padding-top: 10px">
            <%if(!Objects.isNull(autoreLogin)){
                if(autoreLogin.getAuNickname().equals(autore.getAuNickname())){
                String eliminazione = ""+commento.getComCodice()+","+autore.getAuNickname();%>
            <div class="container" style="float: left">
                <button id="ModificaBottone2<%=commento.getComCodice()%>" type='button'>Modifica</button>
                <script defer>
                    var el3 = document.getElementById("ModificaBottone2<%=commento.getComCodice()%>");
                    var el2 = document.getElementById("ConfermaModifica2<%=commento.getComCodice()%>");
                    //el3.addEventListener("click", function () {
                        $("#ModificaBottone2<%=commento.getComCodice()%>").bind("click", function(){
                        modifica("<%=commento.getComCodice()%>")
                    })

                            /*var x = $("#ModificaBottone2<%=commento.getComCodice()%>").html()
                            if(x ==="Modifica") {
                                //document.getElementById("textarea<%=commento.getComCodice()%>").disabled = false;
                                //document.getElementById("textarea<%=commento.getComCodice()%>").readonly = false;
                                //document.getElementById("textarea<%=commento.getComCodice()%>").removeAttribute("disabled");
                                //document.getElementById("textarea<%=commento.getComCodice()%>").removeAttribute("readonly");
                                //$("#textarea<%=commento.getComCodice()%>").remove();
                                <%
                                String testo = commento.getTesto();
                                request.getSession().setAttribute("commentoTesto",testo);
                                %>
                                /*$.ajax({
                                    type: "get",
                                    url: "http://localhost:8080/GameToday_war/textarea.jsp",
                                    dataType: "html",
                                    success: function(output) {
                                        $("#ajax<%=commento.getComCodice()%>").html(output)
                                    },
                                    error: function (output){
                                        alert("Non riuscito")
                                    }
                                });
                                let testo = $("#textarea<%=commento.getComCodice()%>").val();
                                var v = document.getElementById('ajax<%=commento.getComCodice()%>')
                                var z = document.getElementById('ajax2<%=commento.getComCodice()%>')
                                if(v.style.display === "none"){
                                    v.style.display = "block";
                                    z.style.display = "none";
                                }else{
                                    v.style.display = "none";
                                    z.style.display = "block";
                                }
                                document.querySelector("textarea2<%=commento.getComCodice()%>").innerHTML = sessionStorage.getItem('testo')
                               // $("#textarea2<%=commento.getComCodice()%>").val(sessionStorage.getItem('testo'))
                                //$("#textarea").attr("id","#textarea<%=commento.getComCodice()%>");
                                //$("#textarea<%=commento.getComCodice()%>").removeAttr("disabled");
                                //$("#textarea<%=commento.getComCodice()%>").removeAttr("readonly");
                                //$("#textarea<%=commento.getComCodice()%>").prop("disabled", false);
                                //$("#textarea<%=commento.getComCodice()%>").prop("readonly", false);
                                //$("#textareaMod").prop("id","#textarea<%=commento.getComCodice()%>")
                                $("#ModificaBottone2<%=commento.getComCodice()%>").text("Conferma Modifiche")
                                //$("#ModificaBottone2<%=commento.getComCodice()%>").attr({id: "ConfermaModifica2<%=commento.getComCodice()%>"});
                                //document.getElementById("ModificaBottone2<%=commento.getComCodice()%>").innerHTML = "Conferma Modifiche";
                                //document.getElementById("ModificaBottone2<%=commento.getComCodice()%>").setAttribute("id", "ConfermaModifica2<%=commento.getComCodice()%>")
                            }else{
                                let testo = $("#textarea2<%=commento.getComCodice()%>").val();
                                alert(testo)
                                sessionStorage.setItem('testo',<%=commento.getComCodice()%>);
                                alert(sessionStorage.getItem('lastname'));
                                $("#ModificaBottone2<%=commento.getComCodice()%>").text("Modifica")
                               $.ajax({
                                    type: "get",
                                    url: "http://localhost:8080/GameToday_war/textareaDisabilitata.jsp",
                                    dataType: "html",
                                    success: function(output) {
                                        $("#ajax<%=commento.getComCodice()%>").html(output)
                                    },
                                    error: function (output){
                                        alert("Non riuscito")
                                    }
                                });
                                var v = document.getElementById('ajax<%=commento.getComCodice()%>')
                                var z = document.getElementById('ajax2<%=commento.getComCodice()%>')
                                if(v.style.display === "block"){
                                    v.style.display = "none";
                                    z.style.display = "block";
                                }else{
                                    v.style.display = "block";
                                    z.style.display = "none";
                                }
                                alert(testo)
                                $("#textarea<%=commento.getComCodice()%>").val("ok")
                                //$("#textareaMod").prop("id","#textarea<%=commento.getComCodice()%>")
                                //$("#textarea<%=commento.getComCodice()%>").text(testo);
                                //$("#textarea<%=commento.getComCodice()%>").attr({"disabled": "disabled"});
                                //$("#textarea<%=commento.getComCodice()%>").attr({"readonly": "readonly"});
                            }
                        })*/
                    /*el2.addEventListener("click", function () {
                        $("#ModificaBottone2<%=commento.getComCodice()%>").bind("click", function () {
                            //document.getElementById("textarea<%=commento.getComCodice()%>").disabled = true;
                            //document.getElementById("textarea<%=commento.getComCodice()%>").readonly = true;
                            //document.getElementById("textarea<%=commento.getComCodice()%>").setAttribute("disabled","disabled");
                            //document.getElementById("textarea<%=commento.getComCodice()%>").setAttribute("readonly","readonly");
                            $("#ModificaBottone2<%=commento.getComCodice()%>").text("Modifica")
                            // $("#ConfermaModifica2<%=commento.getComCodice()%>").attr({id: "ModificaBottone2<%=commento.getComCodice()%>"});
                            $("#textarea<%=commento.getComCodice()%>").prop("disabled", true);
                            $("#textarea<%=commento.getComCodice()%>").prop("readonly", true);
                            //document.getElementById("ConfermaModifica2<%=commento.getComCodice()%>").innerHTML = "Modifica";
                            //document.getElementById("ConfermaModifica2<%=commento.getComCodice()%>").setAttribute("id", "ModificaBottone2<%=commento.getComCodice()%>")
                        })*/
                </script>
            </div>
            <div class="container" style="float: left">
                <button id="eliminaBottone2<%=commento.getComCodice()%>" type='button'>Elimina</button>
                <script>
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

