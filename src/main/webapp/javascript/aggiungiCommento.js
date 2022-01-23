function aggiungiCommento(codice){
    var a  = codice;
    var c  =  $("#textarea").val();
    //const array=s.split(",")
    var codici = {codiceRecensione: a, commentoRecensione: c};
    alert(c)
    $.ajax({
        type: "get",
        url: "http://localhost:8080/GameToday_war/CommentoServlet",
        contentType: "JSON", // NOT dataType!
        data:{ codici: JSON.stringify(codici)},
        success: function(response) {
            alert("Commento correttamente aggiunto!")
            //$("#commentoUtente").html(response);
            let gg = JSON.parse(response);
            $.get("/CommentoServlet", function (gg) {
                var $ul = $("<ul>").appendTo($("#commentoUtente"));
                // $.each(gg,function (index,item){
                $("<li>").text(gg).appendTo($ul);
                //});
            });
        },
        error: function(response) {
            alert('Commento non aggiunto!');
        }
    });
}