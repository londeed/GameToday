function validateForm(form)
{
    let testoInserito = $("#testoInserito").val();
    if(testoInserito==""){
        document.getElementById("inserito").style.display = "block";
        document.getElementById("tbr").style.display = "block";
        return false;
    }

    form.submit();
}