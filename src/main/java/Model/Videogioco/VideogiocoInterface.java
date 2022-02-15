package Model.Videogioco;

import Model.Connessione.ConPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * interfaccia che implementa i metodi presenti in VideogiocoDAO
 */

public interface VideogiocoInterface
{

    /**
     * metodo che interroga il database per restituire un oggetto videogioco con un
     * determinato titolo corrispondente alla stringa passata come parametro
     * @param titolo
     * @return Videogioco
     * @throws SQLException
     */

    Videogioco doRetrieveByTitolo(String titolo) throws SQLException;

    /**
     * metodo che interroga il database per restituire una lista di videogiochi con una mediaValutazioni
     * corrispondente al double passato come parametro
     * @param mediaValutazioni
     * @return Lista di videogiochi
     * @throws SQLException
     */

    List<Videogioco> doRetriveBymediaValutazioni(double mediaValutazioni) throws SQLException;

    /**
     * metodo che interroga il database per restituire la lista dei videogiochi
     * @return Lista di videogiochi
     * @throws SQLException
     */

    List<Videogioco> doRetriveAll() throws SQLException;

    /**
     * metodo che interroga il database per restituire una lista di videogiochi con casaProduttrice corrispondente alla
     * stringa passata come parametro
     * @param casaProduttrice
     * @return Lista di videogiochi
     * @throws SQLException
     */



    List<Videogioco> doRetriveByCasaProduttrice(String casaProduttrice) throws SQLException;

    /**
     * metodo che interroga il database per restituire una lista di videogiochi con piattaforma corrispondente alla
     * stringa passata come parametro
     * @param piattaforma
     * @return
     * @throws SQLException
     */

    List<Videogioco> doRetriveByPiattaforma(String piattaforma) throws SQLException;

    /**
     * metodo che interroga il database per inserire un videogioco tramite un oggetto videogioco passato come parametro
     * @param videogioco
     * @return boolean
     * @throws SQLException
     */

    Boolean insertVideogioco(Videogioco videogioco) throws SQLException;

    /**
     * metodo che interroga il database per aggiornare un videogioco corrispondente alla stringa passata come parametro
     * con un oggetto videogioco passato come parametro
     * @param videogioco
     * @param titolo
     * @return boolean
     * @throws SQLException
     */

    Boolean updateVideogioco(Videogioco videogioco, String titolo) throws SQLException;

    /**
     * metodo che interroga il database per eliminare un videogioco con il titolo
     * corrispondente alla stringa passata come parametro
     * @param titolo
     * @return boolean
     * @throws SQLException
     */

    Boolean deleteVideogico(String titolo) throws SQLException;

    /**
     * metodo che interroga il database per restituire il numero di tutti gli elementi presenti nella tabella videogioco
     * @return size
     * @throws SQLException
     */

    int countAll() throws SQLException;

    /**
     * metodo che interroga il database per restituire una lista di videogiochi ordinata tramite titolo
     * @return Lista di videogiochi
     * @throws SQLException
     */

    List<Videogioco> doRetrieveAllByTitolo() throws SQLException;

    /**
     * metodo che interroga il database per restituire una lista di videogiochi con il titolo che completa o corrisponde
     * alla stringa passata come parametro
     * @param s
     * @return Lista di videogiochi
     * @throws SQLException
     */

    List<Videogioco> doRetrieveAllByTitoloSearch(String s) throws SQLException;

    /**
     * metodo che interroga il database per restituire una lista di videogiochi con il titolo non presente all'interno
     * dell'attributo titolo delle recensioni
     * @return Lista di videogiochi
     * @throws SQLException
     */

    List<Videogioco> doRetrieveByNull() throws SQLException;

    /**
     * metodo che interroga il database per restituire una lista di tre videogiochi ordinati in modo discendente
     * tramite dataPubblicazione
     * @return Lista di videogiochi
     * @throws SQLException
     */

    List<Videogioco> doRetrieveByData() throws SQLException;
}
