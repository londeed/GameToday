package Model.Gestione;

/**
 * classe gestione, rappresenta un'entità
 */


public class Gestione {
    private String amNickname;
    private String titolo;

    /**
     * questo metodo restituisce il nickname dell'amministratore
     * @return nickname
     */

    public String getAmNickname() {
        return amNickname;
    }

    /**
     * questo metodo imposta il nickname dell'amministratore
     * @param amNickname
     */

    public void setAmNickname(String amNickname) {
        this.amNickname = amNickname;
    }

    /**
     * questo metodo restituisce il titolo del videogioco
     * @return titolo
     */

    public String getTitolo() {
        return titolo;
    }

    /**
     * questo metodo imposta il titolo del videogioco
     * @param titolo
     */

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
}