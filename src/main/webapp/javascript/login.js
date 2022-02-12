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
    form.submit();
}