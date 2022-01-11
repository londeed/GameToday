package Model.Autore;

import Model.Amministratore.Amministratore;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class AutoreExtraction {
    public Autore mapping(ResultSet rs) throws SQLException
    {
        Autore autore= new Autore();
        autore.setAuNickname(rs.getString(1));
        autore.setNome(rs.getString(2));
        autore.setCognome(rs.getString(3));
        autore.setAvatar(rs.getInt(4));
        autore.setEmail(rs.getString(5));
        autore.setPassword(rs.getString(6));
        autore.setRecEffettuate(rs.getInt(7));
        autore.setRecCommissionate(rs.getInt(8));
        autore.setScadenza(rs.getDate(9));
        autore.setLike(rs.getInt(10));
        autore.setDislike(rs.getInt(11));

        return autore;
    }

}