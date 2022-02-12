package Model.Visione;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * classe utilizzata per il mapping del resultset di Visione dal database
 */

public class VisioneExtraction {

    /**
     * metodo che effettua il mapping di visione
     * @param rs
     * @return Visione
     * @throws SQLException
     */

    public Visione mapping(ResultSet rs) throws SQLException {
        Visione visione = new Visione();
        visione.setAuNickname(rs.getString(1));
        visione.setTitolo(rs.getString(2));
        return visione;
    }
}