
var nome ;
var like ;
var dislike;
var numero;
var verifica;
var avatar;
/*function controllaLogin(verifica,codice) {
    var ver = verifica;
    var code = codice;
    if (!ver) {
        var cod = {codiceCommento: code};
        $.ajax({
            type: "get",
            url: "http://localhost:8080/GameToday_war/CommentoServlet/rimuovi",
            contentType: "JSON", // NOT dataType!
            data: {cod: JSON.stringify(cod)},
            success: function (response) {
                //location.reload();
                alert("Commento correttamente aggiunto!");
            },
            error: function (response) {
                alert('Commento non aggiunto!');
            }
        });
    }
}*/

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
    var codici = {codiceRecensione: array[0], commentoRecensione: c, user: nome, tipologia: selettore};
     if(verifica === "true"){
         $.ajax({
             type: "get",
             url: "http://localhost:8080/GameToday_war/CommentoServlet/aggiungi",
             contentType: "JSON", // NOT dataType!
             data: {codici: JSON.stringify(codici)},
             success: function (response) {
                 //location.reload();
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

  function appariNuovoCommento(){
        //nome,like,dislike
        if(verifica === "true") {
            numero = uniqid();
            var nom = nome;
            var lik = like;
            var dislik = dislike;
            var rand = Math.random();
            var h4 = $("<h4 id=\"utNome\" style=\"padding-top: 70px\">").appendTo($("#commentoUtente"));
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
            var div = $("<div class=\"row row-cols-lg-auto g-3 align-items-center\" style=\"float: right; padding-top: 10px\" id=\"div\" >").appendTo($("#commentoUtente"));
            document.querySelector('#div').setAttribute("id", "div" + numero)
            var div2 = $("<div class=\"col-12\" id=\"div2\" >").appendTo($('#div' + numero));
            document.querySelector('#div2').setAttribute("id", "div2" + numero)
            var elimina = $("<button id=\"eliminaBottone\" type='button'>").appendTo($("#utCommento"+numero));
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
}


function getRandomInt(min, max) {
    min = Math.ceil(min);
    max = Math.floor(max);
    return Math.floor(Math.random() * (max - min)) + min;
}

function uniqid() {
    var id = getRandomInt(0, Date.now());
    return id;
}

/*function appariNuovoCommento(nome,like,dislike){
    numero = uniqid();
    var nom = nome;
    var lik = like;
    var dislik = dislike;
    var rand = Math.random();
    var h4 = $("<h4 id=\"utNome\" style=\"padding-top: 70px\">").appendTo($("#commentoUtente"));
   // var numero = uniqid();
    document.querySelector('#utNome').setAttribute("id","utNome"+numero)
    document.querySelector('#utNome'+numero).innerHTML = nom;
    var input = $("<input class=\"form-control\" type=\"text\" id=\"utCommento\" aria-label=\"Disabled input example\" disabled readonly >").appendTo($("#commentoUtente"));
    document.querySelector('#utCommento').setAttribute("id","utCommento"+numero)
    var commentoNumero = "utCommento"+numero;
    let testo  = $("#textarea").val();
    document.querySelector('#utCommento'+numero).setAttribute("value",""+testo)
    var div = $("<div class=\"row row-cols-lg-auto g-3 align-items-center\" style=\"float: right; padding-top: 10px\" id=\"div\" >").appendTo($("#commentoUtente"));
    document.querySelector('#div').setAttribute("id","div"+numero)
    var div2 = $("<div class=\"col-12\" id=\"div2\" >").appendTo($('#div'+numero));
    document.querySelector('#div2').setAttribute("id","div2"+numero)
    var button1 = $("<button id=\"button1\" onclick='salvaInterazione(\"true\")'>").appendTo($('#div2'+numero));
    document.querySelector('#button1').setAttribute("id","button1"+numero)
    var i = $("<i class=\"far fa-thumbs-up\" id=\"i\">").appendTo($('#button1'+numero));
    document.querySelector('#i').setAttribute("id","i"+numero)
    var p = $("<p id=\"utLike\">").appendTo($('#i'+numero));
    document.querySelector('#utLike').setAttribute("id","utLike"+numero)
    document.querySelector('#utLike'+numero).innerHTML = lik
    var div3 = $("<div class=\"col-12\" id=\"div3\" >").appendTo($('#div'+numero));
    document.querySelector('#div3').setAttribute("id","div3"+numero)
    var button2 = $("<button id=\"button2\" onclick='salvaInterazione(\"false\")'>").appendTo($('#div3'+numero));
    document.querySelector('#button2').setAttribute("id","button2"+numero)
    //document.querySelector('#button2'+numero).setAttribute("name","button2"+numero)
    var i2 = $("<i class=\"far fa-thumbs-down\" id=\"i2\">").appendTo($('#button2'+numero));
    document.querySelector('#i2').setAttribute("id","i2"+numero)
    var p2 = $("<p id=\"utDislike\">").appendTo($('#i2'+numero));
    document.querySelector('#utDislike').setAttribute("id","utDislike"+numero)
    document.querySelector('#utDislike'+numero).innerHTML = dislik
    alert(commentoNumero)
    $.ajax({
        type: "get",
        url: "http://localhost:8080/GameToday_war/CommentoServlet/salva#Commenti",
        contentType: "JSON", // NOT dataType!
        data:{ commentoNumero: JSON.stringify(commentoNumero)},
        success: function(response) {
            alert("Salvataggio avvenuto correttamente!");
        },
        error: function(response) {
            alert('Salvataggio non avvenuto!');
        }
    });
}*/

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
// aggiungere nickname e avatar dell'utente del commento
// aggiustare il testo del commento
// interazione con commento sotto al commento (?)


/*$(document).on("click", "#bottoneCommento", function() {
    $("#commentoUtente").html(response);
    let gg = JSON.parse(response);
    $.get("/CommentoServlet/aggiungiCommento", function (responseJson) {
        var $ul = $("<ul>").appendTo($("#commentoUtente"));
        $.each(responseJson,function (index,item){
            $("<li>").text(gg).appendTo($ul);
            alert("siuum")
            $.getJSON("http://localhost:8080/GameToday_war/CommentoServlet/aggiungiCommento", function (responseJson) {
                var $ul = $("<ul>").appendTo($("#commentoUtente"));
                const obj = JSON.parse(responseJson);
                alert("cod")
                $("#utCommento").innerHTML(obj.list(0));
                $.each(obj, function (index, item) {
                    $("#utCommento").innerHTML(0, item);
                    $("#utLike").innerHTML(1, item);
                    $("#utDislike").innerHTML(2, item);
                    $("<li>").text(item).appendTo($ul);
                });
            });
//});*/

function elimina(){





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

function modifica(){




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