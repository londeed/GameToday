package Model.Utente;

public class UtenteNull extends UtenteAbstract{

    private String utNickname;
    private String nome;
    private String cognome;
    private int avatar;
    private String email;
    private String password;
    private int valEffettuate;
    private int like;
    private int dislike;

    public String getUtNickname() {
        return utNickname;
    }

    public void setUtNickname(String utNickname) {
        this.utNickname = utNickname;
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

    public int getValEffettuate() {
        return valEffettuate;
    }

    public void setValEffettuate(int valEffettuate) {
        this.valEffettuate = valEffettuate;
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
    public boolean isNull() { return true; }
}
