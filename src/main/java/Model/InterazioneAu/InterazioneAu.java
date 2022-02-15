package Model.InterazioneAu;

/**
 * classe interazioneAu, rappresenta un'entità
 */


public class InterazioneAu {
    private String comCodice;
    private String auNickname;
    private boolean aul;
    private boolean aud;

    /**
     * questo metodo resituisce il codice del commento
     * @return comCodice
     */

    public String getComCodice() {
        return comCodice;
    }

    /**
     * questo metodo imposta il codice del commento
     * @param comCodice
     */

    public void setComCodice(String comCodice) {
        this.comCodice = comCodice;
    }

    /**
     * questo metodo resituisce il nickname dell'autore
     * @return nickname
     */

    public String getAuNickname() {
        return auNickname;
    }

    /**
     * questo metodo imposta il nickname dell'autore
     * @param auNickname
     */

    public void setAuNickname(String auNickname) {
        this.auNickname = auNickname;
    }

    /**
     * questo metodo verifica se l'autore ha inserito un like
     * @return aul
     */

    public boolean isAul() {
        return aul;
    }

    /**
     * questo metodo imposta l'inserimento di un like da parte di un autore
     * @param aul
     */

    public void setAul(boolean aul) {
        this.aul = aul;
    }

    /**
     * questo metodo verifica se l'autore ha inserito un dislike
     * @return aud
     */

    public boolean isAud() {
        return aud;
    }

    /**
     * questo metodo imposta l'inserimento di un dislike da parte di un autore
     * @param aud
     */

    public void setAud(boolean aud) {
        this.aud = aud;
    }
}