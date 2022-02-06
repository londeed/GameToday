package Model.InterazioneAu;

import Model.Commento.Commento;
import Model.Connessione.ConPool;
import Model.Gestione.Gestione;
import Model.InterazioneUt.InterazioneUt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public interface InterazioneAuInterface {

    InterazioneAu doRetrieveInterazioneAuByCodice(String comCodice) throws SQLException;
    List<InterazioneAu> doRetrieveInterazioneAuByNickname(String auNickname) throws SQLException;
    Commento doRetrieveCommentoAuByCodice(String comCodice) throws SQLException;
    List<Commento> doRetrieveCommentoAuByNickname(String auNickname) throws SQLException;
    Boolean insertByAutore(String comCodice, String auNickname, Boolean aul, Boolean aud) throws SQLException ;
    List<String> doRetrieveNicknameAuByComCodice(String comCodice) throws SQLException;
    String doRetrieveByCreazioneCommento(String comCodice) throws SQLException;
    InterazioneAu doRetrieveInterazioneCreazioneCommento(String comCodice)throws SQLException;
    Boolean delete(String comCodice,String nickname,boolean like,boolean dislike)throws SQLException;
}