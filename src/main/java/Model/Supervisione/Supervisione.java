package Model.Supervisione;

/**
 * classe supervisione, rappresenta la tabella di relazione tra amministratore e recensione
 */

public class Supervisione {
    private String amNickname;
    private String codice;

    /**
     * metodo che restituisce amNickname di supervisione
     * @return amNickname
     */

    public String getAmNickname() {
        return amNickname;
    }

    /**
     * metodo che imposta il valore di amNickname di supervisione con la stringa passata come parametro
     * @param amNickname
     */

    public void setAmNickname(String amNickname) {
        this.amNickname = amNickname;
    }

    /**
     * metodo che restituisce codice di supervisione
     * @return codice
     */

    public String getCodice() {
        return codice;
    }

    /**
     * metodo che imposta il valore di codice di supervisione con la stringa passata come parametro
     * @param codice
     */

    public void setCodice(String codice) {
        this.codice = codice;
    }
}
