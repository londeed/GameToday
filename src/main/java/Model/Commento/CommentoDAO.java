package Model.Commento;

import Model.Autore.Autore;
import Model.Autore.AutoreExtraction;
import Model.Connessione.ConPool;
import Model.Recensione.Recensione;
import Model.Recensione.RecensioneExtraction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * classe che utilizza i metodi di interrogazione del database riguardanti i commenti
 */

public class CommentoDAO
{

    /**
     * questo metodo restituisce un commento in base al codice
     * @param codice
     * @return commento
     * @throws SQLException
     */

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

    /**
     * questo metodo permette di inseerire un commento
     * @param commento
     * @return boolean
     * @throws SQLException
     */

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

    /**
     * questo metodo permette di aggiornare un commento in base al codice
     * @param commento
     * @param comCodice
     * @return boolean
     * @throws SQLException
     */

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

    /**
     * questo metodo permette di eliminare un commento in base al codice
     * @param comCodice
     * @return boolean
     * @throws SQLException
     */

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

    /**
     * questo metodo permette di contare il numero di commenti presenti nel database
     * @return N° di commenti
     * @throws SQLException
     */

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

    /**
     * questo metodo permette di ritornare la lista dei codici dei commenti
     * @return lista dei codici
     * @throws SQLException
     */

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

    /**
     * questo metodo permette di ritornare un commenti in base ai codici
     * @param codice
     * @return lista di commenti
     * @throws SQLException
     */

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

    /**
     * questo metodo permette di aggiornare le interazioni
     * @param comCodice
     * @param interazione
     * @return boolean
     * @throws SQLException
     */

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

    /**
     * questo metodo permette di aggiornare il testo dei commenti
     * @param testo
     * @param comCodice
     * @return boolean
     * @throws SQLException
     */


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

    /**
     * query innestata per il ritorno per i commenti non verificati
     * @return lista di commenti
     * @throws SQLException
     */

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

    /**
     * questo metodo restituisce tutti i commenti
     * @return lista commenti
     * @throws SQLException
     */

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

    /**
     * query innestata
     * @return stringa
     * @throws SQLException
     */

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