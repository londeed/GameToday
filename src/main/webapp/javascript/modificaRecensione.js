/**
 * questa funzione ci permette di controllare i parametri inseriti per effettuare la modifica della recensione
 * @param form
 * @returns {boolean}
 */

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