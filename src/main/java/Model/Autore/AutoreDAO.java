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
            try(PreparedStatement ps= connection.prepareStatement("SELECT * FROM autore")){
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
            try(PreparedStatement ps = connection.prepareStatement("INSERT INTO autore(AuNickname, AuNome, AuCognome, AuAvatar, REffettuate, RCommisionate, AuEmail, Scadenza, AuPW, AuLike, AuDislike) VALUES (?,?,?,?,?,?,?,?,?,?,?);")){
                ps.setString(1,autore.getAuNickname());
                ps.setString(2, autore.getNome());
                ps.setString(3, autore.getCognome());
                ps.setInt(4, autore.getAvatar());
                ps.setInt(5, autore.getRecEffettuate());
                ps.setString(5, autore.getRecCommissionate());
                ps.setString(6, autore.getEmail());
                ps.setDate(7, autore.getScadenza());
                ps.setString(8, autore.getPassword());
                ps.setInt(9, autore.getLike());
                ps.setInt(10, autore.getDislike());
                int rows = ps.executeUpdate();
                return rows == 1;
            }

        }
    }

    public Boolean updateAutore(Autore autore,String auNickname) throws SQLException
    {
        try(Connection connection = ConPool.getConnection()){
            try(PreparedStatement ps = connection.prepareStatement("UPDATE autore SET AuNickname=?, AuNome=?, AuCognome=?, AuAvatar=?, REffettuate=?, RCommisionate=?, AuEmail=?, Scadenza=?, AuPW=?, AuLike=?, AuDislike=? WHERE AuNickname=?")){
                ps.setString(1,autore.getAuNickname());
                ps.setString(2, autore.getNome());
                ps.setString(3, autore.getCognome());
                ps.setInt(4, autore.getAvatar());
                ps.setInt(5, autore.getRecEffettuate());
                ps.setString(5, autore.getRecCommissionate());
                ps.setString(6, autore.getEmail());
                ps.setDate(7, autore.getScadenza());
                ps.setString(8, autore.getPassword());
                ps.setInt(9, autore.getLike());
                ps.setInt(10, autore.getDislike());
                ps.setString(11,auNickname);
                int rows = ps.executeUpdate();
                return rows == 1;
            }

        }
    }

    public Boolean deleteAutore(String auNickname) throws SQLException
    {
        try(Connection con = ConPool.getConnection()) {
            try(PreparedStatement ps = con.prepareStatement("DELETE FROM autore WHERE AuNickname = ?")){
                ps.setString(1, auNickname);
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
            try(PreparedStatement ps = con.prepareStatement("SELECT *  FROM autore WHERE AuEmail=? AND AuPW=?")){
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
            try(PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM autore")){
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
            try(PreparedStatement ps= connection.prepareStatement("SELECT * FROM autore WHERE AuEmail = ?")){
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