package Model.Valutazione;

import Model.Supervisione.Supervisione;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ValutazioneExtraction {
    public Valutazione mapping(ResultSet rs) throws SQLException {
        Valutazione valutazione = new Valutazione();
        valutazione.setUtNickname(rs.getString(1));
        valutazione.setTitolo(rs.getString(2));

        return valutazione;
    }
}