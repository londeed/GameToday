package Model.Verifica;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VerificaExtraction {
    public Verifica mapping(ResultSet rs) throws SQLException {
        Verifica verifica = new Verifica();
        verifica.setComCodice(rs.getString(1));
        verifica.setAmNickname(rs.getString(2));

        return verifica;
    }
}