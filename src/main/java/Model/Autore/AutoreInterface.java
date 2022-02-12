package Model.Autore;

import java.sql.SQLException;
import java.util.List;

public interface AutoreInterface
{
    List<Autore> doRetrieveAutoreAll() throws SQLException;
    Boolean createAutore(Autore autore) throws SQLException;
    Boolean updateAutore(Autore autore, String auNickname) throws SQLException;
    Boolean deleteAutore(String auNickname) throws SQLException;
    Autore loginAutore(String email, String password) throws SQLException;
    int countAll() throws SQLException;
    Autore doRetrieveAutoreByEmail(String email) throws SQLException;
    Autore doRetrieveAutoreByNickname(String auNickname) throws SQLException;
    Boolean updateAutoreRecCommissionate(String auNickname, String titolo)throws SQLException;
    Boolean updateAutoreRecCommissionateBis(String auNickname)throws SQLException;
}
