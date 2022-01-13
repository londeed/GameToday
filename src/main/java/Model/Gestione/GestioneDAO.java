package Model.Gestione;

import Model.Connessione.ConPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class GestioneDAO {
    public List<Gestione> doRetrieveGamebyAdmin(String amNickname) throws SQLException{
        try(Connection connection= ConPool.getConnection()) {
            try(PreparedStatement ps= connection.prepareStatement("SELECT * FROM gestione WHERE AmNickname = ? ")){
                ps.setString(1,amNickname);
                ResultSet rs= ps.executeQuery();
                List<Gestione> gestione=new ArrayList<>();
                GestioneExtraction gestioneExtraction=new GestioneExtraction();
                while(rs.next())
                {
                    gestione.add(gestioneExtraction.mapping(rs));
                }
                rs.close();
                return gestione;
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
    }



    public Gestione doRetrieveGameAsTitle(String titolo) throws SQLException {
        try (Connection connection = ConPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM gestione WHERE Titolo = ? ")) {
                ps.setString(1, titolo);
                ResultSet rs = ps.executeQuery();
                Gestione gestione = new Gestione();
                GestioneExtraction gestioneExtraction = new GestioneExtraction();
                while (rs.next()) {
                    gestione =gestioneExtraction.mapping(rs);
                }
                rs.close();
                return gestione;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public  Boolean insertGestione(String amNickname, String titolo) throws SQLException{
    int rows = 0;
        try (Connection connection = ConPool.getConnection()) {
        try (PreparedStatement ps = connection.prepareStatement("INSERT INTO gestione(AmNickname, Titolo) VALUES (?,?);")) {
            ps.setString(1, amNickname);
            ps.setString(2, titolo);
            rows = ps.executeUpdate();
        }
    }
        return rows == 1;
}
}