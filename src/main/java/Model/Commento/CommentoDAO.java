package Model.Commento;

import Model.Autore.Autore;
import Model.Autore.AutoreExtraction;
import Model.Connessione.ConPool;
import Model.Recensione.Recensione;
import Model.Recensione.RecensioneExtraction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentoDAO
{
    public Commento doRetrieveByCodice(String codice) throws SQLException
    {
        try(Connection connection= ConPool.getConnection())
        {
            try(PreparedStatement ps= connection.prepareStatement("SELECT * FROM commento WHERE CommentoCod = ?")){
                ps.setString(1, codice);
                ResultSet rs= ps.executeQuery();
                Commento commento=new Commento();
                CommentoExtraction commentoExtraction=new CommentoExtraction();
                if(rs.next()){
                    commento = commentoExtraction.mapping(rs);
                }
                rs.close();
                return commento;
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
    }

    public Boolean insertCommento(Commento commento) throws SQLException
    {
        try(Connection connection = ConPool.getConnection()){
            try(PreparedStatement ps = connection.prepareStatement("INSERT INTO commento(CommentoCod, Codice, CLike, CDislike, CTesto) VALUES (?,?,?,?,?);")){
                ps.setString(1, commento.getComCodice());
                ps.setString(2, commento.getCodice());
                ps.setInt(3, commento.getLike());
                ps.setInt(4, commento.getDislike());
                ps.setString(5, commento.getTesto());
                int rows = ps.executeUpdate();
                return rows == 1;
            }
        }
    }

    public Boolean updateCommento(Commento commento, String comCodice) throws SQLException
    {
        try(Connection connection = ConPool.getConnection()){
            try(PreparedStatement ps = connection.prepareStatement("UPDATE commento SET CommentoCod=?, Codice=?, CLike=?, CDislike=?, CTesto=? WHERE CommentoCod=?")){
                ps.setString(1, commento.getComCodice());
                ps.setString(2, commento.getCodice());
                ps.setInt(3, commento.getLike());
                ps.setInt(4, commento.getDislike());
                ps.setString(5, commento.getTesto());
                ps.setString(6, comCodice);
                int rows = ps.executeUpdate();
                return rows == 1;
            }
        }
    }

    public Boolean deleteCommento(String comCodice) throws SQLException
    {
        try(Connection con = ConPool.getConnection()) {
            try(PreparedStatement ps = con.prepareStatement("DELETE FROM commento WHERE CommentoCod = ?")){
                ps.setString(1, comCodice);
                int rows = ps.executeUpdate();
                return rows == 1;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public int countAll() throws SQLException
    {
        try(Connection con = ConPool.getConnection()){
            try(PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM commento")){
                ResultSet rs = ps.executeQuery();
                int size = 0;
                if(rs.next()){
                    size = rs.getInt(1);
                }
                return  size;
            }
        }
    }

    public List<String> doRetrieveAllCodiciCommenti() throws SQLException
    {
        try(Connection connection= ConPool.getConnection())
        {
            try(PreparedStatement ps= connection.prepareStatement("SELECT CommentoCod FROM commento")){
                ResultSet rs= ps.executeQuery();
                List<String> codiceCom = new ArrayList<>();
                while(rs.next())
                {
                    codiceCom.add(rs.getString(1));
                }
                rs.close();
                return codiceCom;
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
    }

    public List<Commento> doRetrieveAllCommentiByCodice(String codice) throws SQLException
    {
        try(Connection connection= ConPool.getConnection())
        {
            try(PreparedStatement ps= connection.prepareStatement("SELECT * FROM commento WHERE Codice = ?")){
                ps.setString(1, codice);
                ResultSet rs= ps.executeQuery();
                List<Commento> commentiList = new ArrayList<>();
                CommentoExtraction commentoExtraction = new CommentoExtraction();
                while(rs.next())
                {
                    commentiList.add(commentoExtraction.mapping(rs));
                }
                rs.close();
                return commentiList;
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
    }

    public Boolean updateInterazione(String comCodice, String interazione) throws SQLException {
        try (Connection connection = ConPool.getConnection()) {
            if (interazione.equals("0")) {
                try (PreparedStatement ps = connection.prepareStatement("UPDATE commento SET CLike=Clike+1 WHERE CommentoCod =?")) {
                    ps.setString(1, comCodice);
                    int rows = ps.executeUpdate();
                    return rows == 1;
                }
            } else {
                try (PreparedStatement ps = connection.prepareStatement("UPDATE commento SET CDislike=CDislike+1 WHERE CommentoCod =?")) {
                    ps.setString(1, comCodice);
                    int rows = ps.executeUpdate();
                    return rows == 1;
                }
            }
        }
    }


    public Boolean updateTesto(String testo, String comCodice) throws SQLException{
        try (Connection connection = ConPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement("UPDATE commento SET CTesto=? WHERE CommentoCod =?")) {
                ps.setString(1, testo);
                ps.setString(2, comCodice);
                int rows = ps.executeUpdate();
                return rows == 1;
            }
        }
    }


    public List<Commento> doRetrieveAllCommentinotVerfied() throws SQLException
    {
        try(Connection connection= ConPool.getConnection())
        {
            try(PreparedStatement ps= connection.prepareStatement("select * from commento where not exists (select * from verifica where commento.CommentoCod=verifica.CommentoCod)")){
                ResultSet rs= ps.executeQuery();
                List<Commento> commentiList = new ArrayList<>();
                CommentoExtraction commentoExtraction = new CommentoExtraction();
                while(rs.next())
                {
                    commentiList.add(commentoExtraction.mapping(rs));
                }
                rs.close();
                return commentiList;
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
    }

    public List<Commento> doRetrieveAll() throws SQLException
    {
        try(Connection connection= ConPool.getConnection())
        {
            try(PreparedStatement ps= connection.prepareStatement("select * from commento")){
                ResultSet rs= ps.executeQuery();
                List<Commento> commentiList = new ArrayList<>();
                CommentoExtraction commentoExtraction = new CommentoExtraction();
                while(rs.next())
                {
                    commentiList.add(commentoExtraction.mapping(rs));
                }
                rs.close();
                return commentiList;
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
    }


    public String doRetrieveCodiceByMaxCommenti() throws SQLException
    {
        try(Connection connection= ConPool.getConnection())
        {
            try(PreparedStatement ps= connection.prepareStatement("SELECT `Codice`,COUNT(`Codice`) AS `value_occurrence` FROM `commento` GROUP BY `Codice` ORDER BY `value_occurrence` DESC LIMIT 1")){
                ResultSet rs= ps.executeQuery();
                String codice="";
                if(rs.next()){
                    codice = rs.getString(1);
                }
                rs.close();
                return codice;
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
    }
}