package Model.Amministratore;

import java.sql.SQLException;
import java.util.List;

public interface AmministratoreInterface
{
    List<Amministratore> doRetrieveAllAmministratore() throws SQLException;
    Boolean createAmministratore(Amministratore amministratore) throws SQLException;
    Boolean updateAmministratore(Amministratore amministratore, String amNickname) throws SQLException;
    Boolean deleteAmministratore(String amNickname) throws SQLException;
    Amministratore loginAmministratore(String email, String password) throws SQLException;
    int countAll() throws SQLException;
    Amministratore doRetrieveAmministratoreByEmail(String email) throws SQLException;
}