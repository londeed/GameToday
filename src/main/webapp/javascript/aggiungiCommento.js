function aggiungiCommento(codice){
    var a  = codice;
    var c  =  $("#textarea").val();
    //const array=s.split(",")
    var codici = {codiceRecensione: a, commentoRecensione: c};
    $.ajax({
        type: "get",
        url: "http://localhost:8080/GameToday_war/CommentoServlet/aggiungi",
        contentType: "JSON", // NOT dataType!
        data:{ codici: JSON.stringify(codici)},
        success: function(response) {
            //location.reload();
            alert("Commento correttamente aggiunto!");
        },
        error: function(response) {
            alert('Commento non aggiunto!');
        }
    });
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

function appariNuovoCommento(nome,like,dislike){
    var nom = nome;
    var lik = like;
    var dislik = dislike;
    var rand = Math.random();
    var h4 = $("<h4 id=\"utNome\" style=\"padding-top: 70px\">").appendTo($("#commentoUtente"));
    var numero = uniqid();
    document.querySelector('#utNome').setAttribute("id","utNome"+numero)
    document.querySelector('#utNome'+numero).innerHTML = nom;
    var input = $("<input class=\"form-control\" type=\"text\" id=\"utCommento\" aria-label=\"Disabled input example\" disabled readonly >").appendTo($("#commentoUtente"));
    document.querySelector('#utCommento').setAttribute("id","utCommento"+numero)
    let testo  = $("#textarea").val();
    document.querySelector('#utCommento'+numero).setAttribute("value",""+testo)
    var div = $("<div class=\"row row-cols-lg-auto g-3 align-items-center\" style=\"float: right; padding-top: 10px\" id=\"div\" >").appendTo($("#commentoUtente"));
    document.querySelector('#div').setAttribute("id","div"+numero)
    var div2 = $("<div class=\"col-12\" id=\"div2\" >").appendTo($('#div'+numero));
    document.querySelector('#div2').setAttribute("id","div2"+numero)
    var i = $("<i class=\"far fa-thumbs-up\" id=\"i\">").appendTo($('#div2'+numero));
    document.querySelector('#i').setAttribute("id","i"+numero)
    var p = $("<p id=\"utLike\">").appendTo($('#i'+numero));
    document.querySelector('#utLike').setAttribute("id","utLike"+numero)
    document.querySelector('#utLike'+numero).innerHTML = lik
    var div3 = $("<div class=\"col-12\" id=\"div3\" >").appendTo($('#div'+numero));
    document.querySelector('#div3').setAttribute("id","div3"+numero)
    var i2 = $("<i class=\"far fa-thumbs-down\" id=\"i2\">").appendTo($('#div3'+numero));
    document.querySelector('#i2').setAttribute("id","i2"+numero)
    var p2 = $("<p id=\"utDislike\">").appendTo($('#i2'+numero));
    document.querySelector('#utDislike').setAttribute("id","utDislike"+numero)
    document.querySelector('#utDislike'+numero).innerHTML = dislik
}




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