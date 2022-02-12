package Model.Autore;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AutoreExtraction {
    public Autore mapping(ResultSet rs) throws SQLException
    {
        Autore autore= new Autore();
        autore.setAuNickname(rs.getString(1));
        autore.setNome(rs.getString(2));
        autore.setCognome(rs.getString(3));
        autore.setAvatar(rs.getInt(4));
        autore.setRecEffettuate(rs.getInt(5));
        autore.setRecCommissionate(rs.getString(6));
        autore.setEmail(rs.getString(7));
        autore.setScadenza(rs.getDate(8));
        autore.setPassword(rs.getString(9));
        autore.setLike(rs.getInt(10));
        autore.setDislike(rs.getInt(11));
        return autore;
    }

}