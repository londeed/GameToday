package Model.Amministratore;

public class Amministratore extends AmministratoreAbstract {
    private String amNickname;
    private String nome;
    private String cognome;
    private int avatar;
    private String email;
    private String password;
    private int videogiochiInseriti;

    public Amministratore(String amNickname) {
        this.amNickname = amNickname;
    }

    @Override
    public String getAmNickname() {
        return amNickname;
    }

    public void setAmNickname(String amNickname) {
        this.amNickname = amNickname;
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

    public int getVideogiochiInseriti() {
        return videogiochiInseriti;
    }

    public void setVideogiochiInseriti(int videogiochiInseriti) {
        this.videogiochiInseriti = videogiochiInseriti;
    }

    @Override
    public boolean isNull() { return false; }
}