package Model.Autore;

import java.sql.Date;

/**
 * classe autore, rappresenta un'entità
 */

public class AutoreNull extends AutoreAbstract {

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

    /**
     * questo metodo restituisce il NickName dell'autore
     * @return auNickname
     */

    public String getAuNickname() {
        return auNickname;
    }

    /**
     * questo metodo imposta il Nickname dell'autore
     * @param auNickname
     */

    public void setAuNickname(String auNickname) {
        this.auNickname = auNickname;
    }

    /**
     * questo metodo restituisce il nome dell'autore
     * @return nome
     */

    public String getNome() {
        return nome;
    }

    /**
     * questo metodo imposta il nome all'autore
     * @param nome
     */

    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * questo metodo restituisce il cognome dell'autore
     * @return cognome
     */

    public String getCognome() {
        return cognome;
    }

    /**
     * questo metodo imposta il cognome dell'autore
     * @param cognome
     */

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * questo metodo restituisce l'avatar dell'autore
     * @return avatar
     */

    public int getAvatar() {
        return avatar;
    }

    /**
     *questo metodo imposta l'avatar dell'autore
     * @param avatar
     */

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    /**
     * questo metodo restituisce l'email dell'autore
     * @return email
     */

    @Override
    public String getEmail() {
        return email;
    }

    /**
     * questo metodo imposta l'email dell'autore
     * @param email
     */

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * questo metodo restituisce la password dell'autore
     * @return password
     */

    public String getPassword() {
        return password;
    }

    /**
     * questo metodo imposta la password dell'autore
     * @param password
     */

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * questo metodo restituisce il numero di recensioni effettuate
     * @return recEffettuate
     */

    public int getRecEffettuate() {
        return recEffettuate;
    }

    /**
     * questo metodo imposta il numero di recensione effettuate
     * @param recEffettuate
     */

    public void setRecEffettuate(int recEffettuate) {
        this.recEffettuate = recEffettuate;
    }

    /**
     * questo metodo restituisce la recensione presa in carico dall'autore
     * @return recCommissionate
     */

    public String getRecCommissionate() {
        return recCommissionate;
    }

    /**
     * questo metodo imposta la recensione presa in carico dall'autore
     * @param recCommissionate
     */

    public void setRecCommissionate(String recCommissionate) {
        this.recCommissionate = recCommissionate;
    }

    /**
     * questo metodo restituisce la scadenza della recensione
     * @return scadenza
     */

    public Date getScadenza() {
        return scadenza;
    }

    /**
     * questo metodo imposta la scadenza della recensione
     * @param scadenza
     */

    public void setScadenza(Date scadenza) {
        this.scadenza = scadenza;
    }

    /**
     * questo metodo restituisce il numero di like inseriti dall'autore
     * @return like
     */

    public int getLike() {
        return like;
    }

    /**
     * questo metodo imposta il numero di like inseriti dall'autore
     * @param like
     */

    public void setLike(int like) {
        this.like = like;
    }

    /**
     * questo metodo restituisce il numero di dislike inseriti dall'autore
     * @return dislike
     */

    public int getDislike() {
        return dislike;
    }

    /**
     * questo metodo imposta il numero di dislike inseriti dall'autore
     * @param dislike
     */

    public void setDislike(int dislike) {
        this.dislike = dislike;
    }

    /**
     * questo metodo verifica se l'autore è nullo
     * questo metodo è utilizzato nel pattern NullObject
     * @return true
     */

    @Override
    public boolean isNull() { return true; }
}
