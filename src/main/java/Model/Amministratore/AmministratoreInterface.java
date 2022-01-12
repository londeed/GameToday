package Model.Amministratore;

import Model.Utente.Utente;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

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