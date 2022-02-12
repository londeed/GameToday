package Model.Verifica;

/**
 * classe verifica, rappresenta la tabella di relazione tra amministratore e commento
 */

public class Verifica {
    private String comCodice;
    private String amNickname;

    /**
     * metodo che restituisce comCodice di verifica
     * @return comCodice
     */

    public String getComCodice() {
        return comCodice;
    }

    /**
     * metodo che imposta il valore di comCodice con la stringa passata come parametro
     * @param comCodice
     */

    public void setComCodice(String comCodice) {
        this.comCodice = comCodice;
    }

    /**
     * metodo che restituisce amNickname di verifica
     * @return amNickname
     */

    public String getAmNickname() {
        return amNickname;
    }

    /**
     * metodo che imposta il valore di amNickname con la stringa passata come parametro
     * @param amNickname
     */

    public void setAmNickname(String amNickname) {
        this.amNickname = amNickname;
    }
}