package Model.Amministratore;

import Model.Connessione.ConPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AmministratoreDAO {

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

    public Amministratore doRetrieveAmministratoreByEmail(String email) throws SQLException
    {
        try(Connection connection= ConPool.getConnection())
        {
            try(PreparedStatement ps= connection.prepareStatement("SELECT * FROM utente WHERE AmEmail = ?")){
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

    public Boolean createAmministratore(Amministratore amministratore) throws SQLException {
        try(Connection connection = ConPool.getConnection()){
            try(PreparedStatement ps = connection.prepareStatement("INSERT INTO Amministratore(AmNickname, AmPW, AmNome, AmEmail, AmCognome, VideogiochiInseriti, AmAvatar) VALUES (?,?,?,?,?,?,?);")){
                ps.setString(1,amministratore.getAmNickname());
                ps.setString(2, amministratore.getPassword());
                ps.setString(3, amministratore.getNome());
                ps.setString(4, amministratore.getEmail());
                ps.setString(5, amministratore.getCognome());
                ps.setInt(6, amministratore.getVideogiochiInseriti());
                ps.setInt(7, amministratore.getAvatar());
                int rows = ps.executeUpdate();
                return rows == 1;
            }

        }
    }

    public Boolean updateAmministratore(Amministratore amministratore) throws SQLException
    {
        try(Connection connection = ConPool.getConnection()){
            try(PreparedStatement ps = connection.prepareStatement("UPDATE Amministratore SET AmNickname=?, AmPW=?, AmNome=?, AmEmail=?, AmCognome=?, VideogiochiInseriti=?, AmAvatar=? WHERE AmNickname=?")){
                ps.setString(1,amministratore.getAmNickname());
                ps.setString(2, amministratore.getPassword());
                ps.setString(3, amministratore.getNome());
                ps.setString(4, amministratore.getEmail());
                ps.setString(5, amministratore.getCognome());
                ps.setInt(6, amministratore.getVideogiochiInseriti());
                ps.setInt(7, amministratore.getAvatar());
                int rows = ps.executeUpdate();
                return rows == 1;
            }

        }
    }

    public Boolean deleteAmministratore(int amNickname) throws SQLException
    {
        try(Connection con = ConPool.getConnection()) {
            try(PreparedStatement ps = con.prepareStatement("DELETE FROM Amministratore WHERE AmNickname = ?")){
                ps.setInt(1, amNickname);
                int rows = ps.executeUpdate();
                return rows == 1;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Amministratore loginAmministratore(String email, String password) throws SQLException
    {
        Amministratore amministratore;
        try(Connection con = ConPool.getConnection()) {
            try(PreparedStatement ps = con.prepareStatement("SELECT *  FROM Amministratore WHERE AmEmail=? AND AmPW=?")){
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

    int countAll() throws SQLException
    {
        try(Connection con = ConPool.getConnection()){
            try(PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM Amministratore")){
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