package Model.InterazioneAu;

public class InterazioneAu {
    private String comCodice;
    private String auNickname;
    private boolean aul;
    private boolean aud;

    public String getComCodice() {
        return comCodice;
    }

    public void setComCodice(String comCodice) {
        this.comCodice = comCodice;
    }

    public String getAuNickname() {
        return auNickname;
    }

    public void setAuNickname(String auNickname) {
        this.auNickname = auNickname;
    }

    public boolean isAul() {
        return aul;
    }

    public void setAul(boolean aul) {
        this.aul = aul;
    }

    public boolean isAud() {
        return aud;
    }

    public void setAud(boolean aud) {
        this.aud = aud;
    }
}