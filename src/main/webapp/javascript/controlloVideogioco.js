function validateForm(form)
{
    let Titolo = $("#Titolo").val();
    if(Titolo==""){
        document.getElementById("titolonullo").style.display = "block";
        document.getElementById("tbr").style.display = "block";
        return false;
    }

    if(Titolo.length>50){
        document.getElementById("titololungo").style.display = "block";
        document.getElementById("tbrsbagliato").style.display = "block";
        return false;
    }

    let CasaProduttrice = $("#CasaProduttrice").val();
    if(CasaProduttrice.length>20){
        document.getElementById("casalungo").style.display = "block";
        document.getElementById("cbr").style.display = "block";
        return false;
    }

    if(CasaProduttrice==""){
        document.getElementById("casanullo").style.display = "block";
        document.getElementById("cbrsbagliato").style.display = "block";
        return false;
    }

    let Tipologia = $("#Tipologia").val();
    if(Tipologia==""){
        document.getElementById("tipologianullo").style.display = "block";
        document.getElementById("tibr").style.display = "block";
        return false;
    }

    if(Tipologia.length>20){
        document.getElementById("tipologialungo").style.display = "block";
        document.getElementById("tibrsbagliato").style.display = "block";
        return false;
    }

    form.submit();
}