package Model.Supervisione;

import Model.Commento.Commento;
import Model.InterazioneUt.InterazioneUt;

import java.sql.SQLException;
import java.util.List;

public interface SupervisioneInterface
{
    List<Supervisione> doRetrieveRecensioneAsAdmin(int codice, String amNickname) throws SQLException;
    List<Supervisione> doRetrieveAllByUtente(String utNickname) throws SQLException;
    Supervisione insertByAmministratore(int codice, String amNickname);
}
