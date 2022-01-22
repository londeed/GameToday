package Model.Commento;

import java.sql.SQLException;
import java.util.List;

public interface CommentoInterface
{
    Commento doRetrieveByCodice(String codice) throws SQLException;
    Boolean insertCommento(Commento commento) throws SQLException;
    Boolean updateCommento(Commento commento, String comCodice) throws SQLException;
    Boolean deleteCommento(String comCodice) throws SQLException;
    int countAll() throws SQLException;
    List<String> doRetrieveAllCodiciCommenti() throws SQLException;
}
