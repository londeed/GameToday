package Model.InterazioneUt;

public class InterazioneUt {
    private String comCodice;
    private String utNickname;
    private boolean utl;
    private boolean utd;

    public String getComCodice() {
        return comCodice;
    }

    public void setComCodice(String comCodice) {
        this.comCodice = comCodice;
    }

    public String getUtNickname() {
        return utNickname;
    }

    public void setUtNickname(String utNickname) {
        this.utNickname = utNickname;
    }

    public boolean isUtl() {
        return utl;
    }

    public void setUtl(boolean utl) {
        this.utl = utl;
    }

    public boolean isUtd() {
        return utd;
    }

    public void setUtd(boolean utd) {
        this.utd = utd;
    }
}