package Model.Commento;

public class Commento {
    private String comCodice;
    private String codice;
    private int dislike;
    private int like;
    private String testo;

    public String getComCodice() {
        return comCodice;
    }

    public void setComCodice(String comCodice) {
        this.comCodice = comCodice;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public int getDislike() {
        return dislike;
    }

    public void setDislike(int dislike) {
        this.dislike = dislike;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }
}