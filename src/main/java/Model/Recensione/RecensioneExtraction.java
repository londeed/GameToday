package Model.Recensione;

import Model.InterazioneUt.InterazioneUt;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class RecensioneExtraction {
    public Recensione mapping(ResultSet rs) throws SQLException {
        Recensione recensione = new Recensione();
        recensione.setCodice(rs.getInt(1));
        recensione.setAutore(rs.getString(2));
        recensione.setData(rs.getDate(3));
        recensione.setTesto(rs.getString(4));
        recensione.setAuNickname(rs.getString(5));
        recensione.setTitolo(rs.getString(6));

        return recensione;
    }
}