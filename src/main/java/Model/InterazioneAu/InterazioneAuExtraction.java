package Model.InterazioneAu;

import Model.Gestione.Gestione;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InterazioneAuExtraction {
    public InterazioneAu mapping(ResultSet rs) throws SQLException {
        InterazioneAu interazioneAu = new InterazioneAu();
        interazioneAu.setComCodice(rs.getInt(1));
        interazioneAu.setAuNickname(rs.getString(2));

        return interazioneAu;
    }
}
