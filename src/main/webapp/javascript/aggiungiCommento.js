/**
 * Javascript utilizzato per l'aggiunta di commenti
 */

var nome ;
var like ;
var dislike;
var verifica;
var avatar;
var text = [];
var n = 0;

/**
 * questa funzione permette di aggiungere un commento alle recensioni
 * @param x
 */

 function aggiungiCommento(x){

    const array = x.split(",")

    nome = array[1];
    like = array[2];
    dislike = array[3];
    verifica = array[4];
    var selettore = array[5];
    avatar = array[6];
    var c = $("#textarea").val();
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
         //var input = $("<textarea class=\"form-control\" type=\"text\" id=\"utCommento\" aria-label=\"Disabled input example\" style=\"resize: none\" disabled readonly >").appendTo($("#commentoUtente"));
         //document.querySelector('#utCommento').setAttribute("id", "utCommento" + numero)
         var input = $("<div id=\"utCommento\" style=\"border:solid turquoise;border-radius: 10px;padding: 2%\">").appendTo($("#commentoUtente"));
         document.querySelector('#utCommento').setAttribute("id", "utCommento" + numero)
         var commentoNumero = "utCommento" + numero;
         let testo = $("#textarea").val();
         let testoCambiato = testo.replace('merda','*****');
         testoCambiato = testoCambiato.replace('cazzo','*****');
         testoCambiato = testoCambiato.replace('negro','*****');
         testoCambiato = testoCambiato.replace('vaffanculo','*****');
         testoCambiato = testoCambiato.replace('fanculo','*****');
         testoCambiato = testoCambiato.replace('imbecille','*****');
         testoCambiato = testoCambiato.replace('puttana','*****');
         testoCambiato = testoCambiato.replace('stronzo','*****');
         testoCambiato = testoCambiato.replace('mongoloide','*****');
         testoCambiato = testoCambiato.replace('idiota','*****');
         testoCambiato = testoCambiato.replace('coglione','*****');
         text[n] = testoCambiato;
         n += 1;
         text[n] = commentoNumero;
         n += 1;
         document.querySelector('#utCommento' + numero).innerHTML = testoCambiato;
         var div = $("<div class=\"row row-cols-lg-auto g-3 align-items-center\" style=\"padding-top: 10px\;float: left\" id=\"div\" >").appendTo($("#commentoUtente"));
         document.querySelector('#div').setAttribute("id", "div" + numero)
         var modifica = $("<button id=\"ModificaBottone\" type='button' onclick='modificaCreati()'>").appendTo($("#div"+numero));
         document.querySelector("#ModificaBottone").setAttribute("onclick", 'modificaCreati("'+"utCommento"+numero+'")')
         document.querySelector("#ModificaBottone").setAttribute("id", "ModificaBottone" + numero)
         document.querySelector("#ModificaBottone"+numero).innerHTML = "Modifica"
         var elimina = $("<button id=\"eliminaBottone\" type='button' onclick='elimina()'>").appendTo($("#div"+numero));
         document.querySelector("#eliminaBottone").setAttribute("onclick", 'elimina("'+"utCommento"+numero+'")')
         document.querySelector("#eliminaBottone").setAttribute("id", "eliminaBottone" + numero)
         document.querySelector("#eliminaBottone"+numero).innerHTML = "Elimina"
        var codici = {numeroCom: commentoNumero, codiceRecensione: array[0], commentoRecensione: c, user: nome, tipologia: selettore};
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

/**
 * questa funzione permette di creare un codice numerico per l'id dei commenti creati
 * @param min
 * @param max
 * @returns {number}
 */

function getRandomInt(min, max) {
    min = Math.ceil(min);
    max = Math.floor(max);
    return Math.floor(Math.random() * (max - min)) + min;
}

/**
 * questa funzione restituisce codice numerico (id dei commenti)
 * @returns {number}
 */

function uniqid() {
    var id = getRandomInt(0, Date.now());
    return id;
}

/**
 * questa funzione permette il salvataggio dei like e dei dislike dei commenti appena creati
 * @param valore
 * @param x
 */

function salvaInterazione(valore,x){
    var verifica = x;
    if(verifica) {
        var v = valore;
        var n = "utCommento" + numero;
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

/**
 * questa funzione permette il salvataggio dei like e dei dislike per i commenti già presenti nel database
 * @param stringa
 * @constructor
 */

function CommentoEsistente(stringa){
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
}

/**
 * questa funzione permette di eliminare un commento
 * @param numeroCommento
 */

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

/**
 * questa funzione permette di modificare un commento appena creato
 * @param numeroCommento
 */

function modificaCreati(numeroCommento){
    var num = numeroCommento
    var modal = document.getElementById("myModal");
    var btn = document.getElementById("ModificaBottone"+num);
    var span = document.getElementsByClassName("close")[0];

    alert(text[0]);
    var length = text.length;
    var test;
    var v;
    for (var i = 1; i <= length; i++) {
        console.log(text[i]);
        if(text[i] === num){
            test = text[--i]
            v = i;
            ++i;
        }
        i++;
    }

        $("#modificatore").val(test);
        modal.style.display = "block";

    span.onclick = function() {
        modal.style.display = "none";
    }

    var btnMod = document.getElementById("salvaModifica");
    var testo;
    btnMod.onclick = function() {
        testo = $("#modificatore").val();
        text[v] = testo
        $("#" + num).html(testo)
        var code = {numCom: num, testo: testo};
        $.ajax({
            type: "get",
            url: "http://localhost:8080/GameToday_war/CommentoServlet/modificaCreati",
            contentType: "JSON", // NOT dataType!
            data: {code: JSON.stringify(code)},
            success: function (response) {
                alert("Modifica riuscita");
            },
            error: function (response) {
                alert('Errore, modifica non riuscita');
            }
        });
        modal.style.display = "none";
    }

window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

}

/**
 * questa funzione permette di modificare un commento
 * @param cod
 */

function modifica(cod){
    var h = cod

    var modal = document.getElementById("myModal");

    var btn = document.getElementById("ModificaBottone2"+h);

    var span = document.getElementsByClassName("close")[0];

        let test = $("#ajax2"+h).html()
        $("#modificatore").val(test);
        modal.style.display = "block";

    span.onclick = function() {
        modal.style.display = "none";
    }

    var btnMod = document.getElementById("salvaModifica");
    var testo;

    btnMod.onclick = function() {
        testo = $("#modificatore").val();
        $("#ajax2"+h).html(testo)
        var modificato = {testo: testo,codideComm: cod};
        $.ajax({
            type: "get",
            url: "http://localhost:8080/GameToday_war/CommentoServlet/modifica",
            contentType: "JSON", // NOT dataType!
            data:{ modificato: JSON.stringify(modificato)},
            success: function(response) {
                alert("Modifica riuscita");
            },
            error: function(response) {
                alert('Errore, modifica non riuscita');
            }
        });
        modal.style.display = "none";
    }

    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
}

/**
 * questa funzione permette di confermare la modfica di un commento
 * @param cod
 */

function confermaModifica(cod){
        var q = cod
        document.getElementById("textarea"+q).disabled = true;
        document.getElementById("textarea"+q).readonly = true;
        document.getElementById("ConfermaModifica2"+q).innerHTML = "Modifica";
        document.getElementById("ConfermaModifica2"+q).setAttribute("id", "ModificaBottone2"+q)
}