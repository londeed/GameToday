package Model.Recensione;

import java.sql.Date;

/**
 * classe recensione, rappresenta un'entità
 */


public class Recensione {
    private String codice;
    private String auNome;
    private Date data;
    private String testo;
    private String auNickname;
    private String titolo;

    /**
     * questo metodo restituisce il codice della recensione
     * @return codice
     */

    public String getCodice() {
        return codice;
    }

    /**
     * questo metodo imposta il codice della recensione
     * @param codice
     */

    public void setCodice(String codice) {
        this.codice = codice;
    }

    /**
     * questo metodo restituisce il nome della recensione
     * @return nome
     */

    public String getAuNome() {
        return auNome;
    }

    /**
     * questo metodo imposta il nome della recensione
     * @param auNome
     */

    public void setAuNome(String auNome) {
        this.auNome = auNome;
    }

    /**
     * questo metodo restituisce la data della recensione
     * @return data
     */

    public Date getData() {
        return data;
    }

    /**
     * questo metodo imposta la data della recensione
     * @param data
     */

    public void setData(Date data) {
        this.data = data;
    }

    /**
     * questo metodo restituisce il testo della recensione
     * @return testo
     */

    public String getTesto() {
        return testo;
    }

    /**
     * questo metodo imposta il testo della recensione
     * @param testo
     */

    public void setTesto(String testo) {
        this.testo = testo;
    }

    /**
     * questo metodo restituisce il nickname della recensione
     * @return nickname
     */

    public String getAuNickname() {
        return auNickname;
    }

    /**
     * questo metodo imposta il nickname della recensione
     * @param auNickname
     */

    public void setAuNickname(String auNickname) {
        this.auNickname = auNickname;
    }

    /**
     * questo metodo restituisce il titolo della recensione
     * @return titolo
     */

    public String getTitolo() {
        return titolo;
    }

    /**
     * questo metodo imposta il titolo della recensione
     * @param titolo
     */

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
}