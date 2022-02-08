function registrazione(){
    $.ajax({
        type: "get",
        url: "http://localhost:8080/GameToday_war/registrazione.jsp",
        dataType: "html",
        success: function (risposta) {
            $("#sezioneLogin").html(risposta);
        },
        error: function () {
            alert("Problema del server." +
                "Riprova più tardi!");
        }
    });
}