package Model.Amministratore;

/**
 * classe amministratore, rappresenta un entità
 */

public class AmministratoreNull extends AmministratoreAbstract {

        private String amNickname;
        private String nome;
        private String cognome;
        private int avatar;
        private String email;
        private String password;
        private int videogiochiInseriti;

    /**
     * questo metodo restituisce il NickName dell'amministratore
     * @return amNickname
     */

        public String getAmNickname() {
            return amNickname;
        }

    /**
     * questo metodo imposta il NickName all'amministratore
     * @param amNickname
     */

        public void setAmNickname(String amNickname) {
            this.amNickname = amNickname;
        }

    /**
     * questo metodo restituisce il nome dell'amministratore
     * @return nome
     */

        public String getNome() {
            return nome;
        }

    /**
     * questo metodo imposta il Nome all'amministratore
     * @param nome
     */

        public void setNome(String nome) {
            this.nome = nome;
        }

    /**
     * questo metodo restituisce il Cognome dell'amministratore
     * @return cognome
     */

        public String getCognome() {
            return cognome;
        }

    /**
     * questo metodo imposta il Cognome all'amministratore
     * @param cognome
     */

        public void setCognome(String cognome) {
            this.cognome = cognome;
        }

    /**
     * questo metodo restituisce l'avatr dell'amministratore
     * @return avatar
     */

        public int getAvatar() {
            return avatar;
        }

    /**
     * questo metodo imposta l'avatr all'amministratore
     * @param avatar
     */

        public void setAvatar(int avatar) {
            this.avatar = avatar;
        }

    /**
     * questo metodo restituisce l'email dell'amministratore
     * questo metodo è utilizzato nel pattern NullObject
     * @return email
     */

        @Override
        public String getEmail() {
            return email;
        }

    /**
     * questo metodo imposta l'email all'amministratore
     * @param email
     */

        public void setEmail(String email) {
            this.email = email;
        }

    /**
     * questo metodo restituisce la password dell'amministratore
     * @return password
     */

        public String getPassword() {
            return password;
        }

    /**
     * questo metodo imposta la password all'amministratore
     * @param password
     */

        public void setPassword(String password) {
            this.password = password;
        }

    /**
     * questo metodo restituisce il numero di videogiochi inseriti
     * @return videogiochiInseriti
     */

        public int getVideogiochiInseriti() {
            return videogiochiInseriti;
        }

    /**
     * questo metodo imposta il numero di videogiochi inseriti
     * @param videogiochiInseriti
     */

        public void setVideogiochiInseriti(int videogiochiInseriti) {
            this.videogiochiInseriti = videogiochiInseriti;
        }

    /**
     * questo metodo verifica se l'amministratore è nullo
     * questo metodo è utilizzato nel pattern NullObject
     * @return false
     */

        @Override
        public boolean isNull() { return true; }
}
