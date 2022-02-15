package Model.InterazioneAu;

import Model.Commento.Commento;

import java.sql.SQLException;
import java.util.List;

/**
 * interfaccia che implementa i metodi presenti in InterazioneAuDAO
 */

public interface InterazioneAuInterface {

    /**
     * questo metodo restituisce un interazione tramite il commento del codice
     * @param comCodice
     * @return interazioneAu
     * @throws SQLException
     */

    InterazioneAu doRetrieveInterazioneAuByCodice(String comCodice) throws SQLException;

    /**
     * questo metodo restituisce una lista di interazioni tramite il nickname dell'autore
     * @param auNickname
     * @return lista di interazioni
     * @throws SQLException
     */

    List<InterazioneAu> doRetrieveInterazioneAuByNickname(String auNickname) throws SQLException;

    /**
     * questo metodo restituisce una lista di commenti tramite il codice
     * @param comCodice
     * @return commento
     * @throws SQLException
     */

    Commento doRetrieveCommentoAuByCodice(String comCodice) throws SQLException;

    /**
     * questo metodo restituisce una lista di commenti tramite l'interazione
     * @param auNickname
     * @return lista di commenti
     * @throws SQLException
     */

    List<Commento> doRetrieveCommentoAuByNickname(String auNickname) throws SQLException;

    /**
     * questo metodo inserisce un interazione
     * @param comCodice
     * @param auNickname
     * @param aul
     * @param aud
     * @return boolean
     * @throws SQLException
     */

    Boolean insertByAutore(String comCodice, String auNickname, Boolean aul, Boolean aud) throws SQLException ;

    /**
     * questo metodo restituics una lista di nickname tramite il commento del codice
     * @param comCodice
     * @return lista di stringhe
     * @throws SQLException
     */

    List<String> doRetrieveNicknameAuByComCodice(String comCodice) throws SQLException;

    /**
     * restituisce il nickname dell'autore che ha scritto il commento
     * @param comCodice
     * @return stringa
     * @throws SQLException
     */

    String doRetrieveByCreazioneCommento(String comCodice) throws SQLException;

    /**
     * restituisce interazioneAu
     * @param comCodice
     * @return interazioneAu
     * @throws SQLException
     */

    InterazioneAu doRetrieveInterazioneCreazioneCommento(String comCodice)throws SQLException;

    /**
     * questo metodo permette di eliminare un interazione
     * @param comCodice
     * @param nickname
     * @param like
     * @param dislike
     * @return boolean
     * @throws SQLException
     */

    Boolean delete(String comCodice,String nickname,boolean like,boolean dislike)throws SQLException;
}