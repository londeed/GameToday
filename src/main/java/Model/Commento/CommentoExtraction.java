package Model.Commento;

import Model.Amministratore.Amministratore;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentoExtraction {
    public Commento mapping(ResultSet rs) throws SQLException
    {
        Commento commento= new Commento();
        commento.setComCodice(rs.getInt(1));
        commento.setCodice(rs.getInt(2));
        commento.setDislike(rs.getBoolean(3));
        commento.setLike(rs.getBoolean(4));
        commento.setTesto(rs.getString(5));

        return commento;
    }
}