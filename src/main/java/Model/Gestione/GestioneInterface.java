package Model.Gestione;

import java.sql.SQLException;
import java.util.List;

public interface GestioneInterface
{
    List<Gestione> doRetrieveGamebyAdmin(String amNickname) throws SQLException;
    Gestione doRetrieveGameAsTitle(String titolo) throws SQLException;
    Boolean insertGestione(String amNickname, String titolo) throws SQLException;
}
