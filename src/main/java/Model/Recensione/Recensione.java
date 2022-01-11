package Model.Recensione;

import java.util.Date;

public class Recensione {
    private int codice;
    private String autore;
    private Date data;
    private String testo;
    private String auNickname;
    private String titolo;

    public int getCodice() {
        return codice;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    public String getAuNickname() {
        return auNickname;
    }

    public void setAuNickname(String auNickname) {
        this.auNickname = auNickname;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
}