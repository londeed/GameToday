<%@ page import="java.util.regex.Pattern" %>
<%@ page import="Model.Videogioco.Videogioco" %>
<%@ page import="Model.Valutazione.Valutazione" %>
<!DOCTYPE html>
<html lang="it" xmlns="http://www.w3.org/1999/html">
<head>
    <jsp:include page="/WEB-INF/views/partials/head.jsp">
        <jsp:param name="title" value="Dettaglio videogioco"/>
        <jsp:param name="style" value=""/>
        <jsp:param name="script" value="rating,rating2"/>
    </jsp:include>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <style>
        .ratings {
            margin-right: 10px
        }

        .ratings i {
            color: #cecece;
            font-size: 32px
        }

        .rating-color {
            color: #fbc634 !important
        }

        .review-count {
            font-weight: 400;
            margin-bottom: 2px;
            font-size: 24px !important
        }

        .small-ratings i {
            color: #cecece
        }

        .review-stat {
            font-weight: 300;
            font-size: 18px;
            margin-bottom: 2px
        }
        .rate {
            border-bottom-right-radius: 12px;
            border-bottom-left-radius: 12px
        }

        .rating {
            display: flex;
            flex-direction: row-reverse;
            justify-content: center
        }

        .rating>input {
            display: none

        }

        .rating>label {
            position: relative;
            width: 1em;
            font-size: 30px;
            font-weight: 300;
            color: #FFD600;
            cursor: pointer
        }

        .rating>label::before {
            content: "\2605";
            position: absolute;
            opacity: 0
        }

        .rating>label:hover:before,
        .rating>label:hover~label:before {
            opacity: 1 !important
        }

        .rating>input:checked~label:before {
            opacity: 1
        }

        .rating:hover>input:checked~label:before {
            opacity: 0.4
        }

        .buttons {
            top: 36px;
            position: relative
        }

        .rating-submit {
            border-radius: 15px;
            color: #fff;
            height: 49px
        }

        .rating-submit:hover {
            color: #fff
        }

    </style>
</head>
<body style="background-color: #141414; color: white; font-family: AlumniSans-Italic; text-align: center">
<%
    Videogioco videogioco = (Videogioco) request.getAttribute("dettaglioVideogioco");
    Valutazione valutazione = (Valutazione) request.getAttribute("valutazione");
    Utente utenteVal = (Utente) request.getSession(false).getAttribute("userUt");
    Autore autoreVal = (Autore) request.getSession(false).getAttribute("userAu");
%>

<header>
    <%@include file="../partials/headerCustomer.jsp"%>
</header>
<div class="row">
    <div class="g col-6" style="padding-top: 50px; padding-left: 50px">
