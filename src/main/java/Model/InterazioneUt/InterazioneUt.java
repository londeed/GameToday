package Model.InterazioneUt;

/**
 * classe interazioneAu, rappresenta un'entità
 */

public class InterazioneUt {
    private String comCodice;
    private String utNickname;
    private boolean utl;
    private boolean utd;

    /**
     * questo metodo restituisce il codice del commento
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
     * questo metodo restituisce il nickname dell'utente
     * @return
     */

    public String getUtNickname() {
        return utNickname;
    }

    /**
     * questo metodo imposta il nickname del commento
     * @param utNickname
     */

    public void setUtNickname(String utNickname) {
        this.utNickname = utNickname;
    }

    /**
     * questo metodo verifica se l'utente ha messo like
     * @return bolean
     */

    public boolean isUtl() {
        return utl;
    }

    /**
     * questo metodo imposta il like messo dall'utente
     */

    public void setUtl(boolean utl) {
        this.utl = utl;
    }

    /**
     * questo metodo verifica se l'utente ha messo dislike
     * @return
     */

    public boolean isUtd() {
        return utd;
    }

    /**
     * questo metodo imposta il dislike messo dall'utente
     * @param utd
     */

    public void setUtd(boolean utd) {
        this.utd = utd;
    }
}