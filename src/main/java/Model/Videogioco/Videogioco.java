package Model.Videogioco;

import java.sql.Date;

public class Videogioco {
    private String titolo;
    private int pegi;
    private int totaleVoti;
    private String casaProduttrice;
    private double mediaValutazioni;
    private String piattaforma;
    private Date dataPubblicazione;
    private String tipologia;

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getPegi() {
        return pegi;
    }

    public void setPegi(int pegi) {
        this.pegi = pegi;
    }

    public int getTotaleVoti() {
        return totaleVoti;
    }

    public void setTotaleVoti(int totaleVoti) {
        this.totaleVoti = totaleVoti;
    }

    public String getCasaProduttrice() {
        return casaProduttrice;
    }

    public void setCasaProduttrice(String casaProduttrice) {
        this.casaProduttrice = casaProduttrice;
    }

    public double getMediaValutazioni() {
        return mediaValutazioni;
    }

    public void setMediaValutazioni(double mediaValutazioni) {
        this.mediaValutazioni = mediaValutazioni;
    }

    public String getPiattaforma() {
        return piattaforma;
    }

    public void setPiattaforma(String piattaforma) {
        this.piattaforma = piattaforma;
    }

    public Date getDataPubblicazione() {
        return dataPubblicazione;
    }

    public void setDataPubblicazione(Date dataPubblicazione) {
        this.dataPubblicazione = dataPubblicazione;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }
}