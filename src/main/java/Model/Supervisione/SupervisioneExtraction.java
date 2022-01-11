package Model.Supervisione;

import Model.Recensione.Recensione;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SupervisioneExtraction {
    public Supervisione mapping(ResultSet rs) throws SQLException {
        Supervisione supervisione = new Supervisione();
        supervisione.setAmNickname(rs.getString(1));
        supervisione.setCodice(rs.getInt(2));

        return supervisione;
    }
}