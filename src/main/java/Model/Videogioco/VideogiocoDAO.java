package Model.Videogioco;

import Model.Connessione.ConPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *classe che utilizza i metodi di interrogazione del database riguardanti Videogioco
 */

public class VideogiocoDAO {

    /**
     * metodo che interroga il database per restituire un oggetto videogioco con un
     * determinato titolo corrispondente alla stringa passata come parametro
     * @param titolo
     * @return Videogioco
     * @throws SQLException
     */

    public Videogioco doRetrieveByTitolo(String titolo) throws SQLException{
        try(Connection connection= ConPool.getConnection()) {
                try(PreparedStatement ps= connection.prepareStatement("SELECT * FROM videogioco WHERE Titolo = ?")){
                ps.setString(1, titolo);
                ResultSet rs= ps.executeQuery();
                Videogioco videogioco=new Videogioco();
                VideogiocoExtraction videogiocoExtraction=new VideogiocoExtraction();
                if(rs.next()){
                    videogioco = videogiocoExtraction.mapping(rs);
                }
                rs.close();
                return videogioco;
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * metodo che interroga il database per restituire una lista di videogiochi con una mediaValutazioni
     * corrispondente al double passato come parametro
     * @param mediaValutazioni
     * @return Lista di videogiochi
     * @throws SQLException
     */

    public List<Videogioco> doRetriveBymediaValutazioni(double mediaValutazioni) throws SQLException{
        try(Connection connection= ConPool.getConnection()) {
            try(PreparedStatement ps= connection.prepareStatement("SELECT * FROM videogioco WHERE MediaValutazioni = ?")){
                ps.setDouble(1, mediaValutazioni);
                ResultSet rs= ps.executeQuery();
                List<Videogioco> videogioco=new ArrayList<>();
                VideogiocoExtraction videogiocoExtraction=new VideogiocoExtraction();
                if(rs.next()){
                    videogioco.add(videogiocoExtraction.mapping(rs));
                }
                rs.close();
                return videogioco;
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * metodo che interroga il database per restituire la lista dei videogiochi
     * @return Lista di videogiochi
     * @throws SQLException
     */

    public List<Videogioco> doRetriveAll() throws SQLException{
        try(Connection connection= ConPool.getConnection()) {
            try(PreparedStatement ps= connection.prepareStatement("SELECT * FROM videogioco")){
                ResultSet rs= ps.executeQuery();
                List<Videogioco> videogioco=new ArrayList<>();
                VideogiocoExtraction videogiocoExtraction=new VideogiocoExtraction();
                while (rs.next()){
                    videogioco.add(videogiocoExtraction.mapping(rs));
                }
                rs.close();
                return videogioco;
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * metodo che interroga il database per restituire una lista di videogiochi con casaProduttrice corrispondente alla
     * stringa passata come parametro
     * @param casaProduttrice
     * @return Lista di videogiochi
     * @throws SQLException
     */

    public List<Videogioco> doRetriveByCasaProduttrice(String casaProduttrice) throws SQLException{
        try(Connection connection= ConPool.getConnection()) {
            try(PreparedStatement ps= connection.prepareStatement("SELECT * FROM videogioco WHERE CasaProduttrice = ?")){
                ps.setString(1, casaProduttrice);
                ResultSet rs= ps.executeQuery();
                List<Videogioco> videogioco=new ArrayList<>();
                VideogiocoExtraction videogiocoExtraction=new VideogiocoExtraction();
                if(rs.next()){
                    videogioco.add(videogiocoExtraction.mapping(rs));
                }
                rs.close();
                return videogioco;
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * metodo che interroga il database per restituire una lista di videogiochi con piattaforma corrispondente alla
     * stringa passata come parametro
     * @param piattaforma
     * @return
     * @throws SQLException
     */

    public List<Videogioco> doRetriveByPiattaforma(String piattaforma) throws SQLException{
        try(Connection connection= ConPool.getConnection()) {
            try(PreparedStatement ps= connection.prepareStatement("SELECT * FROM videogioco WHERE Piattaforma = ?")){
                ps.setString(1, piattaforma);
                ResultSet rs= ps.executeQuery();
                List<Videogioco> videogioco=new ArrayList<>();
                VideogiocoExtraction videogiocoExtraction=new VideogiocoExtraction();
                while(rs.next()){
                    videogioco.add(videogiocoExtraction.mapping(rs));
                }
                rs.close();
                return videogioco;
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * metodo che interroga il database per inserire un videogioco tramite un oggetto videogioco passato come parametro
     * @param videogioco
     * @return boolean
     * @throws SQLException
     */

    public Boolean insertVideogioco(Videogioco videogioco) throws SQLException{
        try(Connection connection = ConPool.getConnection()){
            try(PreparedStatement ps = connection.prepareStatement("INSERT INTO videogioco(Titolo, Pegi, TotaleVoti, CasaProduttrice, MediaValutazioni, Piattaforma, DataPubblicazione, Tipologia) VALUES (?,?,?,?,?,?,?,?);")){
                ps.setString(1,videogioco.getTitolo());
                ps.setInt(2, videogioco.getPegi());
                ps.setInt(3, videogioco.getTotaleVoti());
                ps.setString(4, videogioco.getCasaProduttrice());
                ps.setDouble(5, videogioco.getMediaValutazioni());
                ps.setString(6, videogioco.getPiattaforma());
                ps.setDate(7, videogioco.getDataPubblicazione());
                ps.setString(8, videogioco.getTipologia());
                int rows = ps.executeUpdate();
                return rows == 1;
            }
        }
    }

    /**
     * metodo che interroga il database per aggiornare un videogioco corrispondente alla stringa passata come parametro
     * con un oggetto videogioco passato come parametro
     * @param videogioco
     * @param titolo
     * @return boolean
     * @throws SQLException
     */

    public Boolean updateVideogioco(Videogioco videogioco, String titolo) throws SQLException{
        try(Connection connection = ConPool.getConnection()){
            try(PreparedStatement ps = connection.prepareStatement("UPDATE videogioco SET Titolo=?, Pegi=?, TotaleVoti=?, CasaProduttrice=?, MediaValutazioni=?, Piattaforma=?, DataPubblicazione=?, Tipologia=? WHERE Titolo=?")){
                ps.setString(1, videogioco.getTitolo());
                ps.setInt(2, videogioco.getPegi());
                ps.setInt(3, videogioco.getTotaleVoti());
                ps.setString(4, videogioco.getCasaProduttrice());
                ps.setDouble(5, videogioco.getMediaValutazioni());
                ps.setString(6, videogioco.getPiattaforma());
                ps.setDate(7, videogioco.getDataPubblicazione());
                ps.setString(8, videogioco.getTipologia());
                ps.setString(9, titolo);
                int rows = ps.executeUpdate();
                return rows == 1;
            }
        }
    }

    /**
     * metodo che interroga il database per eliminare un videogioco con il titolo
     * corrispondente alla stringa passata come parametro
     * @param titolo
     * @return boolean
     * @throws SQLException
     */

    public Boolean deleteVideogico(String titolo) throws SQLException{
        try(Connection con = ConPool.getConnection()) {
            try(PreparedStatement ps = con.prepareStatement("DELETE FROM videogioco WHERE Titolo = ?")){
                ps.setString(1, titolo);
                int rows = ps.executeUpdate();
                return rows == 1;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * metodo che interroga il database per restituire il numero di tutti gli elementi presenti nella tabella videogioco
     * @return size
     * @throws SQLException
     */

    public int countAll() throws SQLException{
        try(Connection con = ConPool.getConnection()){
            try(PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM videogioco")){
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
     * metodo che interroga il database per restituire una lista di videogiochi ordinata tramite titolo
     * @return Lista di videogiochi
     * @throws SQLException
     */

    public List<Videogioco> doRetrieveAllByTitolo() throws SQLException
    {
        try(Connection connection= ConPool.getConnection())
        {
            try(PreparedStatement ps= connection.prepareStatement("SELECT * FROM videogioco ORDER BY Titolo")){
                ResultSet rs= ps.executeQuery();
                List<Videogioco> videogioco=new ArrayList<>();
                VideogiocoExtraction videogiocoExtraction=new VideogiocoExtraction();
                while(rs.next())
                {
                    videogioco.add(videogiocoExtraction.mapping(rs));
                }
                rs.close();
                return videogioco;
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * metodo che interroga il database per restituire una lista di videogiochi con il titolo che completa o corrisponde
     * alla stringa passata come parametro
     * @param s
     * @return Lista di videogiochi
     * @throws SQLException
     */

    public List<Videogioco> doRetrieveAllByTitoloSearch(String s) throws SQLException
    {
        try(Connection connection= ConPool.getConnection())
        {
            try(PreparedStatement ps= connection.prepareStatement("SELECT * FROM videogioco WHERE Titolo LIKE ?")){
                ps.setString(1, s);
                ResultSet rs= ps.executeQuery();
                List<Videogioco> videogioco=new ArrayList<>();
                VideogiocoExtraction videogiocoExtraction=new VideogiocoExtraction();
                while(rs.next())
                {
                    videogioco.add(videogiocoExtraction.mapping(rs));
                }
                rs.close();
                return videogioco;
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * metodo che interroga il database per restituire una lista di videogiochi con il titolo non presente all'interno
     * dell'attributo titolo delle recensioni
     * @return Lista di videogiochi
     * @throws SQLException
     */

    public List<Videogioco> doRetrieveByNull() throws SQLException
    {
        try(Connection connection= ConPool.getConnection())
        {
            try(PreparedStatement ps= connection.prepareStatement("select * from videogioco where not exists ( select recensione.titolo from recensione where videogioco.titolo=recensione.titolo)")){
                ResultSet rs= ps.executeQuery();
                List<Videogioco> videogioco=new ArrayList<>();
                VideogiocoExtraction videogiocoExtraction=new VideogiocoExtraction();
                while(rs.next())
                {
                    videogioco.add(videogiocoExtraction.mapping(rs));
                }
                rs.close();
                return videogioco;
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * metodo che interroga il database per restituire una lista di tre videogiochi ordinati in modo discendente
     * tramite dataPubblicazione
     * @return Lista di videogiochi
     * @throws SQLException
     */

    public List<Videogioco> doRetrieveByData() throws SQLException {
        try (Connection connection = ConPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM videogioco ORDER BY DataPubblicazione DESC LIMIT 3")) {
                ResultSet rs = ps.executeQuery();
                List<Videogioco> videogioco = new ArrayList<>();
                VideogiocoExtraction videogiocoExtraction = new VideogiocoExtraction();
                while (rs.next()) {
                    videogioco.add(videogiocoExtraction.mapping(rs));
                }
                rs.close();
                return videogioco;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

}


