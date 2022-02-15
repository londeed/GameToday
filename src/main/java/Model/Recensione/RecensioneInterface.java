package Model.Recensione;

import java.sql.SQLException;
import java.util.List;

/**
 * interfaccia che implementa i metodi presenti in RecensioneDAO
 */

public interface RecensioneInterface
{

    /**
     * questo metodo resituisce una recensione tramite il codice
     * @param codice
     * @return recensione
     * @throws SQLException
     */

    Recensione doRetrieveByCodice(String codice) throws SQLException;

    /**
     * questo metodo restituisce una recensione tramite il titolo
     * @param titolo
     * @return recensione
     * @throws SQLException
     */

    Recensione doRetrieveByTitolo(String titolo) throws SQLException;

    /**
     * questo metodo restituisce una lista di recensioni tramite il nickname
     * @param autore
     * @return lista di recensioni
     * @throws SQLException
     */

    List<Recensione> doRetrieveByAutore(String autore) throws SQLException;

    /**
     * questo metodo permette l'inserimento di una recensione
     * @param recensione
     * @return boolean
     * @throws SQLException
     */

    Boolean insertRecensione(Recensione recensione) throws SQLException;

    /**
     * questo metodo permette l'aggiornamento di una recensione
     * @param recensione
     * @param codice
     * @return
     * @throws SQLException
     */

    Boolean updateRecensione(Recensione recensione, String codice) throws SQLException;

    /**
     * questo metodo permette l'aggiornamento del testo di una una recensione
     * @param recensione
     * @param codice
     * @return
     * @throws SQLException
     */

    Boolean updateRecensioneText(String recensione, String codice) throws SQLException;

    /**
     * questo metodo permette l'aggiornamento del testo di una recensione da inviare all'utente
     * @param recensione
     * @param titolo
     * @return
     * @throws SQLException
     */

    Boolean updateRecensioneTextbis(String recensione, String titolo) throws SQLException;

    /**
     * questo metodo permette l'eliminazione di una recensione
     * @param codice
     * @return boolean
     * @throws SQLException
     */

    Boolean deleterecensione(String codice) throws SQLException;

    /**
     * questo metodo permette di contare le recensioni
     * @return N° di recensioni
     * @throws SQLException
     */


    int countAll() throws SQLException;

    /**
     * questo metodo restituisce le recensioni ordinate per data
     * @return lista di recensioni
     * @throws SQLException
     */

    List<Recensione> doRetrieveAllByDataPubblicazione() throws SQLException;

    /**
     * questo metodo restituisce le recensioni con data nulla
     * @return lista di recensioni
     * @throws SQLException
     */

    List<Recensione> doRetrieveAllByDataisNull() throws SQLException;

    /**
     * questo metodo permette l'approvazione di una recensione da parte dell'autore
     * @param titolo
     * @return boolean
     * @throws SQLException
     */

    Boolean updateRecensioneApprovata(String titolo) throws SQLException;

    /**
     * questo metodo restituisce le recensioni ordinate per data (LIMIT 1)
     * @return
     * @throws SQLException
     */

    Recensione doRetrieveByDataUltima() throws SQLException;

    /**
     * questo metodo restituisce la prima recensione ordinata per data
     * @return
     * @throws SQLException
     */

    Recensione doRetrieveByDataPrima() throws SQLException;
}