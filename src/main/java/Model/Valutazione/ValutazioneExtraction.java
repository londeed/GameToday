package Model.Valutazione;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * classe utilizzata per il mapping del resultset di Valutazione dal database
 */

public class ValutazioneExtraction {

    /**
     * metodo che effettua il mapping di valutazione
     * @param rs
     * @return Valutazione
     * @throws SQLException
     */

    public Valutazione mapping(ResultSet rs) throws SQLException {
        Valutazione valutazione = new Valutazione();
        valutazione.setUtNickname(rs.getString(1));
        valutazione.setTitolo(rs.getString(2));
        return valutazione;
    }
}