<%
    if (videogioco != null ){
    if (videogioco.getTitolo().contains(":")) {
        String[] parts = videogioco.getTitolo().split(Pattern.quote(":"));
%>
        <div class="card shadow-sm">
            <img class="img-responsive" src="./img/<%=parts[0]+parts[1]%>/<%=parts[0]+parts[1]%>-1.jpg"  alt="immagineDivertente">
        </div>
<%   }else{
%>
        <div class="card shadow-sm">
            <img class="img-responsive" src="./img/<%=videogioco.getTitolo()%>/<%=videogioco.getTitolo()%>-1.jpg" alt="immagineDivertente">
        </div>
            <%}%>
<%}%>
    </div>
    <div class="col" style="padding-top: 50px">
    <ul>
        <h1><%=videogioco.getTitolo()%></h1>
        <p>Casa Produttrice: <%=videogioco.getCasaProduttrice()%></p>
        <p>Pegi: <%=videogioco.getPegi()%></p>
        <p>Tipologia: <%=videogioco.getTipologia()%></p>
        <p>Totale voti: <%=videogioco.getTotaleVoti()%></p>
        <p>Piattaforma: <%=videogioco.getPiattaforma()%></p>
        <p>Data Pubblicazione: <%=videogioco.getDataPubblicazione()%></p>
        <p><h5 class="review-count"><%=videogioco.getTotaleVoti()%> valutazioni</h5>
        <%if(videogioco.getMediaValutazioni()<=5 && videogioco.getMediaValutazioni()>4){%>
            <p><div class="ratings"> <i class="fa fa-star rating-color"></i> <i class="fa fa-star rating-color"></i> <i class="fa fa-star rating-color"></i> <i class="fa fa-star rating-color"></i> <i class="fa fa-star rating-color"></i></div></div></p>
        <%}%>
        <%if(videogioco.getMediaValutazioni()<=4 && videogioco.getMediaValutazioni()>3){%>
            <p><div class="ratings"> <i class="fa fa-star rating-color"></i> <i class="fa fa-star rating-color"></i> <i class="fa fa-star rating-color"></i> <i class="fa fa-star rating-color"></i> <i class="fa fa-star"></i></div></div></p>
        <%}%>
        <%if(videogioco.getMediaValutazioni()<=3 && videogioco.getMediaValutazioni()>2){%>
            <p><div class="ratings"> <i class="fa fa-star rating-color"></i> <i class="fa fa-star rating-color"></i> <i class="fa fa-star rating-color"></i> <i class="fa fa-star"></i> <i class="fa fa-star"></i></div></div></p>
        <%}%>
        <%if(videogioco.getMediaValutazioni()<=2 && videogioco.getMediaValutazioni()>1){%>
            <p><div class="ratings"> <i class="fa fa-star rating-color"></i> <i class="fa fa-star rating-color"></i> <i class="fa fa-star"></i> <i class="fa fa-star"></i> <i class="fa fa-star"></i></div></div></p>
        <%}%>
        <%if(videogioco.getMediaValutazioni()<=1 && videogioco.getMediaValutazioni()>0){%>
            <p><div class="ratings"> <i class="fa fa-star rating-color"></i> <i class="fa fa-star"></i> <i class="fa fa-star"></i> <i class="fa fa-star"></i> <i class="fa fa-star"></i></div></div></p>
        <%}%>
        <%if(videogioco.getMediaValutazioni()==0){%>
            <p><div class="ratings"> <i class="fa fa-star"></i> <i class="fa fa-star"></i> <i class="fa fa-star"></i> <i class="fa fa-star"></i> <i class="fa fa-star"></i></div></div></p>
        <%}%>
    </ul>
        <%if(Objects.isNull(autoreVal)){
            if(!Objects.isNull(utenteVal)){
                if(!Objects.isNull(valutazione)){
            %>
                <div id="valutazione2" style="float: right">
                    <p>Hai già inserito una valutazione</p>
                    <p>Inserisci nuova valutazione(sostituirà la precedente)</p>
                    <h6 class="mb-0">Inserisci valutazione</h6>
                    <div class="rating"><input type="radio" name="rating2" value="5" id="10"><label for="10"><span>&#9734</span></label> <input type="radio" name="rating2" value="4" id="9"><label for="9"><span>&#9734</span></label> <input type="radio" name="rating2" value="3" id="8"><label for="8"><span>&#9734</span></label> <input type="radio" name="rating2" value="2" id="7"><label for="7"><span>&#9734</span></label> <input type="radio" name="rating2" value="1" id="6"><label for="6"><span>&#9734</span></label></div>
                    <div id="bottoneValutazione2" class="buttons px-4 mt-0"><button class="btn btn-block rating-submit" style="background-color: turquoise">Invia valutazione</button></div>
                    <script>
                        $("#bottoneValutazione2").bind("click", function(){
                            rating2('<%=videogioco.getTitolo()%>')
                        })
                    </script>
                </div>
        <%
        }else{%>
                <div id="valutazione" style="float: right">
                    <h6 class="mb-0">Inserisci valutazione</h6>
                    <div class="rating"><input type="radio" name="rating" value="5" id="5"><label for="5"><span>&#9734</span></label> <input type="radio" name="rating" value="4" id="4"><label for="4"><span>&#9734</span></label> <input type="radio" name="rating" value="3" id="3"><label for="3"><span>&#9734</span></label> <input type="radio" name="rating" value="2" id="2"><label for="2"><span>&#9734</span></label> <input type="radio" name="rating" value="1" id="1"><label for="1"><span>&#9734</span></label></div>
                    <div id="bottoneValutazione1" class="buttons px-4 mt-0"><button class="btn btn-block rating-submit" style="background-color: turquoise" >Invia valutazione</button></div>
                    <script>
                        $("#bottoneValutazione1").bind("click", function(){
                            rating('<%=videogioco.getTitolo()%>')
                        })
                    </script>
                </div>
        <%}
        }else{%>
        <ul>
            <p>Per effettuare una valutazione devi prima loggarti</p>
        </ul>
         <%}}%>
        <ul>
            <form action="${pageContext.request.contextPath}/RecensioneServlet" method="get">
                <button class="btn btn-link" style="border: 0px">Vai alla recensione
                    <input type="hidden" id="dettaglioRecensione" name="dettaglioRecensione" value="<%=videogioco.getTitolo()%>">
                </button>
            </form>
        </ul>
</div>
</div>
<footer>
    <%@include file="../partials/footerCustomer.jsp"%>
</footer>
</body>
</html>
