package Model.Autore;

import Model.Connessione.ConPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AutoreDAO
{
    /**
     * questo metodo restituisce tutti gli autori
     * @return Lista di auotri
     * @throws SQLException
     */

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

    /**
     * questo metodo crea un autore nel database
     * @param autore
     * @return boolean
     * @throws SQLException
     */

    public Boolean createAutore(Autore autore) throws SQLException
    {
        try(Connection connection = ConPool.getConnection()){
            try(PreparedStatement ps = connection.prepareStatement("INSERT INTO autore(AuNickname, AuNome, AuCognome, AuAvatar, REffettuate, RCommissionate, AuEmail, Scadenza, AuPW, AuLike, AuDislike) VALUES (?,?,?,?,?,?,?,?,?,?,?)")){
                ps.setString(1,autore.getAuNickname());
                ps.setString(2, autore.getNome());
                ps.setString(3, autore.getCognome());
                ps.setInt(4, autore.getAvatar());
                ps.setInt(5, autore.getRecEffettuate());
                ps.setString(6, autore.getRecCommissionate());
                ps.setString(7, autore.getEmail());
                ps.setDate(8, autore.getScadenza());
                ps.setString(9, autore.getPassword());
                ps.setInt(10, autore.getLike());
                ps.setInt(11, autore.getDislike());
                int rows = ps.executeUpdate();
                return rows == 1;
            }

        }
    }

    /**
     * questo metodo aggiorna l'autore nel database
     * @param autore
     * @param auNickname
     * @return boolean
     * @throws SQLException
     */

    public Boolean updateAutore(Autore autore,String auNickname) throws SQLException
    {
        try(Connection connection = ConPool.getConnection()){
            try(PreparedStatement ps = connection.prepareStatement("UPDATE autore SET AuNickname=?, AuNome=?, AuCognome=?, AuAvatar=?, REffettuate=?, RCommissionate=?, AuEmail=?, Scadenza=?, AuPW=?, AuLike=?, AuDislike=? WHERE AuNickname=?")){
                ps.setString(1,autore.getAuNickname());
                ps.setString(2, autore.getNome());
                ps.setString(3, autore.getCognome());
                ps.setInt(4, autore.getAvatar());
                ps.setInt(5, autore.getRecEffettuate());
                ps.setString(6, autore.getRecCommissionate());
                ps.setString(7, autore.getEmail());
                ps.setDate(8, autore.getScadenza());
                ps.setString(9, autore.getPassword());
                ps.setInt(10, autore.getLike());
                ps.setInt(11, autore.getDislike());
                ps.setString(12,auNickname);
                int rows = ps.executeUpdate();
                return rows == 1;
            }

        }
    }

    /**
     * questo metodo elimina un autore presente nel database
     * @param auNickname
     * @return boolean
     * @throws SQLException
     */

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

    /**
     * questo metodo permette all'autore di effettuare il login
     * @param email
     * @param password
     * @return autore
     * @throws SQLException
     */

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

    /**
     * questo metodo restituisce il numero di autori presenti nel database
     * @return N° di autori presenti nel database
     * @throws SQLException
     */

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

    /**
     * questo metodo restituisce un autore tramite l'email
     * @param email
     * @return Autore
     * @throws SQLException
     */

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

    /**
     * questo metodo restituisce un autore tramite il nickname
     * @param auNickname
     * @return autore
     * @throws SQLException
     */


    public Autore doRetrieveAutoreByNickname(String auNickname) throws SQLException{
        try(Connection connection= ConPool.getConnection())
        {
            try(PreparedStatement ps= connection.prepareStatement("SELECT * FROM autore WHERE AuNickname = ?")){
                ps.setString(1,auNickname);
                ResultSet rs= ps.executeQuery();
                Autore autore=new Autore();
                AutoreExtraction autoreExtraction= new AutoreExtraction();
                if(rs.next())
                {
                    autore = autoreExtraction.mapping(rs);
                }
                rs.close();
                return autore;
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * questo metodo aggiorna le recensioni prese in carico dall'autore
     * @param auNickname
     * @param titolo
     * @return boolean
     * @throws SQLException
     */

    public Boolean updateAutoreRecCommissionate(String auNickname, String titolo)throws SQLException{
        try(Connection connection = ConPool.getConnection()){
            try(PreparedStatement ps = connection.prepareStatement("UPDATE autore SET RCommissionate=? WHERE AuNickname=?")){
                ps.setString(1,titolo);
                ps.setString(2, auNickname);
                int rows = ps.executeUpdate();
                return rows == 1;
            }
        }
    }

    /**
     * questo metodo aggiorna le recensioni prese in carico dall'autore
     * @param auNickname
     * @return boolean
     * @throws SQLException
     */

    public Boolean updateAutoreRecCommissionateBis(String auNickname)throws SQLException{
        try(Connection connection = ConPool.getConnection()){
            try(PreparedStatement ps = connection.prepareStatement("UPDATE autore SET RCommissionate=?, REffettuate=REffettuate+1 WHERE AuNickname=?")){
                String s="";
                ps.setString(1, s);
                ps.setString(2, auNickname);
                int rows = ps.executeUpdate();
                return rows == 1;
            }
        }
    }
}