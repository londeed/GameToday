package Model.Utente;

/**
 * classe utente, rappresenta un'entità
 */


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

    /**
     * questo metodo restituisce il nickname dell'utente
     * @return utNickname
     */

    public String getUtNickname() {
        return utNickname;
    }

    /**
     * questo metodo imposta il nickname dell'utente
     * @param utNickname
     */

    public void setUtNickname(String utNickname) {
        this.utNickname = utNickname;
    }

    /**
     * questo metodo restituisce il nome dell'utente
     * @return nome
     */

    public String getNome() {
        return nome;
    }

    /**
     * questo metodo imposta il nome dell'utente
     * @param nome
     */

    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * questo metodo restituisce il cognome dell'utente
     * @return cognome
     */

    public String getCognome() {
        return cognome;
    }

    /**
     * questo metodo imposta il cognome dell'utente
     * @param cognome
     */

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * questo metodo restituisce l'avatar dell'utente
     * @return avatar
     */

    public int getAvatar() {
        return avatar;
    }

    /**
     * questo metodo imposta l'avatar dell'utente
     * @param avatar
     */

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    /**
     * questo metodo restituisce l'email dell'utente
     * @return email
     */

    @Override
    public String getEmail() {
        return email;
    }

    /**
     * questo metodo imposta l'email dell'utente
     * @param email
     */

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * questo metodo restituisce la password dell'utente
     * @return password
     */

    public String getPassword() {
        return password;
    }

    /**
     * questo metodo imposta la password dell'utente
     * @param password
     */

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * questo metodo restituisce il numero di valutazioni effettuate dall'utente
     * @return N° valutazioni
     */

    public int getValEffettuate() {
        return valEffettuate;
    }

    /**
     * questo metodo imposta il numero di valutazioni effettuate dall'utente
     * @param valEffettuate
     */

    public void setValEffettuate(int valEffettuate) {
        this.valEffettuate = valEffettuate;
    }

    /**
     * questo metodo restituisce il numero di like inseriti dall'utente
     * @return N° like
     */

    public int getLike() {
        return like;
    }

    /**
     * questo metodo imposta il numero di like inseriti dall'utente
     * @param like
     */

    public void setLike(int like) {
        this.like = like;
    }

    /**
     * questo metodo restituisce il numero di dislike inseriti dall'utente
     * @return N° dislike
     */

    public int getDislike() {
        return dislike;
    }

    /**
     * questo metodo imposta il numero di dislike inseriti dall'utente
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
