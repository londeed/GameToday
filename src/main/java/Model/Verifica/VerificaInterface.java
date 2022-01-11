package Model.Verifica;

import Model.Supervisione.Supervisione;

import java.sql.SQLException;
import java.util.List;

public interface VerificaInterface
{
    Verifica delete(int comCodice) throws SQLException;
}
