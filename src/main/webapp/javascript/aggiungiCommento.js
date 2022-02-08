
var nome ;
var like ;
var dislike;
var verifica;
var avatar;
var text = [];
var n = 0;

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
         //var input = $("<textarea class=\"form-control\" type=\"text\" id=\"utCommento\" aria-label=\"Disabled input example\" style=\"resize: none\" disabled readonly >").appendTo($("#commentoUtente"));
         //document.querySelector('#utCommento').setAttribute("id", "utCommento" + numero)
         var input = $("<div id=\"utCommento\" style=\"border:solid turquoise;border-radius: 10px;padding: 2%\">").appendTo($("#commentoUtente"));
         document.querySelector('#utCommento').setAttribute("id", "utCommento" + numero)
         var commentoNumero = "utCommento" + numero;
         let testo = $("#textarea").val();
         text[n] = testo;
         n += 1;
         text[n] = commentoNumero;
         n += 1;
         document.querySelector('#utCommento' + numero).innerHTML = testo;
         var div = $("<div class=\"row row-cols-lg-auto g-3 align-items-center\" style=\"padding-top: 10px\;float: left\" id=\"div\" >").appendTo($("#commentoUtente"));
         document.querySelector('#div').setAttribute("id", "div" + numero)
         //var div2 = $("<div class=\"col-12\" id=\"div2\" >").appendTo($('#div' + numero));
         //document.querySelector('#div2').setAttribute("id", "div2" + numero)
         var modifica = $("<button id=\"ModificaBottone\" type='button' onclick='modificaCreati()'>").appendTo($("#div"+numero));
         document.querySelector("#ModificaBottone").setAttribute("onclick", 'modificaCreati("'+"utCommento"+numero+'")')
         document.querySelector("#ModificaBottone").setAttribute("id", "ModificaBottone" + numero)
         document.querySelector("#ModificaBottone"+numero).innerHTML = "Modifica"
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

function modificaCreati(numeroCommento){
    var num = numeroCommento
    // Get the modal
    var modal = document.getElementById("myModal");

// Get the button that opens the modal
    var btn = document.getElementById("ModificaBottone"+num);

// Get the <span> element that closes the modal
    var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal
    //btn.onclick = function() {
    var length = text.length;
    var test;
    var v;
    for (var i = 1; i <= length; i++) {
        console.log(text[i]);
        if(text[i] === num){
            test = text[--i]
            v = i;
            alert(i)
            ++i;
            alert(i)
        }
        i++;
    }
        //let test = $("#utCommento"+num).html()
        $("#modificatore").val(test);
        modal.style.display = "block";
    //}

// When the user clicks on <span> (x), close the modal
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

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

}

function modifica(cod){
    var h = cod
    // Get the modal
    var modal = document.getElementById("myModal");

// Get the button that opens the modal
    var btn = document.getElementById("ModificaBottone2"+h);

// Get the <span> element that closes the modal
    var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal
    btn.onclick = function() {
        let test = $("#ajax2"+h).html()
        $("#modificatore").val(test);
        modal.style.display = "block";
    }

// When the user clicks on <span> (x), close the modal
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

// When the user clicks anywhere outside of the modal, close it
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
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