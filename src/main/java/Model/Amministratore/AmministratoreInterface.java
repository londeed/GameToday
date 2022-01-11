package Model.Amministratore;

import Model.Utente.Utente;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface AmministratoreInterface
{
    List<Amministratore> doRetrieveAll() throws SQLException;
    Boolean createAmministratore(Amministratore amministratore) throws SQLException;
    Boolean updateAmministratore(Amministratore amministratore) throws SQLException;
    Boolean deleteAmministratore(int amNickname) throws SQLException;
    Amministratore loginAmministratore(String email, String password) throws SQLException;
    int countAll() throws SQLException;
    Amministratore doRetrieveByEmail(String email) throws SQLException;
}