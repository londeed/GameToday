/**
 * questa funzione ci permette di controllare i parametri inseriti durante l'inserimento delle recensioni
 * @param form
 * @returns {boolean}
 */

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