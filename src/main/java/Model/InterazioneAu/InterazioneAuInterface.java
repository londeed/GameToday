package Model.InterazioneAu;

import Model.Commento.Commento;
import Model.Connessione.ConPool;
import Model.Gestione.Gestione;

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
}