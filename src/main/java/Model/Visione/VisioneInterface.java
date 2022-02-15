package Model.Visione;

import java.sql.SQLException;
import java.util.List;

/**
 * interfaccia che implementa i metodi presenti in VisioneDAO
 */

public interface VisioneInterface
{
    /**
     *metodo che interroga il database per restituire tutti gli elementi visione con un
     * determinato nickname autore passato come parametro
     * @param auNickname
     * @return Lista di visione
     * @throws SQLException
     */

    List<Visione> doRetrieveVisioneByAutore(String auNickname) throws SQLException;

    /**
     * metodo che interroga il database per restituire tutti gli elementi visione con un
     * determinato titolo passato come parametro
     * @param titolo
     * @return Lista di visione
     * @throws SQLException
     */

    List<Visione> doRetrieveVisioneByTitolo(String titolo) throws SQLException;

    /**
     * metodo che interroga il database per inserire un elemento visione tramite il nickname dell'autore
     * e il titolo del videogioco passati come parametro
     * @param auNickname
     * @param titolo
     * @return boolean
     * @throws SQLException
     */

    Boolean insertVisione(String auNickname,String titolo) throws SQLException;
}