
var nome ;
var like ;
var dislike;
var verifica;
var avatar;

 function aggiungiCommento(x){
//codice,nome,like,dislike

    const array = x.split(",")

    nome = array[1];
    like = array[2];
    dislike = array[3];
    verifica = array[4];
    alert(verifica)
    var selettore = array[5];
    avatar = array[6];
    // var a  = codice;
    var c = $("#textarea").val();
    //const array=s.split(",")
     if(verifica === "true") {
         var numero = uniqid();
         var nom = nome;
         var lik = like;
         var dislik = dislike;
         var rand = Math.random();
         var involucro = $("<div class='container' id='commento'>").appendTo($("#commentoUtente"));
         document.querySelector('#commento').setAttribute("id", "commento" + numero)
         var h4 = $("<h4 id=\"utNome\" style=\"padding-top: 70px\">").appendTo($("#commento"+numero));
         var image = new Image();
         image.src = "./img/Avatar/avatar"+avatar+".png";
         document.querySelector('#utNome').innerHTML += '<img src="'+image.src+'" alt="Pic not found" class="d-block"  style="width:5%; height: 5%" />';
         document.querySelector('#utNome').setAttribute("id", "utNome" + numero)
         document.querySelector('#utNome' + numero).innerHTML += nom;
         var input = $("<textarea class=\"form-control\" type=\"text\" id=\"utCommento\" aria-label=\"Disabled input example\" style=\"resize: none\" disabled readonly >").appendTo($("#commentoUtente"));
         document.querySelector('#utCommento').setAttribute("id", "utCommento" + numero)
         var commentoNumero = "utCommento" + numero;
         let testo = $("#textarea").val();
         document.querySelector('#utCommento' + numero).innerHTML = testo;
         var div = $("<div class=\"row row-cols-lg-auto g-3 align-items-center\" style=\"padding-top: 10px\" id=\"div\" >").appendTo($("#commentoUtente"));
         document.querySelector('#div').setAttribute("id", "div" + numero)
         //var div2 = $("<div class=\"col-12\" id=\"div2\" >").appendTo($('#div' + numero));
         //document.querySelector('#div2').setAttribute("id", "div2" + numero)
         var elimina = $("<button id=\"eliminaBottone\" type='button' onclick='elimina()'>").appendTo($("#div"+numero));
         document.querySelector("#eliminaBottone").setAttribute("onclick", 'elimina("'+"utCommento"+numero+'")')
         document.querySelector("#eliminaBottone").setAttribute("id", "eliminaBottone" + numero)
         document.querySelector("#eliminaBottone"+numero).innerHTML = "Elimina"
         //var numeroCommento = {numeroCom: commentoNumero};
        var codici = {numeroCom: commentoNumero, codiceRecensione: array[0], commentoRecensione: c, user: nome, tipologia: selettore};
    // if(verifica === "true"){
         $.ajax({
             type: "get",
             url: "http://localhost:8080/GameToday_war/CommentoServlet/aggiungi",
             contentType: "JSON", // NOT dataType!
             data: {codici: JSON.stringify(codici)},
             success: function (response) {
                 //location.reload();
                 document.querySelector("#textarea").value = "";
                 alert("Commento correttamente aggiunto!");
             },
             error: function (response) {
                 alert('Commento non aggiunto!');
             }
         });
     }else{
         alert("Per creare un commento devi prima loggarti!");
     }

}

  /*function appariNuovoCommento(){
        //nome,like,dislike
        if(verifica === "true") {
            numero = uniqid();
            var nom = nome;
            var lik = like;
            var dislik = dislike;
            var rand = Math.random();
            var involucro = $("<div class='container' id='commento'>").appendTo($("#commentoUtente"));
            document.querySelector('#commento').setAttribute("id", "commento" + numero)
            var h4 = $("<h4 id=\"utNome\" style=\"padding-top: 70px\">").appendTo($("#commento"+numero));
            var image = new Image();
            image.src = "./img/Avatar/avatar"+avatar+".png";
            document.querySelector('#utNome').innerHTML += '<img src="'+image.src+'" alt="Pic not found" class="d-block"  style="width:5%; height: 5%" />';
            document.querySelector('#utNome').setAttribute("id", "utNome" + numero)
            document.querySelector('#utNome' + numero).innerHTML += nom;
            var input = $("<textarea class=\"form-control\" type=\"text\" id=\"utCommento\" aria-label=\"Disabled input example\" style=\"resize: none\" disabled readonly >").appendTo($("#commentoUtente"));
            document.querySelector('#utCommento').setAttribute("id", "utCommento" + numero)
            var commentoNumero = "utCommento" + numero;
            let testo = $("#textarea").val();
            document.querySelector('#utCommento' + numero).innerHTML = testo;
            var div = $("<div class=\"row row-cols-lg-auto g-3 align-items-center\" style=\"padding-top: 10px\" id=\"div\" >").appendTo($("#commentoUtente"));
            document.querySelector('#div').setAttribute("id", "div" + numero)
            //var div2 = $("<div class=\"col-12\" id=\"div2\" >").appendTo($('#div' + numero));
            //document.querySelector('#div2').setAttribute("id", "div2" + numero)
            var elimina = $("<button id=\"eliminaBottone\" type='button' onclick='elimina(\"utCommento\" + numero)'>").appendTo($("#div"+numero));
            document.querySelector("#eliminaBottone").setAttribute("id", "eliminaBottone" + numero)
            document.querySelector("#eliminaBottone"+numero).innerHTML = "Elimina"
            //document.querySelector('#button1').setAttribute("id", "button1" + numero)
            //var i = $("<i class=\"far fa-thumbs-up\" id=\"i\">").appendTo($('#button1' + numero));
            //document.querySelector('#i').setAttribute("id", "i" + numero)
            //var p = $("<p id=\"utLike\">").appendTo($('#i' + numero));
            //document.querySelector('#utLike').setAttribute("id", "utLike" + numero)
            //document.querySelector('#utLike' + numero).innerHTML = lik
            //var div3 = $("<div class=\"col-12\" id=\"div3\" >").appendTo($('#div' + numero));
            //document.querySelector('#div3').setAttribute("id", "div3" + numero)
            //var button2 = $("<button id=\"button2\" onclick='salvaInterazione(\"false\")'>").appendTo($('#div3' + numero));
            //document.querySelector('#button2').setAttribute("id", "button2" + numero)
            //document.querySelector('#button2'+numero).setAttribute("name","button2"+numero)
            //var i2 = $("<i class=\"far fa-thumbs-down\" id=\"i2\">").appendTo($('#button2' + numero));
            //document.querySelector('#i2').setAttribute("id", "i2" + numero)
            //var p2 = $("<p id=\"utDislike\">").appendTo($('#i2' + numero));
            //document.querySelector('#utDislike').setAttribute("id", "utDislike" + numero)
            //document.querySelector('#utDislike' + numero).innerHTML = dislik
            var numeroCommento = {numeroCom: commentoNumero};
            $.ajax({
                type: "get",
                url: "http://localhost:8080/GameToday_war/CommentoServlet/salvaNumCommenti",
                contentType: "JSON", // NOT dataType!
                data: {numeroCommento: JSON.stringify(numeroCommento)},
                success: function (response) {
                    document.querySelector("#textarea").value = "";
                    alert("Salvataggio avvenuto correttamente!");
                },
                error: function (response) {
                    alert('Salvataggio non avvenuto!');
                }
            });
        }
}*/


