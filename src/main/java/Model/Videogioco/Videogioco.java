package Model.Videogioco;

import java.sql.Date;

/**
 * classe videogioco, rappresenta un'entità del database
 */

public class Videogioco {
    private String titolo;
    private int pegi;
    private int totaleVoti;
    private String casaProduttrice;
    private double mediaValutazioni;
    private String piattaforma;
    private Date dataPubblicazione;
    private String tipologia;

    /**
     *metodo che restituisce titolo del videogioco
     * @return titolo
     */

    public String getTitolo() {
        return titolo;
    }

    /**
     * metodo che imposta titolo del videogioco con una stringa passata come parametro
     * @param titolo
     */

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    /**
     * metodo che restituisce pegi del videogioco
     * @return pegi
     */

    public int getPegi() {
        return pegi;
    }

    /**
     * metodo che imposta pegi del videogioco con un intero passato come parametro
     * @param pegi
     */

    public void setPegi(int pegi) {
        this.pegi = pegi;
    }

    /**
     * metodo che restituisce totaleVoti del videogioco
     * @return totaleVoti
     */

    public int getTotaleVoti() {
        return totaleVoti;
    }

    /**
     * metodo che imposta totaleVoti con un intero passato come parametro
     * @param totaleVoti
     */

    public void setTotaleVoti(int totaleVoti) {
        this.totaleVoti = totaleVoti;
    }

    /**
     * metodo che restituisce casaProduttrice del videogioco
     * @return casaProduttrice
     */

    public String getCasaProduttrice() {
        return casaProduttrice;
    }

    /**
     * metodo che imposta casaProduttrice del videogioco con una stringa passata come parametro
     * @param casaProduttrice
     */

    public void setCasaProduttrice(String casaProduttrice) {
        this.casaProduttrice = casaProduttrice;
    }

    /**
     * metodo che restituisce mediaValutazioni del videogioco
     * @return mediaValutazioni
     */

    public double getMediaValutazioni() {
        return mediaValutazioni;
    }

    /**
     * metodo che imposta mediaValutazioni del videogioco con un double passato come parametro
     * @param mediaValutazioni
     */

    public void setMediaValutazioni(double mediaValutazioni) {
        this.mediaValutazioni = mediaValutazioni;
    }

    /**
     * metodo che restituisce piattaforma del videogioco
     * @return piattaforma
     */

    public String getPiattaforma() {
        return piattaforma;
    }

    /**
     * metodo che imposta piattaforma del videogioco con una stringa passata come parametro
     * @param piattaforma
     */

    public void setPiattaforma(String piattaforma) {
        this.piattaforma = piattaforma;
    }

    /**
     * metodo che restituisce dataPubblicazione del videogioco
     * @return dataPubblicazione
     */

    public Date getDataPubblicazione() {
        return dataPubblicazione;
    }

    /**
     * metodo che imposta dataPubblicazione del videogioco con una data passata come parametro
     * @param dataPubblicazione
     */

    public void setDataPubblicazione(Date dataPubblicazione) {
        this.dataPubblicazione = dataPubblicazione;
    }

    /**
     * metodo che restituisce tipologia del videogioco
     * @return tipologia
     */

    public String getTipologia() {
        return tipologia;
    }

    /**
     * metodo che imposta tipologia del videogioco con una stringa passata come parametro
     * @param tipologia
     */

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

}