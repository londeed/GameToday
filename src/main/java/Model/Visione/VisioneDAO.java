package Model.Visione;

import Model.Connessione.ConPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * classe che utilizza i metodi di interrogazione del database riguardanti Visione
 */

public class VisioneDAO {

    /**
     * metodo che interroga il database per restituire tutti gli elementi visione con un
     * determinato nickname autore passato come parametro
     * @param auNickname
     * @return Lista di visione
     * @throws SQLException
     */

    public List<Visione> doRetrieveVisioneByAutore(String auNickname) throws SQLException {
        try(Connection connection= ConPool.getConnection())
        {
            try(PreparedStatement ps= connection.prepareStatement("SELECT * FROM visione WHERE AuNickname = ?")){
                ps.setString(1, auNickname);
                ResultSet rs= ps.executeQuery();
                List <Visione> visione=new ArrayList<>();
                VisioneExtraction visioneExtraction = new VisioneExtraction();
                while (rs.next()){
                    visione.add(visioneExtraction.mapping(rs));
                }
                rs.close();
                return visione;
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * metodo che interroga il database per restituire tutti gli elementi visione con un
     * determinato titolo passato come parametro
     * @param titolo
     * @return Lista di visione
     * @throws SQLException
     */

    public List<Visione> doRetrieveVisioneByTitolo(String titolo) throws SQLException {
        try(Connection connection= ConPool.getConnection())
        {
            try(PreparedStatement ps= connection.prepareStatement("SELECT * FROM visione WHERE Titolo = ?")){
                ps.setString(1, titolo);
                ResultSet rs= ps.executeQuery();
                List <Visione> visione=new ArrayList<>();
                VisioneExtraction visioneExtraction = new VisioneExtraction();
                while (rs.next()){
                    visione.add(visioneExtraction.mapping(rs));
                }
                rs.close();
                return visione;
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * metodo che interroga il database per inserire un elemento visione tramite il nickname dell'autore
     * e il titolo del videogioco passati come parametro
     * @param auNickname
     * @param titolo
     * @return boolean
     * @throws SQLException
     */

    public Boolean insertVisione(String auNickname, String titolo) throws SQLException{
        int rows = 0;
        try (Connection connection = ConPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement("INSERT INTO visione(AuNickname,Titolo) VALUES (?,?);")) {
                ps.setString(1, auNickname);
                ps.setString(2, titolo);
                rows = ps.executeUpdate();
            }
        }
        return rows == 1;
    }
}
