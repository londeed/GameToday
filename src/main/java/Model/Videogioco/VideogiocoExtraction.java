package Model.Videogioco;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * classe utilizzata per il mapping del resultset di Videogioco dal database
 */

public class VideogiocoExtraction {

    /**
     * metodo che effettua il mapping di videogioco
     * @param rs
     * @return Videogioco
     * @throws SQLException
     */

    public Videogioco mapping(ResultSet rs) throws SQLException {
        Videogioco videogioco = new Videogioco();
        videogioco.setTitolo(rs.getString(1));
        videogioco.setPegi(rs.getInt(2));
        videogioco.setTotaleVoti(rs.getInt(3));
        videogioco.setCasaProduttrice(rs.getString(4));
        videogioco.setMediaValutazioni(rs.getDouble(5));
        videogioco.setPiattaforma(rs.getString(6));
        videogioco.setDataPubblicazione(rs.getDate(7));
        videogioco.setTipologia(rs.getString(8));
        return videogioco;
    }
}