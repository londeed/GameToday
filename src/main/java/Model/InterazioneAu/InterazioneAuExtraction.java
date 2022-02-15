package Model.InterazioneAu;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * classe utlizzata per il mapping del resultset dell'amministratore dal database
 */

public class InterazioneAuExtraction {

    /**
     * metodo che effettua il mapping dell'interazioneAu
     * @param rs
     * @return interazioneAu
     * @throws SQLException
     */

    public InterazioneAu mapping(ResultSet rs) throws SQLException {
        InterazioneAu interazioneAu = new InterazioneAu();
        interazioneAu.setComCodice(rs.getString(1));
        interazioneAu.setAuNickname(rs.getString(2));
        interazioneAu.setAul(rs.getBoolean(3));
        interazioneAu.setAud(rs.getBoolean(4));
        return interazioneAu;
    }
}
