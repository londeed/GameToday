package Model.Visione;

import Model.Verifica.Verifica;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VisioneExtraction {
    public Visione mapping(ResultSet rs) throws SQLException {
        Visione visione = new Visione();
        visione.setAuNickname(rs.getString(1));
        visione.setTitolo(rs.getString(2));

        return visione;
    }
}