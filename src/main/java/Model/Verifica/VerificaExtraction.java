package Model.Verifica;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * classe utilizzata per il mapping del resultset di Verifica dal database
 */

public class VerificaExtraction {

    /**
     * metodo che effettua il mapping di verifica
     * @param rs
     * @return Verifica
     * @throws SQLException
     */

    public Verifica mapping(ResultSet rs) throws SQLException {
        Verifica verifica = new Verifica();
        verifica.setComCodice(rs.getString(1));
        verifica.setAmNickname(rs.getString(2));
        return verifica;
    }
}