package Model.InterazioneUt;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * classe utlizzata per il mapping del resultset dell'interazioneUt dal database
 */

public class InterazioneUtExtraction {

    /**
     * metodo che effettua il mapping dell'interazioneUt
     * @param rs
     * @return
     * @throws SQLException
     */

    public InterazioneUt mapping(ResultSet rs) throws SQLException {
        InterazioneUt interazioneUt = new InterazioneUt();
        interazioneUt.setComCodice(rs.getString(1));
        interazioneUt.setUtNickname(rs.getString(2));
        interazioneUt.setUtl(rs.getBoolean(3));
        interazioneUt.setUtd(rs.getBoolean(4));
        return interazioneUt;
    }
}
