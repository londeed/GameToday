package Model.InterazioneUt;

import Model.Commento.Commento;

import java.sql.SQLException;
import java.util.List;

public interface InterazioneUtInterface {

    InterazioneUt doRetrieveInterazioneUtByCodice(String comCodice) throws SQLException;
    List<InterazioneUt> doRetrieveInterazioneUtByNickname(String utNickname) throws SQLException;
    Commento doRetrieveCommentoUtByCodice(String comCodice) throws SQLException;
    List<Commento> doRetrieveCommentoUtByNickname(String utNickname) throws SQLException;
    Boolean insertByUtente(String comCodice, String utNickname, Boolean utl, Boolean utd) throws SQLException;
    List<String> doRetrieveNicknameUtByComCodice(String comCodice) throws SQLException;
    String doRetrieveByCreazioneCommento(String comCodice) throws SQLException;
    InterazioneUt doRetrieveInterazioneCreazioneCommento(String comCodice)throws SQLException;
    Boolean delete(String comCodice,String nickname,boolean like,boolean dislike)throws SQLException;
}