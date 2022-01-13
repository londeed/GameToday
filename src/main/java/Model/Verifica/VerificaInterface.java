package Model.Verifica;

import Model.Commento.Commento;
import Model.InterazioneAu.InterazioneAu;
import Model.Supervisione.Supervisione;

import java.sql.SQLException;
import java.util.List;

public interface VerificaInterface
{
     Boolean delete(String comCodice) throws SQLException;
     Boolean update (Commento commento, String comCodice) throws SQLException;
     Verifica doRetrieveInterazioneAmByCodice(String comCodice) throws SQLException;
     List<Verifica> doRetrieveInterazioneAmByNickname(String amNickname) throws SQLException;
     Boolean insertVerifica(String comCodice, String amNickname) throws SQLException;

}
