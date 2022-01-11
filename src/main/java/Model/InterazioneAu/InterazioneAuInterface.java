package Model.InterazioneAu;

import Model.Commento.Commento;
import Model.Gestione.Gestione;

import java.sql.SQLException;
import java.util.List;

public interface InterazioneAuInterface
{
    List<InterazioneAu> doRetrieveGameAsTitle(int comCodice, String auNickname) throws SQLException;
    List<Commento> doRetrieveAllByAutore(int comCodice, String auNickname) throws SQLException;
}