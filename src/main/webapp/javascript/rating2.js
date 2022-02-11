function rating2(titolo){
    let valutazione2 = $('input[name="rating2"]:checked').val();
    let val = {valutazione: valutazione2,titolo: titolo}
    $.ajax({
        type: "get",
        url: "http://localhost:8080/GameToday_war/VideogiocoServlet/valutazione",
        contentType: "JSON", // NOT dataType!
        data: {val: JSON.stringify(val)},
        success: function (response) {
            $("#valutazione2").html("Grazie per la tua valutazione!")
        },
        error: function (response) {
            alert('Valutazione non riuscita!');
        }
    });
}
