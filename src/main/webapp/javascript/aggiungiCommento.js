function aggiungiCommento(){
    var c  =  $("#textarea").val();
    //const array=s.split(",")
   // var aggiunta = {
     //   codiceM: array[0],id: array[1]  ,fcodice: c, quantita: q,registrato: array[2]
    //};
    $.ajax({
        type: "get",
        url: "http://localhost:8080/GameToday/CommentoServlet",
        contentType: "JSON", // NOT dataType!
        data:{ c: JSON.stringify(c)},
        success: function(response) {
            alert("Commento correttamente aggiunto!")
        },
        error: function(response) {
            alert('Commento non aggiunto!');
        }
    });
}