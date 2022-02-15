package Model.Commento;

import java.sql.SQLException;
import java.util.List;

/**
 * interfaccia che implementa i metodi presenti in CommentoDAO
 */

public interface CommentoInterface
{
    /**
     * questo metodo restituisce un commento in base al codice
     * @param codice
     * @return commento
     * @throws SQLException
     */

    Commento doRetrieveByCodice(String codice) throws SQLException;

    /**
     * questo metodo permette di inseerire un commento
     * @param commento
     * @return boolean
     * @throws SQLException
     */


    Boolean insertCommento(Commento commento) throws SQLException;

    /**
     * questo metodo permette di aggiornare un commento in base al codice
     * @param commento
     * @param comCodice
     * @return boolean
     * @throws SQLException
     */

    Boolean updateCommento(Commento commento, String comCodice) throws SQLException;

    /**
     * questo metodo permette di eliminare un commento in base al codice
     * @param comCodice
     * @return boolean
     * @throws SQLException
     */

    Boolean deleteCommento(String comCodice) throws SQLException;

    /**
     * questo metodo permette di contare il numero di commenti presenti nel database
     * @return N° di commenti
     * @throws SQLException
     */

    int countAll() throws SQLException;

    /**
     * questo metodo permette di ritornare la lista dei codici dei commenti
     * @return lista dei codici
     * @throws SQLException
     */

    List<String> doRetrieveAllCodiciCommenti() throws SQLException;

    /**
     * questo metodo permette di ritornare un commenti in base ai codici
     * @param codice
     * @return lista di commenti
     * @throws SQLException
     */

    List<Commento> doRetrieveAllCommentiByCodice(String codice) throws SQLException;

    /**
     * questo metodo permette di aggiornare le interazioni
     * @param comCodice
     * @param interazione
     * @return boolean
     * @throws SQLException
     */

    Boolean updateInterazione(String comCodice, String interazione) throws SQLException;

    /**
     * questo metodo permette di aggiornare il testo dei commenti
     * @param testo
     * @param comCodice
     * @return boolean
     * @throws SQLException
     */

    Boolean updateTesto(String testo, String comCodice) throws SQLException;

    /**
     * query innestata per il ritorno per i commenti non verificati
     * @return lista di commenti
     * @throws SQLException
     */

    List<Commento> doRetrieveAllCommentinotVerfied() throws SQLException;

    /**
     * questo metodo restituisce tutti i commenti
     * @return lista commenti
     * @throws SQLException
     */

    List<Commento> doRetrieveAll() throws SQLException;

    /**
     * query innestata
     * @return stringa
     * @throws SQLException
     */


    String doRetrieveCodiceByMaxCommenti() throws SQLException;
}
