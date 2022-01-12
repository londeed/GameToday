package Model.Autore;

import Model.Amministratore.Amministratore;
import Model.Amministratore.AmministratoreExtraction;
import Model.Connessione.ConPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AutoreDAO
{
    public List<Autore> doRetrieveAutoreAll() throws SQLException
    {
        try(Connection connection= ConPool.getConnection())
        {
            try(PreparedStatement ps= connection.prepareStatement("SELECT * FROM Autore")){
                ResultSet rs= ps.executeQuery();
                List<Autore> autore=new ArrayList<>();
                AutoreExtraction autoreExtraction= new AutoreExtraction();
                while(rs.next())
                {
                    autore.add(autoreExtraction.mapping(rs));
                }
                rs.close();
                return autore;
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
    }

    public Boolean createAutore(Autore autore) throws SQLException
    {
        try(Connection connection = ConPool.getConnection()){
            try(PreparedStatement ps = connection.prepareStatement("INSERT INTO Autore(AuNickname, AuPW, AuNome, AuLike, AuDislike, AuEmail, AuCognome, REffettuate, RCommissionate, AuAvatar, Scadenza) VALUES (?,?,?,?,?,?,?,?,?,?,?);")){
                ps.setString(1,autore.getAuNickname());
                ps.setString(2, autore.getPassword());
                ps.setString(3, autore.getNome());
                ps.setInt(4, autore.getLike());
                ps.setInt(5, autore.getDislike());
                ps.setString(5, autore.getEmail());
                ps.setString(6, autore.getCognome());
                ps.setInt(7, autore.getRecEffettuate());
                ps.setInt(8, autore.getRecCommissionate());
                ps.setInt(9, autore.getAvatar());
                ps.setDate(10, (Date) autore.getScadenza());
                int rows = ps.executeUpdate();
                return rows == 1;
            }

        }
    }

    public Boolean updateAutore(Autore autore) throws SQLException
    {
        try(Connection connection = ConPool.getConnection()){
            try(PreparedStatement ps = connection.prepareStatement("UPDATE Autore SET AuNickname=?, AuPW=?, AuNome=?, AuLike=?, AuDislike=?, AuEmail=?, AuCognome=?, REffettuate=?, RCommissionate=?, AuAvatar=?, Scadenza=? WHERE AuNickname=?")){
                ps.setString(1,autore.getAuNickname());
                ps.setString(2, autore.getPassword());
                ps.setString(3, autore.getNome());
                ps.setInt(4, autore.getLike());
                ps.setInt(5, autore.getDislike());
                ps.setString(5, autore.getEmail());
                ps.setString(6, autore.getCognome());
                ps.setInt(7, autore.getRecEffettuate());
                ps.setInt(8, autore.getRecCommissionate());
                ps.setInt(9, autore.getAvatar());
                ps.setDate(10, (Date) autore.getScadenza());
                int rows = ps.executeUpdate();
                return rows == 1;
            }

        }
    }

    public Boolean deleteAutore(int auNickname) throws SQLException
    {
        try(Connection con = ConPool.getConnection()) {
            try(PreparedStatement ps = con.prepareStatement("DELETE FROM Autore WHERE AuNickname = ?")){
                ps.setInt(1, auNickname);
                int rows = ps.executeUpdate();
                return rows == 1;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Autore loginAutore(String email, String password) throws SQLException
    {
        Autore autore=new Autore();
        try(Connection con = ConPool.getConnection()) {
            try(PreparedStatement ps = con.prepareStatement("SELECT *  FROM Autore WHERE AuEmail=? AND AuPW=?")){
                ps.setString(1, email);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    autore = new AutoreExtraction().mapping(rs);
                    return autore;
                }
            }
            return null;
        }
    }

    public int countAll() throws SQLException
    {
        try(Connection con = ConPool.getConnection()){
            try(PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM Autore")){
                ResultSet rs = ps.executeQuery();
                int size = 0;
                if(rs.next()){
                    size = rs.getInt(1);
                }
                return  size;
            }
        }
    }

    public Autore doRetrieveAutoreByEmail(String email) throws SQLException
    {
        try(Connection connection= ConPool.getConnection())
        {
            try(PreparedStatement ps= connection.prepareStatement("SELECT * FROM Autore WHERE AuEmail = ?")){
                ps.setString(1, email);
                ResultSet rs= ps.executeQuery();
                Autore autore=new Autore();
                AutoreExtraction autoreExtraction=new AutoreExtraction();
                if(rs.next()){
                    autore = autoreExtraction.mapping(rs);
                }
                rs.close();
                return autore;
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
    }
}