/**
 * questa funzione ci permette di controllare i parametri inseriti durante la registrazione
 * @param form
 * @returns {boolean}
 */

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

    let UtNickname = $("#UtNickname").val();
    if(UtNickname.length<2){
        document.getElementById("nickname").style.display = "block";
        document.getElementById("nbr").style.display = "block";
        return false;
    }

    if(UtNickname.length>15){
        document.getElementById("nicknamelungo").style.display = "block";
        document.getElementById("nbrlungo").style.display = "block";
        return false;
    }

    if(!UtNickname.match(p_pattern)){
        document.getElementById("nicknamesbagliato").style.display = "block";
        document.getElementById("nbrsbagliato").style.display = "block";
        return false;
    }

    let UtEmail = $("#UtEmail").val();
    if(UtEmail.length<2){
        document.getElementById("email").style.display = "block";
        document.getElementById("ebr").style.display = "block";
        return false;
    }

    let p_patternEmail = /^[\w-\.]{2,}@([\w-]+\.)+[\w-]{2,4}$/;

    if(!UtEmail.match(p_patternEmail)){
        document.getElementById("emailsbagliato").style.display = "block";
        document.getElementById("ebrsbagliato").style.display = "block";
        return false;
    }

    let UtAvatar = $("#UtAvatar").val();
    if(UtAvatar==""){
        document.getElementById("avatarsbagliato").style.display = "block";
        document.getElementById("abrsbagliato").style.display = "block";
        return false;
    }

    let UtPW = $("#UtPW").val();
    if(UtPW.length<8){
        document.getElementById("pw").style.display = "block";
        document.getElementById("pbr").style.display = "block";
        return false;
    }

    if(UtPW.length>20){
        document.getElementById("pwlungo").style.display = "block";
        document.getElementById("pbrlungo").style.display = "block";
        return false;
    }

    let p_patternPw = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[^\w\s]).{8,20}$/;
    if(!UtPW.match(p_patternPw)){
        document.getElementById("pwsbagliato").style.display = "block";
        document.getElementById("pbrsbagliato").style.display = "block";
        return false;
    }

    form.submit();
}