function getRandomInt(min, max) {
    min = Math.ceil(min);
    max = Math.floor(max);
    return Math.floor(Math.random() * (max - min)) + min;
}

function uniqid() {
    var id = getRandomInt(0, Date.now());
    return id;
}

function salvaInterazione(valore,x){
    var verifica = x;
    if(verifica) {
        var v = valore;
        var n = "utCommento" + numero;
        alert(n)
        var a;
        var b;
        if (v === "true") {
            a = "1";
            b = "0";
        } else {
            a = "0";
            b = "1";
        }
        var interazione = {likes: a, dislikes: b, num: n};
        alert("i topi non avevano nipoti")
        $.ajax({
            type: "get",
            url: "http://localhost:8080/GameToday_war/CommentoServlet/aggiungiInterazione",
            contentType: "JSON", // NOT dataType!
            data: {interazione: JSON.stringify(interazione)},
            success: function (response) {
                alert("Like o dislike correttamente aggiunto!");
            },
            error: function (response) {
                alert('Like o dislike non aggiunto!');
            }
        });
    }else{
        alert("Per interagire con un commento devi prima loggarti!");
    }
}

function CommentoEsistente(stringa){
    alert("siamo dentro")
    const array = stringa.split(",")
    var v = array[0];
    var c = array[1];
    var i = array[2];
    var interazione = {interazione: v , cCod: c , cInterazione: i};
    alert("ci siamo")
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
}
// aggiustare il testo del commento
// interazione con commento sotto al commento (?)

function elimina(numeroCommento){
    var num = numeroCommento
    var code = {numCom: num};
    $.ajax({
        type: "get",
        url: "http://localhost:8080/GameToday_war/CommentoServlet/elimina",
        contentType: "JSON", // NOT dataType!
        data:{ code: JSON.stringify(code)},
        success: function(response) {
            alert("Eliminazione riuscita");
        },
        error: function(response) {
            alert('Errore in fase di eliminazione');
        }
    });
}

function modifica(cod){
    var h = cod
    var x = $("#ModificaBottone2"+h).html()
    if(x ==="Modifica") {
let testo = $("#textarea"+h).val();
var v = document.getElementById('ajax'+h)
var z = document.getElementById('ajax2'+h)
if(v.style.display === "none"){
    v.style.display = "block";
    z.style.display = "none";
}else{
    v.style.display = "none";
    z.style.display = "block";
}
//document.getElementById("textarea2"+h).setAttribute("value","what");
$("#textarea2"+h).val("niente").trigger('change');

$("#ModificaBottone2"+h).text("Conferma Modifiche")
}else{
    let test = $("#textarea2"+h).val();
    alert(test)
    $("#ModificaBottone2"+h).text("Modifica")
    var v = document.getElementById('ajax'+h)
var z = document.getElementById('ajax2'+h)
if(v.style.display === "block"){
        v.style.display = "none";
        z.style.display = "block";
    }else{
        v.style.display = "block";
        z.style.display = "none";
    }
    alert(testo)
        document.querySelector("#textarea"+h).innerHTML = test
}
}

function confermaModifica(cod){
        var q = cod
        document.getElementById("textarea"+q).disabled = true;
        document.getElementById("textarea"+q).readonly = true;
        //document.getElementById("textarea<%=commento.getComCodice()%>").setAttribute("disabled","disabled");
        //document.getElementById("textarea<%=commento.getComCodice()%>").setAttribute("readonly","readonly");
        document.getElementById("ConfermaModifica2"+q).innerHTML = "Modifica";
        document.getElementById("ConfermaModifica2"+q).setAttribute("id", "ModificaBottone2"+q)
    /*$.ajax({
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
    });*/
}