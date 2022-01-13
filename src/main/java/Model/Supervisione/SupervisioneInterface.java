package Model.Supervisione;

import Model.Commento.Commento;
import Model.InterazioneUt.InterazioneUt;
import Model.Recensione.Recensione;
import Model.Verifica.Verifica;

import java.sql.SQLException;
import java.util.List;

public interface SupervisioneInterface
{
    Supervisione doRetrieveSupervisioneByCodice(String codice) throws SQLException;
    List<Supervisione> doRetrieveSupervisioneByNickname(String amNickname) throws SQLException;
    Boolean update (Recensione recensione, String codice) throws SQLException;
    Boolean insertByAmministratore(String codice, String amNickname) throws SQLException;
}
