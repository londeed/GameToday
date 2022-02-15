package Model.Gestione;

import java.sql.SQLException;
import java.util.List;

/**
 * interfaccia che implementa i metodi presenti in GestioneDAO
 */

public interface GestioneInterface
{

    /**
     * questo metodo restituisce tutti i videogiochi inseriti da un amministratore identificato tramite il nickname
     * @param amNickname
     * @return lista gestione
     * @throws SQLException
     */

    List<Gestione> doRetrieveGamebyAdmin(String amNickname) throws SQLException;

    /**
     * questo metodo restituisce tutti i videogiochi inseriti da un amministratore identificato tramite il loro titolo
     * @param titolo
     * @return lista gestione
     * @throws SQLException
     */

    Gestione doRetrieveGameAsTitle(String titolo) throws SQLException;

    /**
     * questo metodo inserisce nel database un videogioco collegandolo all'autore tramite i loro nickname e titolo
     * @param amNickname
     * @param titolo
     * @return lista gestione
     * @throws SQLException
     */

    Boolean insertGestione(String amNickname, String titolo) throws SQLException;
}
