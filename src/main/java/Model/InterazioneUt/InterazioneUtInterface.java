package Model.InterazioneUt;

import Model.Commento.Commento;

import java.sql.SQLException;
import java.util.List;

/**
 * interfaccia che implementa i metodi presenti in InterazioneUtDAO
 */


public interface InterazioneUtInterface {

    /**
     * questo metodo resituisce l'interazione tramite il codice del commento
     * @param comCodice
     * @return interazioneUt
     * @throws SQLException
     */

    InterazioneUt doRetrieveInterazioneUtByCodice(String comCodice) throws SQLException;

    /**
     * questo metodo resituisce una lista di interazioni tramite il nickname dell'utente
     * @param utNickname
     * @return lista di interazioni
     * @throws SQLException
     */

    List<InterazioneUt> doRetrieveInterazioneUtByNickname(String utNickname) throws SQLException;

    /**
     * restituisce un commento tramite il suo codice
     * @param comCodice
     * @return commento
     * @throws SQLException
     */

    Commento doRetrieveCommentoUtByCodice(String comCodice) throws SQLException;

    /**
     * questo metodo restituisce una lista di commenti tramite il loro codice unito al nickname dell'utente
     * @param utNickname
     * @return lista di commenti
     * @throws SQLException
     */

    List<Commento> doRetrieveCommentoUtByNickname(String utNickname) throws SQLException;

    /**
     * questo metodo permette all'utente di inserire un commento
     * @param comCodice
     * @param utNickname
     * @param utl
     * @param utd
     * @return boolean
     * @throws SQLException
     */

    Boolean insertByUtente(String comCodice, String utNickname, Boolean utl, Boolean utd) throws SQLException;

    /**
     * questo metoddo restituisce i nickname tramite i codici del commento
     * @param comCodice
     * @return lista di stringhe
     * @throws SQLException
     */

    List<String> doRetrieveNicknameUtByComCodice(String comCodice) throws SQLException;

    /**
     * questo metodo restituisce il nickname dell'utente tramite le sue interazioni(like e dislike)
     * @param comCodice
     * @return stringa
     * @throws SQLException
     */

    String doRetrieveByCreazioneCommento(String comCodice) throws SQLException;

    /**
     * questo metodo restituisce un interazione tramite il codice del commento unito a like e dislike
     * @param comCodice
     * @return interazioneUt
     * @throws SQLException
     */

    InterazioneUt doRetrieveInterazioneCreazioneCommento(String comCodice)throws SQLException;

    /**
     * questo metodo permette di eliminare un interazioneUt tramite il codice del commento unito al nickname dell'utente
     * ed ai sui like e dislike
     * @param comCodice
     * @param nickname
     * @param like
     * @param dislike
     * @return boolean
     * @throws SQLException
     */

    Boolean delete(String comCodice,String nickname,boolean like,boolean dislike)throws SQLException;
}