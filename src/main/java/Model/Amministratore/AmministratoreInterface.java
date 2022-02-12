package Model.Amministratore;

import java.sql.SQLException;
import java.util.List;

/**
 * interfaccia che implementa i metodi presenti in AmministratoreDAO
 */

public interface AmministratoreInterface
{
    /**
     * questo metodo restituisce tutti gli amministratori
     * @return Lista di amministratori
     * @throws SQLException
     */

    List<Amministratore> doRetrieveAllAmministratore() throws SQLException;

    /**
     * questo metodo crea un Amministratore
     * @param amministratore
     * @return boolean
     * @throws SQLException
     */

    Boolean createAmministratore(Amministratore amministratore) throws SQLException;

    /**
     * questo metodo aggiorna un amministratore
     * @param amministratore
     * @param amNickname
     * @return boolean
     * @throws SQLException
     */

    Boolean updateAmministratore(Amministratore amministratore, String amNickname) throws SQLException;

    /**
     * questo metodo elimina un amministratore
     * @param amNickname
     * @return boolean
     * @throws SQLException
     */

    Boolean deleteAmministratore(String amNickname) throws SQLException;

    /**
     * questo metodo permette all'amministratore di effettuare il login
     * @param email
     * @param password
     * @return amministratore
     * @throws SQLException
     */

    Amministratore loginAmministratore(String email, String password) throws SQLException;

    /**
     * questo metodo restituisce il numero degli amministratori
     * @return N° Amministratori
     * @throws SQLException
     */

    int countAll() throws SQLException;

    /**
     * questo metodo restituisce tutti gli amministratori per email
     * @param email
     * @return Amministratore
     * @throws SQLException
     */

    Amministratore doRetrieveAmministratoreByEmail(String email) throws SQLException;
}