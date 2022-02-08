/*
function login(){
    var x = document.getElementById("appareLogin");
    if (x.style.display === "none") {
        x.style.display = "block";
        $("#appareLogin").show();
        var y = document.getElementById("main");
        y.style.height = "100%";
        y.style.width = "100%";
        y.style.position = "fixed";
        y.style.zIndex = "3"
        y.style.backgroundcolor = "333333";
        y.style.filter = "alpha(opacity=50)";
        y.style.opacity = "0.50";
        y.style.mozopacity = "0.50";
        $("#oscura").show();
    } else {
        x.style.display = "none";
        $("#oscura").hide();
    }
}*/


function validateForm(form)
{
    //let email = document.getElementById('email').value;
    let email = $("#email").val();
    console.log(email);
    let password = $("#password").val();
    console.log(password)
    let e_pattern = /^[\w-\.]{2,}@([\w-]+\.)+[\w-]{2,4}$/;
    //Minimo otto e massimo 32 caratteri, almeno una lettera maiuscola, una lettera minuscola, un numero e un carattere speciale:
    let p_pattern = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[^\w\s]).{8,20}$/;
    if(!password.match(p_pattern)){
        $("#password").css("background-color", "rgba(255, 0, 0, 0.5)");
        alert("Dati password errati");
        return false;
    }
    if(!email.match(e_pattern)){
        $("#email").css("background-color", "rgba(255, 0, 0, 0.5)");
        alert("Dati email errati");
        return false;
    }
    alert(email)
    alert(password)
    form.submit();
}

/*function invia(){
    /*var email = $("#floatingInput").val();
    var password = $("#floatingPassword").val();
    var credenziali = {Email: email, Password: password};
    alert(credenziali)
    $.ajax({
        type: "get",
        url: "http://localhost:8080/GameToday_war/UserServlet/login",
        contentType: "JSON", // NOT dataType!
        data: {credenziali: JSON.stringify(credenziali)},
        success: function (response) {
            //location.reload();
            alert("Loggato con successo!");
        },
        error: function (response) {
            alert('Errore in fase di login!');
        }
    });
}*/