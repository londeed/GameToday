package Model.Valutazione;

/**
 * classe valutazione, rappresenta la tabella di relazione tra utente e videogioco
 */

public class Valutazione {
    private String utNickname;
    private String titolo;

    /**
     * metodo che restituisce utNickname di valutazione
     * @return utNickname
     */

    public String getUtNickname() {
        return utNickname;
    }

    /**
     * metodo che imposta il valore di utNickname di valutazione con la stringa passata come parametro
     * @param utNickname
     */

    public void setUtNickname(String utNickname) {
        this.utNickname = utNickname;
    }

    /**
     * metodo che restituisce titolo di valutazione
     * @return titolo
     */

    public String getTitolo() {
        return titolo;
    }

    /**
     * metodo che imposta il valore di titolo di valutazione con la stringa passata come parametro
     * @param titolo
     */

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
}