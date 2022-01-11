package Model.Autore;

import Model.Amministratore.Amministratore;

import java.sql.SQLException;
import java.util.List;

public interface AutoreInterface
{
    List<Autore> doRetrieveAll() throws SQLException;
    Boolean createAutore(Autore autore) throws SQLException;
    Boolean updateAutore(Autore autore) throws SQLException;
    Boolean deleteAutore(int auNickname) throws SQLException;
    Autore loginAutore(String email, String password) throws SQLException;
    int countAll() throws SQLException;
    Autore doRetrieveByEmail(String email) throws SQLException;
}
