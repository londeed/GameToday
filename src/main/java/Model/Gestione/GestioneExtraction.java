package Model.Gestione;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * classe utlizzata per il mapping del resultset della gestione dal database
 */

public class GestioneExtraction {

    /**
     * metodo che effettua il mapping della gestione
     * @param rs
     * @return mapping
     * @throws SQLException
     */

    public Gestione mapping(ResultSet rs) throws SQLException {
        Gestione gestione = new Gestione();
        gestione.setAmNickname(rs.getString(1));
        gestione.setTitolo(rs.getString(2));

        return gestione;
    }
}