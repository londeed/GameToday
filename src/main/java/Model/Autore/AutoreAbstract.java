package Model.Autore;

/**
 * Classe abstract utilizzata per implementare il design pattern NullObject
 */

    public abstract class AutoreAbstract {
        protected String email;

    /**
     * metodo utilizzato per verificare se l'autore è null
     * @return
     */

    public abstract boolean isNull();

    /**
     * metodo utilizzato per controllare l'email
     * @return
     */

        public abstract String getEmail();
}
