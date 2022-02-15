/**
 * questa funzione ci permette di controllare i parametri inseriti per effettuare il login
 * @param form
 * @returns {boolean}
 */

function validateForm(form)
{
    //let email = document.getElementById('email').value;
    let email = $("#email").val();
    console.log(email);
    let password = $("#password").val();
    console.log(password)
    let e_pattern = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    //Minimo otto e massimo 32 caratteri, almeno una lettera maiuscola, una lettera minuscola, un numero e un carattere speciale:
    let p_pattern = /^((?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$&*])).{8,32}$/;
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
    form.submit();
}