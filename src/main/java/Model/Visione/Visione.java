package Model.Visione;

/**
 * classe di visione, rappresenta la tabella di relazione tra autore e videogioco
 */

public class Visione {
    private String auNickname;
    private String titolo;

    /**
     *metodo che restituisce il nickname dell'autore
     * @return auNickname
     */

    public String getAuNickname() {
        return auNickname;
    }

    /**
     *metodo che imposta il valore di auNickname con la stringa passata come parametro
     * @param auNickname
     */

    public void setAuNickname(String auNickname) {
        this.auNickname = auNickname;
    }

    /**
     *metodo che ritorna il valore della variabile titolo
     * @return titolo
     */

    public String getTitolo() {
        return titolo;
    }

    /**
     *metodo che imposta il valore di titolo con la stringa passata come parametro
     * @param titolo
     */

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
}