package Model.Recensione;

import java.sql.Date;

public class Recensione {
    private String codice;
    private String auNome;
    private Date data;
    private String testo;
    private String auNickname;
    private String titolo;

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getAuNome() {
        return auNome;
    }

    public void setAuNome(String auNome) {
        this.auNome = auNome;
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