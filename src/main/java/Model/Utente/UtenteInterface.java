package Model.Utente;

import Model.Amministratore.Amministratore;

import java.sql.SQLException;
import java.util.List;

public interface UtenteInterface
{
    List<Utente> doRetrieveAll() throws SQLException;
    Boolean createUtente(Utente utente) throws SQLException;
    Boolean updateUtente(Utente utente) throws SQLException;
    Boolean deleteUtente(int utNickname) throws SQLException;
    Utente loginUtente(String email, String password) throws SQLException;
    int countAll() throws SQLException;
    Utente doRetrieveByEmail(String email) throws SQLException;
}
