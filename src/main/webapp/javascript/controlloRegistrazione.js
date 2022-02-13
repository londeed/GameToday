function validateForm(form)
{
    let UtNome = $("#UtNome").val();
    if(UtNome.length<2){
        document.getElementById("nome").style.display = "block";
        document.getElementById("br").style.display = "block";
        return false;
    }

    if(UtNome.length>15){
        document.getElementById("nomelungo").style.display = "block";
        document.getElementById("brlungo").style.display = "block";
        return false;
    }

    let p_pattern = /^(?=.*?[A-Z])(?=.*?[a-z]).{2,15}$/;
    if(!UtNome.match(p_pattern)){
        document.getElementById("nomesbagliato").style.display = "block";
        document.getElementById("brsbagliato").style.display = "block";
        return false;
    }

    let UtCognome = $("#UtCognome").val();
    if(UtCognome.length<2){
        document.getElementById("cognome").style.display = "block";
        document.getElementById("cbr").style.display = "block";
        return false;
    }

    if(UtCognome.length>15){
        document.getElementById("cognomelungo").style.display = "block";
        document.getElementById("cbrlungo").style.display = "block";
        return false;
    }

    if(!UtCognome.match(p_pattern)){
        document.getElementById("cognomesbagliato").style.display = "block";
        document.getElementById("cbrsbagliato").style.display = "block";
        return false;
    }

    form.submit();
}