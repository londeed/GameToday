function validateForm(form)
{
    let testoModificato = $("#testoModificato").val();
    if(testoModificato==""){
        document.getElementById("inserito").style.display = "block";
        document.getElementById("tbr").style.display = "block";
        return false;
    }

    form.submit();
}