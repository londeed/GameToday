package Model.Verifica;

import Model.Valutazione.Valutazione;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VerificaExtraction {
    public Verifica mapping(ResultSet rs) throws SQLException {
        Verifica verifica = new Verifica();
        verifica.setComCodice(rs.getInt(1));
        verifica.setAmNickname(rs.getString(2));

        return verifica;
    }
}