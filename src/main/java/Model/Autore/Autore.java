package Model.Autore;

import java.sql.Date;

public class Autore extends AutoreAbstract {
    private String auNickname;
    private String nome;
    private String cognome;
    private int avatar;
    private String email;
    private String password;
    private int recEffettuate;
    private String recCommissionate;
    private Date scadenza;
    private int like;
    private int dislike;

    public String getAuNickname() {
        return auNickname;
    }

    public void setAuNickname(String auNickname) {
        this.auNickname = auNickname;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    @Override
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRecEffettuate() {
        return recEffettuate;
    }

    public void setRecEffettuate(int recEffettuate) {
        this.recEffettuate = recEffettuate;
    }

    public String getRecCommissionate() {
        return recCommissionate;
    }

    public void setRecCommissionate(String recCommissionate) {
        this.recCommissionate = recCommissionate;
    }

    public Date getScadenza() {
        return scadenza;
    }

    public void setScadenza(Date scadenza) {
        this.scadenza = scadenza;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getDislike() {
        return dislike;
    }

    public void setDislike(int dislike) {
        this.dislike = dislike;
    }

    @Override
    public boolean isNull() { return false; }
}