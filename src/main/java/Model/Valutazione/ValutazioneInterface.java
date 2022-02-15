package Model.Valutazione;

import Model.Videogioco.Videogioco;

import java.sql.SQLException;
import java.util.List;

/**
 * interfaccia che implementa i metodi presenti in ValutazioneDAO
 */

public interface ValutazioneInterface
{

    /**
     * metodo che interroga il database per restituire una lista di valutazione con UtNickname corrispondente alla
     * stringa passata come parametro
     * @param utNickname
     * @return Lista di valutazione
     * @throws SQLException
     */

    List<Valutazione> doRetrieveValutazioneByUtente(String utNickname) throws SQLException;

    /**
     * metodo che interroga il database per restituire una lista di valutazione con Titolo corrispondente alla
     * stringa passata come parametro
     * @param titolo
     * @return Lista di valutazione
     * @throws SQLException
     */

    List<Valutazione> doRetrieveValutazioneByTitolo(String titolo) throws SQLException;

    /**
     * metodo che interroga il database per inserire un elemento valutazione tramite UtNickname dell'utente
     * e Titolo del videogioco passati come parametro
     * @param titolo
     * @param utNickname
     * @return boolean
     * @throws SQLException
     */

    Valutazione insertByUtente(String titolo, String utNickname) throws SQLException;

    /**
     * metodo che interroga il database per aggiornare MediaValutazioni di un elemento valutazione, con Titolo
     * corrispondente alla stringa passata come parametro, tramite un intero passato come parametro
     * @param titolo
     * @param value
     * @return boolean
     * @throws SQLException
     */

    Videogioco updateValutazione(String titolo, int value) throws SQLException;

    /**
     * metodo che interroga il database per restituire un elemento valutazione con Titolo e UtNickname corrispondenti
     * alle rispettive stringhe passate come parametro
     * @param titolo
     * @param utNickname
     * @return Valutazione
     * @throws SQLException
     */

    Valutazione doRetrieveValutazione(String titolo,String utNickname) throws SQLException;
}
