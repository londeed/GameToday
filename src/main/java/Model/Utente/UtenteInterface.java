package Model.Utente;

import java.sql.SQLException;
import java.util.List;

/**
 * interfaccia che implementa i metodi presenti in UtenteDAO
 */

public interface UtenteInterface
{

    /**
     * questo metodo restituisce tutti gli utenti
     * @return lista di utenti
     * @throws SQLException
     */

    List<Utente> doRetrieveUtenteAll() throws SQLException;

    /**
     * questo metodo crea un nuovo utente
     * @param utente
     * @return boolean
     * @throws SQLException
     */

    Boolean createUtente(Utente utente) throws SQLException;

    /**
     * questo metodo aggiorna l'utente tramite il nickname
     * @param utente
     * @param utNickname
     * @return boolean
     * @throws SQLException
     */
    Boolean updateUtente(Utente utente, String utNickname) throws SQLException;

    /**
     * questo metodo elimina un utente tramite il nickname
     * @param utNickname
     * @return boolean
     * @throws SQLException
     */

    Boolean deleteUtente(String utNickname) throws SQLException;

    /**
     * questo metodo permette all'utente di effettuare il login
     * @param email
     * @param password
     * @return utente
     * @throws SQLException
     */

    Utente loginUtente(String email, String password) throws SQLException;

    /**
     * questo metodo conta il numero di utenti
     * @return N° di utenti
     * @throws SQLException
     */

    int countAll() throws SQLException;

    /**
     * questo metodo restituisce un utente tramite l'email
     * @param email
     * @return utente
     * @throws SQLException
     */

    Utente doRetrieveUtenteByEmail(String email) throws SQLException;

    /**
     * questo metodo restituisce un utente tramite il nickname
     * @param utNickname
     * @return utente
     * @throws SQLException
     */

    Utente doRetrieveUtenteByNickname(String utNickname) throws SQLException;
}
