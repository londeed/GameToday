/**
 * questa funzione ci permette di gestire le valutazioni
 * @param titolo
 */

function rating(titolo){
    let valutazione = $('input[name="rating"]:checked').val();
    let val = {valutazione: valutazione,titolo: titolo}
    $.ajax({
        type: "get",
        url: "http://localhost:8080/GameToday_war/VideogiocoServlet/valutazione",
        contentType: "JSON", // NOT dataType!
        data: {val: JSON.stringify(val)},
        success: function (response) {
            $("#valutazione").html("Grazie per la tua valutazione!")
        },
        error: function (response) {
            alert('Valutazione non riuscita!');
        }
    });
}