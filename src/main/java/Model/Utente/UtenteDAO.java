package Model.Utente;

import Model.Autore.Autore;
import Model.Autore.AutoreExtraction;
import Model.Connessione.ConPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UtenteDAO
{

    public List<Utente> doRetrieveAll() throws SQLException
    {
        try(Connection connection= ConPool.getConnection())
        {
            try(PreparedStatement ps= connection.prepareStatement("SELECT * FROM Utente")){
                ResultSet rs= ps.executeQuery();
                List<Utente> utente=new ArrayList<>();
                UtenteExtraction utenteExtraction=new UtenteExtraction();
                while(rs.next())
                {
                    utente.add(utenteExtraction.mapping(rs));
                }
                rs.close();
                return utente;
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
    }

    public Boolean createUtente(Utente utente) throws SQLException
    {
        try(Connection connection = ConPool.getConnection()){
            try(PreparedStatement ps = connection.prepareStatement("INSERT INTO Utente(UtNickname, UtPW, UtNome, UtLike, UtDislike, UtEmail, UtCognome, ValEffettuate, UtAvatar) VALUES (?,?,?,?,?,?,?,?,?);")){
                ps.setString(1,utente.getUtNickname());
                ps.setString(2, utente.getPassword());
                ps.setString(3, utente.getNome());
                ps.setInt(4, utente.getLike());
                ps.setInt(5, utente.getDislike());
                ps.setString(5, utente.getEmail());
                ps.setString(6, utente.getCognome());
                ps.setInt(7, utente.getValEffettuate());
                ps.setInt(8, utente.getAvatar());
                int rows = ps.executeUpdate();
                return rows == 1;
            }

        }
    }

    public Boolean updateUtente(Utente utente) throws SQLException
    {
        try(Connection connection = ConPool.getConnection()){
            try(PreparedStatement ps = connection.prepareStatement("UPDATE Utente SET UtNickname=?, UtPW=?, UtNome=?, UtLike=?, UtDislike=?, UtEmail=?, UtCognome=?, ValEffettuate=?, UtAvatar=?")){
                ps.setString(1,utente.getUtNickname());
                ps.setString(2, utente.getPassword());
                ps.setString(3, utente.getNome());
                ps.setInt(4, utente.getLike());
                ps.setInt(5, utente.getDislike());
                ps.setString(5, utente.getEmail());
                ps.setString(6, utente.getCognome());
                ps.setInt(7, utente.getValEffettuate());
                ps.setInt(8, utente.getAvatar());
                int rows = ps.executeUpdate();
                return rows == 1;
            }

        }
    }

    public Boolean deleteUtente(int utNickname) throws SQLException
    {
        try(Connection con = ConPool.getConnection()) {
            try(PreparedStatement ps = con.prepareStatement("DELETE FROM Utente WHERE UtNickname = ?")){
                ps.setInt(1, utNickname);
                int rows = ps.executeUpdate();
                return rows == 1;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Utente loginUtente(String email, String password) throws SQLException
    {
        Utente utente=new Utente();
        try(Connection con = ConPool.getConnection()) {
            try(PreparedStatement ps = con.prepareStatement("SELECT *  FROM Utente WHERE UtEmail=? AND UtPW=?")){
                ps.setString(1, email);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    utente = new UtenteExtraction().mapping(rs);
                    return utente;
                }
            }
            return null;
        }
    }

    public int countAll() throws SQLException
    {
        try(Connection con = ConPool.getConnection()){
            try(PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM Utente")){
                ResultSet rs = ps.executeQuery();
                int size = 0;
                if(rs.next()){
                    size = rs.getInt(1);
                }
                return  size;
            }
        }
    }

    public Utente doRetrieveUtenteByEmail(String email) throws SQLException
    {
        try(Connection connection= ConPool.getConnection())
        {
            try(PreparedStatement ps= connection.prepareStatement("SELECT * FROM Utente WHERE UtEmail = ?")){
                ps.setString(1, email);
                ResultSet rs= ps.executeQuery();
                Utente utente=new Utente();
                UtenteExtraction utenteExtraction=new UtenteExtraction();
                if(rs.next()){
                    utente = utenteExtraction.mapping(rs);
                }
                rs.close();
                return utente;
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
    }
}
