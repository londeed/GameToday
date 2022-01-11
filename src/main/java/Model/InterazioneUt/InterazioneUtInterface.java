package Model.InterazioneUt;

import Model.Commento.Commento;
import Model.InterazioneAu.InterazioneAu;

import java.sql.SQLException;
import java.util.List;

public interface InterazioneUtInterface
{
    List<InterazioneUt> doRetrieveGameAsTitle(int comCodice, String utNickname) throws SQLException;
    List<Commento> doRetrieveAllByUtente(int comCodice, String utNickname) throws SQLException;
}
