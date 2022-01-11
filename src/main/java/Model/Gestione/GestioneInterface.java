package Model.Gestione;

import java.sql.SQLException;
import java.util.List;

public interface GestioneInterface
{
    List<Gestione> doRetrieveGameAsTitle(String amNickname, String titolo) throws SQLException;
}