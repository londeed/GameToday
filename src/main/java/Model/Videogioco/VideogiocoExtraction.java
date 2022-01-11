package Model.Videogioco;

import Model.Supervisione.Supervisione;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VideogiocoExtraction {
    public Videogioco mapping(ResultSet rs) throws SQLException {
        Videogioco videogioco = new Videogioco();
        videogioco.setTitolo(rs.getString(1));
        videogioco.setPegi(rs.getInt(2));
        videogioco.setTotaleVoti(rs.getInt(3));
        videogioco.setCasaProduttrice(rs.getString(4));
        videogioco.setMediaValutazioni(rs.getDouble(5));
        videogioco.setPiattaforma(rs.getString(6));
        videogioco.setDataPubblicazione(rs.getDate(7));

        return videogioco;
    }
}