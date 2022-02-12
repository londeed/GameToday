package Model.Amministratore;

/**
 * Classe abstract utilizzata per implementare il design pattern NullObject
 */

    public abstract class AmministratoreAbstract {


        protected String email;

    /**
     * metodo utilizzato per verificare se l'amministratore è null
     * @return boolean
     */

    public abstract boolean isNull();

    /**
     * metodo utilizzato per controllare l'email
     * @return String
     */

        public abstract String getEmail();
    }