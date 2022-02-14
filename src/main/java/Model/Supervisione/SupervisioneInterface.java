package Model.Supervisione;

import Model.Recensione.Recensione;

import java.sql.SQLException;
import java.util.List;

/**
 * interfaccia che implementa i metodi presenti in SupervisioneDAO
 */

public interface SupervisioneInterface
{

    /**
     * metodo che interroga il database per restituire un oggetto supervisione con il Codice corrispondente alla
     * stringa passata come parametro
     * @param codice
     * @return Supervisione
     * @throws SQLException
     */

    Supervisione doRetrieveSupervisioneByCodice(String codice) throws SQLException;

    /**
     * metodo che interroga il database per restituire una lista di Supervisione con AmNickname corrispondente alla
     * stringa passata come parametro
     * @param amNickname
     * @return List<Supervisione>
     * @throws SQLException
     */

    List<Supervisione> doRetrieveSupervisioneByNickname(String amNickname) throws SQLException;

    /**
     * metodo che interroga il database per aggiornare un elemento recensione, con Codice corrispondente alla stringa
     * passata come parametro, tramite l'oggetto recensione anch'esso passato come parametro
     * @param recensione
     * @param codice
     * @return Boolean
     * @throws SQLException
     */

    Boolean update (Recensione recensione, String codice) throws SQLException;

    /**
     * metodo che interroga il database per inserire un oggetto supervisione tramite una stringa Codice e una
     * stringa AmNickname passate come parametri
     * @param codice
     * @param amNickname
     * @return Boolean
     * @throws SQLException
     */

    Boolean insertByAmministratore(String codice, String amNickname) throws SQLException;
}
