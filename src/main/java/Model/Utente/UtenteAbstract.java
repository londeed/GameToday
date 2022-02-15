package Model.Utente;

/**
 * Classe abstract utilizzata per implementare il design pattern NullObject
 */

public abstract class UtenteAbstract {
    protected String email;

    /**
     * metodo utilizzato per verificare se l'utente è null
     * @return boolean
     */

    public abstract boolean isNull();

    /**
     * metodo utilizzato per controllare l'email
     * @return email
     */

    public abstract String getEmail();
}
