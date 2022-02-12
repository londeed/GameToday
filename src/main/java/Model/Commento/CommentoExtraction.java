package Model.Commento;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentoExtraction {
    public Commento mapping(ResultSet rs) throws SQLException
    {
        Commento commento= new Commento();
        commento.setComCodice(rs.getString(1));
        commento.setCodice(rs.getString(2));
        commento.setLike(rs.getInt(3));
        commento.setDislike(rs.getInt(4));
        commento.setTesto(rs.getString(5));
        return commento;
    }
}