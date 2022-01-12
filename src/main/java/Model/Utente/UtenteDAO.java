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
            try(PreparedStatement ps= connection.prepareStatement("SELECT * FROM utente")){
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
            try(PreparedStatement ps = connection.prepareStatement("INSERT INTO utente(UtNickname, UtNome, UtCognome, ValEffettuate, UtEmail, UtPW, UtLike, UtDislike, UtAvatar) VALUES (?,?,?,?,?,?,?,?,?);")){
                ps.setString(1,utente.getUtNickname());
                ps.setString(2, utente.getNome());
                ps.setString(3, utente.getCognome());
                ps.setInt(4, utente.getValEffettuate());
                ps.setString(5, utente.getEmail());
                ps.setString(6, utente.getPassword());
                ps.setInt(7, utente.getLike());
                ps.setInt(8, utente.getDislike());
                ps.setInt(9, utente.getAvatar());
                int rows = ps.executeUpdate();
                return rows == 1;
            }

        }
    }

    public Boolean updateUtente(Utente utente, String utNickname) throws SQLException
    {
        try(Connection connection = ConPool.getConnection()){
            try(PreparedStatement ps = connection.prepareStatement("UPDATE Utente SET UtNickname=?, UtNome=?, UtCognome=?, ValEffettuate=?, UtEmail=?, UtPW=?, UtLike=?, UtDislike=?, UtAvatar=? WHERE UtNickname = ?")){
                ps.setString(1,utente.getUtNickname());
                ps.setString(2, utente.getNome());
                ps.setString(3, utente.getCognome());
                ps.setInt(4, utente.getValEffettuate());
                ps.setString(5, utente.getEmail());
                ps.setString(6, utente.getPassword());
                ps.setInt(7, utente.getLike());
                ps.setInt(8, utente.getDislike());
                ps.setInt(9, utente.getAvatar());
                ps.setString(10, utNickname);
                int rows = ps.executeUpdate();
                return rows == 1;
            }

        }
    }

    public Boolean deleteUtente(String utNickname) throws SQLException
    {
        try(Connection con = ConPool.getConnection()) {
            try(PreparedStatement ps = con.prepareStatement("DELETE FROM utente WHERE UtNickname = ?")){
                ps.setString(1, utNickname);
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
            try(PreparedStatement ps = con.prepareStatement("SELECT *  FROM utente WHERE UtEmail=? AND UtPW=?")){
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
            try(PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM utente")){
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
            try(PreparedStatement ps= connection.prepareStatement("SELECT * FROM utente WHERE UtEmail = ?")){
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
