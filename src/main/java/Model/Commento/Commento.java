package Model.Commento;

public class Commento {
    private int comCodice;
    private int codice;
    private boolean dislike;
    private boolean like;
    private String testo;

    public int getComCodice() {
        return comCodice;
    }

    public void setComCodice(int comCodice) {
        this.comCodice = comCodice;
    }

    public int getCodice() {
        return codice;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public boolean isDislike() {
        return dislike;
    }

    public void setDislike(boolean dislike) {
        this.dislike = dislike;
    }

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }
}