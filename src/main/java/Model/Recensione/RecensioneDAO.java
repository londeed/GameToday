package Model.Recensione;

import Model.Connessione.ConPool;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecensioneDAO {

     public Recensione doRetrieveByCodice(String codice) throws SQLException{
         try(Connection connection= ConPool.getConnection())
         {
             try(PreparedStatement ps= connection.prepareStatement("SELECT * FROM recensione WHERE Codice = ?")){
                 ps.setString(1, codice);
                 ResultSet rs= ps.executeQuery();
                 Recensione recensione=new Recensione();
                 RecensioneExtraction recensioneExtraction=new RecensioneExtraction();
                 if(rs.next()){
                     recensione = recensioneExtraction.mapping(rs);
                 }
                 rs.close();
                 return recensione;
             }catch (SQLException e){
                 throw new RuntimeException(e);
             }
         }
     }

    public Recensione doRetrieveByTitolo(String titolo) throws SQLException{
        try(Connection connection= ConPool.getConnection())
        {
            try(PreparedStatement ps= connection.prepareStatement("SELECT * FROM recensione WHERE Titolo = ?")){
                ps.setString(1, titolo);
                ResultSet rs= ps.executeQuery();
                Recensione recensione=new Recensione();
                RecensioneExtraction recensioneExtraction=new RecensioneExtraction();
                if(rs.next()){
                    recensione = recensioneExtraction.mapping(rs);
                }
                rs.close();
                return recensione;
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
    }

    public List<Recensione> doRetrieveByAutore(String AuNickname) throws SQLException{
        try(Connection connection= ConPool.getConnection()) {
            try(PreparedStatement ps= connection.prepareStatement("SELECT * FROM recensione WHERE AuNickname = ?")){
                ps.setString(1,AuNickname);
                ResultSet rs= ps.executeQuery();
                List<Recensione> recensione=new ArrayList<>();
                RecensioneExtraction recensioneExtraction=new RecensioneExtraction();
                while(rs.next())
                {
                    recensione.add(recensioneExtraction.mapping(rs));
                }
                rs.close();
                return recensione;
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
    }

    public Boolean insertRecensione(Recensione recensione) throws SQLException{
        try(Connection connection = ConPool.getConnection()){
            try(PreparedStatement ps = connection.prepareStatement("INSERT INTO recensione(Codice, AuNickname, RData, RTesto, AuNome, Titolo) VALUES (?,?,?,?,?,?);")){
                ps.setString(1,recensione.getCodice());
                ps.setString(2, recensione.getAuNickname());
                ps.setDate(3, recensione.getData());
                ps.setString(4, recensione.getTesto());
                ps.setString(5, recensione.getAuNome());
                ps.setString(6, recensione.getTitolo());
                int rows = ps.executeUpdate();
                return rows == 1;
            }
        }
    }

    public Boolean updateRecensione(Recensione recensione, String codice) throws SQLException{
        try(Connection connection = ConPool.getConnection()){
            try(PreparedStatement ps = connection.prepareStatement("UPDATE recensione SET Codice=?, AuNickname=?, RData=?, RTesto=?, AuNome=?, Titolo=? WHERE Codice=?")){
                ps.setString(1, recensione.getCodice());
                ps.setString(2, recensione.getAuNickname());
                ps.setDate(3, recensione.getData());
                ps.setString(4, recensione.getTesto());
                ps.setString(5, recensione.getAuNome());
                ps.setString(6, recensione.getTitolo());
                ps.setString(7, recensione.getCodice());
                int rows = ps.executeUpdate();
                return rows == 1;
            }
        }
    }

    public Boolean updateRecensioneText(String recensione, String codice) throws SQLException{
        try(Connection connection = ConPool.getConnection()){
            try(PreparedStatement ps = connection.prepareStatement("UPDATE recensione SET RTesto=? WHERE Codice=?")){
                ps.setString(1, recensione);
                ps.setString(2, codice);
                int rows = ps.executeUpdate();
                return rows == 1;
            }
        }
    }

    public Boolean updateRecensioneTextbis(String recensione, String titolo) throws SQLException{
        try(Connection connection = ConPool.getConnection()){
            try(PreparedStatement ps = connection.prepareStatement("UPDATE recensione SET RTesto=?, RData=null WHERE Titolo=?")){
                ps.setString(1, recensione);
                ps.setString(2, titolo);
                int rows = ps.executeUpdate();
                return rows == 1;
            }
        }
    }

    public Boolean updateRecensioneApprovata(String titolo) throws SQLException{
        try(Connection connection = ConPool.getConnection()){
            try(PreparedStatement ps = connection.prepareStatement("UPDATE recensione SET RData=? WHERE Titolo=?")){
                LocalDate todaysDate = LocalDate.now();
                ps.setObject(1, todaysDate);
                ps.setString(2, titolo);
                int rows = ps.executeUpdate();
                return rows == 1;
            }
        }
    }

    public Boolean deleterecensione(String codice) throws SQLException{
        try(Connection con = ConPool.getConnection()) {
            try(PreparedStatement ps = con.prepareStatement("DELETE FROM recensione WHERE Codice = ?")){
                ps.setString(1, codice);
                int rows = ps.executeUpdate();
                return rows == 1;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public int countAll() throws SQLException{
        try(Connection con = ConPool.getConnection()){
            try(PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM recensione")){
                ResultSet rs = ps.executeQuery();
                int size = 0;
                if(rs.next()){
                    size = rs.getInt(1);
                }
                return  size;
            }
        }
    }

    public List<Recensione> doRetrieveAllByDataPubblicazione() throws SQLException{
        try(Connection connection= ConPool.getConnection())
        {
            try(PreparedStatement ps= connection.prepareStatement("SELECT * FROM recensione ORDER BY RData desc")){
                ResultSet rs= ps.executeQuery();
                List<Recensione> recensione = new ArrayList<>();
                RecensioneExtraction recensioneExtraction = new RecensioneExtraction();
                while(rs.next())
                {
                    recensione.add(recensioneExtraction.mapping(rs));
                }
                rs.close();
                return recensione;
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
    }

    public List<Recensione> doRetrieveAllByDataisNull() throws SQLException{
        try(Connection connection= ConPool.getConnection())
        {
            try(PreparedStatement ps= connection.prepareStatement("select * from recensione where RData is null")){
                ResultSet rs= ps.executeQuery();
                List<Recensione> recensione = new ArrayList<>();
                RecensioneExtraction recensioneExtraction = new RecensioneExtraction();
                while(rs.next())
                {
                    recensione.add(recensioneExtraction.mapping(rs));
                }
                rs.close();
                return recensione;
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
    }


    public Recensione doRetrieveByDataUltima() throws SQLException{
        try(Connection connection= ConPool.getConnection())
        {
            try(PreparedStatement ps= connection.prepareStatement("SELECT * FROM recensione ORDER BY RData DESC LIMIT 1")){
                ResultSet rs= ps.executeQuery();
                Recensione recensione=new Recensione();
                RecensioneExtraction recensioneExtraction=new RecensioneExtraction();
                if(rs.next()){
                    recensione = recensioneExtraction.mapping(rs);
                }
                rs.close();
                return recensione;
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
    }


    public Recensione doRetrieveByDataPrima() throws SQLException{
        try(Connection connection= ConPool.getConnection())
        {
            try(PreparedStatement ps= connection.prepareStatement("SELECT * FROM recensione ORDER BY RData ASC LIMIT 1")){
                ResultSet rs= ps.executeQuery();
                Recensione recensione=new Recensione();
                RecensioneExtraction recensioneExtraction=new RecensioneExtraction();
                if(rs.next()){
                    recensione = recensioneExtraction.mapping(rs);
                }
                rs.close();
                return recensione;
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
    }

}
