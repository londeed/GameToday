package Model.Amministratore;

import Model.Connessione.ConPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * classe che utilizza i metodi di interrogazione del database riguardanti l'Amministratore
 */

public class AmministratoreDAO {

    /**
     * questo metodo restituisce tutti gli amministratori
     * @return Lista di amministratori
     * @throws SQLException
     */

    public List<Amministratore> doRetrieveAllAmministratore() throws SQLException{
        try(Connection connection= ConPool.getConnection())
        {
            try(PreparedStatement ps= connection.prepareStatement("SELECT * FROM amministratore")){
                ResultSet rs= ps.executeQuery();
                List<Amministratore> amministratore=new ArrayList<>();
                AmministratoreExtraction amministratoreExtraction=new AmministratoreExtraction();
                while(rs.next())
                {
                    amministratore.add(amministratoreExtraction.mapping(rs));
                }
                rs.close();
                return amministratore;
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * questo metodo restituisce tutti gli amministratori per email
     * @param email
     * @return Amministratore
     * @throws SQLException
     */

    public Amministratore doRetrieveAmministratoreByEmail(String email) throws SQLException
    {
        try(Connection connection= ConPool.getConnection())
        {
            try(PreparedStatement ps= connection.prepareStatement("SELECT * FROM amministratore WHERE AmEmail = ?")){
                ps.setString(1, email);
                ResultSet rs= ps.executeQuery();
                Amministratore amministratore=new Amministratore();
                AmministratoreExtraction amministratoreExtraction=new AmministratoreExtraction();
                if(rs.next()){
                    amministratore = amministratoreExtraction.mapping(rs);
                }
                rs.close();
                return amministratore;
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * questo metodo crea un Amministratore
     * @param amministratore
     * @return boolean
     * @throws SQLException
     */

    public Boolean createAmministratore(Amministratore amministratore) throws SQLException {
        try(Connection connection = ConPool.getConnection()){
            try(PreparedStatement ps = connection.prepareStatement("INSERT INTO amministratore(AmNickname, AmNome, AmCognome, AmAvatar, AmEmail, AmPW, VideogiochiInseriti) VALUES (?,?,?,?,?,?,?);")){
                ps.setString(1,amministratore.getAmNickname());
                ps.setString(2, amministratore.getNome());
                ps.setString(3, amministratore.getCognome());
                ps.setInt(4, amministratore.getAvatar());
                ps.setString(5, amministratore.getEmail());
                ps.setString(6, amministratore.getPassword());
                ps.setInt(7, amministratore.getVideogiochiInseriti());
                int rows = ps.executeUpdate();
                return rows == 1;
            }

        }
    }

    /**
     * questo metodo aggiorna un amministratore
     * @param amministratore
     * @param amNickname
     * @return boolean
     * @throws SQLException
     */

    public Boolean updateAmministratore(Amministratore amministratore, String amNickname) throws SQLException
    {
        try(Connection connection = ConPool.getConnection()){
            try(PreparedStatement ps = connection.prepareStatement("UPDATE amministratore SET AmNickname=?, AmNome=?, AmCognome=?, AmAvatar=?, AmEmail=?, AmPW=?, VideogiochiInseriti=? WHERE AmNickname=?")){
                ps.setString(1,amministratore.getAmNickname());
                ps.setString(2, amministratore.getNome());
                ps.setString(3, amministratore.getCognome());
                ps.setInt(4, amministratore.getAvatar());
                ps.setString(5, amministratore.getEmail());
                ps.setString(6, amministratore.getPassword());
                ps.setInt(7, amministratore.getVideogiochiInseriti());
                ps.setString(8, amNickname);
                int rows = ps.executeUpdate();
                return rows == 1;
            }
        }
    }

    /**
     * questo metodo elimina un amministratore
     * @param amNickname
     * @return boolean
     * @throws SQLException
     */

    public Boolean deleteAmministratore(String amNickname) throws SQLException
    {
        try(Connection con = ConPool.getConnection()) {
            try(PreparedStatement ps = con.prepareStatement("DELETE FROM amministratore WHERE AmNickname = ?")){
                ps.setString(1, amNickname);
                int rows = ps.executeUpdate();
                return rows == 1;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * questo metodo permette all'amministratore di effettuare il login
     * @param email
     * @param password
     * @return amministratore
     * @throws SQLException
     */

    public Amministratore loginAmministratore(String email, String password) throws SQLException
    {
        Amministratore amministratore;
        try(Connection con = ConPool.getConnection()) {
            try(PreparedStatement ps = con.prepareStatement("SELECT *  FROM amministratore WHERE AmEmail=? AND AmPW=?")){
                ps.setString(1, email);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    amministratore = new AmministratoreExtraction().mapping(rs);
                    return amministratore;
                }
            }
            return null;
        }
    }

    /**
     * questo metodo restituisce il numero degli amministratori
     * @return N° Amministratori
     * @throws SQLException
     */

    public int countAll() throws SQLException
    {
        try(Connection con = ConPool.getConnection()){
            try(PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM amministratore")){
                ResultSet rs = ps.executeQuery();
                int size = 0;
                if(rs.next()){
                    size = rs.getInt(1);
                }
                return  size;
            }
        }
    }
}