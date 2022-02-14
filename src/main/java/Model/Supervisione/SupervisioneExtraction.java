package Model.Supervisione;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * classe utilizzata per il mapping del resultset di supervisione dal database
 */

public class SupervisioneExtraction {

    /**
     * metodo che effettua il mapping di Supervisione
     * @param rs
     * @return Supervisione
     * @throws SQLException
     */

    public Supervisione mapping(ResultSet rs) throws SQLException {
        Supervisione supervisione = new Supervisione();
        supervisione.setAmNickname(rs.getString(1));
        supervisione.setCodice(rs.getString(2));
        return supervisione;
    }
}