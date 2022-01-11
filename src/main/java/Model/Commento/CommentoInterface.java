package Model.Commento;

import java.sql.SQLException;
import java.util.List;

public interface CommentoInterface
{
    Commento doRetrieveByCodice(int codice) throws SQLException;
    Boolean insertCommento(Commento commento) throws SQLException;
    Boolean updateCommento(Commento commento, int comCodice) throws SQLException;
    Boolean deleteCommento(int comCodice) throws SQLException;
    int countAll() throws SQLException;
}
