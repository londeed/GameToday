package Model.Amministratore;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * classe utlizzata per il mapping del resultset dell'amministratore dal database
 */

public class AmministratoreExtraction {

    /**
     * metodo che effettua il mapping dell'amministratore
     * @param rs
     * @return amministratore
     * @throws SQLException
     */

    public Amministratore mapping(ResultSet rs) throws SQLException
    {
        Amministratore amministratore= new Amministratore();
        amministratore.setAmNickname(rs.getString(1));
        amministratore.setNome(rs.getString(2));
        amministratore.setCognome(rs.getString(3));
        amministratore.setAvatar(rs.getInt(4));
        amministratore.setEmail(rs.getString(5));
        amministratore.setPassword(rs.getString(6));
        amministratore.setVideogiochiInseriti(rs.getInt(7));

        return amministratore;
    }
}