package Model.InterazioneUt;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InterazioneUtExtraction {
    public InterazioneUt mapping(ResultSet rs) throws SQLException {
        InterazioneUt interazioneUt = new InterazioneUt();
        interazioneUt.setComCodice(rs.getString(1));
        interazioneUt.setUtNickname(rs.getString(2));
        interazioneUt.setUtl(rs.getBoolean(3));
        interazioneUt.setUtd(rs.getBoolean(4));
        return interazioneUt;
    }
}
