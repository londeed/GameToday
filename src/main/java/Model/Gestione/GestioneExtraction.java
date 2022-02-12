package Model.Gestione;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GestioneExtraction {
    public Gestione mapping(ResultSet rs) throws SQLException {
        Gestione gestione = new Gestione();
        gestione.setAmNickname(rs.getString(1));
        gestione.setTitolo(rs.getString(2));

        return gestione;
    }
}