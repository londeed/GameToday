package Model.Recensione;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RecensioneExtraction {
    public Recensione mapping(ResultSet rs) throws SQLException {
        Recensione recensione = new Recensione();
        recensione.setCodice(rs.getString(1));
        recensione.setAuNickname(rs.getString(2));
        recensione.setData(rs.getDate(3));
        recensione.setTesto(rs.getString(4));
        recensione.setAuNome(rs.getString(5));
        recensione.setTitolo(rs.getString(6));

        return recensione;
    }
}